package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.gui.GuiContainer;
import de.ellpeck.rockbottom.api.gui.component.ComponentProgressBar;
import org.newdawn.slick.Color;

/**
 * Created by Kinomora on 7/3/2017.
 */
public class GuiGenerator extends GuiContainer {

    private final TileEntityGenerator tile;

    public GuiGenerator(AbstractEntityPlayer player, TileEntityGenerator tile) {
        super(player, 198, 150);
        this.tile = tile;
    }

    public void initGui(IGameInstance game) {
        super.initGui(game);
        //Charge percentage
        this.components.add(new ComponentProgressBar(this, this.guiLeft + 60, this.guiTop + 13, 80, 10, Color.cyan, false, this.tile::getCapacityPercentage));
        //Burn percentage remaining
        this.components.add(new ComponentProgressBar(this, this.guiLeft + 74, this.guiTop + 30, 8, 18, GuiContainer.FIRE_COLOR,true, this.tile::getFuelPercentage));
    }
}
