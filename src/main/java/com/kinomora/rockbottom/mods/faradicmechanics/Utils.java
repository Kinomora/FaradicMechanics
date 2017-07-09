package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.RockBottomAPI;

/**
 * Created by Kinomora on 7/4/2017.
 */
public class Utils {

    public boolean allowTimeProgress = false;

    public static int getPlayerXCoord(){
        return (int) RockBottomAPI.getGame().getPlayer().x;
    }

    public static int getPlayerYCoord(){
        return (int) RockBottomAPI.getGame().getPlayer().y;
    }

    public static int getPointerXCoord(){
        return (int) RockBottomAPI.getGame().getInteractionManager().getMousedTileX();
    }

    public static int getPointerYCoord(){
        return (int) RockBottomAPI.getGame().getInteractionManager().getMousedTileY();
    }
}
