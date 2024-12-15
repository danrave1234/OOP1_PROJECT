public abstract class Adventure{
    protected String name;
    protected int health;
    protected int defense;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    public int getDefense(){
        return defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }

}