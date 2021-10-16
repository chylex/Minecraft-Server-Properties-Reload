package chylex.serverproperties.mixin;

import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerList.class)
public interface PlayerListMixin {
	@Mutable
	@Accessor
	void setMaxPlayers(int maxPlayers);
}
