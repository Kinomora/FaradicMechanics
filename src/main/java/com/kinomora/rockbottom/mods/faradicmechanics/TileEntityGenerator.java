package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.inventory.Inventory;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.tile.entity.TileEntityFueled;
import de.ellpeck.rockbottom.api.world.IWorld;
import org.newdawn.slick.util.Log;

import java.util.Currency;

/**
 * Created by Kinomora on 7/3/2017.
 */
public class TileEntityGenerator extends TileEntityFueled {

    //Power management
    boolean up = world.getTileEntity(x,y + 1) instanceof TileEntityPowerCable;
    boolean right = world.getTileEntity(x + 1, y) instanceof TileEntityPowerCable;
    boolean down = world.getTileEntity(x,y - 1) instanceof TileEntityPowerCable; //works
    boolean left = world.getTileEntity(x - 1, y) instanceof TileEntityPowerCable; //works

    //Constants
    public final Inventory inventory = new Inventory(1);

    //Power related
    public int currentPower = 0;
    public int maxPower = 64000;

    public TileEntityGenerator(IWorld world, int x, int y) {
        super(world, x, y);
    }

    @Override
    protected boolean needsSync() {
        return super.needsSync();
    }

    @Override
    protected void onSync() {
        super.onSync();
    }

    @Override
    protected boolean tryTickAction() {
        //Generate power
        if (currentPower < maxPower) {
            if (this.isActive()) {
                this.currentPower += 20;
                if (this.currentPower > this.maxPower) {
                    this.currentPower = this.maxPower;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void update(IGameInstance game) {
        super.update(game);

        if (currentPower >= 40) {
            if(up){
                Log.debug("Up");
                currentPower -= 40;
            } else if (left){
                Log.debug("Left"); //Works
                currentPower -= 40;
            } else if (down){
                Log.debug("Down"); //Works
                currentPower -= 40;
            } else if (right){
                Log.debug("Right");
                currentPower -= 40;
            } else {
                Log.debug("None");
            }
        }
    }

    @Override
    protected float getFuelModifier() {
        //Speed at which coal is consumed. "Inverse" of power generated.
        return 0.5f;
    }

    @Override
    protected ItemInstance getFuel() {
        return this.inventory.get(0);
    }

    @Override
    protected void removeFuel() {
        this.inventory.remove(0, 1);
    }

    @Override
    protected void onActiveChange(boolean active) {
        this.world.causeLightUpdate(this.x, this.y);
    }

    public float getCapacityPercentage() {
        return (float)this.currentPower / (float)this.maxPower;
    }

    @Override
    public void save(DataSet set, boolean forSync) {
        super.save(set, forSync);
        if(!forSync) {
            this.inventory.save(set);
        }

        set.addInt("currentPower", this.currentPower);
    }

    @Override
    public void load(DataSet set, boolean forSync) {
        super.load(set, forSync);
        if(!forSync) {
            this.inventory.load(set);
        }

        this.currentPower = set.getInt("currentPower");
    }
}
