package chylex.serverproperties.props;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public abstract class LongServerProperty extends ServerProperty<Long> {
	
	@Override
	public final Long get(final DedicatedServerProperties properties) {
		return Long.valueOf(getLong(properties));
	}
	
	@Override
	public final void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final Long value, final PropertyChangeCallback callback) {
		applyLong(server, target, value.longValue(), callback);
	}
	
	@Override
	public String toString(final Long value) {
		return String.valueOf(value.longValue());
	}
	
	protected abstract long getLong(DedicatedServerProperties properties);
	
	protected abstract void applyLong(final DedicatedServer server, DedicatedServerPropertiesMixin target, long value, final PropertyChangeCallback callback);
}
