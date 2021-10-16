package chylex.serverproperties.props.supported;
import chylex.serverproperties.mixin.DedicatedServerPropertiesMixin;
import chylex.serverproperties.props.PropertyChangeCallback;
import chylex.serverproperties.props.ServerProperty;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.world.level.GameType;
import java.util.Locale;

public final class GamemodeProperty extends ServerProperty<GameType> {
	public static final GamemodeProperty INSTANCE = new GamemodeProperty();
	
	private GamemodeProperty() {}
	
	@Override
	public GameType get(final DedicatedServerProperties properties) {
		return properties.gamemode;
	}
	
	@Override
	public void apply(final DedicatedServer server, final DedicatedServerPropertiesMixin target, final GameType value, final PropertyChangeCallback callback) {
		target.setGamemode(value);
		server.setDefaultGameType(value);
	}
	
	@Override
	public String toString(final GameType value) {
		return super.toString(value).toLowerCase(Locale.ROOT);
	}
}
