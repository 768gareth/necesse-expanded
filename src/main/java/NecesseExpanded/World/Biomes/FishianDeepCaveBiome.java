package NecesseExpanded.World.Biomes;

import necesse.engine.AbstractMusicList;
import necesse.engine.MusicList;
import necesse.engine.registries.MusicRegistry;
import necesse.engine.sound.GameMusic;
import necesse.entity.mobs.PlayerMob;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.MobSpawnTable;
import necesse.level.maps.biomes.swamp.SwampBiome;

public class FishianDeepCaveBiome extends SwampBiome
{ 
  public MobSpawnTable getMobSpawnTable(Level level) {
    return new MobSpawnTable().add(100, "staticjellyfish");
  }
  
  public MobSpawnTable getCritterSpawnTable(Level level) {
    return deepCaveCritters;
  }
  
  public float getSpawnRateMod(Level level) {
    return super.getSpawnRateMod(level) * 1.2F;
  }
  
  public AbstractMusicList getLevelMusic(Level level, PlayerMob perspective) {
    return (AbstractMusicList)new MusicList(new GameMusic[] { MusicRegistry.Away });
  }
}
