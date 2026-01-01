package NecesseExpanded.Patches.Gameplay;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.inventory.InventoryItem;
import necesse.inventory.PlayerInventoryManager;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodEnter;
import net.bytebuddy.asm.Advice.This;

@ModMethodPatch(target = PlayerInventoryManager.class, name = "giveStarterItems", arguments = {})
public class PlayerInventoryPatch {
    @OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@This PlayerInventoryManager Manager) 
    {
        if (NecesseExpanded.Main.SettingsGetter.getBoolean("starter_equipment_enabled"))
        {
            System.out.println("[Necesse Expanded] Updating player starting equipment...");
            Manager.giveLookArmor();
            InventoryItem Torches = new InventoryItem("torch");
            Torches.setAmount(50);
            InventoryItem HealthPotions = new InventoryItem("healthpotion");
            HealthPotions.setAmount(10);
            InventoryItem FoodItem = new InventoryItem("bread");
            FoodItem.setAmount(10);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, new InventoryItem("ironsword"), "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, new InventoryItem("ironpickaxe"), "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, new InventoryItem("ironaxe"), "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, new InventoryItem("ironshovel"), "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, Torches, "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, HealthPotions, "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, FoodItem, "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, new InventoryItem("recipebook"), "startitem", null);
            Manager.main.addItem(Manager.player.getLevel(), Manager.player, new InventoryItem("leatherdashers"), "startitem", null);
            return true;
        }
        return false;
    }
}
