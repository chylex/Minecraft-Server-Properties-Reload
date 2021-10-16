package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class OpPermissionLevel extends IntServerProperty {
	public static final OpPermissionLevel INSTANCE = new OpPermissionLevel();
	
	private OpPermissionLevel() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.opPermissionLevel;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setOpPermissionLevel(value);
	}
}
