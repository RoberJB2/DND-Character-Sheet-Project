package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * @author N Arango
 * @version %I%
 * @since 1.0
 * 
 * Class: Basic Stat Manager
 *  public
 * 
 * Responsibilities:
 *  Manages the stats, variables, and possible bonuses for the specified character sheet
 * 
 * Collaborators:
 *  CharacterSheet
 * 
 * Methods:
 *  Attributes
 *      private
 *      Holds and manipulates the basic DND stats such as Strength, Wisdom, Charisma, Intelligence, Constitution, and Dexterity
 *  Saving Throws
 *      private
 *      Calculates and stores the values for saving throws, related to basic stats
 *  Skills:
 *      private
 *      Holds all DND skills for a character, an example is Acrobatics.
 */
import java.io.Serializable;

public class BasicStatManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private int playerLevel = 1;
    private int experiencePoints = 0;

    // Core Attributes
    private int strength = 10;
    private int dexterity = 10;
    private int constitution = 10;
    private int intelligence = 10;
    private int wisdom = 10;
    private int charisma = 10;
    
    // Proficiency System
    private int proficiencyBonus = (int) (Math.ceil(playerLevel/4) + 2);
    private boolean[] skillProficiencies = new boolean[19];
    
    // Skill indices (matches D&D 5e skill order)
    public static final int ATHLETICS = 0;
    public static final int ACROBATICS = 1;
    public static final int SLEIGHT_OF_HAND = 2;
    public static final int STEALTH = 3;
    public static final int ARCANA = 4;
    public static final int HISTORY = 5;
    public static final int INVESTIGATION = 6;
    public static final int NATURE = 7;
    public static final int RELIGION = 8;
    public static final int ANIMAL_HANDLING = 9;
    public static final int INSIGHT = 10;
    public static final int MEDICINE = 11;
    public static final int PERCEPTION = 12;
    public static final int SURVIVAL = 13;
    public static final int DECEPTION = 14;
    public static final int INTIMIDATION = 15;
    public static final int PERFORMANCE = 16;
    public static final int PERSUASION = 17;
    public static final int FORTITUDE = 18;
    
    /**
     * Constructor for BasicStatManager.
     * Sets all proficiencies to being false by default.
     */
    public BasicStatManager() {
        // initialize all proficiencies to false by default.
        for(int i = 0; i < skillProficiencies.length; i++) {
            skillProficiencies[i] = false;
        }
    }
    /**
     * Setter for playerLevel.
     * Also updates the proficiencyBonus to account for new level.
     * 
     * @param level new playerLevel.
     */
    public void setLevel(int level){
       playerLevel = level;
       proficiencyBonus = (int) (Math.ceil(playerLevel/4) + 2);
    }
    
    /**
     * Getter for playerLevel.
     * 
     * @return current playerLevel.
     */
    public int getLevel(){
        return playerLevel;
    }

    /**
     * Setter for experiencePoints.
     * 
     * @param amount new experiencePoints.
     */
    public void setExperience(int amount) {
        experiencePoints = amount;
    }
    
    /**
     * Getter for experiencePoints.
     * 
     * @return int, current experiencePoints.
     */
    public int getExperience(){
        return experiencePoints;
    }
    /**
     * Getter for strength.
     * 
     * @return int, strength.
     */
    public int getStrength() { return strength; }
    /**
     * Setter for strength.
     * 
     * @param strength, holds the input for strength.
     */
    public void setStrength(int strength) {
        validateAttribute(strength);
        this.strength = strength;
    }
    /**
     * Getter for dexterity.
     * 
     * @return The dexterity value.
     */
    public int getDexterity() { return dexterity; }
    /**
     * Setter for dexterity.
     * 
     * @param dexterity, holds the input for dexterity.
     */
    public void setDexterity(int dexterity) {
        validateAttribute(dexterity);
        this.dexterity = dexterity;
    }
    /**
     * Getter for constitution.
     * 
     * @return The constitution value.
     */
    public int getConstitution() { return constitution; }
    /**
     * Setter for constitution.
     * 
     * @param constitution, holds the input for constitution.
     */
    public void setConstitution(int constitution) {
        validateAttribute(constitution);
        this.constitution = constitution;
    }
    /**
     * Getter for intelligence.
     * 
     * @return The intelligence value.
     */
    public int getIntelligence() { return intelligence; }
    /**
     * Setter for intelligence.
     * 
     * @param intelligence, holds the input for intelligence.
     */
    public void setIntelligence(int intelligence) {
        validateAttribute(intelligence);
        this.intelligence = intelligence;
    }
    /**
     * Getter for wisdom.
     * 
     * @return The wisdom value.
     */
    public int getWisdom() { return wisdom; }
    /**
     * Setter for wisdom.
     * 
     * @param wisdom, holds the input for wisdom.
     */
    public void setWisdom(int wisdom) {
        validateAttribute(wisdom);
        this.wisdom = wisdom;
    }
    
    /**
     * Getter for charisma.
     * 
     * @return the charisma value.
     */
    public int getCharisma() { return charisma; }
    /**
     * Setter for charisma.
     * 
     * @param charisma, holds the input for charisma.
     */
    public void setCharisma(int charisma) {
        validateAttribute(charisma);
        this.charisma = charisma;
    }
    
    /**
     * Getter for proficiency bonus.
     * 
     * @return The proficiency bonus.
     */
    public int getProficiencyBonus() { return proficiencyBonus; }
    /**
     * Setter for proficiency bonus.
     * 
     * @param bonus, holds the value of the proficiency bonus.
     */
    public void setProficiencyBonus(int bonus) {
        if(bonus < 0) throw new IllegalArgumentException("Proficiency bonus cannot be negative");
        this.proficiencyBonus = bonus;
    }
    /**
     * This checks if the character is proficient or not in any selected skill.
     * 
     * @param skillIndex, holds the skill's index.
     * @return boolean
     */
    public boolean isProficient(int skillIndex) {
        return skillProficiencies[skillIndex];
    }
    
    /**
     * this function sets the proficiency for any selected skill.
     * This is based upon user input.
     * 
     * @param skillIndex, holds the skill's index.
     * @param proficient, holds whether or not the character is proficient in said skill.
     * @see EditChar
     */
    public void setProficiency(int skillIndex, boolean proficient) {
        skillProficiencies[skillIndex] = proficient;
    }

    /**
     * Gets the entire proficiency array.
     * Only used to convert to json.
     * 
     * @return skillProficiencies[], the array of skill proficiencies.
     */
    public boolean[] returnProf(){
        return skillProficiencies;
    }
    
    /**
     * This function gets the skill value based on the index of the skill.
     * Then calculates the skill's modifier.
     * 
     * @param skillIndex, holds the index of the selected skill
     * @return The modifier value for any selected skill.
     */
    public int getSkillValue(int skillIndex) {
        int baseModifier = 0;
        boolean proficient = skillProficiencies[skillIndex];
        
        switch(skillIndex) {
            // STR-based
            case ATHLETICS:
                baseModifier = calculateModifier(strength);
                break;
            case FORTITUDE:
                baseModifier = calculateModifier(strength);
                break;
                
            // DEX-based
            case ACROBATICS:
                baseModifier = calculateModifier(dexterity);
                break;
            case SLEIGHT_OF_HAND:
                baseModifier = calculateModifier(dexterity);
                break;
            case STEALTH:
                baseModifier = calculateModifier(dexterity);
                break;
                
            // INT-based
            case ARCANA:
                baseModifier = calculateModifier(intelligence);
                break;
            case HISTORY:
                baseModifier = calculateModifier(intelligence);
                break;
            case INVESTIGATION:
                baseModifier = calculateModifier(intelligence);
                break;
            case NATURE:
                baseModifier = calculateModifier(intelligence);
                break;
            case RELIGION:
                baseModifier = calculateModifier(intelligence);
                break;
                
            // WIS-based
            case ANIMAL_HANDLING:
                baseModifier = calculateModifier(wisdom);
                break;
            case INSIGHT:
                baseModifier = calculateModifier(wisdom);
                break;
            case MEDICINE:
                baseModifier = calculateModifier(wisdom);
                break;
            case PERCEPTION:
                baseModifier = calculateModifier(wisdom);
                break;
            case SURVIVAL:
                baseModifier = calculateModifier(wisdom);
                break;
                
            // CHA-based
            case DECEPTION:
                baseModifier = calculateModifier(charisma);
                break;
            case INTIMIDATION:
                baseModifier = calculateModifier(charisma);
                break;
            case PERFORMANCE:
                baseModifier = calculateModifier(charisma);
                break;
            case PERSUASION:
                baseModifier = calculateModifier(charisma);
                break;
            
            default:
                throw new IllegalArgumentException("Invalid skill index");
        }
        
        return baseModifier + (proficient ? proficiencyBonus : 0);
    }

    /**
     * Calculates the modifier to skill scores.
     * 
     * @param abilityScore, holds the base ability score.
     * @return The ability score after calculation.
     */
    private int calculateModifier(int abilityScore) {
        return (int) Math.floor((abilityScore - 10) / 2);
    }
    
    /**
     * This checks to see if the attribute value is between 1 and 30.
     * 
     * @param value , Holds the attribute value.
     */
    private void validateAttribute(int value) {
        if(value < 1 || value > 30) {
            throw new IllegalArgumentException("Ability scores must be between 1 and 30");
        }
    }

    /**
     * All of these are getters for the UI. These get every base stat for
     * the character and their modifier value.
     * 
     * @return int, calculatedModifer, Each base stat.
     */
    public int getStrengthModifier() { return calculateModifier(strength); }
    public int getDexterityModifier() { return calculateModifier(dexterity); }
    public int getConstitutionModifier() { return calculateModifier(constitution); }
    public int getIntelligenceModifier() { return calculateModifier(intelligence); }
    public int getWisdomModifier() { return calculateModifier(wisdom); }
    public int getCharismaModifier() { return calculateModifier(charisma); }
    
}