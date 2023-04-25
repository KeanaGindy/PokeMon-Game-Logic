package Base;

/**
 * Interface representing an attack that a Code-a-mon can use in battle.
 */
public interface AttackFactoryInt {
    
    /**
     * Gets the name of the attack.
     * 
     * @return The name of the attack.
     */
    String getName();
    
    /**
     * Gets the damage of the attack.
     * 
     * @return The damage of the attack.
     */
    int getDamage();
    
    /**
     * Gets the type of the attack.
     * 
     * @return The type of the attack.
     */
    String getType();
    
    /**
     * Calculates the damage to be dealt by the attack, taking into account
     * critical strikes and misses.
     * 
     * @return The net damage to be dealt by the attack.
     */
    int calculateDamage();
}

