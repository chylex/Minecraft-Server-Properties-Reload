package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.mixin.MinecraftServerMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class SpawnMonstersProperty extends BoolServerProperty {
	public static final SpawnMonstersProperty INSTANCE = new SpawnMonstersProperty();
	
	private SpawnMonstersProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.spawnMonsters;
	}
	
	@SuppressWarnings("CastToIncompatibleInterface")
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setSpawnMonsters(value);
		((MinecraftServerMixin)server).callUpdateMobSpawningFlags();
	}
}
