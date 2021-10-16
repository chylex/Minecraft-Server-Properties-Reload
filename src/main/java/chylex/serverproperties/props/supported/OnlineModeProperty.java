package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.BoolServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.server.players.GameProfileCache;

public final class OnlineModeProperty extends BoolServerProperty {
	public static final OnlineModeProperty INSTANCE = new OnlineModeProperty();
	
	private OnlineModeProperty() {}
	
	@Override
	protected boolean getBool(final DedicatedServerProperties properties) {
		return properties.onlineMode;
	}
	
	@Override
	protected void applyBool(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final boolean value, final PropertyChangeCallback callback) {
		target.setOnlineMode(value);
		server.setUsesAuthentication(value);
		GameProfileCache.setUsesAuthentication(value);
	}
}
