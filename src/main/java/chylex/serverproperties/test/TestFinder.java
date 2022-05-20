package chylex.serverproperties.test;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestGenerator;
import net.minecraft.gametest.framework.GlobalTestReporter;
import net.minecraft.gametest.framework.TeamcityTestReporter;
import net.minecraft.gametest.framework.TestFunction;
import net.minecraft.world.level.block.Rotation;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class TestFinder {
	@SuppressWarnings("UnstableApiUsage")
	@GameTestGenerator
	public static List<TestFunction> getTests() throws IOException {
		GlobalTestReporter.replaceWith(new TeamcityTestReporter());
		
		final List<TestFunction> functions = new ArrayList<>();
		int batchNumber = 0;
		
		final ClassPath cp = ClassPath.from(Thread.currentThread().getContextClassLoader());
		for (final ClassInfo ci : cp.getTopLevelClassesRecursive("chylex.serverproperties.test")) {
			for (final Method method : ci.load().getMethods()) {
				var test = method.getAnnotation(GameTest.class);
				if (test == null) {
					continue;
				}
				
				functions.add(new TestFunction("batch" + (++batchNumber), method.getName(), method.getName(), Rotation.NONE, 0, 0, true, 1, 1, helper -> {
					helper.fail(""); // TODO
				}));
			}
		}
		
		return functions;
	}
	
	private TestFinder() {}
}
