import java.util.ArrayList;
import java.util.HashMap;

/**
 * My absolute monster of a being class.
 * It has everything, from the basic accessors and mutators to everything that the being can do.
 * Thing is, I'll probably need to write even more in here later on when I implement more systems like equipment or status.
 * Also, writing all the comments for the getters and setters was painful. It was the same thing over and over again. Actual pain.
 */
public class Being
{
	
	//---------------------------------------------------------------------------------------------------------------------
	//Data Attributes
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * The name of the being.
	 */
	private String name;
	
	/**
	 * The being's first name.
	 */
	private String firstName;
	
	/**
	 * The being's last name.
	 */
	private String lastName;
	
	/**
	 * The being's base stats. This is an object that holds a collection of int values representing the beings stats.
	 */
	private Stats baseStats;
	
	/**
	 * This is the max amount of health the being can have at any given time.
	 * It is initially set by the level, and the being's endurance stat adds extra to it. (see constructor)
	 */
	private int maxHealth;
	
	/**
	 * This is the health points that a being has that changes as they are attacked.
	 * It is initially set by the level, and the being's endurance stat adds extra to it. (see constructor)
	 */
	private int healthPoints;
	
	/**
	 * This is the max amount of skill points a being can have at any given time.
	 * Determined by the level of the being. (see constructor)
	 * I probably don't need this if the max skill points is determined by the beings level (I can just use the level as the cap)
	 * However, I was planning on making dexterity add to the skill points a bit.
	 * The reason being, I want Cel to rely on her skill points rather on her high dexterity in addition to a variety of skills to deal damage with crits and be a utility player.
	 */
	private int maxSkill;
	
	/**
	 * This is the skill points that a being has that changes as they use skills.
	 * Determined by the level of the being. (see constructor)
	 * Again, I was planning on making dexterity add to the skill points, but not sure yet.
	 */
	private int skillPoints;
	
	/**
	 * This is how much damage a being does at base with the attack function.
	 * Initially determined by the being's strength. (see constructor)
	 */
	private int physicalDamage;
	
	/**
	 * This is the chance a being has to land a critical hit (out of 100).
	 * Initially determined by the being's dexterity. (see constructor)
	 */
	private int critChance;
	
	/**
	 * This is how much a being's damage is multiplied by when they land a critical hit.
	 * Initially determined by the being's dexterity. (see constructor)
	 */
	private int critDamageMultiplier;
	
	/**
	 * This represents the percentage of damage that is taken away when a being is attacked physically.
	 * Initially determined by the being's endurance. (see constructor)
	 */
	private int physicalDamageMitigator;
	
	/**
	 * This represents the percentage of damage that is taken away when a being is attacked by spells.
	 * Initially determined by the being's endurance. (see constructor)
	 */
	private int magicDamageMitigator;
	
	/**
	 * How much mana a being has, which is used up when casting a spell.
	 * Initially determined by the being's intelligence. (see constructor)
	 */
	private int mana;
	
	/**
	 * How effective that magic is (how much damage it deals/health it heals, how much it raises stats by, etc.).
	 * Initially determined by the being's intelligence. (see constructor)
	 */
	private int magicEfficacy;
	
	/**
	 * The being's turn value.
	 * This is a bit of a weird attribute. However, to explain, whenever an encounter occurs, the being starts with an initial turn value.
	 * The being with the highest turn value gets the first time. Beings with equal turn values will be chosen by a priority system that is randomly generated each encounter.
	 * After that being's turn, their turn value is decremented, and the next turn goes to the being with the highest turn value again.
	 * (This means that beings can go multiple times in a row.)
	 * Finally, after every being has had a turn, everyone's turn value is reset.
	 * I still have some things in this system that needs to be ironed out (i.e. How should turn values of beings that aren't on the frontline work?)
	 * Initially determined by the being's agility. (see constructor)
	 */
	private int turnValue;
	
	/**
	 * The chance that a being has to dodge an attack (out of 100). In an attack, their dodge chance is subtracted by the attacker's agility.
	 * Initially determined by the being's agility. (see constructor)
	 */
	private int dodgeChance;
	
	/**
	 * This is a hash map of all the status effects that the being has on them.
	 * Each key is the status effect, and it corresponds to an integer that represents how many turns the status effects lasts.
	 * I do want some status effects to stack, so I'm going to have to figure out how that works.
	 */
	private HashMap<StatusEffect, Integer> statusEffects = new HashMap<StatusEffect, Integer>();
	
