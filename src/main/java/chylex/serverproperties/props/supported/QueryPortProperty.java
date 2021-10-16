package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.finalizers.ReloadQueryThread;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class QueryPortProperty extends IntServerProperty {
	public static final QueryPortProperty INSTANCE = new QueryPortProperty();
	
	private QueryPortProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.queryPort;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setQueryPort(value);
		callback.addFinalizer(new ReloadQueryThread());
	}
}
