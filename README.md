# How to Use

Use the command `/properties reload` to reload the server.properties file (requires permission level 2 or higher). You will see a report of which properties were changed, and which are unsupported.

## Supported Properties

As of 1.18, the following properties are supported:

- `allow-flight`
- `allow-nether`
- `broadcast-console-to-ops`
- `broadcast-rcon-to-ops`
- `difficulty`
- `enable-command-block`
- `enable-jmx-monitoring`
- `enable-query`
- `enable-rcon`
- `enable-status`
- `enforce-whitelist`
  - When enabled, it will kick non-whitelisted players even if the whitelist is disabled. This is consistent with Minecraft's existing inconsistency (for ex. `/deop` command will do the same).
- `entity-broadcast-range-percentage`
- `force-gamemode`
  - Only affects players who login after the change.
  - Use `/defaultgamemode` to set game mode for all online players.
- `function-permission-level`
  - Only takes place after reloading resource packs using `/reload`.
- `gamemode`
  - Only affects players who login after the change.
  - Use `/defaultgamemode` to set game mode for all online players.
- `hardcore`
  - The heart icon and respawn menu will only update for players who login after the change, but respawning itself works as expected.
- `max-players`
  - Only affects players who try to login after the change.
- `max-world-size`
- `motd`
- `network-compression-threshold`
  - Only affects players who login after the change.
  - When changed while a player is logging in, it might cause the connection to be setup incorrectly and cause errors. Be careful.
- `online-mode`
  - Only affects players who login after the change.
- `op-permission-level`
  - Works the same as editing `server.properties` and restarting, i.e. it only applies to users `/op`'d after the change and does not affect existing operators.
- `player-idle-timeout`
- `prevent-proxy-connections`
  - Only affects players who login after the change.
- `pvp`
- `query.port`
- `rcon.password`
  - Any currently connected RCON clients will be disconnected.
- `rcon.port`
  - Any currently connected RCON clients will be disconnected.
- `require-resource-pack`
  - Only affects players who login after the change.
- `resource-pack`
  - Only affects players who login after the change.
- `resource-pack-prompt`
  - Only affects players who login after the change.
- `resource-pack-sha1`
  - Only affects players who login after the change.
- `simulation-distance`
- `spawn-animals`
- `spawn-monsters`
- `spawn-npcs`
- `spawn-protection`
- `view-distance`
- `white-list`

## Unsupported Properties

- `generate-structures`
- `generator-settings`
- `level-name`
- `level-seed`
- `level-type`
- `max-tick-time`
- `rate-limit`
- `resource-pack-hash`
  - Use `resource-pack-sha1` instead.
- `server-ip`
- `server-port`
- `snooper-enabled`
- `sync-chunk-writes`
- `text-filtering-config`
- `use-native-transport`

# Installation

The mod only works on dedicated servers. The following mod loaders are supported:

- **Fabric** (note: this mod does not require Fabric API)
- **Forge**

After you install the mod loader of your choice, download the mod and place the .jar file into the mods folder of your server.
