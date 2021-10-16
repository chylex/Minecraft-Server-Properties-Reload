package chylex.serverproperties.props.finalizers;
import chylex.serverproperties.mixin.DedicatedServerMixin;
import chylex.serverproperties.props.PropertyChangeFinalizer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.rcon.thread.QueryThreadGs4;

public final class ReloadQueryThread implements PropertyChangeFinalizer {
	@Override
	public String getKey() {
		return "query";
	}
	
	@Override
	public void run(final DedicatedServer server) {
		@SuppressWarnings("CastToIncompatibleInterface")
		final DedicatedServerMixin serverMixin = (DedicatedServerMixin)server;
		final QueryThreadGs4 oldThread = serverMixin.getQueryThreadGs4();
		
		if (oldThread != null) {
			oldThread.stop();
			serverMixin.setQueryThreadGs4(null);
		}
		
		if (server.getProperties().enableQuery) {
			serverMixin.setQueryThreadGs4(QueryThreadGs4.create(server));
		}
	}
}
