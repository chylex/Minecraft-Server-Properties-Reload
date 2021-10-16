package chylex.serverproperties.mixin;

import net.minecraft.world.level.LevelSettings;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PrimaryLevelData.class)
public interface PrimaryLevelDataMixin {
	@Accessor
	LevelSettings getSettings();
	
	@Accessor
	void setSettings(LevelSettings settings);
}
