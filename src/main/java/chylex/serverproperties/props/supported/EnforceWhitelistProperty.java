package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class EnforceWhitelistProperty extends BoolServerProperty {
	public static final EnforceWhitelistProperty INSTANCE = new EnforceWhitelistProperty();
	
	private EnforceWhitelistProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.enforceWhitelist;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setEnforceWhitelist(value);
		server.setEnforceWhitelist(value);
		if (value) {
			server.kickUnlistedPlayers(server.createCommandSourceStack());
		}
	}
}
