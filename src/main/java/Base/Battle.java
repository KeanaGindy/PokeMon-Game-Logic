public class Battle {
    private Trainer trainer1;
    private Trainer trainer2;
    private CodeAMon codeAMon1;
    private CodeAMon codeAMon2;
    private boolean isTrainer1Turn;
    
    public Battle(Trainer trainer1, Trainer trainer2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.codeAMon1 = trainer1.getNextCodeAMon();
        this.codeAMon2 = trainer2.getNextCodeAMon();
        this.isTrainer1Turn = true;
    }
    
    public boolean isOver() {
        return codeAMon1.getHealth() <= 0 || codeAMon2.getHealth() <= 0;
    }
    
    public void doTurn(Attack attack) {
        CodeAMon attacker = isTrainer1Turn ? codeAMon1 : codeAMon2;
        CodeAMon defender = isTrainer1Turn ? codeAMon2 : codeAMon1;
        
        if (attacker.getHealth() <= 0) {
            System.out.println(attacker.getName() + " is unable to attack.");
        } else {
            System.out.println(attacker.getName() + " uses " + attack.getName() + "!");
            
            if (Math.random() < attack.getAccuracy()) {
                int damage = attack.getDamage();
                double effectiveness = attacker.getEffectiveness(defender);
                
                damage *= effectiveness;
                defender.takeDamage(damage);
                
                System.out.println("It deals " + damage + " damage!");
                
                if (effectiveness > 1) {
                    System.out.println("It's super effective!");
                } else if (effectiveness < 1) {
                    System.out.println("It's not very effective...");
                }
                
                if (Math.random() < attack.getCriticalChance()) {
                    System.out.println("A critical hit!");
                    damage *= 2;
                }
            } else {
                System.out.println(attacker.getName() + " misses the attack!");
            }
        }
        
        isTrainer1Turn = !isTrainer1Turn;
    }
    
    public void doTrainerTurn(Item item) {
        Trainer currentTrainer = isTrainer1Turn ? trainer1 : trainer2;
        
        if (item.getEffect() == ItemEffect.HEAL) {
            CodeAMon codeAMon = currentTrainer.getNextCodeAMon();
            
            if (codeAMon == null) {
                System.out.println(currentTrainer.getName() + " has no conscious CodeAMons left!");
            } else {
                int amount = item.getAmount();
                codeAMon.heal(amount);
                System.out.println(codeAMon.getName() + " recovers " + amount + " health!");
            }
        } else if (item.getEffect() == ItemEffect.STAT_BOOST) {
            CodeAMon codeAMon = isTrainer1Turn ? codeAMon1 : codeAMon2;
            StatType statType = item.getStatType();
            int amount = item.getAmount();
            codeAMon.boostStat(statType, amount);
            System.out.println(codeAMon.getName() + "'s " + statType + " is boosted by " + amount + "!");
        }
        
        isTrainer1Turn = !isTrainer1Turn;
    }
    
    public void end() {
        if (codeAMon1.getHealth() <= 0) {
            trainer2.addMoney(100);
            trainer2.addExperience(codeAMon2.getLevel() * 50);
            System.out.println(trainer1.getName() + "'s " + codeAMon
