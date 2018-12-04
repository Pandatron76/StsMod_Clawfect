package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.Defect;

import java.util.ArrayList;

@SpirePatch(clz= Defect.class, method="getStartingDeck")
public class getStartingDeckPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, Defect __instance) {

        //Clear out the original Deck
        __result.clear();

        for(int i = 0; i <=4; i++) {
            __result.add("VintageClaw");
        }

        for(int i = 0; i <=4; i++) {
            __result.add("Defend_B");
        }

        // Test Deck
        // Comment out the real deck and make a test deck below

        return __result;
    }
}

