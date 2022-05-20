val modId: String by project
val minecraftVersion: String by project
val fabricVersion: String by project

plugins {
	idea
	id("fabric-loom") version "0.11-SNAPSHOT"
}

dependencies {
	minecraft("com.mojang:minecraft:$minecraftVersion")
	modImplementation("net.fabricmc:fabric-loader:$fabricVersion")
	mappings(loom.officialMojangMappings())
	
	testImplementation("net.fabricmc.fabric-api:fabric-api:0.47.8+1.18.2")
}

loom {
	runs {
		named("client") {
			configName = "Fabric Client"
			client()
			runDir("../run")
			ideConfigGenerated(true)
		}
		
		named("server") {
			configName = "Fabric Server"
			server()
			runDir("../run")
			ideConfigGenerated(true)
		}
		
		register("serverTest") {
			configName = "Fabric Server Test"
			server()
			source(sourceSets.test.get())
			runDir("./build/tmp/fabric-server-test")
			property("fabric-api-gametest", "1")
			ideConfigGenerated(false)
		}
	}
	
	mixin {
		add(sourceSets.main.get(), "$modId.refmap.json")
	}
}

tasks.processResources {
	filesMatching("fabric.mod.json") {
		expand(inputs.properties)
	}
}

tasks.remapJar {
	archiveVersion.set(tasks.jar.get().archiveVersion)
}
