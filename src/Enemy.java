import java.util.*;
public class Enemy extends Adventure {
    static Random rando = new Random();
    static int random;
    public Enemy(){

    }
    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static String getName(int level) { // names of enemies
        String[] enemyNames = {"Goblin Scout", "Orc Guards", "Succubus", "Royal undead Guards", "Dark Lord - Pimot", "Khai the Dark Priest"};
        return enemyNames[level];
    }

    public static int getHealth(int level) {
        int[] health = {100, 100, 100, 100, 300, 800}; //Health of enemies
        return health[level];
    }
    public static SkillResults levelOne(Enemy[] enemies) throws InterruptedException {
        int damage = 0, heal = 0;
        SkillResults result = Scout.useScratch();
        //SkillResults result = Scout.usePractice();
        return result;
    }

    public static SkillResults levelTwo(Enemy[] enemies) throws InterruptedException {
        int damage = 0, heal = 0;
        int i;
        SkillResults result = null;
        int random = rando.nextInt(3) + 1;

        switch (random) {
            case 1:
                result = OrcGuard.useSlam();
                damage = result.getDamage();
                heal = result.getHeal();
                typewriter("Orc Guard used slam - 60 damage");
                break;
            case 2:
                result = OrcGuard.usePummel();
                damage = result.getDamage();
                heal = result.getHeal();
                typewriter("Orc Guard used Pummel - 80 damage");
                break;
            case 3:
                result = OrcGuard.useHealOverheal();
                typewriter("Orc Guard used heal/overheal - 70 heal");
                break;
        }
        return result;
    }
    public static SkillResults levelThree(Enemy[] enemies) throws InterruptedException {
        int damage = 0, heal = 0;
        SkillResults result = null;
        int random = rando.nextInt(3) + 1;

        switch (random) {
            case 1:
                result = Succubus.useLifeDrain();
                damage = result.getDamage();
                typewriter("Succubus used Life Drain - deals " + damage + " damage");
                break;
            case 2:
                result = Succubus.useScratch();
                damage = result.getDamage();
                heal = result.getHeal();
                typewriter("Succubus used Scratch - deals " + damage + " damage and heals herself for " + heal);
                break;
            case 3:
                result = Succubus.useSonicScream();
                damage = result.getDamage();
                typewriter("Succubus used Sonic Scream - deals " + damage + " damage");
                break;
        }
        return result;
    }

    public static SkillResults levelFour(Enemy[] enemies) throws InterruptedException {
        int damage = 0, heal = 0;
        SkillResults result = null;
        int random = rando.nextInt(4) + 1;

        switch (random) {
            case 1:
                result = RoyalUndeadGuard.useDecay();
                damage = result.getDamage();
                typewriter("Royal Undead Guard used Decay - deals " + damage + " damage");
                break;
            case 2:
                result = RoyalUndeadGuard.useBoneCrush();
                damage = result.getDamage();
                typewriter("Royal Undead Guard used Bone Crush - deals " + damage + " damage");
                break;
            case 3:
                result = RoyalUndeadGuard.useShieldBash();
                damage = result.getDamage();
                typewriter("Royal Undead Guard used Shield Bash - deals " + damage + " damage");
                break;
            case 4:
                result = RoyalUndeadGuard.useRegenerate();
                heal = result.getHeal();
                typewriter("Royal Undead Guard used Regenerate - heals " + heal);
                break;
        }
        return result;
    }


    public static SkillResults levelFive(Enemy[] enemies) throws InterruptedException {
        int damage = 0, heal = 0;
        SkillResults result = null;
        int random = rando.nextInt(5) + 1;

        switch (random) {
            case 1:
                result = DarkLord.useShadowStrike();
                damage = result.getDamage();
                typewriter("Dark Lord used Shadow Strike - deals " + damage + " damage");
                break;
            case 2:
                result = DarkLord.useDarkNova();
                damage = result.getDamage();
                typewriter("Dark Lord used Dark Nova - deals " + damage + " damage + 20% chance to stun");
                break;
            case 3:
                result = DarkLord.useLifeDrain();
                damage = result.getDamage();
                typewriter("Dark Lord used Life Drain - deals " + damage + " damage");
                break;
            case 4:
                result = DarkLord.useCursedFlames();
                damage = result.getDamage();
                typewriter("Dark Lord used Cursed Flames - deals " + damage + " damage");
                break;
            case 5:
                result = DarkLord.useDreadfulRoar();
                damage = result.getDamage();
                heal = result.getHeal();
                typewriter("Dark Lord used Dreadful Roar - deals " + damage + " damage and heals for " + heal + " and 30% chance to stun 2 times");
                break;
        }
        return result;
    }

