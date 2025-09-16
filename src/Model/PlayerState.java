package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 *
 * @author Robert J.
 * @author Ellie R
 * @author N Arango
 * @version %I%
 * @since 1.0
 * 
 * Class: Player State
 * public
 * 
 * Collaborators:
 *  Character Sheet
 * 
 * Responsibilities:
 *  Changes real time effects and stats such as:
 *  Current Health, Status (Ex: Poison), and Experience Points
 * 
 * Methods:
 *  CurrentHealth:
 *      private
 *      Receives and gives data on the characters health based on user input
 *  ExperiencePoints(EXP Experience):
 *      private
 *      parameters: inputs the experience type through the EXP object
 *      return:
 *      Receives and gives data on the character's Experience Points or Milestone
 *  Status Enum:
 *      private
 *      parameters: none
 *      return: none
 *      Holds all available status effects and their values
 *  StatusEffect:
 *      Gives and receives data to the character's stats, 
 *      altering them based on input (Status given).
 */
public class PlayerState {

    private int currentHealth;
    private int maxHealth;
    private final Set<Status> activeStatuses = EnumSet.noneOf(Status.class);
    
    /**
     * Default Constructor for PlayerState.
     */
    public PlayerState() {
        currentHealth = 1;
        maxHealth = 1;
    }

    /**
     * Enum for Statuses
     */
    public enum Status {
        ENCUMBERED("Encumbered", "STR", -1);
        //add more later, not even sure this is the right stat modifier for overencumbered, just an example
        
        private final String displayName;
        private final String affectedStat;
        private final int modifier;
        
        /**
         * Constructor with parameters for Status.
         * 
         * @param displayName, string holding display name.
         * @param affectedStat, string holding the affected stat.
         * @param modifier, amount to modify the affected stat by. Example: -1.
         */
        Status(String displayName, String affectedStat, int modifier) {
            this.displayName = displayName;
            this.affectedStat = affectedStat;
            this.modifier = modifier;
        }
        /**
         * Getter for displayed name
         * 
         * @return the displayed name
         */
        public String getDisplayName() {
            return displayName;
        }
        /**
         * Getter for affected stat
         * 
         * @return String, which stat was effected
         */
        public String getAffectedStat() {
            return affectedStat;
        }
        /**
         * Getter for modifier
         * 
         * @return int, modifier value
         */
        public int getModifier() {
            return modifier;
        }
    }
    
    /**
     * Setter for maxHealth
     * 
     * @param amount new Max Health
     */
    public void setMaxHealth(int amount) {
        maxHealth = amount;
    }

    /**
     * Setter for currentHealth
     * 
     * @param amount new currentHealth
     */
    public void setCurrentHealth(int amount) {
        currentHealth = amount;
    }
    /**
     * Adds a status effect to the character
     * 
     * @param status, holds the status name
     */
    public void addStatus(Status status) {
        activeStatuses.add(status);
    }
    /**
     * Removes a status.
     * 
     * @param status, holds the name of the status.
     */
    public void removeStatus(Status status) {
        activeStatuses.remove(status);
    }
    /**
     * Checks to see if the character has the status.
     * 
     * @param status, holds the status name.
     * @return boolean
     */
    public boolean hasStatus(Status status) {
        return activeStatuses.contains(status);
    }
    /**
     * Getter for Active Statuses
     * 
     * @return set of statuses
     */
    public Set<Status> getActiveStatuses() {
        return Collections.unmodifiableSet(activeStatuses);
    }

    /**
     * Getter for currentHealth
     * 
     * @return current currentHealth
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Getter for maxHealth
     * 
     * @return current maxHealth
     */
    public int getMaxHealth(){
        return maxHealth;
    }
}
