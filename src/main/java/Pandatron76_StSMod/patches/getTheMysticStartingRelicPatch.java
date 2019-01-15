package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import mysticmod.character.MysticCharacter;
import mysticmod.relics.SpellBook;


import java.util.ArrayList;

@SpirePatch(cls = "mysticmod.character.MysticCharacter", method = "getStartingRelics", optional = true)
public class getTheMysticStartingRelicPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, MysticCharacter __instance){

        // Remove Angel Wings from the starting relics
        __result.remove(SpellBook.ID);

        // Add the relic 'Pandora's Box' to the starting relics
        __result.add("Pandora's Box");

        // Remove the 'Pandora's Box' from the relic tracker
        UnlockTracker.markRelicAsSeen("Pandora's Box");
        // Remove the 'Angel Wings' from the relic tracker
        UnlockTracker.markRelicAsSeen(SpellBook.ID);

        // Return the relics that Yohane will start with
        return __result;
    }
}
