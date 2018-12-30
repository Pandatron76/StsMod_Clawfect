package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.blue.Claw;

@SpirePatch(clz = Claw.class, method = SpirePatch.CONSTRUCTOR)
public class cardsBlueClawPatch {
    public static void Postfix(Claw __instance){

        // Set base damage to -3 so scaling is 'reasonable'
        __instance.baseDamage = -3;
        // Give the Claw card the 'CLAW' tag so it can scale with other claws.
        __instance.tags.add(CardTagsEnum.CLAW);
    }
}
