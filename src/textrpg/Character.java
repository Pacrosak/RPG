package textrpg;

public abstract class Character {

    public String name;
    public int fullHp;
    public int hp;
    public int experience;
   



    public Character(String name, int fullHp, int exp) {
        this.name = name;
        this.fullHp = fullHp;
        this.hp = fullHp;
        this.experience = exp;

    }

}
