package chylex.serverproperties.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MinecraftServer.class)
public interface MinecraftServerMixin {
	@Invoker
	void callUpdateMobSpawningFlags();
}
