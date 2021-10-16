package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class PlayerIdleTimeoutProperty extends IntServerProperty {
	public static final PlayerIdleTimeoutProperty INSTANCE = new PlayerIdleTimeoutProperty();
	
	private PlayerIdleTimeoutProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.playerIdleTimeout.get().intValue();
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		server.setPlayerIdleTimeout(value); // also updates property object
	}
}
