package Pandatron76_StSMod.cards.custom_blue;

import Pandatron76_StSMod.Clawfect;
import basemod.abstracts.CustomCard;

import com.badlogic.gdx.graphics.Color;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.vfx.combat.ClawEffect;

import Pandatron76_StSMod.patches.CardTagsEnum;
import Pandatron76_StSMod.actions.defect.ClawTagAction;

public class ClawLightning extends CustomCard {

    public static final String ID = "Clawfect:ClawLightning";
    public static final String IMG_NAME = ID.split(":")[1];
    public static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final int COST = 0;
    public static final int ATTACK_DMG = -7;

    public ClawLightning() {

        super(ID, NAME, Clawfect.makeCardImagePath(IMG_NAME), COST, DESCRIPTION,
                AbstractCard.CardType.ATTACK, CardColor.BLUE, CardRarity.COMMON, CardTarget.ENEMY);
        this.showEvokeValue = true;
        this.showEvokeOrbCount = 1;
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.baseDamage = ATTACK_DMG;
        this.tags.add(CardTagsEnum.CLAW);

    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster){

        if (monster != null) {
            AbstractDungeon.actionManager.addToBottom(new VFXAction(new ClawEffect(
                    monster.hb.cX, monster.hb.cY, Color.CYAN, Color.WHITE), 0.1F));
        }

        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(monster, new DamageInfo(player, this.damage, this.damageTypeForTurn),
                        AbstractGameAction.AttackEffect.SLASH_HEAVY));
        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
        AbstractDungeon.actionManager.addToBottom(new ClawTagAction(this, this.magicNumber));

    }

    @Override
    public AbstractCard makeCopy() {
        return new ClawLightning();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeDamage(2);
        }
    }
}
