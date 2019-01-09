package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.Ironclad;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.util.ArrayList;

@SpirePatch(clz = Ironclad.class, method = "getStartingRelics")
public class getIroncladStartingRelicPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, Ironclad __instance) {
        // Clear out the original relics
        __result.clear();
        // Add the relic 'Pandora's Box' to the starting relics
        __result.add("Pandora's Box");
        // Remove the 'Pandora's Box' from the relic tracker
        UnlockTracker.markRelicAsSeen("Pandora's Box");

        // Remove the 'Burning Blood' from the relic tracker
        UnlockTracker.markRelicAsSeen("Burning Blood");
        // Return the relics that Ironclad will start with
        return __result;
    }
}
