package Pandatron76_StSMod.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class CardTagsEnum {

    // Adding 'CLAW' as a CardTag so all the 'Claw' type cards can reference/scale off each other
    // TODO: Make the concept of a card scaling off another card being played a keyword (to reduce text on card).
    @SpireEnum
    public static AbstractCard.CardTags CLAW;
}
