package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import chylex.serverproperties.props.finalizers.ReloadRconThread;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class RconPasswordProperty extends ServerProperty<String> {
	public static final RconPasswordProperty INSTANCE = new RconPasswordProperty();
	
	private RconPasswordProperty() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.rconPassword;
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final String value, final PropertyChangeCallback callback) {
		target.setRconPassword(value);
		callback.addFinalizer(new ReloadRconThread());
	}
}
