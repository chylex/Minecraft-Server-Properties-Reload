package chylex.serverproperties.props;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public abstract class BoolServerProperty extends ServerProperty<Boolean> {
	
	@Override
	public final Boolean get(final DedicatedServerProperties properties) {
		return Boolean.valueOf(getBool(properties));
	}
	
	@Override
	public final void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final Boolean value, final PropertyChangeCallback callback) {
		applyBool(server, target, value.booleanValue(), callback);
	}
	
	@Override
	public final String toString(final Boolean value) {
		return String.valueOf(value.booleanValue());
	}
	
	protected abstract boolean getBool(DedicatedServerProperties properties);
	
	protected abstract void applyBool(final DedicatedServer server, DedicatedServerPropertiesMixin target, boolean value, final PropertyChangeCallback callback);
}
