package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.finalizers.ReloadRconThread;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class RconPortProperty extends IntServerProperty {
	public static final RconPortProperty INSTANCE = new RconPortProperty();
	
	private RconPortProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.rconPort;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setRconPort(value);
		callback.addFinalizer(new ReloadRconThread());
	}
}