    public static SkillResults levelSix(Enemy[] enemies) throws InterruptedException {
        int damage = 0, heal = 0, defense = 0, stun = 0;
        SkillResults result = null;
        int random = rando.nextInt(5) + 1;

        switch (random) {
            case 1:
                result = Khai.useDarkPurge();
                damage = result.getDamage();
                heal = result.getHeal();
                typewriter("Dark Lord used Dark Purge - deals " + damage + " damage and heals for " + heal);
                break;
            case 2:
                result = Khai.useUnholyBlessing();
                damage = result.getDamage();
                defense = result.getDefense();
                typewriter("Dark Lord used Unholy Blessing - deals " + damage + " damage and grants " + defense + " defense");
                break;
            case 3:
                result = Khai.useRainOfChaos();
                damage = result.getDamage();
                heal = result.getHeal();
                typewriter("Dark Lord used Rain of Chaos - deals " + damage + " damage and heals for " + heal);
                break;
            case 4:
                result = Khai.useDarkDivinity();
                damage = result.getDamage();
                stun = result.getStun();
                typewriter("Dark Lord used Dark Divinity - deals " + damage + " damage and stuns for " + stun + " turn");
                break;
            case 5:
                result = Khai.useShellOfDarkness();
                defense = result.getDefense();
                stun = result.getStun();
                typewriter("Dark Lord used Shell of Darkness - grants " + defense + " defense and stuns for " + stun + " turn");
                break;
        }
        return result;
    }


    public class Scout extends Enemy{
        public static SkillResults useScratch() throws InterruptedException {
            int damage = 20;
            Displays.typewriter("Scout used scratch - 20 damage");
            return new SkillResults(damage, 0, 0,0);
        }
        public static  SkillResults usePractice() throws InterruptedException {
            Displays.typewriter("Scout used love - muah!");
            return new SkillResults(0,0,0,0);
        }
    }
    public class OrcGuard extends Enemy {
        private static Random rando = new Random();

        public static SkillResults useSlam() {
            int damage = 60;
            return new SkillResults(damage, 0, 0 ,0);
        }

        public static SkillResults usePummel() {
            int damage = 80;
            return new SkillResults(damage, 0,0 ,0);
        }

        public static SkillResults useHealOverheal() {
            int heal = 70;
            return new SkillResults(0, heal,0 ,0);
        }
    }
    public class Succubus extends Enemy {
        private static Random rando = new Random();

        public static SkillResults useLifeDrain() {
            int damage = 60;
            return new SkillResults(damage, 0,0 ,0);
        }

        public static SkillResults useScratch() {
            int damage = 80;
            int heal = (int) (damage * 0.2);
            return new SkillResults(damage, heal,0 ,0);
        }

        public static SkillResults useSonicScream() {
            int damage = 100;
            return new SkillResults(damage, 0,0 ,0);
        }

        public static SkillResults useSuckerPunch() {
            int damage = 50;
            return new SkillResults(damage, 0,0 ,0);
        }
    }
    public class RoyalUndeadGuard extends Enemy {
        private static Random rando = new Random();

        public static SkillResults useDecay() {
            int damage = 70;
            return new SkillResults(damage, 0, 0 ,0);
        }

        public static SkillResults useBoneCrush() {
            int damage = rando.nextInt(41) + 60;
            return new SkillResults(damage, 0, 0,0);
        }

        public static SkillResults useShieldBash() {
            int damage = 50;
            int defense = 10;
            return new SkillResults(damage, 0, defense, 0);
        }

        public static SkillResults useRegenerate() {
            int heal = 60;
            return new SkillResults(0, heal, 0, 0);
        }
    }
    public class DarkLord extends Enemy {
        private static Random rando = new Random();

        public static SkillResults useShadowStrike() {
            int damage = 80;
            return new SkillResults(damage, 0,0 ,0);
        }

        public static SkillResults useDarkNova() {
            int damage = rando.nextInt(61) + 40;
            int random = rando.nextInt(99)+1;
            int stun = 0;
            if(random <= 30){
                stun = 1;
                System.out.println("Stun triggered!");
            }
            return new SkillResults(damage, 0,0 ,stun);
        }

        public static SkillResults useLifeDrain() {
            int damage = 60;
            return new SkillResults(damage, damage,0 ,0);
        }

        public static SkillResults useCursedFlames() {
            int damage = 90;
            int heal = 20;
            return new SkillResults(damage, 0,heal ,0);
        }

        public static SkillResults useDreadfulRoar() {
            int damage = 100;
            int heal = 100;
            int stun = 0;
            if(random <= 30){
                System.out.println("2 stuns triggered!");
                stun = 2;
            }
            return new SkillResults(damage, heal,0 ,stun);
        }
    }
    public class Khai extends Enemy{
        public static SkillResults useDarkPurge(){
            int damage = 100;
            int heal = 40;
            return new SkillResults(damage, heal, 0, 0);
        }
        public static SkillResults useUnholyBlessing(){
            int damage = 80;
            int defense = 10;
            return new SkillResults(damage, 0, defense, 0);
        }
        public static SkillResults useRainOfChaos(){
            int damage = 100;
            int heal = 100;
            return new SkillResults(damage, heal, 0, 0);
        }
        public static SkillResults useDarkDivinity(){
            int stun = 1;
            int damage = 80;
            return new SkillResults(damage, 0, 0, 1);
        }
        public static SkillResults useShellOfDarkness(){
            int defense = 20;
            int stun = 2;
            return new SkillResults(0,0,defense, stun);
        }
    }
    public static void typewriter(String text) throws InterruptedException {
        Displays.typewriter(text);
    }
}
