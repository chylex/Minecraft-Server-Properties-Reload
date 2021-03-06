package chylex.serverproperties.props;

import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import java.util.Objects;

public abstract class ServerProperty<T> {
	public final boolean hasChanged(final DedicatedServerProperties oldProperties, final DedicatedServerProperties newProperties) {
		return !Objects.equals(get(oldProperties), get(newProperties));
	}
	
	public final void apply(final DedicatedServer server, final DedicatedServerProperties source, final DedicatedServerPropertiesMixin target, final PropertyChangeCallback callback) {
		apply(server, target, get(source), callback);
	}
	
	public final String toStringFrom(final DedicatedServerProperties source) {
		return toString(get(source));
	}
	
	public abstract T get(DedicatedServerProperties properties);
	
	public abstract void apply(final DedicatedServer server, DedicatedServerPropertiesMixin target, T value, final PropertyChangeCallback callback);
	
	public String toString(final T value) {
		return Objects.toString(value, "<null>");
	}
}
