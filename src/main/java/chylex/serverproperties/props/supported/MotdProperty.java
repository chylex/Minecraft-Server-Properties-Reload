package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class MotdProperty extends ServerProperty<String> {
	public static final MotdProperty INSTANCE = new MotdProperty();
	
	private MotdProperty() {}
	
	@Override
	public String get(final DedicatedServerProperties properties) {
		return properties.motd;
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final String value, final PropertyChangeCallback callback) {
		target.setMotd(value);
		server.setMotd(value);
		server.getStatus().setDescription(new TextComponent(value));
	}
}
