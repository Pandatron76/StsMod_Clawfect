package Pandatron76_StSMod.cards.custom_blue;

import Pandatron76_StSMod.actions.defect.ClawTagAction;
import basemod.abstracts.CustomCard;

import Pandatron76_StSMod.Clawfect;
import Pandatron76_StSMod.patches.CardTagsEnum;

import com.megacrit.cardcrawl.actions.unique.RipAndTearAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ClawAndTear extends CustomCard {

    public static final String ID = "ClawAndTear";
    public static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final int COST = 0;
    private static final int ATTACK_DMG = -7;
    private static final int NUM_ATTACKS = 2;

    public ClawAndTear() {

        super(ID, NAME, Clawfect.makeCardImagePath(ID), COST, DESCRIPTION,
                AbstractCard.CardType.ATTACK, CardColor.BLUE, CardRarity.UNCOMMON, CardTarget.ENEMY);

        this.baseDamage = ATTACK_DMG;
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTagsEnum.CLAW);
    }

    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        AbstractDungeon.actionManager.addToBottom(new RipAndTearAction(
                AbstractDungeon.getMonsters().getRandomMonster(true), new DamageInfo(
                        player, this.baseDamage), this.magicNumber));

        AbstractDungeon.actionManager.addToBottom(new ClawTagAction(this, this.magicNumber));

    }

    public AbstractCard makeCopy()
    {
        return new ClawAndTear();
    }

    public void upgrade()
    {
        if (!this.upgraded)
        {
            upgradeName();
            upgradeDamage(2);
        }
    }


}
