package chylex.serverproperties.command;

import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.mixin.SettingsMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.PropertyChangeFinalizer;
import chylex.serverproperties.props.ServerProperties;
import chylex.serverproperties.props.ServerProperty;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import org.apache.logging.log4j.LogManager;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import static net.minecraft.commands.Commands.literal;

public final class PropertiesCommand {
	private PropertiesCommand() {}
	
	public static void register(final CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(literal("properties")
			.requires(s -> s.hasPermission(2))
			.then(literal("reload")
				.executes(c -> reloadPropertiesFile(c.getSource())))
		);
	}
	
	@SuppressWarnings("CastToIncompatibleInterface")
	private static int reloadPropertiesFile(final CommandSourceStack s) {
		final MinecraftServer server = s.getServer();
		
		if (!(server instanceof final DedicatedServer dedicatedServer)) {
			s.sendFailure(new TextComponent("This command is only supported on dedicated servers!"));
			return 0;
		}
		
		final DedicatedServerProperties oldProperties = dedicatedServer.getProperties();
		final DedicatedServerProperties newProperties = DedicatedServerProperties.fromFile(Paths.get("server.properties"));
		final Set<String> unknownPropertyNames = new HashSet<>(((SettingsMixin)newProperties).getProperties().stringPropertyNames());
		
		s.sendSuccess(new TextComponent("Reloading server properties:"), true);
		
		int reloadedProperties = 0;
		int failedProperties = 0;
		
		final Map<String, PropertyChangeFinalizer> finalizers = new HashMap<>();
		final PropertyChangeCallback callback = finalizer -> finalizers.putIfAbsent(finalizer.getKey(), finalizer);
		
		newProperties.getWorldGenSettings(dedicatedServer.registryAccess()); // loads worldgen property defaults
		
		for (final Entry<String, ServerProperty<?>> entry : ServerProperties.all().stream().sorted(Entry.comparingByKey()).toList()) {
			final String name = entry.getKey();
			final ServerProperty<?> prop = entry.getValue();
			
			unknownPropertyNames.remove(name);
			
			try {
				if (prop.hasChanged(oldProperties, newProperties)) {
					final String oldValue = prop.toStringFrom(oldProperties);
					final String newValue = prop.toStringFrom(newProperties);
					
					try {
						prop.apply(dedicatedServer, newProperties, (DedicatedServerPropertiesMixin)oldProperties, callback);
						sendReloadSuccessMessage(s, name, oldValue, newValue);
						++reloadedProperties;
					} catch (final UnsupportedOperationException e) {
						sendReloadUnsupportedMessage(s, name);
						++failedProperties;
					}
				}
			} catch (final Throwable t) {
				sendReloadErrorMessage(s, name);
				LogManager.getLogger().error("Caught exception while reloading a property: " + name, t);
				++failedProperties;
			}
		}
		
		int finalizerErrors = 0;
		
		for (final PropertyChangeFinalizer finalizer : finalizers.values()) {
			try {
				finalizer.run(dedicatedServer);
			} catch (final Throwable t) {
				++finalizerErrors;
				LogManager.getLogger().error("Caught exception while finalizing a reload: " + finalizer.getKey(), t);
			}
		}
		
		for (final String name : unknownPropertyNames.stream().sorted().toList()) {
			sendPropertySkippedMessage(s, name);
		}
		
		if (reloadedProperties == 0 && failedProperties == 0) {
			sendNoChangesMessage(s);
		}
		
		if (finalizerErrors > 0) {
			sendErrorOccurredMessage(s);
		}
		
		return reloadedProperties;
	}
	
	private static void sendReloadSuccessMessage(final CommandSourceStack s, final String name, final String oldValue, final String newValue) {
		s.sendSuccess(new TextComponent("  " + name + ": ").withStyle(ChatFormatting.LIGHT_PURPLE)
			.append(new TextComponent(oldValue).withStyle(ChatFormatting.WHITE))
			.append(new TextComponent(" -> ").withStyle(ChatFormatting.GRAY))
			.append(new TextComponent(newValue).withStyle(ChatFormatting.WHITE)), true);
	}
	
	private static void sendReloadUnsupportedMessage(final CommandSourceStack s, final String name) {
		s.sendSuccess(new TextComponent("  " + name + ':').withStyle(ChatFormatting.RED)
			.append(new TextComponent(" cannot be reloaded (unsupported)").withStyle(ChatFormatting.WHITE)), true);
	}
	
	private static void sendReloadErrorMessage(final CommandSourceStack s, final String name) {
		s.sendSuccess(new TextComponent("  " + name + ':').withStyle(ChatFormatting.RED)
			.append(new TextComponent(" cannot be reloaded (error)").withStyle(ChatFormatting.WHITE)), true);
	}
	
	private static void sendPropertySkippedMessage(final CommandSourceStack s, final String name) {
		s.sendSuccess(new TextComponent("  " + name + ':').withStyle(ChatFormatting.GRAY)
			.append(new TextComponent(" skipped unknown property").withStyle(ChatFormatting.WHITE)), true);
	}
	
	private static void sendNoChangesMessage(final CommandSourceStack s) {
		s.sendSuccess(new TextComponent("  Found no changes").withStyle(ChatFormatting.GRAY), true);
	}
	
	private static void sendErrorOccurredMessage(final CommandSourceStack s) {
		s.sendSuccess(new TextComponent("An error occurred, please check server logs.").withStyle(ChatFormatting.RED), true);
	}
}
