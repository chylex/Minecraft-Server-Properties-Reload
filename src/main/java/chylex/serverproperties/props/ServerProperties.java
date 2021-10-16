package chylex.serverproperties.props;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ServerProperties {
	private static final Map<String, ServerProperty<?>> ALL = new HashMap<>();
	
	public static Collection<Entry<String, ServerProperty<?>>> all() {
		return Collections.unmodifiableCollection(ALL.entrySet());
	}
	
	private static void register(final String name, final ServerProperty<?> property) {
		if (ALL.put(name, property) != null) {
			throw new IllegalArgumentException("Server property with name '" + name + "' is already registered!");
		}
	}
	
	static {
	}
	
	private ServerProperties() {}
}
