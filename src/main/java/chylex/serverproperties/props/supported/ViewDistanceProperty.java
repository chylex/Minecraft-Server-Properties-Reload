package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ViewDistanceProperty extends IntServerProperty {
	public static final ViewDistanceProperty INSTANCE = new ViewDistanceProperty();
	
	private ViewDistanceProperty() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.viewDistance;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setViewDistance(value);
		server.getPlayerList().setViewDistance(value);
	}
}
