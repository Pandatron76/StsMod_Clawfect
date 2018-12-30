package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.Defect;
import com.megacrit.cardcrawl.helpers.CardLibrary;

import java.util.ArrayList;

@SpirePatch(clz= Defect.class, method="getStartingDeck")
public class getStartingDeckPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, Defect __instance) {

        //Clear out the original Deck
        __result.clear();

        // Defect's starting deck will be 10 cards (5 'Claws' and 5 'Defends')
        // Add Claws (Its ID is "Gash")
        for(int i = 0; i <=4; i++) {
            __result.add("Gash");
        }

        // Add Defends
        for(int i = 0; i <=4; i++) {
            __result.add("Defend_B");
        }

        return __result;
    }
}

