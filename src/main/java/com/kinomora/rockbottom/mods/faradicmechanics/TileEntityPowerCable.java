package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.data.set.DataSet;
import de.ellpeck.rockbottom.api.tile.entity.TileEntity;
import de.ellpeck.rockbottom.api.world.IWorld;
import org.newdawn.slick.util.Log;

/**
 * Created by Kinomora on 7/8/2017.
 */
public class TileEntityPowerCable extends TileEntity {

    private int currentPower = 0;
    private int maxPower = 40;

    public TileEntityPowerCable(IWorld world, int x, int y) {
        super(world, x, y);
    }

    public int getCurrentPower(){
        return currentPower;
    }

    public int getMaxPower(){
        return maxPower;
    }

    public void setCurrentPower(int newPower){
        this.currentPower = newPower;
    }

    @Override
    public void update(IGameInstance game) {
        super.update(game);
        //Log.debug("Current power: " + currentPower);
    }

    @Override
    public void save(DataSet set, boolean forSync) {
        super.save(set, forSync);

        set.addInt("currentPower", this.currentPower);
    }

    @Override
    public void load(DataSet set, boolean forSync) {
        super.load(set, forSync);

        this.currentPower = set.getInt("currentPower");
    }
}
