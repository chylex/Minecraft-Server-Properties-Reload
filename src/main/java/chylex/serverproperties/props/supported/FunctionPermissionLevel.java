package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.IntServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class FunctionPermissionLevel extends IntServerProperty {
	public static final FunctionPermissionLevel INSTANCE = new FunctionPermissionLevel();
	
	private FunctionPermissionLevel() {}
	
	@Override
	protected int getInt(final DedicatedServerProperties properties) {
		return properties.functionPermissionLevel;
	}
	
	@Override
	protected void applyInt(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final int value, final PropertyChangeCallback callback) {
		target.setFunctionPermissionLevel(value);
	}
}
