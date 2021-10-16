package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.finalizers.ReloadRconThread;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class EnableRconProperty extends BoolServerProperty {
	public static final EnableRconProperty INSTANCE = new EnableRconProperty();
	
	private EnableRconProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.enableRcon;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setEnableRcon(value);
		callback.addFinalizer(new ReloadRconThread());
	}
}
