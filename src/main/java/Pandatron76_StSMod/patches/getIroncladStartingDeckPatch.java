package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.Ironclad;

import java.util.ArrayList;

@SpirePatch(clz = Ironclad.class, method = "getStartingDeck")
public class getIroncladStartingDeckPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, Ironclad __instance) {

        // Clear out the original deck
        __result.clear();

        // Add "Bash" to the deck
        __result.add("Bash");

        // Return the deck
        return __result;
    }

}
