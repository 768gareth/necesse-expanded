package NecesseExpanded.Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import necesse.engine.registries.GameRegistry;

public class ClearRegistry 
{
    @SuppressWarnings("rawtypes")
    public static void Clear(GameRegistry<?> Registry) {
    try {
      Field listField = GameRegistry.class.getDeclaredField("list");
      listField.setAccessible(true);
      ((ArrayList)listField.get(Registry)).clear();
      Field IDMapField = GameRegistry.class.getDeclaredField("stringIDToIDMap");
      IDMapField.setAccessible(true);
      ((HashMap)IDMapField.get(Registry)).clear();
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
}
