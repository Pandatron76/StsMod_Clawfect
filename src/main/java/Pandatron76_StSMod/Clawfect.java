package Pandatron76_StSMod;

import Pandatron76_StSMod.cards.custom_blue.*;
import Pandatron76_StSMod.custom_relics.DRClaw;
import basemod.BaseMod;
import basemod.ModLabel;
import basemod.helpers.RelicType;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.ModPanel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;

@SpireInitializer
public class Clawfect implements
        PostInitializeSubscriber,
        EditCardsSubscriber,
        EditStringsSubscriber,
        EditRelicsSubscriber {

    public static final Logger logger = LogManager.getLogger(Clawfect.class.getSimpleName());
    public static final String MODNAME = "Pandatron76_StSMod.Clawfect";
    public static final String AUTHOR = "Pandatron76";
    public static final String DESCRIPTION = "v1.0.0\n Defect loves his claws <3. Custom mod for friend";

    public static final float TBD_LABEL_X = 350.0f;
    public static final float TBD_LABEL_Y = 750.0f;

    public static final String ASSETS_FOLDER = "img";
    public static final String BADGE_IMG = "/badges/ClawfectBadge.png";

    public static Boolean RestConfirmPopupFlag = true;

    public Clawfect() {

        BaseMod.subscribe(this);
        logger.info("Subscribing to PostInitializeSubscriber event");
        logger.info("Subscribing to EditRelicsSubscriber event");
        logger.info("Subscribing to EditStringsSubscriber event");

    }

    public static void initialize() {
        Clawfect clawClawDefect = new Clawfect();
    }

    @Override
    public void receiveEditRelics(){
        BaseMod.addRelic(new DRClaw(), RelicType.SHARED);
    }

    @Override
    public void receiveEditCards() {

        //Add the new Claw cards
        BaseMod.addCard(new ClawLightning());
        BaseMod.addCard(new Clawrage());
        BaseMod.addCard(new ClawCell());
        BaseMod.addCard(new ClawSnap());
        BaseMod.addCard(new ClawpileDriver());
        BaseMod.addCard(new ClawAndTear());
        BaseMod.addCard(new ClawForTheEyes());
        BaseMod.addCard(new ClawingBeam());
        BaseMod.addCard(new ClawAndGloom());
        BaseMod.addCard(new ClawForOne());
        BaseMod.addCard(new Clawline());
        BaseMod.addCard(new Clawter());
        BaseMod.addCard(new Clawzard());
        BaseMod.addCard(new FTC());
        BaseMod.addCard(new ScrapingClaw());

        //Unlock all the newly added claw cards
        UnlockTracker.unlockCard(ClawLightning.ID);
        UnlockTracker.unlockCard(Clawrage.ID);
        UnlockTracker.unlockCard(ClawCell.ID);
        UnlockTracker.unlockCard(ClawSnap.ID);
        UnlockTracker.unlockCard(ClawpileDriver.ID);
        UnlockTracker.unlockCard(ClawAndTear.ID);
        UnlockTracker.unlockCard(ClawForTheEyes.ID);
        UnlockTracker.unlockCard(ClawingBeam.ID);
        UnlockTracker.unlockCard(ClawAndGloom.ID);
        UnlockTracker.unlockCard(ClawForOne.ID);
        UnlockTracker.unlockCard(Clawline.ID);
        UnlockTracker.unlockCard(Clawter.ID);
        UnlockTracker.unlockCard(Clawzard.ID);
        UnlockTracker.unlockCard(FTC.ID);
        UnlockTracker.unlockCard(ScrapingClaw.ID);

        //Remove the non-claw related counter parts (originals)
        BaseMod.removeCard("Ball Lightning", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Barrage", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Beam Cell", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Cold Snap", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Compile Driver", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Rip and Tear", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Go for the Eyes", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Sweeping Beam", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Doom and Gloom", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("All For One", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Streamline", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Melter", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Blizzard", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("FTL", AbstractCard.CardColor.BLUE);
        BaseMod.removeCard("Scrape", AbstractCard.CardColor.BLUE);
    }

    @Override
    public void receiveEditStrings(){

        String relicStrings = Gdx.files.internal("localization/Custom-RelicStrings.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);

        String cardStrings = Gdx.files.internal("localization/CustomDefect-CardStrings.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CardStrings.class, cardStrings);

    }

    @Override
    public void receivePostInitialize() {

        Texture badgeTexture = new Texture(makePath(BADGE_IMG));
        ModPanel settingsPanel = new ModPanel();
        ModLabel TBD_Label = new ModLabel("Nothing here at this time. Enjoy the mod :)",
                TBD_LABEL_X,
                TBD_LABEL_Y,
                settingsPanel, me -> {});

        settingsPanel.addUIElement(TBD_Label);

        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION , settingsPanel);

        Settings.isDailyRun = false;
        Settings.isTrial = false;
        Settings.isDemo = false;
    }

    public static final String makeCardImagePath(String cardName) {
        return makePath("cards/" + cardName);
    }

    /**
     * Makes a full path for a resource path
     * @param resource the resource, must *NOT* have a leading "/"
     * @return the full path
     */
    public static final String makePath(String resource) {
        String result = ASSETS_FOLDER + "/clawfect/" + resource;

        if (! hasExtension(resource)) {
            result += ".png";
        }

        return result;
    }

    private static boolean hasExtension(String filename) {
        return filename.lastIndexOf('.') > 0;
    }

}
