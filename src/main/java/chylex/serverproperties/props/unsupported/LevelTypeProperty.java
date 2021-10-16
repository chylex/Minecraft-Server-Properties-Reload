package chylex.serverproperties.props.unsupported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.mixin.SettingsMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;

public final class LevelTypeProperty extends ServerProperty<String> {
	public static final LevelTypeProperty INSTANCE = new LevelTypeProperty();
	
	private LevelTypeProperty() {}
	
	@SuppressWarnings("CastToIncompatibleInterface")
	@Override
	public String get(final DedicatedServerProperties properties) {
		return ((SettingsMixin)properties).getProperties().getProperty("level-type", "default");
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final String value, final PropertyChangeCallback callback) {
		throw new UnsupportedOperationException();
	}
}
