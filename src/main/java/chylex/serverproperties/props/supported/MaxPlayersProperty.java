package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.mixin.PlayerListMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class MaxPlayersProperty extends IntServerProperty {
	public static final MaxPlayersProperty INSTANCE = new MaxPlayersProperty();
	
	private MaxPlayersProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.maxPlayers;
	}
	
	@SuppressWarnings("CastToIncompatibleInterface")
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setMaxPlayers(value);
		((PlayerListMixin)server.getPlayerList()).setMaxPlayers(value);
	}
}
