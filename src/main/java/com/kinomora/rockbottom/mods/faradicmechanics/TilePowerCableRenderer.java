package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.render.tile.DefaultTileRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kinomora on 7/8/2017.
 */
public class TilePowerCableRenderer extends DefaultTileRenderer<TilePowerCable> {

    private boolean isBeingPowered = false;

    private static final String[] NAME = new String[]{
            "Up",               //0
            "Right",            //1
            "Down",             //2
            "Left",             //3
            "UpRight",          //4
            "RightDown",        //5
            "DownLeft",         //6
            "LeftUp",           //7
            "UpRightDown",      //8
            "RightDownLeft",    //9
            "DownLeftUp",       //10
            "LeftUpRight",      //11
            "UpRightDownLeft",  //12
            "UpDown",           //13
            "RightLeft"};       //14
    private final List<IResourceName> unpowered = new ArrayList<>();
    private final List<IResourceName> powered = new ArrayList<>();

    public TilePowerCableRenderer(IResourceName texture) {
        super(RockBottomAPI.createRes(FaradicMechanics.instance,"cable"));
        for (String SUFFIX : NAME) {
            unpowered.add(this.texture.addSuffix("nonpowered." + SUFFIX));
            powered.add(this.texture.addSuffix("powered." + SUFFIX));
        }
        unpowered.add(this.texture.addSuffix("nonpowered." + "NonConnected"));
    }

    public void setPoweredState(boolean state){
        this.isBeingPowered = state;
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, TilePowerCable tile, int x, int y, float renderX, float renderY, float scale, Color[] light) {
        boolean up = world.getTile(x,y + 1) instanceof ICableAttachment;
        boolean right = world.getTile(x + 1, y) instanceof ICableAttachment;
        boolean down = world.getTile(x,y - 1) instanceof ICableAttachment;
        boolean left = world.getTile(x - 1,y) instanceof ICableAttachment;

        int i;
        if(up){
            if(right){
                if(down){
                    if(left){
                        //Up Right Down Left
                        i = 12;
                    } else {
                        //Up Right Down
                        i = 8;
                    }
                } else if(left){
                    //Up Right Left
                    i = 11;
                } else {
                    //Up Right
                    i = 4;
                }
            } else if(down){
                if(left){
                    //Up Down Left
                    i = 10;
                } else {
                    //Up Down
                    i = 13;
                }
            } else if(left) {
                //Up Left
                i = 7;
            } else {
                //Up
                i = 0;
            }
        } else {
            //NOT UP
            if(right){
                if(down){
                    if(left){
                        //Right Down Left
                        i = 9;
                    } else {
                        //Right Down
                        i = 5;
                    }
                } else if(left){
                    //Right Left
                    i = 14;
                } else {
                    //Right
                    i = 1;
                }
            //NOT RIGHT
            } else if(down){
                if(left) {
                    //Down Left
                    i = 6;
                } else {
                    //Down
                    i = 2;
                }
            } else if(left){
                //Left
                i = 3;
            } else {
                //None
                i = 15;
            }
        }

        if(isBeingPowered){
            manager.getTexture(this.powered.get(i)).drawWithLight(renderX, renderY, scale, scale, light);
        } else {
            manager.getTexture(this.unpowered.get(i)).drawWithLight(renderX, renderY, scale, scale, light);
        }
    }
}
