package Pandatron76_StSMod.cards.custom_blue;

import Pandatron76_StSMod.Clawfect;
import Pandatron76_StSMod.actions.defect.ClawTagAction;
import Pandatron76_StSMod.patches.CardTagsEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class ClawCell extends CustomCard {

    public static final String ID = "ClawCell";
    public static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final int COST = 0;
    public static final int ATTACK_DMG = -2;
    public static final int MAGIC_NUMBER = 1;

    public ClawCell() {

        super(ID, NAME, Clawfect.makeCardImagePath(ID), COST, DESCRIPTION,
                AbstractCard.CardType.ATTACK, CardColor.BLUE, CardRarity.COMMON, CardTarget.ENEMY);

        this.baseDamage = ATTACK_DMG;
        this.baseMagicNumber = MAGIC_NUMBER;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTagsEnum.CLAW);
    }

    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(
                monster, new DamageInfo(player, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));

        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(monster, player, new VulnerablePower(
                monster, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));

        AbstractDungeon.actionManager.addToBottom(new ClawTagAction(this, this.magicNumber));
    }

    public AbstractCard makeCopy()
    {
        return new ClawCell();
    }

    public void upgrade()
    {
        if (!this.upgraded)
        {
            upgradeDamage(1);
            upgradeName();
        }
    }




}