	/**
	 * NOT IMPLEMENTED YET.
	 * Stat points are supposed used in the level up system.
	 * Stat points are obtained through leveling up, and you can spend those stat points to level up whatever stat you want.
	 * I liked this idea because it could allow for diverse being building, as if you wanted to min max, you could, or you could try go for certain niche mixes that synergize.
	 */
	private int statPoints = 0;
	
	/**
	 * This is a list of the skills that the being has learned. 
	 * Right now, I don't add to it, but later on in the game, I plan to have options to learn skills in some way, shape, or form. 
	 * Maybe it could be through leveling up or battle rewards. Idk.
	 */
	private ArrayList<Ability> learnedSkills = new ArrayList<Ability>();
	
	/**
	 * This is a list of the spells that the being has learned. 
	 * Right now, I don't add to it, but later on in the game, I plan to have options to learn skills in some way, shape, or form. 
	 * Maybe certain spells level up once they get used a certain amount (Hopefully that isn't too grindy), or maybe they can be bought.
	 */
	private ArrayList<Ability> learnedSpells = new ArrayList<Ability>();
	
	/**
	 * NOT IMPLEMENTED YET.
	 * The weapon the being has equipped. May raise certain stats.
	 */
	private Weapon weapon;
	
	/**
	 * NOT IMPLEMENTED YET.
	 * The armor the being has equipped. May raise certain stats.
	 */
	private Armor armor;

