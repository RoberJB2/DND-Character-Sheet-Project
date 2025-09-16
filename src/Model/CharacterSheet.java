package Model;


import java.io.Serializable;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * @author N Arango
 * 
 * Interfaces between the Controller and the other elements of the Model.
 */

    public class CharacterSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    private String characterName;
    private final BasicStatManager basicStats;
    private final Inventory inventory;
    private final PlayerState playerState;
    private final SpellBook spellBook;

    public CharacterSheet(String name) {
        this.characterName = Objects.requireNonNull(name, "Character must have a name");
        this.basicStats = new BasicStatManager();
        this.inventory = new Inventory();
        this.playerState = new PlayerState();
        this.spellBook = new SpellBook();
    }

    /**
     * Gets characterName
     * 
     * @return current characterName
     */
    public String getCharacterName() { return characterName; }
    
    /**
     * Sets new characterName
     * 
     * @param name string of the new characterName
     */
    public void setCharacterName(String name){
        characterName = name;
    }
    
    public BasicStatManager getBaseStats() { return basicStats; }
    public Inventory getInventory() { return inventory; }
    public PlayerState getPlayerState() { return playerState; }
    public SpellBook getSpellBook() { return spellBook; }
    
    /**
     * Sets Strength in basicStats
     * 
     * @param i new Strength
     */
    public void setStrength(int i){
        basicStats.setStrength(i);
    }
    
    /**
     * Gets Strength from basicStats
     * 
     * @return current Strength
     */
    public int getStrength(){
        int i = basicStats.getStrength();
        return i;
    }
    
    /**
     * Sets Dexterity in basicStats
     * 
     * @param i new Dexterity
     */
    public void setDexterity(int i){
        basicStats.setDexterity(i);
    }
    
    /**
     * Gets Dexterity from basicStats
     * 
     * @return current Dexterity
     */
    public int getDexterity(){
        int i = basicStats.getDexterity();
        return i;
    }
    
    /**
     * Sets Constitution in basicStats
     * 
     * @param i new Constitution
     */
    public void setConstitution(int i){
        basicStats.setConstitution(i);
    }
    
    /**
     * Gets Constitution from basicStats
     * 
     * @return current Constitution
     */
    public int getConstitution(){
        int i = basicStats.getConstitution();
        return i;
    }
    
    /**
     * Sets Intelligence in basicStats
     * 
     * @param i new Intelligence
     */
    public void setIntelligence(int i){
        basicStats.setIntelligence(i);
    }
    
    /**
     * Gets Intelligence from basicStats
     * 
     * @return current Intelligence
     */
    public int getIntelligence(){
        int i = basicStats.getIntelligence();
        return i;
    }
    
    /**
     * Sets Wisdom in basicStats
     * 
     * @param i new Wisdom
     */
    public void setWisdom(int i){
        basicStats.setWisdom(i);
    }
    
    /**
     * Gets Wisdom from basicStats
     * 
     * @return current Wisdom
     */
    public int getWisdom(){
        int i = basicStats.getWisdom();
        return i;
    }
    
    /**
     * Sets Charisma in basicStats
     * 
     * @param i new Charisma
     */
    public void setCharisma(int i){
        basicStats.setCharisma(i);
    }
    
    /**
     * Gets Charisma from basicStats
     * 
     * @return current Charisma
     */
    public int getCharisma(){
        int i = basicStats.getCharisma();
        return i;
    }
    
    /**
     * Sets maxHealth in playerState
     * 
     * @param i new maxHealth
     */
    public void setMaxHealth(int i){
        playerState.setMaxHealth(i);
    }
    
    /**
     * Gets maxHealth from playerState
     * 
     * @return current maxHealth
     */
    public int getMaxHealth(){
        int i = playerState.getMaxHealth();
        return i;
    }
    
    /**
     * Sets currentHealth in playerState
     * 
     * @param i new currentHealth
     */
    public void setCurrentHealth(int i){
        playerState.setCurrentHealth(i);
    }
    
    /**
     * Gets currentHealth from playerState
     * 
     * @return current currentHealth
     */
    public int getCurrentHealth(){
        int i = playerState.getCurrentHealth();
        return i;
    }
    
    /**
     * Sets playerLevel in basicStats
     * 
     * @param i new playerLevel
     */
    public void setLevel(int i){
        basicStats.setLevel(i);
    }
    
    /**
     * Gets playerLevel from basicStats
     * 
     * @return current playerLevel
     */
    public int getLevel(){
        int i = basicStats.getLevel();
        return i;
    }
    
    /**
     * Sets experiencePoints in basicStats
     * 
     * @param i new experiencePoints
     */
    public void setExperience(int i){
        basicStats.setExperience(i);
    }
    
    /**
     * Gets experiencePoints from basicStats
     * 
     * @return current experiencePoints
     */
    public int getExperience(){
        int i = basicStats.getExperience();
        return i;
    }
    
    /**
     * Gets the value of the indicated Skill from basicStats
     * 
     * @param i index of the skill requested
     * @return value of the requested Skill
     */
    public int getSkillValue(int i){
        int j = basicStats.getSkillValue(i);
        return j;
    }
    
    /**
     * Changes the proficiency of the indicated skill
     * 
     * @param i index of the skill
     * @param state new value of the proficiency
     */
    public void setProficiency(int i, boolean state){
        basicStats.setProficiency(i, state);
    }
    
    /**
     * Checks if the character is proficient in the indicated skill
     * 
     * @param i index of the skill
     * @return value of the proficiency
     */
    public boolean isProficient(int i){
        return basicStats.isProficient(i);
    }
    
    /**
     * Gets the boolean array for skill proficiency. Only used for saving to json
     * 
     * @return skill proficiency array
     */
    public boolean[] returnProf(){
        return basicStats.returnProf();
    }
    
    /**
     * Gets the saving throw value for the indicated core stat from basicStats
     * 
     * @param key key to choose core stat
     * @return value for saving throws
     */
    public int getSkillProf(int key){
        int j;
        switch (key){
            case 1 -> j = basicStats.getStrengthModifier();
            case 2 -> j = basicStats.getDexterityModifier();
            case 3 -> j = basicStats.getConstitutionModifier();
            case 4 -> j = basicStats.getIntelligenceModifier();
            case 5 -> j = basicStats.getWisdomModifier();
            case 6 -> j = basicStats.getCharismaModifier();
            default -> j = 0;
        }
        return j;
    }
}
