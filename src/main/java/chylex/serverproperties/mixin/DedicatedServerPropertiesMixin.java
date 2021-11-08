package chylex.serverproperties.mixin;

import net.minecraft.server.dedicated.DedicatedServerProperties;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DedicatedServerProperties.class)
public interface DedicatedServerPropertiesMixin {
	@Mutable @Accessor void setAllowFlight(boolean allowFlight);
	@Mutable @Accessor void setAllowNether(boolean allowNether);
	@Mutable @Accessor void setBroadcastConsoleToOps(boolean broadcastConsoleToOps);
	@Mutable @Accessor void setBroadcastRconToOps(boolean broadcastRconToOps);
	@Mutable @Accessor void setDifficulty(Difficulty difficulty);
	@Mutable @Accessor void setEnableCommandBlock(boolean enableCommandBlock);
	@Mutable @Accessor void setEnableJmxMonitoring(boolean enableJmxMonitoring);
	@Mutable @Accessor void setEnableQuery(boolean enableQuery);
	@Mutable @Accessor void setEnableRcon(boolean enableRcon);
	@Mutable @Accessor void setEnableStatus(boolean enableStatus);
	@Mutable @Accessor void setEnforceWhitelist(boolean enforceWhitelist);
	@Mutable @Accessor void setEntityBroadcastRangePercentage(int entityBroadcastRangePercentageProperty);
	@Mutable @Accessor void setForceGameMode(boolean forceGamemode);
	@Mutable @Accessor void setFunctionPermissionLevel(int functionPermissionLevel);
	@Mutable @Accessor void setGamemode(GameType gamemode);
	@Mutable @Accessor void setHardcore(boolean hardcore);
	@Mutable @Accessor void setHideOnlinePlayers(boolean hideOnlinePlayers);
	@Mutable @Accessor void setMaxPlayers(int maxPlayers);
	@Mutable @Accessor void setMaxWorldSize(int maxWorldSize);
	@Mutable @Accessor void setMotd(String motd);
	@Mutable @Accessor void setNetworkCompressionThreshold(int networkCompressionThreshold);
	@Mutable @Accessor void setOnlineMode(boolean onlineMode);
	@Mutable @Accessor void setOpPermissionLevel(int opPermissionLevel);
	@Mutable @Accessor void setPreventProxyConnections(boolean preventProxyConnections);
	@Mutable @Accessor void setPvp(boolean spawnPvp);
	@Mutable @Accessor void setQueryPort(int queryPort);
	@Mutable @Accessor void setRconPassword(String rconPassword);
	@Mutable @Accessor void setRconPort(int rconPort);
	@Mutable @Accessor void setRequireResourcePack(boolean requireResourcePack);
	@Mutable @Accessor void setResourcePack(String resourcePack);
	@Mutable @Accessor void setResourcePackPrompt(String resourcePackPrompt);
	@Mutable @Accessor void setResourcePackSha1(String sha1);
	@Mutable @Accessor void setSimulationDistance(int simulationDistance);
	@Mutable @Accessor void setSpawnAnimals(boolean spawnAnimals);
	@Mutable @Accessor void setSpawnMonsters(boolean spawnMonsters);
	@Mutable @Accessor void setSpawnNpcs(boolean spawnNpcs);
	@Mutable @Accessor void setSpawnProtection(int spawnProtection);
	@Mutable @Accessor void setViewDistance(int viewDistance);
}
