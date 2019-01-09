package Pandatron76_StSMod;

import basemod.BaseMod;
import basemod.ModLabel;
import basemod.ModPanel;
import basemod.interfaces.PostInitializeSubscriber;

import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import com.megacrit.cardcrawl.core.Settings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class StartingRelicPandorasBox implements
        PostInitializeSubscriber {

    public static final Logger logger = LogManager.getLogger(StartingRelicPandorasBox.class.getName());
    public static final String MODNAME = "Pandatron76_StSMod.StartingRelicPandorasBox";
    public static final String AUTHOR = "Pandatron76";
    public static final String DESCRIPTION = "v1.0.0\n Replaces starting relic for " +
            "Ironclad, The Silent and Defect with Pandora's Box.";

    public static final float TBD_LABEL_X = 350.0f;
    public static final float TBD_LABEL_Y = 750.0f;

    public static final String ASSETS_FOLDER = "img";
    public static final String BADGE_IMG = "/badges/StartingRelicPandorasBoxBadge.png";

    public StartingRelicPandorasBox() {
        BaseMod.subscribe(this);
        logger.info("Subscribing to PostInitializeSubscriber event");
        logger.info("Subscribing to EditStringsSubscriber event");
        logger.info("Subscribing to EditRelicsSubscriber event");
    }

    public static void initialize(){
        StartingRelicPandorasBox praisePandorasBox = new StartingRelicPandorasBox();
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

    /**
     * Makes a full path for a resource path
     * @param resource the resource, must *NOT* have a leading "/"
     * @return the full path
     */
    public static final String makePath(String resource) {
        String result = ASSETS_FOLDER  + resource;

        if (! hasExtension(resource)) {
            result += ".png";
        }

        return result;
    }

    private static boolean hasExtension(String filename) {
        return filename.lastIndexOf('.') > 0;
    }


}
