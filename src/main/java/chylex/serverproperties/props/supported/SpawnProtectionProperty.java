package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class SpawnProtectionProperty extends IntServerProperty {
	public static final SpawnProtectionProperty INSTANCE = new SpawnProtectionProperty();
	
	private SpawnProtectionProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.spawnProtection;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setSpawnProtection(value);
	}
}
