package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class EntityBroadcastRangePercentageProperty extends IntServerProperty {
	public static final EntityBroadcastRangePercentageProperty INSTANCE = new EntityBroadcastRangePercentageProperty();
	
	private EntityBroadcastRangePercentageProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.entityBroadcastRangePercentage;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setEntityBroadcastRangePercentage(value);
	}
}
