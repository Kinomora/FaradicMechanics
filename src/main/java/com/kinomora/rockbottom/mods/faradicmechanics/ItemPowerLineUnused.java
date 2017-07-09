package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.item.ItemBasic;
import de.ellpeck.rockbottom.api.item.ItemInstance;
import de.ellpeck.rockbottom.api.render.item.IItemRenderer;
import de.ellpeck.rockbottom.api.util.reg.IResourceName;

import java.util.List;

/**
 * Created by Kinomora on 7/2/2017.
 */
public class ItemPowerLineUnused extends ItemBasic{

    private static final String itemName = "itemPowerCable";
    private static final IResourceName LOC = RockBottomAPI.createRes(FaradicMechanics.instance,"details." + itemName);

    public ItemPowerLineUnused(IResourceName name) {
        super(name);
    }

    @Override
    protected IItemRenderer createRenderer(IResourceName name) {
        return new HoldingItemRenderer(name);
    }

    @Override
    public void describeItem(IAssetManager manager, ItemInstance instance, List<String> desc, boolean isAdvanced) {
        super.describeItem(manager, instance, desc, isAdvanced);
        desc.add(manager.localize(LOC));
    }
}
