package chylex.serverproperties.mixin;

import net.minecraft.server.dedicated.Settings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import java.util.Properties;

@Mixin(Settings.class)
public interface SettingsMixin {
	@Accessor
	Properties getProperties();
}
