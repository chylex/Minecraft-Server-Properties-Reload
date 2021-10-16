package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class ResourcePackSha1Property extends ServerProperty<String> {
	public static final ResourcePackSha1Property INSTANCE = new ResourcePackSha1Property();
	
	private ResourcePackSha1Property() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.resourcePackSha1;
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final String value, final PropertyChangeCallback callback) {
		target.setResourcePackSha1(value);
		server.setResourcePack(server.getResourcePack(), server.getPackHash());
	}
}
