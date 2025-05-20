
/**
 * THIS ENUM HAS NOT BEEN IMPLEMENTED YET
 * All enemies have an attribute, but I haven't gotten to making the actual extra damage system when strong elements fight against weak elements.
 * Some attacks have an elemental effects, like certain magics or weapons.
 * Anyway, the basic rundown is:
 * Neutral does not beat or get beaten by anything.
 * Fire beats ice.
 * Ice beats lightning.
 * Lightning beats water.
 * Water beats fire.
 * Holy is effective on targets inflicted with zombie, and probably the final boss which I haven't even made yet.
 */
public enum Attribute
{
	
	//Beats nothing.
	NEUTRAL,
	
	//Beats ice.
	FIRE,
	
	//Beats fire.
	WATER,
	
	//Beats water.
	LIGHTNING,
	
	//Beats lightning.
	ICE,
	
	//Effective on targets inflicted with zombie status effect.
	HOLY
	
}
