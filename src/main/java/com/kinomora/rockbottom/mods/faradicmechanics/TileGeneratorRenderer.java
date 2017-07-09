package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.render.tile.DefaultTileRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import de.ellpeck.rockbottom.api.world.IWorld;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.util.Log;

/**
 * Created by Kinomora on 7/7/2017.
 */
public class TileGeneratorRenderer extends DefaultTileRenderer<TileGenerator> {

    private static IResourceName generatorStage1;
    private static IResourceName generatorStage2;
    private static IResourceName generatorStage3;
    private static IResourceName generatorStage4;
    private static IResourceName generatorStage5;
    private static IResourceName generatorFull;
    private static IResourceName generatorErr;

    public TileGeneratorRenderer() {
        super(RockBottomAPI.createRes(FaradicMechanics.instance,"tileGenerator"));
        this.generatorStage1 = this.texture.addSuffix("Stage1");
        this.generatorStage2 = this.texture.addSuffix("Stage2");
        this.generatorStage3 = this.texture.addSuffix("Stage3");
        this.generatorStage4 = this.texture.addSuffix("Stage4");
        this.generatorStage5 = this.texture.addSuffix("Stage5");
        this.generatorFull = this.texture.addSuffix("Full");
        this.generatorErr = this.texture.addSuffix("Err");
    }

    @Override
    public void render(IGameInstance game, IAssetManager manager, Graphics g, IWorld world, TileGenerator tile, int x, int y, float renderX, float renderY, float scale, Color[] light) {
        float capacityPercentage = world.getTileEntity(x,y,TileEntityGenerator.class).getCapacityPercentage();
        IResourceName tex;

        if (capacityPercentage == 0){
            tex = this.texture;
        } else if(capacityPercentage <= 0.167f){
            tex = this.generatorStage1;
        } else if (capacityPercentage <= 0.334f){
            tex = this.generatorStage2;
        } else if (capacityPercentage <= 0.501f){
            tex = this.generatorStage3;
        } else if (capacityPercentage <= 0.668f){
            tex = this.generatorStage4;
        } else if (capacityPercentage <= 0.833f){
            tex = this.generatorStage5;
        } else if (capacityPercentage == 1.000f) {
            tex = this.generatorFull;
        } else {
            tex = this.generatorErr;
        }

        manager.getTexture(tex).drawWithLight(renderX, renderY, scale, scale, light);
    }
}
