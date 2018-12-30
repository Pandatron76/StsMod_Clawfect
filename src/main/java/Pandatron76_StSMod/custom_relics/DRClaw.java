package Pandatron76_StSMod.custom_relics;

import basemod.abstracts.CustomRelic;

import com.badlogic.gdx.graphics.Texture;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class DRClaw extends CustomRelic {

    public static final String ID = "Clawfect:DRClaw";
    public static final String IMG = "img/clawfect/custom_relics/DRClaw.png";

    public DRClaw(){
        super(ID, new Texture(IMG), RelicTier.STARTER, LandingSound.MAGICAL);
    }

    //Claws are 0 and as such players should have less energy per turn to compensate for it.
    public void onEquip()
    {
        AbstractDungeon.player.energy.energyMaster -= 1;
    }

    @Override
    public String getUpdatedDescription(){
        return DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy(){
        return new DRClaw();
    }
}
