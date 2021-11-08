package chylex.serverproperties.props;
import chylex.serverproperties.props.supported.AllowFlightProperty;
import chylex.serverproperties.props.supported.AllowNetherProperty;
import chylex.serverproperties.props.supported.BroadcastConsoleToOpsProperty;
import chylex.serverproperties.props.supported.BroadcastRconToOpsProperty;
import chylex.serverproperties.props.supported.DifficultyProperty;
import chylex.serverproperties.props.supported.EnableCommandBlockProperty;
import chylex.serverproperties.props.supported.EnableJmxMonitoringProperty;
import chylex.serverproperties.props.supported.EnableQueryProperty;
import chylex.serverproperties.props.supported.EnableRconProperty;
import chylex.serverproperties.props.supported.EnableStatusProperty;
import chylex.serverproperties.props.supported.EnforceWhitelistProperty;
import chylex.serverproperties.props.supported.EntityBroadcastRangePercentageProperty;
import chylex.serverproperties.props.supported.ForceGamemodeProperty;
import chylex.serverproperties.props.supported.FunctionPermissionLevel;
import chylex.serverproperties.props.supported.GamemodeProperty;
import chylex.serverproperties.props.supported.HardcoreProperty;
import chylex.serverproperties.props.supported.MaxPlayersProperty;
import chylex.serverproperties.props.supported.MaxWorldSizeProperty;
import chylex.serverproperties.props.supported.MotdProperty;
import chylex.serverproperties.props.supported.NetworkCompressionThresholdProperty;
import chylex.serverproperties.props.supported.OnlineModeProperty;
import chylex.serverproperties.props.supported.OpPermissionLevel;
import chylex.serverproperties.props.supported.PlayerIdleTimeoutProperty;
import chylex.serverproperties.props.supported.PreventProxyConnectionsProperty;
import chylex.serverproperties.props.supported.PvpProperty;
import chylex.serverproperties.props.supported.QueryPortProperty;
import chylex.serverproperties.props.supported.RconPasswordProperty;
import chylex.serverproperties.props.supported.RconPortProperty;
import chylex.serverproperties.props.supported.RequireResourcePackProperty;
import chylex.serverproperties.props.supported.ResourcePackPromptProperty;
import chylex.serverproperties.props.supported.ResourcePackProperty;
import chylex.serverproperties.props.supported.ResourcePackSha1Property;
import chylex.serverproperties.props.supported.SimulationDistanceProperty;
import chylex.serverproperties.props.supported.SpawnAnimalsProperty;
import chylex.serverproperties.props.supported.SpawnMonstersProperty;
import chylex.serverproperties.props.supported.SpawnNpcsProperty;
import chylex.serverproperties.props.supported.SpawnProtectionProperty;
import chylex.serverproperties.props.supported.ViewDistanceProperty;
import chylex.serverproperties.props.supported.WhiteListProperty;
import chylex.serverproperties.props.unsupported.GenerateStructuresProperty;
import chylex.serverproperties.props.unsupported.GeneratorSettingsProperty;
import chylex.serverproperties.props.unsupported.LevelNameProperty;
import chylex.serverproperties.props.unsupported.LevelSeedProperty;
import chylex.serverproperties.props.unsupported.LevelTypeProperty;
import chylex.serverproperties.props.unsupported.MaxTickTimeProperty;
import chylex.serverproperties.props.unsupported.RateLimitProperty;
import chylex.serverproperties.props.unsupported.ResourcePackHashProperty;
import chylex.serverproperties.props.unsupported.ServerIpProperty;
import chylex.serverproperties.props.unsupported.ServerPortProperty;
import chylex.serverproperties.props.unsupported.SyncChunkWrites;
import chylex.serverproperties.props.unsupported.TextFilteringConfigProperty;
import chylex.serverproperties.props.unsupported.UseNativeTransportProperty;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ServerProperties {
	private static final Map<String, ServerProperty<?>> ALL = new HashMap<>();
	
	public static Collection<Entry<String, ServerProperty<?>>> all() {
		return Collections.unmodifiableCollection(ALL.entrySet());
	}
	
	private static void register(final String name, final ServerProperty<?> property) {
		if (ALL.put(name, property) != null) {
			throw new IllegalArgumentException("Server property with name '" + name + "' is already registered!");
		}
	}
	
	static {
		register("allow-flight", AllowFlightProperty.INSTANCE);
		register("allow-nether", AllowNetherProperty.INSTANCE);
		register("broadcast-console-to-ops", BroadcastConsoleToOpsProperty.INSTANCE);
		register("broadcast-rcon-to-ops", BroadcastRconToOpsProperty.INSTANCE);
		register("difficulty", DifficultyProperty.INSTANCE);
		register("enable-command-block", EnableCommandBlockProperty.INSTANCE);
		register("enable-jmx-monitoring", EnableJmxMonitoringProperty.INSTANCE);
		register("enable-query", EnableQueryProperty.INSTANCE);
		register("enable-rcon", EnableRconProperty.INSTANCE);
		register("enable-status", EnableStatusProperty.INSTANCE);
		register("enforce-whitelist", EnforceWhitelistProperty.INSTANCE);
		register("entity-broadcast-range-percentage", EntityBroadcastRangePercentageProperty.INSTANCE);
		register("force-gamemode", ForceGamemodeProperty.INSTANCE);
		register("function-permission-level", FunctionPermissionLevel.INSTANCE);
		register("gamemode", GamemodeProperty.INSTANCE);
		register("hardcore", HardcoreProperty.INSTANCE);
		register("max-players", MaxPlayersProperty.INSTANCE);
		register("max-world-size", MaxWorldSizeProperty.INSTANCE);
		register("motd", MotdProperty.INSTANCE);
		register("network-compression-threshold", NetworkCompressionThresholdProperty.INSTANCE);
		register("online-mode", OnlineModeProperty.INSTANCE);
		register("op-permission-level", OpPermissionLevel.INSTANCE);
		register("player-idle-timeout", PlayerIdleTimeoutProperty.INSTANCE);
		register("prevent-proxy-connections", PreventProxyConnectionsProperty.INSTANCE);
		register("pvp", PvpProperty.INSTANCE);
		register("query.port", QueryPortProperty.INSTANCE);
		register("rcon.password", RconPasswordProperty.INSTANCE);
		register("rcon.port", RconPortProperty.INSTANCE);
		register("require-resource-pack", RequireResourcePackProperty.INSTANCE);
		register("resource-pack", ResourcePackProperty.INSTANCE);
		register("resource-pack-prompt", ResourcePackPromptProperty.INSTANCE);
		register("resource-pack-sha1", ResourcePackSha1Property.INSTANCE);
		register("simulation-distance", SimulationDistanceProperty.INSTANCE);
		register("spawn-animals", SpawnAnimalsProperty.INSTANCE);
		register("spawn-monsters", SpawnMonstersProperty.INSTANCE);
		register("spawn-npcs", SpawnNpcsProperty.INSTANCE);
		register("spawn-protection", SpawnProtectionProperty.INSTANCE);
		register("view-distance", ViewDistanceProperty.INSTANCE);
		register("white-list", WhiteListProperty.INSTANCE);
		
		register("generate-structures", GenerateStructuresProperty.INSTANCE);
		register("generator-settings", GeneratorSettingsProperty.INSTANCE);
		register("level-name", LevelNameProperty.INSTANCE);
		register("level-seed", LevelSeedProperty.INSTANCE);
		register("level-type", LevelTypeProperty.INSTANCE);
		register("max-tick-time", MaxTickTimeProperty.INSTANCE);
		register("rate-limit", RateLimitProperty.INSTANCE);
		register("resource-pack-hash", ResourcePackHashProperty.INSTANCE);
		register("server-ip", ServerIpProperty.INSTANCE);
		register("server-port", ServerPortProperty.INSTANCE);
		register("sync-chunk-writes", SyncChunkWrites.INSTANCE);
		register("text-filtering-config", TextFilteringConfigProperty.INSTANCE);
		register("use-native-transport", UseNativeTransportProperty.INSTANCE);
	}
	
	private ServerProperties() {}
}
