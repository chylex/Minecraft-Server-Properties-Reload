package chylex.serverproperties.props;

import net.minecraft.server.dedicated.DedicatedServer;

public interface PropertyChangeFinalizer {
	String getKey();
	void run(DedicatedServer server);
}
