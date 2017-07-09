package com.kinomora.rockbottom.mods.faradicmechanics;

import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.tile.Tile;
import org.newdawn.slick.util.Log;

import de.ellpeck.rockbottom.api.IApiHandler;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.event.IEventHandler;
import de.ellpeck.rockbottom.api.mod.IMod;

public class FaradicMechanics implements IMod {

	public static final String VERSION = "0.0.1";
	public static final String MOD_NAME = "FaradicMechanics";

    public static FaradicMechanics instance;

    //Tiles (blocks)
    public static Tile tilePowerConnector;
    public static Tile tilePole;
    public static Tile tileGenerator;
    public static Tile tilePowerCable;

    //Items
    public static Item itemPowerLineUnused;

    //Other

    public FaradicMechanics() {
        instance = this;
    }

	@Override
	public String getDisplayName() {
		return MOD_NAME;
	}

	@Override
	public String getId() {
		return MOD_NAME.toLowerCase();
	}

	@Override
	public String getVersion() {
		return VERSION;
	}

	@Override
	public String getResourceLocation() {
		return "/assets/" + MOD_NAME;
	}

	@Override
	public String getDescription() {
		return "A mod that adds electricity, machines, and various things by Kinomora";
	}

	@Override
	public void preInit(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {

    }

	@Override
	public void init(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
		Log.info("Starting initializing " + MOD_NAME + " v" + VERSION + " for RockBottom.");

		//Initialize tiles (blocks)
		tilePowerConnector = new TilePowerConnector(RockBottomAPI.createRes(this,"tilePowerConnector")).register().setForceDrop();
		tilePole = new TilePole(RockBottomAPI.createRes(this,"tilePole")).register().setForceDrop();
		tileGenerator = new TileGenerator(RockBottomAPI.createRes(this,"tileGenerator")).register().setForceDrop();
		tilePowerCable = new TilePowerCable(RockBottomAPI.createRes(this,"tilePowerCable")).register().setForceDrop();

		//Initialize items
        itemPowerLineUnused = new ItemPowerLineUnused(RockBottomAPI.createRes(this,"itemPowerLineUnused")).register();

        //Add sipa tanks
	}

	@Override
	public void postInit(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler) {
        Log.info("Finished initializing " + MOD_NAME + " v" + VERSION + ".");
    }
}
