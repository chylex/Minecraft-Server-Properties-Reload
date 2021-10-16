package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.mixin.LevelSettingsMixin;
import chylex.serverproperties.mixin.PrimaryLevelDataMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.world.level.LevelSettings;

public final class HardcoreProperty extends BoolServerProperty {
	public static final HardcoreProperty INSTANCE = new HardcoreProperty();
	
	private HardcoreProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.hardcore;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setHardcore(value);
		
		final PrimaryLevelDataMixin worldDataMixin = (PrimaryLevelDataMixin)server.getWorldData();
		final LevelSettings modifiedSettings = worldDataMixin.getSettings().copy();
		((LevelSettingsMixin)(Object)modifiedSettings).setHardcore(value);
		worldDataMixin.setSettings(modifiedSettings);
		
		server.forceDifficulty();
	}
}
