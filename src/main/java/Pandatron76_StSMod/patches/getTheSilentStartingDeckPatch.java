package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.TheSilent;

import java.util.ArrayList;

@SpirePatch(clz = TheSilent.class, method = "getStartingDeck")
public class getTheSilentStartingDeckPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, TheSilent __instance) {

        // Clear out the original deck
        __result.clear();

        // Add "Survivor" and "Neutralize" to the deck
        __result.add("Survivor");
        __result.add("Neutralize");

        // Return the empty deck
        return __result;
    }
}
