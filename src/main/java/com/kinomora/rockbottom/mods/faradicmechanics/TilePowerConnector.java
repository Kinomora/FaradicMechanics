package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;

import java.util.List;

/**
 * Created by Kinomora on 7/2/2017.
 */
public class TilePowerConnector extends TileBasic{

    private static final String tileName = "tilePowerConnector";
    private static final IResourceName LOC = RockBottomAPI.createRes(FaradicMechanics.instance,"details." + tileName);
    int xBlock1,yBlock1,xBlock2,yBlock2;
    private boolean flip = false;


    public TilePowerConnector(IResourceName name) {
        super(name);
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return null;
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500,1f,true, manager.localize(LOC)));
    }

    @Override
    public boolean onInteractWith(IWorld world, int x, int y, AbstractEntityPlayer player) {

        if(flip){
            xBlock1 = x;
            yBlock1 = y;
        } else {
            xBlock2 = x;
            yBlock2 = y;
        }

        ItemInstance instance = player.getInv().get(player.getSelectedSlot());
        if (instance != null && instance.getItem() == FaradicMechanics.itemPowerLineUnused) {
            drawCable();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFullTile() {
        return false;
    }

    private void drawCable(){
        //Graphics.drawLine();
    }
}
