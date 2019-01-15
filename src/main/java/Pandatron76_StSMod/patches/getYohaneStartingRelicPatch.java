package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import yohanemod.Yohane;

import java.util.ArrayList;

@SpirePatch(cls = "yohanemod.Yohane", method = "getStartingRelics", optional = true)
public class getYohaneStartingRelicPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, Yohane __instance){

        // Remove Angel Wings from the starting relics
        __result.remove("Yohane:AngelWings");

        // Add the relic 'Pandora's Box' to the starting relics
        __result.add("Pandora's Box");

        // Remove the 'Pandora's Box' from the relic tracker
        UnlockTracker.markRelicAsSeen("Pandora's Box");
        // Remove the 'Angel Wings' from the relic tracker
        UnlockTracker.markRelicAsSeen("Yohane:AngelWings");

        // Return the relics that Yohane will start with
        return __result;
    }
}
