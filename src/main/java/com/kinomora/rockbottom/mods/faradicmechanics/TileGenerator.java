package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.Entity;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
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
 * Created by Kinomora on 7/3/2017.
 */
public class TileGenerator extends TileBasic implements ICableAttachment, IPowered {

    private static final String tileName = "tileGenerator";
    private static final IResourceName LOC = RockBottomAPI.createRes(FaradicMechanics.instance,"details." + tileName);

    public TileGenerator(IResourceName name) {
        super(name);
    }

    public boolean canProvideTileEntity() {
        return true;
    }

    public int getLight(IWorld world, int x, int y, TileLayer layer) {
        TileEntityGenerator tile = world.getTileEntity(x, y, TileEntityGenerator.class);
            if(tile != null && tile.isActive()) {
                return 20;
            }


        return 0;
    }

    public boolean onInteractWith(IWorld world, int x, int y, AbstractEntityPlayer player) {
        TileEntityGenerator tile = world.getTileEntity(x,y, TileEntityGenerator.class);
        if(tile != null) {
            player.openGuiContainer(new GuiGenerator(player, tile), new ContainerGenerator(player, tile));
            return true;
        } else {
            return false;
        }
    }

    public void onDestroyed(IWorld world, int x, int y, Entity destroyer, TileLayer layer, boolean forceDrop) {
        super.onDestroyed(world, x, y, destroyer, layer, forceDrop);
        if(!RockBottomAPI.getNet().isClient()) {
            TileEntityGenerator tile = world.getTileEntity(x,y, TileEntityGenerator.class);
            if(tile != null) {
                tile.dropInventory(tile.inventory);
            }
        }
    }

    public BoundBox getBoundBox(IWorld world, int x, int y) {
        return null;
    }

    /*
    public void updateRandomlyForRendering(IWorld world, int x, int y, TileLayer layer, AbstractEntityPlayer player) {
        TileEntityGenerator tile = world.getTileEntity(x, y, TileEntityGenerator.class);
            if(tile != null && tile.isActive()) {
                IParticleManager manager = AbstractGame.get().getParticleManager();
                if(Util.RANDOM.nextFloat() >= 0.25F) {
                    manager.addParticle(new ParticleSmoke(world, (double)x + 0.14D, (double)y + 1.8D, (double)(-Util.RANDOM.nextFloat()) * 0.03D, 0.0D, 0.08F));
                }

                if(Util.RANDOM.nextBoolean()) {
                    manager.addParticle(new ParticleSmoke(world, (double)x + 0.7D, (double)y + 1.55D, Util.RANDOM.nextGaussian() * 0.01D, 0.05D, 0.05F));
                }
            }
        }*/

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.addAll(manager.getFont().splitTextToLength(500,1f,true, manager.localize(LOC)));
    }

    @Override
    public TileEntity provideTileEntity(IWorld world, int x, int y) {
        return new TileEntityGenerator(world, x, y);
    }

    @Override
    protected ITileRenderer createRenderer(IResourceName name) {
        return new TileGeneratorRenderer();
    }

    @Override
    public boolean isFullTile() {
        return false;
    }
}
