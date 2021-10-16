package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.finalizers.ReloadQueryThread;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class EnableQueryProperty extends BoolServerProperty {
	public static final EnableQueryProperty INSTANCE = new EnableQueryProperty();
	
	private EnableQueryProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.enableQuery;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setEnableQuery(value);
		callback.addFinalizer(new ReloadQueryThread());
	}
}
