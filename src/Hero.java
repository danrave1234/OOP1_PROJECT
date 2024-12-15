import java.util.*;
public class Hero extends Adventure{
static Scanner input = new Scanner(System.in);
static Random rando = new Random();
static int damage;
static int random;
static int knight = 0, assassin = 0, warrior = 0, wizard = 0, priest = 0;
    public Hero(){
    }
    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }
    public static Hero[] removePriest(Hero[] heroes) {
        int count = 0;
        for (Hero hero : heroes) {
            if ("Priest".equals(hero.getName())) {
                count++;
            }
        }

        if (count == 0) {
            return heroes;
        }

        Hero[] newArray = new Hero[heroes.length - count];
        int newIndex = 0;

        for (Hero hero : heroes) {
            if (!"Priest".equals(hero.getName())) {
                newArray[newIndex] = hero;
                newIndex++;
            }
        }

        return newArray;
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
    public static String getName(int index) {
        String[] heroNames = {"Knight", "Assassin", "Warrior", "Wizard", "Priest"};
        return heroNames[index];
    }
    public static int getHealth(int index) {
        int[] health = {500, 450, 600, 400, 400};
        return health[index];
    }
public static SkillResults heroSkills(Hero[] heroes, int who) {
    int skillChoice, damage = 0, heal = 0;
    SkillResults result = new SkillResults(0,0,0,0);
    while(true) {
        if (heroes[who - 1].getName().equals("Knight")) {
            if(heroes[who-1].getHealth() > 0) {
                while(true) {
                    Displays.clear();
                    System.out.println("Knight's skills:");
                        System.out.println("Skill 1: Slash, deals 60 damage");
                        System.out.println("Skill 2: Sweep, deals 40-80 damage");
                        System.out.println("Skill 3: Holy Shield, grants 40 defense");
                        if (knight >= 3) {
                            System.out.println("Ultimate 4: Excalibur, deals 100 damage and grants 20 defense. Available!");
                        } else {
                            System.out.println("Ultimate 4: Excalibur, deals 100 damage and grants 20 defense. Required " + (3 - knight) + " Knight uses to use.");
                        }
                        Displays.clear();
                    try {
                        System.out.print("Choose a skill or back(0 - back): ");
                        skillChoice = input.nextInt();
                        Displays.clear();
                        if (skillChoice == 0) {
                            return result;
                        }else if(skillChoice > 5){
                            System.out.println("Invalid input, 1-5 only");
                            continue;
                        }
                        switch (skillChoice) {
                            case 1:
                                result = Knight.useSlash();
                                damage = result.getDamage();
                                heal = result.getHeal();
                                System.out.println("Knight used Slash - deals 60 damage");
                                break;
                            case 2:
                                result = Knight.useSweep();
                                damage = result.getDamage();
                                heal = result.getHeal();
                                System.out.println("Knight used Sweep, deals " + damage + " damage");
                                break;
                            case 3:
                                result = Knight.useHolyShield();
                                int defense = result.getDefense();
                                System.out.println("Knight used Holy Shield - grants " + defense + " defense");
                                break;
                            case 4:
                                if (knight >= 3) {
                                    result = Knight.useExcalibur();
                                    damage = result.getDamage();
                                    defense = result.getDefense();
                                    knight = 0;
                                } else {
                                    System.out.println("Ultimate charge not ready, need " + (3 - knight) + " turns");
                                    Displays.clear();
                                    continue;
                                }
                                break;
                            default:
                        }
                    } catch (InputMismatchException e) {
                        Displays.clear();
                        System.out.println("Invalid input. Please enter a valid number.");
                        input.nextLine();
                        continue;
                    }
                    break;
                }
                }else{
                    System.out.println("The chosen hero is down, choose another");
                    return new SkillResults(0, 0, 0, 0);
                }

            knight+=1;
        } else if (heroes[who - 1].getName().equals("Assassin")) {
            if(heroes[who - 1].getHealth() > 0){
                Displays.clear();
            System.out.println("Assassin's skills:");
            System.out.println("Skill 1: Back Stab - deals 70 damage with the chance of critical hit");
            System.out.println("Skill 2: Swift Dagger - deals 50-100 damage");
            System.out.println("Skill 3: Cloak - Avoid one attack");
            if(assassin >= 3){
                System.out.println("Ultimate 4: Assassin's Mark - deals 90 damage with the higher chance of critical hit. Available!");
            }else{
                System.out.println("Ultimate 4: Assassin's Mark - deals 90 damage with the higher chance of critical hit. Required " + (3-assassin) + " Assassin uses to use");
            }
                Displays.clear();
            try{
            System.out.print("Choose a skill or back(0 - back): ");
            skillChoice = input.nextInt();
            Displays.clear();
            if (skillChoice == 0) {
                return new SkillResults(0,0,0,0);
            }else if(skillChoice > 5){
                System.out.println("Invalid input, 1-5 only");
                continue;
            }
            switch (skillChoice) {
                case 1:
                    result = Assassin.useBackStab();
                    damage = result.getDamage();
                    heal = result.getHeal();
                    System.out.println("Assassin used back stab, deals " + damage + " damage");
                    break;
                case 2:
                    result = Assassin.useSwiftDagger();
                    damage = result.getDamage();
                    heal = result.getHeal();
                    System.out.println("Assassin used swift dagger, deals " + damage + " damage");
                    break;
                case 3:
                    result = Assassin.useCloak();
                    int defense = result.getDefense();
                    System.out.println("Assassin used Cloak - grants " + defense + " defense");
                    break;
                case 4:
                    if(assassin >= 3) {
                        result = Assassin.useAssassinsMark();
                        damage = result.getDamage();
                        heal = result.getHeal();
                        System.out.println("Assassin used Assassin's Mark, deals " + damage + " damage");
                        assassin = 0;
                    }else {
                    System.out.println("Ultimate charge not ready, need " + (3 - assassin) + " turns");
                    Displays.clear();
                    continue;
            }
                    break;
                default:
            }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();
                continue;
            }
        }else{
            System.out.println("The chosen hero is down, choose another");
            return new SkillResults(0,0,0,0);
        }
            assassin+=1;
        } else if (heroes[who - 1].getName().equals("Warrior")) {
            if(heroes[who - 1].getHealth() > 0){
                Displays.clear();
            System.out.println("Warrior's skills:");
            System.out.println("Skill 1: Cleave - deals 60 damage and heal 10 to self");
            System.out.println("Skill 2: Meditate - heals 40 and 30 defense");
            System.out.println("Skill 3: Iron defense - reduced next incoming damage by 50%");
            if(warrior >=2){
                System.out.println("Ultimate 4: ThunderStomp - deals 80 damage and heal self 30% of the damage dealt. Available!");
            }else{
                System.out.println("Ultimate 4: ThunderStomp - deals 80 damage and heal self 30% of the damage dealt. Requires " +(2-warrior)+ " Warrior uses to use");
            }
                Displays.clear();
            try{
            System.out.print("Choose a skill or back(0 - back): ");
            skillChoice = input.nextInt();
            Displays.clear();
            if (skillChoice == 0) {
                return new SkillResults(0,0,0,0);
            }else if(skillChoice > 5){
                System.out.println("Invalid input, 1-5 only");
                continue;
            }
            switch (skillChoice) {
                case 1:
                    result = Warrior.useCleave();
                    damage = result.getDamage();
                    heal = result.getHeal();
                    System.out.println("Warrior used cleave, deals " + damage + " damage and heals " + heal + " to self");
                    break;
                case 2:
                    result = Warrior.useMeditate();
                    damage = result.getDamage();
                    heal = result.getHeal();
                    System.out.println("Warrior used meditate, heals " + heal + " to self");
                    break;
                case 3:
                    result = Warrior.useIronDefense();
                    int defense = result.getDefense();
                    System.out.println("Warrior used Iron Defense - reduces the next incoming damage by " + defense + "%");
                    break;
                case 4:
                    if(warrior >= 2) {
                        result = Warrior.useThunderStomp();
                        damage = result.getDamage();
                        heal = result.getHeal();
                        System.out.println("Warrior used thunder stomp, deals " + damage + " damage and heals " + heal + " to self");
                        warrior =0;
                    } else {
                        System.out.println("Ultimate charge not ready, need " + (2 - warrior) + " turns");
                        Displays.clear();
                        continue;
                    }
                    break;
                default:
            }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();
                continue;
            }
            }else{
                System.out.println("The chosen hero is down, choose another");
                return new SkillResults(0,0,0,0);
            }
            warrior+=1;
        } else if (heroes[who - 1].getName().equals("Wizard")) {
            if(heroes[who - 1].getHealth() > 0){
                Displays.clear();
            System.out.println("Wizard's skills:");
            System.out.println("Skill 1: Fireball - deals 70 damage");
            System.out.println("Skill 2: IceShards - deals 30 - 100 damage and chance to stun");
            System.out.println("Skill 3: Slicing wind - deals 60 - 80 damage");
            if(wizard >= 2){
                System.out.println("Ultimate 4: Dark Magic - deals 100 damage and stuns. Available!");
            }else{
                System.out.println("Ultimate 4: Dark Magic - deals 100 damage and stuns. Required " + (2-wizard) + " Wizard uses to use");
            }
                Displays.clear();
            try{
            System.out.print("Choose a skill or back(0 - back): ");
            skillChoice = input.nextInt();
            Displays.clear();
            if (skillChoice == 0) {
                return new SkillResults(0,0,0,0);
            }else if(skillChoice > 5){
                System.out.println("Invalid input, 1-5 only");
                continue;
            }
            switch (skillChoice) {
                case 1:
                    result = Wizard.useFireball();
                    damage = result.getDamage();
                    heal = result.getHeal();
                    System.out.println("Wizard used fireball, deals " + damage + " damage");
                    break;
                case 2:
                    result = Wizard.useIceShards();
                    damage = result.getDamage();
                    heal = result.getHeal();
                    System.out.println("Wizard used ice shards, deals " + damage + "damage and 20% chance to stun");
                    break;
                case 3:
                    result = Wizard.useSlicingWind();
                    damage = result.getDamage();
                    System.out.println("Wizard used Slicing Wind - deals " + damage + " damage");
                    break;
                case 4:
                    if(wizard >= 2){
                        result = Wizard.useDarkMagic();
                        damage = result.getDamage();
                        System.out.println("Wizard used dark magic, deals " + damage + " and stuns");
                        wizard =0;
                    } else {
                        System.out.println("Ultimate charge not ready, need " + (2 - wizard) + " turns");
                        Displays.clear();
                        continue;
                    }
                    break;
                default:
            }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();
                continue;
            }
            }else{
                System.out.println("The chosen hero is down, choose another");
                return new SkillResults(0,0,0,0);
            }
            wizard+=1;
        } else if (heroes[who - 1].getName().equals("Priest")) {
            if(heroes[who -1].getHealth() > 0){
                Displays.clear();
            System.out.println("Priest's skills:");
            System.out.println("Skill 1: Heal - heals 60 the front most living hero");
            System.out.println("Skill 2: Holy Blessing - gives 30 defense and heal the front most living hero");
            System.out.println("Skill 3: Rain of Destiny - deals 30-60 and heals 30-60 the front most living hero");
            if(priest >= 4){
                System.out.println("Ultimate 4: Renascence: Revive a fallen ally in the front most with 200 hp. Available!");
            }else{
                System.out.println("Ultimate 4: Renascence: Revive a fallen ally in the front most with 200 hp. Required " + (4-priest) + " Priest uses to use");
            }
                Displays.clear();
            try{
            System.out.print("Choose a skill or back(0 - back): ");
            skillChoice = input.nextInt();
            Displays.clear();
            if (skillChoice == 0) {
                return new SkillResults(0,0,0,0);
            }else if(skillChoice > 5){
                System.out.println("Invalid input, 1-5 only");
                continue;
            }
            switch (skillChoice) {
                case 1:
                    result = Priest.useHeal();
                    heal = result.getHeal();
                    System.out.println("Priest used Heal - heals " + heal + " the front most living hero");
                    break;
                case 2:
                    result = Priest.useHolyBlessing();
                    int defense = result.getDefense();
                    heal = result.getHeal();
                    System.out.println("Priest used Holy Blessing - gives " + defense + " defense and heals " + heal + " the front most living hero");
                    break;
                case 3:
                    result = Priest.useRainofDestiny();
                    damage = result.getDamage();
                    heal = result.getHeal();
                    System.out.println("Priest used Rain of Destiny - deals " + damage + " damage and heals " + heal + " the front most living hero");
                    break;
                case 4:
                    if (priest >= 4) {
                        result = Priest.useRenascence();
                        priest=0;
                    } else {
                        System.out.println("Ultimate charge not ready, need " + (4 - priest) + " turns");
                        Displays.clear();
                        continue;
                    }
                    break;
                default:
            }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();
                continue;
            }
            }else{
                System.out.println("The chosen hero is down, choose another");
                return new SkillResults(0,0,0,0);
            }
            priest+=1;
        }
        break;
    }
    return result;
    }

    public class Knight extends Hero {
    public static SkillResults useSlash() {
        int damage = 60;
        return new SkillResults(damage, 0, 0, 0);
    }

    public static SkillResults useSweep() {
        int damage = rando.nextInt(41) + 40;
        return new SkillResults(damage, 0, 0, 0);
    }
    public static SkillResults useHolyShield(){
        int defense = 40;
        return new SkillResults(0, 0, defense, 0);
    }

    public static SkillResults useExcalibur() {
    int damage = 100;
    int defense = 20;
    return new SkillResults(damage, 0, defense, 0);
}
}
    public class Assassin extends Hero {
        public static SkillResults useBackStab() {
            random = rando.nextInt(100)+1;
            if(random <= 20){
                damage = (int) (70 + (.5 * 70));
            }else{
                damage = 70;
            }
            return new SkillResults(damage, 0, 0, 0);
        }

        public static SkillResults useSwiftDagger() {
            damage = rando.nextInt(51)+50;
            return new SkillResults(damage, 0, 0, 0);
        }
        public static SkillResults useCloak(){
            int defense = 100;
            return new  SkillResults(0, 0, defense, 0);
        }
        public static SkillResults useAssassinsMark() {
            random = rando.nextInt(100) + 1;
            if(random <=40){
                damage = 180;
            }else {
                damage = 90;
            }
            return new SkillResults(damage, 0, 0, 0);
        }
    }
    public class Warrior extends Hero {
        public static SkillResults useCleave() {
            int damage = 60;
            int heal = 10;
            return new SkillResults(damage, heal, 0, 0);
        }

        public static SkillResults useMeditate() {
            int heal = 40;
            int defense = 30;
            return new SkillResults(0, heal, defense, 0);
        }

        public static SkillResults useIronDefense() {
            int defense = 50;
            return new SkillResults(0, 0, defense, 0);
        }

        public static SkillResults useThunderStomp() {
            int damage = 80;
            int heal = (int) (0.3 * damage);
            return new SkillResults(damage, heal, 0, 0);
        }
    }
    public class Wizard extends Hero {
        public static SkillResults useFireball() {
            int damage = 70;
            return new SkillResults(damage, 0, 0, 0);
        }

        public static SkillResults useIceShards() {
            int damage = rando.nextInt(71) + 30;
            int random = rando.nextInt(100)+ 1;
            int stun = 0;
            if(random<=20){
                stun = 1;
                System.out.println("Stun Triggered!");
            }
            return new SkillResults(damage, 0, 0, stun);
        }
        public static SkillResults useSlicingWind(){
            int damage = rando.nextInt(40)+60;
            return new SkillResults(damage, 0, 0, 0);
        }

        public static SkillResults useDarkMagic() {
            int damage = 100;
            int stun = 1;
            return new SkillResults(damage, 0, 0, stun);
        }
    }
    public class Priest extends Hero {
        public static SkillResults useHeal() {
            int heal = 60;
            return new SkillResults(0, heal, 0, 0);
        }

        public static SkillResults useHolyBlessing() {
            int defense = 30;
            int heal = 30;
            return new SkillResults(0, heal, defense, 0);
        }

        public static SkillResults useRainofDestiny(){
            int damage = rando.nextInt(30)+30;
            int heal = rando.nextInt(30)+30;
            return new SkillResults(damage, heal, 0, 0);
        }

        public static SkillResults useRenascence() {
            // Implement Ultimate logic
            return new SkillResults(0, 1000, 0,0);
        }
    }
    }