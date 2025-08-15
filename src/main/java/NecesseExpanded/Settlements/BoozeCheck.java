package NecesseExpanded.Settlements;

import necesse.engine.registries.ItemRegistry;

public class BoozeCheck 
{
    private static final int BEER  = ItemRegistry.getItemID("beer");
    private static final int CIDER = ItemRegistry.getItemID("cider");
    private static final int MEAD  = ItemRegistry.getItemID("mead");
    private static final int WINE  = ItemRegistry.getItemID("wine");

    public static Boolean Check(int ID)
    {
        return ID == BEER || ID == CIDER || ID == MEAD || ID == WINE;
    }
}
