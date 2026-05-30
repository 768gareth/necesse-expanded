package NecesseExpanded.Patches.Gameplay;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.PlayerMob;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = PlayerMob.class, arguments = {}, name = "clientTick")
public class PlayerMobPatch 
{
    @OnMethodExit
    static void onExit(@This PlayerMob Player) 
    {
        if (NecesseExpanded.Main.SettingsGetter.getBoolean("player_speed_patch"))
        {
            Player.setSpeed((float)(NecesseExpanded.Main.SettingsGetter.getInt("player_speed_value")));
        }
    }
}
