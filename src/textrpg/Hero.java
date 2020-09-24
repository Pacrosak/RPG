package textrpg;

public class Hero extends Character{

    int gold;
    int potions;
    int damage;
    int defense;
    String inventory;
    int level;

    public Hero(String name) {
        super(name, 100, 0);
        
        this.damage = 5;
        this.defense = 5;
        this.experience = 0;
        this.potions = 0;
        this.inventory="";
        this.gold=500;
        this.level=1;
    }

    
    
}
