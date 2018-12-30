package Pandatron76_StSMod.actions.defect;

import Pandatron76_StSMod.patches.CardTagsEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

//Effectively this is a copy of the 'GashAction'. The difference is checking for CardTagsEnum 'CLAW'
// TODO: Update so it can accept any cardTag to scale any type(s) of cards.
public class ClawTagAction extends AbstractGameAction {

    private AbstractCard card;

    public ClawTagAction(AbstractCard card, int amount){

        this.duration = Settings.ACTION_DUR_FAST;
        this.card = card;
        this.amount = amount;
    }

    public void update(){

        if (this.duration == Settings.ACTION_DUR_FAST){

            this.card.baseDamage += this.amount;
            this.card.applyPowers();

            for (AbstractCard card : AbstractDungeon.player.discardPile.group) {
                if ((card.tags.contains(CardTagsEnum.CLAW)))
                {
                    card.baseDamage += this.amount;
                    card.applyPowers();
                }
            }
            for (AbstractCard card : AbstractDungeon.player.drawPile.group) {
                if ((card.tags.contains(CardTagsEnum.CLAW)))
                {
                    card.baseDamage += this.amount;
                    card.applyPowers();
                }
            }
            for (AbstractCard card : AbstractDungeon.player.hand.group) {
                if ((card.tags.contains(CardTagsEnum.CLAW)))
                {
                    card.baseDamage += this.amount;
                    card.applyPowers();
                }
            }
        }
        tickDuration();
    }
}
