package Pandatron76_StSMod.cards.custom_blue;

import Pandatron76_StSMod.Clawfect;
import Pandatron76_StSMod.actions.defect.ClawTagAction;
import Pandatron76_StSMod.patches.CardTagsEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

public class ClawingBeam extends CustomCard {

    public static final String ID = "Clawfect:ClawingBeam";
    public static final String IMG_NAME = ID.split(":")[1];
    public static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final int COST = 1;
    public static final int ATTACK_DMG = -6;
    public static final int MAGIC_NUMBER = 1;

    public ClawingBeam(){

        super(ID, NAME, Clawfect.makeCardImagePath(IMG_NAME), COST, DESCRIPTION,
                AbstractCard.CardType.ATTACK, CardColor.BLUE, CardRarity.COMMON, CardTarget.ALL_ENEMY);

        this.baseDamage = ATTACK_DMG;
        this.isMultiDamage = true;
        this.baseMagicNumber = MAGIC_NUMBER;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTagsEnum.CLAW);
    }

    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        AbstractDungeon.actionManager.addToBottom(new SFXAction("ATTACK_DEFECT_BEAM"));
        AbstractDungeon.actionManager.addToBottom(new VFXAction(player, new CleaveEffect(), 0.1F));
        AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(
                player, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));

        AbstractDungeon.actionManager.addToBottom(new DrawCardAction(player, this.magicNumber));
        AbstractDungeon.actionManager.addToBottom(new ClawTagAction(this, this.magicNumber));
    }

    public AbstractCard makeCopy()
    {
        return new ClawingBeam();
    }

    public void upgrade()
    {
        if (!this.upgraded)
        {
            upgradeName();
            upgradeDamage(3);
        }
    }
}
