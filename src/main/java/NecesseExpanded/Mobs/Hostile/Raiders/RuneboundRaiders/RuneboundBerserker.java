package NecesseExpanded.Mobs.Hostile.Raiders.RuneboundRaiders;

import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.inventory.InventoryItem;

public class RuneboundBerserker extends RuneboundRaiderTemplate
{
    public RuneboundBerserker()
    {
        super();
        setSpeed(30F);
        this.setMaxHealth(350);
        this.buffManager.addBuff(new ActiveBuff("greaterattackspeedpotion", this, 720, null), true, true);

        this.setWeapon(new InventoryItem("battleaxe_special"));
        this.helmet = new InventoryItem("wig");
        this.chest = new InventoryItem("runeboundleatherchest");
    }
}
