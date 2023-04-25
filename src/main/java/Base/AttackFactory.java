package Base;

public class AttackFactory {

    private String name;
    private int damage;
    private String type;

    public AttackFactory(String name, int damage, String type) {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }

    public int calculateDamage() {
        int crit = (int) (Math.random() * 100);
        int miss = (int) (Math.random() * 100);
        if (miss < 40) {
            System.out.println("Attack missed!");
            return 0;
        }
        int netDamage = this.damage;
        if (crit < 10) {
            System.out.println("Critical strike!");
            netDamage *= 1.2;
        }
        return netDamage;
    }

    
}
