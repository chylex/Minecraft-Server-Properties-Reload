package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerMixin;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ResourcePackPromptProperty extends ServerProperty<String> {
	public static final ResourcePackPromptProperty INSTANCE = new ResourcePackPromptProperty();
	
	private ResourcePackPromptProperty() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.resourcePackPrompt;
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final String value, final PropertyChangeCallback callback) {
		target.setResourcePackPrompt(value);
		
		@SuppressWarnings("CastToIncompatibleInterface")
		final DedicatedServerMixin serverMixin = (DedicatedServerMixin)server;
		serverMixin.setResourcePackPrompt(DedicatedServerMixin.callParseResourcePackPrompt(serverMixin.getSettings()));
	}
}
