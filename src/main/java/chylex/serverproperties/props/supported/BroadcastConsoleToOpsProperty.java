package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class BroadcastConsoleToOpsProperty extends BoolServerProperty {
	public static final BroadcastConsoleToOpsProperty INSTANCE = new BroadcastConsoleToOpsProperty();
	
	private BroadcastConsoleToOpsProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.broadcastConsoleToOps;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setBroadcastConsoleToOps(value);
	}
}
