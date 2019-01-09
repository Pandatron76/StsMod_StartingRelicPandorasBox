package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;


@SpirePatch(clz = AbstractPlayer.class, method = "initializeStarterDeck")
public class initializeStarterDeckPatch {

    public static void Postfix(AbstractPlayer __instance) {

        int deck_size = 0;

        if (__instance.chosenClass.name().equals("IRONCLAD")) {
            deck_size = 9;
        } else if (__instance.chosenClass.name().equals("THE_SILENT")) {
            deck_size = 10;
        } else if (__instance.chosenClass.name().equals("DEFECT")) {
            deck_size = 8;
        }

        for(int i = 1; i <= deck_size; i++) {
            __instance.masterDeck.addToTop(AbstractDungeon.returnRandomCard().makeCopy());
        }
    }
}
