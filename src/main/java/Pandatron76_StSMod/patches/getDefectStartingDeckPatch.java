package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.Defect;

import java.util.ArrayList;

@SpirePatch(clz = Defect.class, method = "getStartingDeck")
public class getDefectStartingDeckPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, Defect __instance) {

        // Clear out the original deck
        __result.clear();

        // Add "Zap" and "Dualcast" to the deck
        __result.add("Zap");
        __result.add("Dualcast");

        // Return the deck
        return __result;
    }
}
