package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.tile.ITileRenderer;
import de.ellpeck.rockbottom.api.tile.TileBasic;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.util.BoundBox;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import de.ellpeck.rockbottom.api.world.TileLayer;

import java.util.List;

/**
 * Created by Kinomora on 7/7/2017.
 */
public class TilePowerCable extends TileBasic implements ICableAttachment {

    private static final String tileName = "tilePowerCable";
    private static final IResourceName LOC = RockBottomAPI.createRes(FaradicMechanics.instance,"details." + tileName);

    public TilePowerCable(IResourceName name) {
        super(name);
    }

    public boolean canProvideTileEntity() {
        return true;
    }

    public void onDestroyed(IWorld world, int x, int y, Entity destroyer, TileLayer layer, boolean forceDrop) {
        super.onDestroyed(world, x, y, destroyer, layer, forceDrop);
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500,1f,true, manager.localize(LOC)));
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TilePowerCableRenderer(name);
    }

    @Override
    public TileEntity provideTileEntity(IWorld world, int x, int y) {
        return new TileEntityPowerCable(world, x, y);
    }

    @Override
    public boolean isFullTile() {
        return false;
    }

    @Override
    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return null;
    }
}
