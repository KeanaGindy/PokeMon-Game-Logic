package Base;

public interface TrainerFactoryInt {
    
    /**
     * Gets the name of the trainer.
     * 
     * @return The name of the trainer.
     */
    String getName();
    
    /**
     * Gets an array of CodeAMonFactory objects representing the trainer's CodeAMons.
     * 
     * @return An array of CodeAMonFactory objects representing the trainer's CodeAMons.
     */
    CodeAMonFactory[] getCodeAMons();
    
    /**
     * Adds a CodeAMonFactory object to the trainer's collection of CodeAMons.
     * 
     * @param codeAMon The CodeAMonFactory object to be added.
     */
    void addCodeAMon(CodeAMonFactory codeAMon);
    
    /**
     * Increases the count of fainted CodeAMons.
     */
    void addFaintedCodeAMon();
    
    /**
     * Gets the count of fainted CodeAMons.
     * 
     * @return The count of fainted CodeAMons.
     */
    int getFaintedCodeAMon();
    
    /**
     * Removes the CodeAMonFactory object at the specified index from the trainer's collection of CodeAMons.
     * 
     * @param index The index of the CodeAMonFactory object to be removed.
     */
    void removeCodeAMon(int index);
    
    /**
     * Determines whether the trainer has at least one active (i.e. healthy) CodeAMonFactory object.
     * 
     * @return True if the trainer has at least one active CodeAMonFactory object, false otherwise.
     */
    boolean hasActiveCodeAMon();
}
