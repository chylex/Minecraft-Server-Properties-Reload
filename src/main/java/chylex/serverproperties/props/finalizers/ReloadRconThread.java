package chylex.serverproperties.props.finalizers;
import chylex.serverproperties.mixin.DedicatedServerMixin;
import chylex.serverproperties.props.PropertyChangeFinalizer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.rcon.thread.RconThread;

public final class ReloadRconThread implements PropertyChangeFinalizer {
	@Override
	public String getKey() {
		return "rcon";
	}
	
	@Override
	public void run(final DedicatedServer server) {
		@SuppressWarnings("CastToIncompatibleInterface")
		final DedicatedServerMixin serverMixin = (DedicatedServerMixin)server;
		final RconThread oldThread = serverMixin.getRconThread();
		
		if (oldThread != null) {
			oldThread.stop();
			serverMixin.setRconThread(null);
		}
		
		if (server.getProperties().enableRcon) {
			serverMixin.setRconThread(RconThread.create(server));
		}
	}
}
