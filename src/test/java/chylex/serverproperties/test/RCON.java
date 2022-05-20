package chylex.serverproperties.test;

import nl.vv32.rcon.Rcon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.fail;

public final class RCON implements BeforeAllCallback, AfterAllCallback {
	private static final Logger LOGGER = LogManager.getLogger("ServerPropertiesReloadTest");
	
	private static Rcon RCON;
	
	public static String cmd(final String command) {
		try {
			final String result = RCON.sendCommand(command);
			LOGGER.info("[RCON IN] /" + command);
			LOGGER.info("[RCON OUT] " + result);
			return result;
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "InsertLiteralUnderscores", "BusyWait", "AssignmentToStaticFieldFromInstanceMethod" })
	@Override
	public void beforeAll(final ExtensionContext context) throws Exception {
		LOGGER.info("Waiting for RCON...");
		
		int seconds = 0;
		while (true) {
			try {
				RCON = Rcon.open("localhost", 25575);
				if (RCON.authenticate("123")) {
					LOGGER.info("Connected to RCON.");
					break;
				}
				else {
					LOGGER.info("RCON authentication failed.");
					fail();
				}
			} catch (final Exception ignored) {}
			
			Thread.sleep(1000L);
			
			if (++seconds > 60) {
				LOGGER.error("Connection to RCON timed out.");
				fail();
			}
		}
	}
	
	@Override
	public void afterAll(final ExtensionContext context) throws Exception {
		if (RCON != null) {
			LOGGER.info("Stopping test server...");
			RCON.sendCommand("stop");
		}
	}
	
	private RCON() {}
}
