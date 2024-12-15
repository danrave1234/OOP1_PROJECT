public class SkillResults {
    private int damage;
    private int heal;
    private int defense;
    private int stun;
    public SkillResults(int damage, int heal, int defense, int stun) {
        this.damage = damage;
        this.heal = heal;
        this.defense = defense;
        this.stun = stun;
    }

    public int getDamage() {
        return damage;
    }
    public int getStun(){
        return stun;
    }
    public int getDefense(){
        return defense;
    }

    public int getHeal() {
        return heal;
    }

    public SkillResults setHeal(int heal) {
        SkillResults result = new SkillResults(0, heal, defense, 0);
        return result;
    }

    public SkillResults setDamage(int damage) {
        SkillResults result = new SkillResults(damage, 0, defense, 0);
        return result;
    }
    public SkillResults setDefense(int defense){
        SkillResults result = new SkillResults(0, 0, defense, 0);
        return result;
    }
    public SkillResults setStun(int stun){
        SkillResults result = new SkillResults(0, 0, 0, stun);
        return result;
    }
}
