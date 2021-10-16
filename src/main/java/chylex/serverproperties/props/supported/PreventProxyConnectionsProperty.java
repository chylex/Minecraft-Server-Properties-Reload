package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class PreventProxyConnectionsProperty extends BoolServerProperty {
	public static final PreventProxyConnectionsProperty INSTANCE = new PreventProxyConnectionsProperty();
	
	private PreventProxyConnectionsProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.preventProxyConnections;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setPreventProxyConnections(value);
		server.setPreventProxyConnections(value);
	}
}
