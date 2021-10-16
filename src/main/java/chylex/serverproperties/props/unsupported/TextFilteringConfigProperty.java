package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class TextFilteringConfigProperty extends ServerProperty<String> {
	public static final TextFilteringConfigProperty INSTANCE = new TextFilteringConfigProperty();
	
	private TextFilteringConfigProperty() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.textFilteringConfig;
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final String value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
