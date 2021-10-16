package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.LongServerProperty;
import chylex.serverproperties.props.PropertyChangeCallback;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class MaxTickTimeProperty extends LongServerProperty {
	public static final MaxTickTimeProperty INSTANCE = new MaxTickTimeProperty();
	
	private MaxTickTimeProperty() {}
	
	@Override
	protected long getLong(final DedicatedServerProperties properties) {
		return properties.maxTickTime;
	}
	
	@Override
	protected void applyLong(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final long value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
