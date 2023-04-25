package Base;

import java.util.List;

/**
 * An interface representing a CodeAMonFactory that creates CodeAMon objects with various attributes and behaviors.
 */
public interface CodeAMonFactoryInt {
    
    /**
     * Gets the health of the CodeAMon.
     * @return the health of the CodeAMon
     */
    public int getHealth();
    
    /**
     * Sets the health of the CodeAMon.
     * @param health the health to set
     */
    public void setHealth(int health);

    /**
     * Sets the defense of the CodeAMon.
     * @param defense the defense to set
     */
    public void setDefense(int defense);
    
    
    /**
     * Checks whether the CodeAMon has fainted.
     * @return true if the CodeAMon has fainted (health <= 0), false otherwise
     */
    public boolean isFainted();
    
    /**
     * Takes damage and adjusts the CodeAMon's health accordingly.
     * @param damage the amount of damage to take
     */
    public void takeDamage(int damage);
    
    /**
     * Gets the name of the CodeAMon.
     * @return the name of the CodeAMon
     */
    public String getName();
    
    /**
     * Gets the level of the CodeAMon.
     * @return the level of the CodeAMon
     */
    public int getLevel();
    
    /**
     * Gets the defense of the CodeAMon.
     * @return the defense of the CodeAMon
     */
    public int getDefense();
    
    /**
     * Gets the type of the CodeAMon.
     * @return the type of the CodeAMon
     */
    public String getType();
    
    /**
     * Gets the list of attacks of the CodeAMon.
     * @return the list of attacks of the CodeAMon
     */
    public List<AttackFactory> getAttacks();
    
    /**
     * Adds the specified attack to the CodeAMon's list of attacks, up to a maximum of four.
     * @param attack the attack to add
     */
    public void addAttack(AttackFactory attack);
    
    /**
     * Allows the current CodeAMon to choose an attack at random from its list of attacks.
     * @return the chosen attack
     */
    public AttackFactory chooseAttack();
}
