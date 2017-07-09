package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.item.DefaultItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Created by Kinomora on 7/2/2017.
 */
public class HoldingItemRenderer extends DefaultItemRenderer {
    public HoldingItemRenderer(IResourceName texture) {
        super(texture);
    }

    @Override
    public void renderOnMouseCursor(IGameInstance game, IAssetManager manager, Graphics g, Item item, ItemInstance instance, float x, float y, float scale, Color filter) {
        this.render(game, manager, g, item, instance, x, y, scale, filter);
    }
}
