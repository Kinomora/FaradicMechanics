package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.tile.MultiTile;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;

import java.util.List;

/**
 * Created by Kinomora on 7/2/2017.
 */
public class TilePole extends MultiTile{

    private static final String tileName = "tilePole";
    private static final IResourceName LOC = RockBottomAPI.createRes(FaradicMechanics.instance,"details." + tileName);

    public TilePole(IResourceName name) {
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
    protected boolean[][] makeStructure() {
        return new boolean[][]{
                {true},
                {true},
                {true},
                {true}
        };
    }

    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public int getHeight() {
        return 4;
    }

    @Override
    public int getMainX() {
        return 0;
    }

    @Override
    public int getMainY() {
        return 0;
    }

    @Override
    public boolean isFullTile() {
        return false;
    }
}
