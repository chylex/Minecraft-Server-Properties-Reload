package chylex.serverproperties.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerSettings;
import net.minecraft.server.rcon.thread.QueryThreadGs4;
import net.minecraft.server.rcon.thread.RconThread;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DedicatedServer.class)
public interface DedicatedServerMixin {
	@Accessor
	QueryThreadGs4 getQueryThreadGs4();
	
	@Accessor
	void setQueryThreadGs4(QueryThreadGs4 thread);
	
	@Accessor
	RconThread getRconThread();
	
	@Accessor
	void setRconThread(RconThread thread);
	
	@Accessor
	DedicatedServerSettings getSettings();
	
	@Mutable
	@Accessor
	void setResourcePackPrompt(Component component);
	
	@Invoker
	static Component callParseResourcePackPrompt(final DedicatedServerSettings settings) {
		throw new AssertionError();
	}
}
