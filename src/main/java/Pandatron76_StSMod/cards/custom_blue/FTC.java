package Pandatron76_StSMod.cards.custom_blue;

import Pandatron76_StSMod.Clawfect;
import basemod.abstracts.CustomCard;

import Pandatron76_StSMod.patches.CardTagsEnum;

import com.megacrit.cardcrawl.actions.defect.FTLAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.blue.FTL;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static com.megacrit.cardcrawl.cards.blue.FTL.EXTENDED_DESCRIPTION;

public class FTC extends CustomCard {

    public static final String ID = "Clawfect:FTC";
    public static final String IMG_NAME = ID.split(":")[1];
    public static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final int COST = 0;
    public static final int ATTACK_DMG = -5;
    public static final int MAGIC_NUMBER = 2;

    public FTC(){

        super(ID, NAME, Clawfect.makeCardImagePath(IMG_NAME), COST, DESCRIPTION,
                AbstractCard.CardType.ATTACK, CardColor.BLUE, CardRarity.COMMON, CardTarget.ENEMY);

        this.baseDamage = ATTACK_DMG;
        this.baseMagicNumber = MAGIC_NUMBER;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTagsEnum.CLAW);
    }

    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        AbstractDungeon.actionManager.addToBottom(new FTLAction(monster, new DamageInfo(player, this.damage, this.damageTypeForTurn), this.magicNumber));

        this.rawDescription = DESCRIPTION;
        initializeDescription();
    }

    public void applyPowers()
    {
        super.applyPowers();

        int count = AbstractDungeon.actionManager.cardsPlayedThisTurn.size();

        this.rawDescription = DESCRIPTION;
        this.rawDescription = (this.rawDescription + EXTENDED_DESCRIPTION[0] + count);
        if (count == 1) {
            this.rawDescription += EXTENDED_DESCRIPTION[1];
        } else {
            this.rawDescription += EXTENDED_DESCRIPTION[2];
        }
        initializeDescription();
    }

    public void onMoveToDiscard()
    {
        this.rawDescription = DESCRIPTION;
        initializeDescription();
    }

    public AbstractCard makeCopy()
    {
        return new FTL();
    }

    public void upgrade()
    {
        if (!this.upgraded)
        {
            upgradeName();
            upgradeDamage(1);
            upgradeMagicNumber(1);
        }
    }
}
