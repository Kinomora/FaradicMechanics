package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.gui.container.ContainerSlot;
import de.ellpeck.rockbottom.api.gui.container.ItemContainer;
import de.ellpeck.rockbottom.api.inventory.IInventory;

/**
 * Created by Kinomora on 7/3/2017.
 */
public class ContainerGenerator extends ItemContainer{

    public ContainerGenerator(AbstractEntityPlayer player, TileEntityGenerator tile) {
        super(player, new IInventory[]{player.getInv(), tile.inventory});

        this.addSlot(new ContainerSlot(tile.inventory, 0, 90, 30));
        this.addPlayerInventory(player, 20, 60);
    }
}
