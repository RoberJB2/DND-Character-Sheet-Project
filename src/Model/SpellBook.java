package Model;


import Model.Spell;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * @version %I%
 * @since 1.0
 * 
 * Class: Spell Book
 * subclass of SpellList
 * public
 * 
 * Collaborators:
 *  Character Sheet, Menu Manager, Spell List
 * 
 * Responsibilities:
 *  Displays, and creates edit ability for available spells for a character
 *  Note: The Spell Book class will store a character's spells in a JSON file
 * 
 * Methods:
 *  SpellCreate Enum:
 *      private
 *      Parameters: none
 *      return: void/none
 *      Holds the character's spells, and is called to create the JSON file
 *      when the character is saved
 *  SpellGet():
 *      private
 *      Parameters: none
 *      return: boolean
 *      Gets chosen spells through input from the user, then
 *      Communicates with the Spell List class to obtain these spells
 *  SpellSet (int SelectSpell):
 *      private
 *      Parameters: Dictates spell chosen
 *      return: booleaen
 *      Communicates with the spell book to set the character's spells
 *  Display(SpellCreate Obj):
 *      private
 *      Parameters: grabs spells from the SpellCreate enum.
 *      return: string
 *      Displays the spells to the GUI
 */
public class SpellBook {
    
    private List<Spell> knownSpells;
    
    /**
     * Default constructor for spell book
     */
    public SpellBook(){
        this.knownSpells = new ArrayList<>();
        this.addSpell(new Spell());
    }
    
    /**
     * Adds any specified spell.
     * 
     * @param spell, holds the spell
     */
    public void addSpell(Spell spell) {
        if (spell != null) {
            knownSpells.add(spell);
        }
    }

    /**
     * Removes any specified spell.
     * 
     * @param spell, holds the spell
     * @return The removed spell.
     */
    public boolean removeSpell(Spell spell) {
        return knownSpells.remove(spell);
    }

    /**
     * Getter for the list of all spells.
     * 
     * @return returns an array list of all spells.
     */
    public List<Spell> getAllSpells() {
        return new ArrayList<>(knownSpells); // Return copy to prevent internal list modification
    }

    /**
     * Getter for all spells associated with a specific spell level.
     * For example, spell level 1 gets all level 1 spells.
     * 
     * @param level, integer for spell level.
     * @return All spells for specified level.
     */
    public List<Spell> getSpellsByLevel(int level) {
        List<Spell> spellsByLevel = new ArrayList<>();
        for (Spell spell : knownSpells) {
            if (spell.getLevel() == level) {
                spellsByLevel.add(spell);
            }
        }
        return spellsByLevel;
    }

    /**
     * Clears the character's spell book.
     */
    public void clearSpellbook() {
        knownSpells.clear();
    }
}