	/**
	 * The party the being belongs to.
	 */
	private Party party;
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Constructor
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Constructor for a being. Takes in the name and stats, and use the given stats to determine their effect in battle.
	 * The order of parameters goes: name, overall level, strength, dexterity, endurance, intelligence, and agility.
	 * @param firstName - The first name of the being.
	 * @param lastName - The last name of the being.
	 * @param level - The overall level of the being.
	 * @param strength - The strength of the being, which determines how much their physical attacks deal.
	 * @param dexterity - The dexterity of a being, which determines their chance to land a critical hit and the critical hit damage multiplier.
	 * @param endurance - The endurance of a being, which determines how much damage is mitigated when attacked, as well as gives extra health.
	 * @param intelligence - The intelligence of a being, which determines how much mana they have and how effective their magic will be.
	 * @param agility - The agility of a being, which determines how often they get turns and their chance to dodge attacks.
	 */
	public Being(String firstName, String lastName, int level, int strength, int dexterity, int endurance, int intelligence, int agility)
	{
		
		//Sets the name.
		this.firstName = firstName;
		this.lastName = lastName;
		name = lastName.length() == 0? firstName : firstName + " " + lastName;
		
		//Sets the base stats.
		baseStats = new Stats(level, strength, dexterity, endurance, intelligence, agility);
						
		/*--Sets the health and skill points based on the level.--*/
		{
			
			//Health equation (where x is the level of the being): (1.5x(x - 21) + 30) / 5
			//Yeah I know the health equation is scuffed but I'll fix it later.
			maxHealth = (1000 * baseStats.getLevel() + (int)(1.5 * baseStats.getLevel() * (baseStats.getLevel() - 21)) + 30) / 5;
			//Skill points equation (where x is the level of the being): 10x
			skillPoints = 10 * baseStats.getLevel();
			
		}
		
		/*--Sets the physical damage the Being object inflict based on the strength stat level.--*/
		{
			
			//Physical damage equation (where x is the strength of the being): 250x + (x(x-5) + 4) OR x^2 + 245x + 4
			physicalDamage = 250 * baseStats.getStrength() + (baseStats.getStrength() * (baseStats.getStrength() - 5) + 4);
		
		}
						
		/*--Sets the crit chance and crit multiplier the Being object has based on the dexterity stat level.--*/
		{
			
			//Sets the crit chance to double the being's dexterity.
			critChance = 2 * baseStats.getDexterity();
			//Crit damage equation (where x is the dexterity of the being): (x / 5) + 2
			critDamageMultiplier = baseStats.getDexterity() / 5 + 2;
						
		}
		
		/*--Sets the damage mitigator the Being object has and adds more health based on the defense stat level.--*/
		{
			
			//Sets the physical damage mitigator to the being's endurance.
			physicalDamageMitigator = baseStats.getEndurance();
			//Sets the magical damage mitigator to the being's endurance.
			magicDamageMitigator = baseStats.getEndurance();
			//Increments the being's maximum health by a percentage of their health based on the endurance.
			//Percentage of health added (where x is the endurance of the being): x / 100
			maxHealth += maxHealth * baseStats.getEndurance() / 100;
			//Sets the health points the being currently has to their max health.
			healthPoints = maxHealth;
			
		}
		
		/*--Sets the magicPoints and magicEfficacy stat based on the intelligence stat level.--*/
		{
			
			//Sets the mana the being has to their intelligence times 50.
			mana = 50 * baseStats.getIntelligence();
			//Sets the being's magic efficacy to their intelligence.
			magicEfficacy = baseStats.getIntelligence();
		
		}
		
		/*--Sets the turn value and dodge chance based on the agility stat level.--*/
		{
			
			//Sets the being's initial turn value to their agility.
			turnValue = baseStats.getAgility();
			//Sets the being's dodge chance (out of 100) to their agility times 4.
			dodgeChance = 4 * baseStats.getAgility();
			
		}
		
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Functionalities
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Causes the being to attack the target.
	 * @param target - The target to be attacked.
	 */
	public void attack(Being target)
	{
		
		//Sets the damage dealt to the being's physicalDamage attribute plus or minus a random percentage of that damage ranging from 0-5%.
		int damage = this.physicalDamage + (this.physicalDamage * (int)(Math.random() * 6) / 100) - (this.physicalDamage * (int)(Math.random() * 6) / 100);
		
		//Subtracts the target's dodgeChance by the user's dodgeChance, and compares it to a randomly generated number from 1-100.
		//Sets the damage to 0 if the difference is greater than or equal to the generated number, and leaves it alone if it is less than.
		damage = target.getDodgeChance() - (this.getDodgeChance() / 2) >= (int)(Math.random() * 100 + 1)? 0 : damage;
		
		//Lets the user know that the target dodged the attack.
		if (damage == 0)
			System.out.println(target.getName() + " dodged the attack!");
		
		else
		{
			
			//Decides whether the attack is critical by randomly picking a number from 1-100.
			//If the being's critChance attribute is greater than or equal to that randomly generated number, the hit is critical. 
			boolean critical = false;
			if (critChance >= (int)(Math.random() * 100) + 1)
			{
			
				damage *= critDamageMultiplier;
				System.out.println("Critical Hit!");
				critical = true;
			
			}
		
			//Reduces the damage dealt based on the target's damage mitigator, which is converted to a percentage.
			//Does not activate if the attack is a critical hit, in which case the damage is not reduced in any way and the being has to take the critical.
			if (!critical)
				damage -= (damage * target.getPhysicalDamageMitigator()) / 100;
		
			//Subtracts the damage from the targets healthPoints.
			target.healthPoints -= damage;
			
			//Lets the user know how much damage the being dealt to the target.
			System.out.println(this.getName() + " dealt " + damage + " damage to " + target.getName() + "!");
			
			//Lets the user know that the being has been downed if their health reaches zero or lower. Also sets it to zero if it below zero.
			if (target.healthPoints <= 0)
			{
				
				target.healthPoints = 0;
				System.out.println(target.getName() + " has been downed!");
			
			}
			
		}
		
	}
	
	/**
	 * Raises the being's defense. (multiplies it by three)
	 */
	public void defend()
	{
		
		physicalDamageMitigator *= 3;
		magicDamageMitigator *= 3;
		
	}
	
	/**
	 * Causes the being to use a skill.
	 * @param skillName - The skill being used.
	 * @param target - The target that the skill is being used on.
	 */
	public void useSkill(String skillName, Being target)
	{
	
		//Iterates through all the skills the being has learned.
		for (Ability skill : learnedSkills)
		{
			
			//Runs the body if the passed skill name matches the skill's name on the current iteration.
			if (skillName.equalsIgnoreCase(skill.getName()))
			{
				
				skill.activate(this, target);
				skillPoints -= skill.getCost();
				
				break;
				
			}
			
		}
		
	}
	
	/**
	 * Causes the being to case a spell.
	 * @param spellName - The spell being cast.
	 * @param target - The target that the spell is being cast on.
	 */
	public void castSpell(String spellName, Being target)
	{
		
		for (Ability spell : learnedSpells)
		{
			
			if (spellName.equalsIgnoreCase(spell.getName()))
			{
				
				spell.activate(this, target);
				skillPoints -= spell.getCost();
				
				break;
				
			}
			
		}
			
		
	}
	
	/**
	 * Causes the being to scan a target.
	 * @param target - The target to be scanned.
	 */
	public void scan(Being target)
	{
		
		System.out.println("Health: " + target.healthPoints + "/" + target.maxHealth);
		System.out.println(target.baseStats.toString());
		
	}
	
	/**
	 * Overriden method that returns the name of the being.
	 */
	public String toString()
	{
		
		return getName();
		
	}
	
	/**
	 * Getter for the being's max health.
	 * @return the being's max health.
	 */
	public int getMaxHealth()
	{
	
		return maxHealth;
	
	}

	/**
	 * Setter for the being's max health.
	 * @param maxHealth - The health that the max health will be set to.
	 */
	public void setMaxHealth(int maxHealth)
	{
	
		this.maxHealth = maxHealth;
	
	}

	/**
	 * Gets the character's max skill points.
	 * @return - The max skill of the character.
	 */
	public int getMaxSkill()
	{
	
		return maxSkill;
	
	}

	/**
	 * Setter for the max skill points of the being.
	 * @param maxSkill - The number the max skill points will be set to.
	 */
	public void setMaxSkill(int maxSkill)
	{
	
		this.maxSkill = maxSkill;
	
	}

	/**
	 * NOT IMPLEMENTED YET
	 * Getter for the stat points that the being currently has.
	 * @return The stat points the character currently has.
	 */
	public int getStatPoints()
	{
	
		return statPoints;
	
	}

	/**
	 * NOT IMPLEMENTED YET
	 * Setter for the stat points that the being currently has.
	 * @param statPoints
	 */
	public void setStatPoints(int statPoints)
	{
	
		this.statPoints = statPoints;
	
	}

	/**
	 * Setter for the physical damage.
	 * @param physicalDamage - The damage that the physical damage will be set to.
	 */
	public void setPhysicalDamage(int physicalDamage)
	{
	
		this.physicalDamage = physicalDamage;
	
	}

	/**
	 * Setter for the crit chance.
	 * @param critChance - The percentage that the crit chance will be set to.
	 */
	public void setCritChance(int critChance)
	{
	
		this.critChance = critChance;
	
	}

	/**
	 * Setter for the crit damage multiplier.
	 * @param critDamageMultiplier - The multiplier the the crit damage multiplier will be set to.
	 */
	public void setCritDamageMultiplier(int critDamageMultiplier)
	{
	
		this.critDamageMultiplier = critDamageMultiplier;
	
	}
	
	/**
	 * Getter for the first name of the being.
	 * @return The first name of the being.
	 */
	public String getFirstName()
	{
	
		return firstName;
	
	}

	/**
	 * Getter for the last name of the being.
	 * @return The last name of the being.
	 */
	public String getLastName()
	{
	
		return lastName;
	
	}

	/**
	 * Getter for the full name of the being.
	 * @return The full name of the being.
	 */
	public String getName()
	{
	
		return name;
	
	}
	
	/**
	 * Setter for the full name of the being.
	 * @param name - The full name that the name of the being will be set to.
	 */
	public void setName(String name)
	{
		
		this.name = name;
		
	}

	/**
	 * Setter for the first name of the being.
	 * @param firstName - The name that the first name of the being will be set to.
	 */
	public void setFirstName(String firstName)
	{
	
		this.firstName = firstName;
	
	}

	/**
	 * Getter for the base stats of the character.
	 * @return The base stats of the character.
	 */
	public Stats getBaseStats()
	{
	
		return baseStats;
	
	}

	/**
	 * Getter for the health points of the being.
	 * @return The health points of the being.
	 */
	public int getHealthPoints()
	{
	
		return healthPoints;
	
	}

	/**
	 * Setter for the health points of the being.
	 * Cannot set the health over the maxHealth.
	 * @param healthPoints - The health points that the being will be set to.
	 */
	public void setHealthPoints(int healthPoints)
	{
	
		this.healthPoints = healthPoints;
		if (this.healthPoints > maxHealth)
			this.healthPoints = maxHealth;
	
	}

	/**
	 * Getter for the skill points of the being.
	 * @return The skill points of the being.
	 */
	public int getSkillPoints()
	{
	
		return skillPoints;
	
	}

	/**
	 * Setter for the skill points of the being.
	 * @param skillPoints - The number that the being's skill points will be set to.
	 */
	public void setSkillPoints(int skillPoints)
	{
	
		this.skillPoints = skillPoints;
		if (this.skillPoints > maxSkill)
			this.skillPoints = maxSkill;
	
	}

	/**
	 * Getter for the physical damage of the being.
	 * @return The base physical damage that the being deals.
	 */
	public int getPhysicalDamage()
	{
	
		return physicalDamage;
	
	}

	/**
	 * Getter for the crit chance of the being.
	 * @return The chance that the being will land a critical hit on any given attack (out of 100)
	 */
	public int getCritChance()
	{
	
		return critChance;
	
	}

	/**
	 * Getter for the crit damage multiplier.
	 * @return The factor that the damage is multiplied by during a critical hit.
	 */
	public int getCritDamageMultiplier()
	{
	
		return critDamageMultiplier;
	
	}
	
	/**
	 * Getter for the physical damage mitigator.
	 * @return The being's physical damage mitigator.
	 */
	public int getPhysicalDamageMitigator()
	{
	
		return physicalDamageMitigator;
	
	}

	/**
	 * The setter for the physical damage mitigator.
	 * @param physicalDamageMitigator - The number the physical damage mitigator will be set to.
	 */
	public void setPhysicalDamageMitigator(int physicalDamageMitigator)
	{
	
		this.physicalDamageMitigator = physicalDamageMitigator;
	
	}

	/**
	 * Getter for the magic damage mitigator.
	 * @return The being's magic damage mitigator.
	 */
	public int getMagicDamageMitigator()
	{
	
		return magicDamageMitigator;
	
	}

	/**
	 * Setter for the magic damage mitigator.
	 * @param magicDamageMitigator - The number that the magic damage mitigator will be set to.
	 */
	public void setMagicDamageMitigator(int magicDamageMitigator)
	{
	
		this.magicDamageMitigator = magicDamageMitigator;
	
	}

	/**
	 * Getter for the mana of the being.
	 * @return The mana of the being.
	 */
	public int getMana()
	{
	
		return mana;
	
	}

	/**
	 * Setter for the mana of the being.
	 * @param mana - The amount of mana that the mana of the being will be set to.
	 */
	public void setMana(int mana)
	{
	
		this.mana = mana;
	
	}

	/**
	 * Getter for the magic efficacy.
	 * @return The magic efficacy that the being has.
	 */
	public int getMagicEfficacy()
	{
	
		return magicEfficacy;
	
	}

	/**
	 * Setter for the magic efficacy.
	 * @param magicEfficacy - The number that the magic efficacy will be set to.
	 */
	public void setMagicEfficacy(int magicEfficacy)
	{
	
		this.magicEfficacy = magicEfficacy;
	
	}

	/**
	 * Getter for the turn value of the character.
	 * @return - The turn value of the character.
	 */
	public int getTurnValue()
	{
	
		return turnValue;
	
	}

	/**
	 * Setter for the turn value of the character.
	 * @param turnValue - The number the being's turn value will be set to.
	 */
	public void setTurnValue(int turnValue)
	{
	
		this.turnValue = turnValue;
	
	}


	/**
	 * Getter for the dodge chance of the character.
	 * @return The inherent dodge chance of the character (not subtracted by another being's dodge chance).`
	 */
	public int getDodgeChance()
	{
	
		return dodgeChance;
	
	}

	/**
	 * Setter for the dodge chance of the character.
	 * @param dodgeChance - The number that the dodge chance will be set to.
	 */
	public void setDodgeChance(int dodgeChance)
	{
	
		this.dodgeChance = dodgeChance;
	
	}

	/**
	 * Getter for the being's learned skills.
	 * @return An array list of the being's learned skills.
	 */
	public ArrayList<Ability> getLearnedSkills()
	{
	
		return learnedSkills;
	
	}
	
	/**
	 * Getter for the being's learned spells.
	 * @return An array list of the being's learned spells.
	 */
	public ArrayList<Ability> getLearnedSpells()
	{
	
		return learnedSpells;
	
	}
	
	/**
	 * NOT IMPLEMENTED YET.
	 * Getter for the weapon the being has equipped.
	 * @return The weapon the being has equipped.
	 */
	public Weapon getWeapon()
	{
	
		return weapon;
	
	}

	/**
	 * NOT IMPLEMENTED YET
	 * Equips a weapon to the user.
	 * @param weapon - The weapon that the being will equip.
	 */
	public void equipWeapon(Weapon weapon)
	{
	
		this.weapon = weapon;
	
	}

	/**
	 * NOT IMPLEMENTED YET
	 * Getter for the armor the being has equipped.
	 * @return The armor the being has equipped.
	 */
	public Armor getArmor()
	{
	
		return armor;
	
	}

	/**
	 * NOT IMPLEMENTED YET
	 * @param armor - The armor that the being will equip.
	 */
	public void equipArmor(Armor armor)
	{
	
		this.armor = armor;
	
	}

	/**
	 * Getter for the party the being is in.
	 * @return The party the being is in.
	 */
	public Party getParty()
	{
	
		return party;
	
	}

	/**
	 * Setter for the party the being is in.
	 * @param party - The party the being will join.
	 */
	public void setParty(Party party)
	{
	
		this.party = party;
	
	}
	
	/**
	 * Getter for the status effects the being currently has on them.
	 * @return The hash map of the status effects the being currently has on them, mapped to an int representing the amount of turns the effects will last for.
	 */
	public HashMap<StatusEffect, Integer> getStatusEffects()
	{
	
		return statusEffects;
	
	}

	/**
	 * Gets the duration of a status effect.
	 * Yeah I should probably rename this to getStatusEffectDuration(). Am I going to. Probably not :P.
	 * @param statusEffectKey - The status effect that you want to find the duration of.
	 * @return The duration the status effect lasts for, unless the passed status effect is no on the being, in which case null is returned.
	 */
	public int getStatusEffect(StatusEffect statusEffectKey)
	{
	
		return statusEffects.get(statusEffectKey);
	
	}

	/**
	 * Decrements the status effect's duration by 1. Will do nothing if the passed status effect is not on the being.
	 * Honestly, in retrospect, with how many times I'm content to just use the dot operator, this method didn't need to be made.
	 * t's functionality is definitely easier to understand from the name than whatever's inside so might as well use it.
	 * @param statusEffect - The status effect to be decremented
	 */
	public void decrementStatusEffect(StatusEffect statusEffect)
	{
	
		//Replaces the status effects duration with a decremented version of it.
		statusEffects.replace(statusEffect, statusEffects.get(statusEffect) - 1);
	
	}
	
	/**
	 * Adds a status effect to the status effects that the being has on them.
	 * Thinking of doing a stack system instead of a duration system so effects can stack, and each turn they lose a stack instead decrementing the duration.
	 * The problem is if I don't want status effects to stack. Ah well I'm sure I'll figure it out.
	 * @param statusEffect - The status effect to be added.
	 * @param duration - The amount of turns that status effect will last.
	 */
	public void addStatusEffect(StatusEffect statusEffect, int duration)
	{
		
		//Runs if the being does not have the effect on them.
		if (!statusEffects.keySet().contains(statusEffect))
		{
			
			//Runs raiseStats() or lowerStats() based on the passed status effect. See those methods for more details.
			switch (statusEffect)
			{
			
			case PUMP:
				raiseStat("strength");
				break;
				
			case WITHER:
				lowerStat("strength");
				break;
			
			case PRECISION:
				raiseStat("dexterity");
				break;
				
			case UNSTABLE:
				lowerStat("dexterity");
				break;
				
			case FOCUS:
				raiseStat("intelligence");
				break;
				
			case DISTRACT:
				lowerStat("intelligence");
				break;
				
			case HARDEN:
				raiseStat("physical defense");
				break;
				
			case FRAIL:
				lowerStat("physical defense");
				break;
				
			case SHELL:
				raiseStat("magic defense");
				break;
				
			case TARGETED:
				lowerStat("magic defense");
				break;
				
			default:
				System.out.print("not implemented yet :(");
			
			}
			
		}
		
		//Adds the passed duration to the current duration if the status effect was already in the hash map. Otherwise just makes a new entry with the passed duration.
		if (statusEffects.keySet().contains(statusEffect))
			statusEffects.put(statusEffect, statusEffects.get(statusEffect) + duration);
		else
			statusEffects.put(statusEffect, duration);
	
	}
	
	/**
	 * Pretty much just the reverse of addStatusEffect().
	 * @param statusEffect - The status effect to be removed.
	 * @return The effect that was removed. Probably could have made it void but uh. Idk.
	 */
	public int removeStatusEffect(StatusEffect statusEffect)
	{
		
		if (!statusEffects.keySet().contains(statusEffect))
		{
			
			//Runs raiseStats() or lowerStats() based on the passed status effect. See those methods for more details.
			switch (statusEffect)
			{
			
			case PUMP:
				lowerStat("strength");
				break;
				
			case WITHER:
				raiseStat("strength");
				break;
			
			case PRECISION:
				lowerStat("dexterity");
				break;
				
			case UNSTABLE:
				raiseStat("dexterity");
				break;
				
			case FOCUS:
				lowerStat("intelligence");
				break;
				
			case DISTRACT:
				raiseStat("intelligence");
				break;
				
			case HARDEN:
				lowerStat("physical defense");
				break;
				
			case FRAIL:
				raiseStat("physical defense");
				break;
				
			case SHELL:
				lowerStat("magic defense");
				break;
				
			case TARGETED:
				raiseStat("magic defense");
				break;
				
			default:
				System.out.print("not implemented yet :(");
			
			}
			
		}
		
		//Returns the status effect that was removed. You know. Just in case you need it. I guess.
		return statusEffects.remove(statusEffect);
	
	}
	
	/**
	 * Raises a character's "stats" based on a string passed to it.
	 * This actually doesn't raise the character's real stats, but rather, individual attributes that those stats effect.
	 * @param stat - A string representing the stat to be raised. 
	 */
	public void raiseStat(String stat)
	{
		
		//Switch that takes in the attribute to be raised.
		switch (stat)
		{
		
		//These literally are just the same equations that are in the constructor, but insert (x + 1) in place of just x.
		
		case "strength":
			physicalDamage = (250 * (baseStats.getStrength() + 1)) + ((baseStats.getStrength() + 1) * (baseStats.getStrength() - 4) + 4);
			break;
		
		case "dexterity":
			critChance = 2 * (baseStats.getDexterity() + 1);
			critDamageMultiplier = ((baseStats.getDexterity() + 1) / 5 + 2);
			break;
			
		case "physical defense":
			physicalDamageMitigator = baseStats.getEndurance() + 1;
			break;
			
		case "magic defense":
			magicDamageMitigator = baseStats.getEndurance() + 1;
			break;
			
		case "intelligence":
			mana = 10 * (baseStats.getIntelligence() + 1);
			magicEfficacy = baseStats.getIntelligence() + 1;
			break;
			
		case "agility":
			turnValue += 1;
			dodgeChance = 4 * (baseStats.getAgility() + 1);
			break;
			
		}
		
	}
	
	/**
	 * Pretty much just the reverse of raiseStat().
	 * @param stat - A string representing the stat to be raised.
	 */
	public void lowerStat(String stat)
	{
		
		//Switch that takes in the attribute to be lowered.
		switch (stat)
		{
		
		//These literally are just the same equations that are in the constructor, but insert (x + 1) in place of just x.
		
		case "strength":
			physicalDamage = (250 * (baseStats.getStrength() - 1)) + ((baseStats.getStrength() - 1) * (baseStats.getStrength() - 6) + 4);
			break;
			
		case "dexterity":
			critChance = 2 * (baseStats.getDexterity() - 1);
			critDamageMultiplier = ((baseStats.getDexterity() - 1) / 5 + 2);
			break;
			
		case "physical defense":
			physicalDamageMitigator = baseStats.getEndurance() - 1;
			break;
			
		case "magic defense":
			magicDamageMitigator = baseStats.getEndurance() - 1;
			break;
			
		case "intelligence":
			mana = 10 * (baseStats.getIntelligence() - 1);
			magicEfficacy = baseStats.getIntelligence() - 1;
			break;
			
		case "agility":
			turnValue -= 1;
			dodgeChance = 4 * (baseStats.getAgility() - 1);
			break;
			
		}
		
	}
	
}
