package chylex.serverproperties.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(RCON.class)
public class ATest {
	@Test
	public void test() {
		RCON.cmd("list");
		assertTrue(true);
	}
}
