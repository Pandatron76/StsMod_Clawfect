package Pandatron76_StSMod.patches;

import Pandatron76_StSMod.custom_relics.DRClaw;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.Defect;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.util.ArrayList;

@SpirePatch(clz=Defect.class, method="getStartingRelics")
public class getStartingRelicsPatch {

    public static ArrayList<String> Postfix(ArrayList<String> __result, Defect __instance) {
        // Remove Cracked Core from the starting relics
        __result.remove("Cracked Core");
        // Add the custom relic 'Dr. Claw' to the starting relics
        __result.add(DRClaw.ID);
        // Remove the 'Dr. Claw' from the relic tracker
        UnlockTracker.markRelicAsSeen(DRClaw.ID);

        // Remove the 'Cracked Core' from the relic tracker
        UnlockTracker.markRelicAsSeen("Cracked Core");
        // Return the relics that Defect will start with
        return __result;
    }
}
