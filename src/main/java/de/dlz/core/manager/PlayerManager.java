package de.dlz.core.manager;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import de.dlz.core.Core;
import de.dlz.core.pojo.CRPPlayer;
import de.dlz.core.pojo.RPPlayer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerManager {

  private final Core core;
  private final Cache<UUID, RPPlayer> playerCache = CacheBuilder
      .newBuilder()
      .expireAfterWrite(30, TimeUnit.MINUTES)
      .build(
          new CacheLoader<>() {
            @Override
            public @NotNull RPPlayer load(@NotNull UUID key) {
              return new CRPPlayer(key, core);
            }
          }
      );

  public PlayerManager(Core core) {
    this.core = core;
  }

  public RPPlayer getRPPlayer(UUID uuid){
    return playerCache.getIfPresent(uuid);
  }

  public RPPlayer getRPPlayer(Player player){
    return playerCache.getIfPresent(player.getUniqueId());
  }

  public void saveAll(){
    this.playerCache.asMap().forEach((uuid, rpPlayer) -> rpPlayer.save());
  }


}
