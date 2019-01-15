package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.TheSilent;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.util.ArrayList;

@SpirePatch(clz = TheSilent.class, method = "getStartingRelics")
public class getTheSilentStartingRelicPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, TheSilent __instance) {
        // Remove Ring of the Snake from the starting relics
        __result.remove("Ring of the Snake");

        // Add the relic 'Pandora's Box' to the starting relics
        __result.add("Pandora's Box");

        // Remove the 'Pandora's Box' from the relic tracker
        UnlockTracker.markRelicAsSeen("Pandora's Box");
        // Remove the 'Ring of the Snake' from the relic tracker
        UnlockTracker.markRelicAsSeen("Ring of the Snake");

        // Return the relics that TheSilent will start with
        return __result;
    }
}
