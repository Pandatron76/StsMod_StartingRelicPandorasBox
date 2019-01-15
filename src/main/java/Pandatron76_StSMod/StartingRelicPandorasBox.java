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
    public static final String DESCRIPTION = "v1.2.0\n Replaces starting relic for...\n" +
            "Ironclad, The Silent, Defect and many more characters's with Pandora's Box.";

    public static final float SUPPORTED_MODS_LABEL_X = 350.0f;
    public static final float SUPPORTED_MODS_LABEL_Y = 750.0f;

    public static final String ASSETS_FOLDER = "img";
    public static final String BADGE_IMG = "/badges/StartingRelicPandorasBoxBadge.png";

    public StartingRelicPandorasBox() {
        BaseMod.subscribe(this);
        logger.info("Subscribing to PostInitializeSubscriber event");
    }

    public static void initialize(){
        StartingRelicPandorasBox praisePandorasBox = new StartingRelicPandorasBox();
    }

    @Override
    public void receivePostInitialize() {

        Texture badgeTexture = new Texture(makePath(BADGE_IMG));
        ModPanel settingsPanel = new ModPanel();
        ModLabel SUPPORTED_MODS_LABEL = new ModLabel("This mod can also be integrated with:",
                SUPPORTED_MODS_LABEL_X,
                SUPPORTED_MODS_LABEL_Y,
                settingsPanel, me -> {});

        ModLabel YOHANE_MOD_LABEL = new ModLabel("Yohane -> https://steamcommunity.com/sharedfiles/filedetails/?id=1612593526",
                SUPPORTED_MODS_LABEL_X,
                SUPPORTED_MODS_LABEL_Y - 50.0f,
                settingsPanel, me -> {});

        ModLabel THEMYSTIC_MOD_LABEL = new ModLabel("TheMystic -> https://steamcommunity.com/sharedfiles/filedetails/?id=1609848111",
                SUPPORTED_MODS_LABEL_X,
                SUPPORTED_MODS_LABEL_Y - 100.0f,
                settingsPanel, me -> {});

        settingsPanel.addUIElement(SUPPORTED_MODS_LABEL);
        settingsPanel.addUIElement(YOHANE_MOD_LABEL);
        settingsPanel.addUIElement(THEMYSTIC_MOD_LABEL);
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
