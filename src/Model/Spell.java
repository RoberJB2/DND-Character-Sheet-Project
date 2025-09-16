package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ellie R.
 * @author Robert J.
 * @version %I%
 * @since 1.0
 */
public class Spell {
    private String name;
    private int level;
    private String effect;
    private String stat;
    private Boolean save;
    private Boolean roll;

    /**
     * This is the parameterized constructor for the Spell class.
     * 
     * @param name, holds the name of the spell.
     * @param level, holds spell level.
     * @param effect, holds the spell effect.
     * @param stat, holds which stat the spell is modified by.
     * @param save, holds which saving throw is associated with the spell.
     * @param roll, holds the roll value.
     */
    public Spell(String name, int level, String effect, String stat, 
                Boolean save, Boolean roll) {
        this.name = name;
        this.level = level;
        this.effect = effect;
        this.stat = stat;
        this.save = save;
        this.roll = roll;
    }

        public Spell() {
        this.name = "Nameless Spell";
        this.level = 1;
        this.effect = "add info here";
        this.stat = "INT";
        this.save = false;
        this.roll = true;
    }
        
    /**
     * Getter for spell name.
     * 
     * @return the spell name.
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for spell name.
     * 
     * @param name String, holds the spell name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter for spell level.
     * 
     * @return The spell level.
     */
    public int getLevel() {
        return level;
    }
    /**
     * Setter for spell level.
     * 
     * @param level, holds the spell level.
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     * Getter for spell effect.
     * 
     * @return the spell effect.
     */
    public String getEffect() {
        return effect;
    }
    /**
     * Setter for spell effect.
     * 
     * @param effect String, holds the effect.
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }
    /**
     * Getter for required stat.
     * 
     * @return The required stat.
     */
    public String getStat() {
        return stat;
    }
    /**
     * Setter for stat associated with the spell.
     * 
     * @param stat, holds which stat is required.
     */
    public void setStat(String stat) {
        this.stat = stat;
    }
    /**
     * Getter for saving throw
     * 
     * @return boolean, this holds the saving throw value.
     */
    public Boolean getSave() {
        return save;
    }
    /**
     * Setter for saving throw.
     * 
     * @param save, this holds the saving throw value.
     */
    public void setSave(Boolean save) {
        this.save = save;
    }
    /**
     * Getter for roll
     * 
     * @return boolean, if the roll worked or not
     */
    public Boolean getRoll() {
        return roll;
    }
    /**
     * Setter for roll
     * 
     * @param roll, holds true or false for if the roll worked or not
     */
    public void setRoll(Boolean roll) {
        this.roll = roll;
    }
}
