import java.util.*;
public class Game {
    static Scanner input = new Scanner(System.in);
    static Random rando = new Random();
    Hero heroes = new Hero();
    Enemy enemies = new Enemy();
    public static int death = 0;
    Displays displays = new Displays();
    public static int getDeath(){
        return death;
    }

    public static int levelOne(Hero[] heroes, Enemy[] enemy) {
        int i, who;
        int energy = 0, enemyEnergy = 0, stun = 0, enemyStun = 0;
        SkillResults result = new SkillResults(0, 0, 0, 0);
        while (true) {
            try {
                energy += 3; //add energy
                while ((energy != 0) && (enemy[enemy.length - 1].getHealth() > 0) && heroes[4].getHealth() > 0) {  //player turn
                    if (enemyStun > 0) {
                        energy -= enemyStun;
                        System.out.println("Player's Turn! Energy: (" + energy + ") Energy reduced due to enemy stun");
                        enemyStun = 0;
                    } else {
                        System.out.println("Player's Turn! Energy: (" + energy + ")");
                    }
                    Displays.clear();
                    do {
                        Displays.displayHeroes(heroes, enemy);
                        System.out.print("Who will move? (0 - for skip and save energy): ");
                        who = input.nextInt();
                        if (who == 0) {
                            break;
                        } else {
                            if (who > 5) {
                                Displays.clear();
                                System.out.println("Invalid number, 1-5 Only");
                                Displays.clear();
                                continue;
                            }
                        }
                        result = Hero.heroSkills(heroes, who);
                        stun += result.getStun();
                    } while (result.getHeal() == 0 && result.getDamage() == 0 && result.getDefense() == 0 && result.getStun() == 0);
                    if (who == 0) {
                        break;
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //heal
                        if(result.getHeal() == 1000){ //revive
                            if(heroes[i].getHealth() <= 0){
                                heroes[i].setHealth(200);
                                break;
                            }else{
                                continue;
                            }
                        }
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setHealth((heroes[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < enemy.length; i++) { //damage to enemies
                        if (enemy[i].getHealth() > 0) {
                            if (enemy[i].getDefense() > 0) {
                                enemy[i].setHealth((int) (enemy[i].getHealth() - (result.getDamage() * (enemy[i].getDefense() / 100.0))));
                            } else {
                                enemy[i].setHealth((enemy[i].getHealth() - result.getDamage()));

                            }
                            enemy[i].setDefense(0);
                            break;
                        }
                    }
                    Displays.clear();
                    energy -= 1;
                }
                Displays.displayHeroes(heroes, enemy);
                System.out.println("Enemy's Turn!");
                enemyEnergy += 3; //add energy

                while ((enemyEnergy != 0) && (heroes[heroes.length - 1].getHealth() > 0) && enemy[enemy.length - 1].getHealth() > 0) {
                    if (stun > 0) {
                        enemyEnergy -= stun;
                        stun = 0;
                        System.out.println("Enemy energy reduced because of stun");
                    }//Enemy Turn
                    result = Enemy.levelOne(enemy);
                    for (i = 0; i < enemy.length; i++) { //heal
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setHealth((enemy[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //damage to enemies
                        if (heroes[i].getHealth() > 0) {
                            if (heroes[i].getDefense() > 0) {
                                heroes[i].setHealth((int) (heroes[i].getHealth() - (result.getDamage() * (heroes[i].getDefense() / 100.0))));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            } else {
                                heroes[i].setHealth((heroes[i].getHealth() - result.getDamage()));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            }
                            heroes[i].setDefense(0);
                            break;
                        }
                    }
                    enemyEnergy -= 1;
                }
                Displays.clear();
                if (heroes[4].getHealth() <= 0) { //Winner Checker
                    System.out.println("The heroes were defeated");
                    return -1;
                } else if (enemy[enemy.length - 1].getHealth() <= 0) {
                    System.out.println("You won!");
                    return 1;
                } else {
                    continue;
                }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Please enter a valid number.");
                Displays.clear();
                energy -= 3;
                input.next();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int levelTwo(Hero[] heroes, Enemy[] enemy) {
        int i, who;
        int energy = 0, enemyEnergy = 0, stun = 0, enemyStun = 0;
        SkillResults result = new SkillResults(0, 0, 0, 0);
        while (true) {
            try {
                energy += 3; //add energy
                while ((energy != 0) && (enemy[enemy.length - 1].getHealth() > 0) && heroes[4].getHealth() > 0) {  //player turn
                    if (enemyStun > 0) {
                        energy -= enemyStun;
                        System.out.println("Player's Turn! Energy: (" + energy + ") Energy reduced due to enemy stun");
                        enemyStun = 0;
                    } else {
                        System.out.println("Player's Turn! Energy: (" + energy + ")");
                    }
                    Displays.clear();
                    do {
                        Displays.displayHeroes(heroes, enemy);
                        System.out.print("Who will move? (0 - for skip and save energy): ");
                        who = input.nextInt();
                        if (who == 0) {
                            break;
                        } else {
                            if (who > 5) {
                                Displays.clear();
                                System.out.println("Invalid number, 1-5 Only");
                                Displays.clear();
                                continue;
                            }
                        }
                        result = Hero.heroSkills(heroes, who);
                        stun += result.getStun();
                    } while (result.getHeal() == 0 && result.getDamage() == 0 && result.getDefense() == 0 && result.getStun() == 0);
                    if (who == 0) {
                        break;
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //heal
                        if(result.getHeal() == 1000){ //revive
                            if(heroes[i].getHealth() <= 0){
                                heroes[i].setHealth(200);

                                break;
                            }else{
                                continue;
                            }
                        }
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setHealth((heroes[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < enemy.length; i++) { //damage to enemies
                        if (enemy[i].getHealth() > 0) {
                            if (enemy[i].getDefense() > 0) {
                                enemy[i].setHealth((int) (enemy[i].getHealth() - (result.getDamage() * (enemy[i].getDefense() / 100.0))));
                            } else {
                                enemy[i].setHealth((enemy[i].getHealth() - result.getDamage()));
                            }
                            enemy[i].setDefense(0);
                            break;
                        }
                    }
                    Displays.clear();
                    energy -= 1;
                }
                Displays.displayHeroes(heroes, enemy);
                System.out.println("Enemy's Turn!");
                enemyEnergy += 3; //add energy

                while ((enemyEnergy != 0) && (heroes[heroes.length - 1].getHealth() > 0) && enemy[enemy.length - 1].getHealth() > 0) {
                    if (stun > 0) {
                        enemyEnergy -= stun;
                        stun = 0;
                        System.out.println("Enemy energy reduced because of stun");
                    }//Enemy Turn
                    result = Enemy.levelTwo(enemy);
                    enemyStun += result.getStun();
                    for (i = 0; i < enemy.length; i++) { //heal
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setHealth((enemy[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //damage to enemies
                        if (heroes[i].getHealth() > 0) {
                            if (heroes[i].getDefense() > 0) {
                                heroes[i].setHealth((int) (heroes[i].getHealth() - (result.getDamage() * (heroes[i].getDefense() / 100.0))));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            } else {
                                heroes[i].setHealth((heroes[i].getHealth() - result.getDamage()));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            }
                            heroes[i].setDefense(0);
                            break;
                        }
                    }
                    enemyEnergy -= 1;
                }
                Displays.clear();
                if (heroes[4].getHealth() <= 0) { //Winner Checker
                    System.out.println("The heroes were defeated");
                    return -1;
                } else if (enemy[enemy.length - 1].getHealth() <= 0) {
                    System.out.println("You won!");
                    return 1;
                } else {
                    continue;
                }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Please enter a valid number.");
                Displays.clear();
                energy -= 3;
                input.next();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int levelThree(Hero[] heroes, Enemy[] enemy) {
        int i, who;
        int energy = 0, enemyEnergy = 0, stun = 0, enemyStun = 0;
        SkillResults result = new SkillResults(0, 0, 0, 0);
        while (true) {
            try {
                energy += 3; //add energy
                while ((energy != 0) && (enemy[enemy.length - 1].getHealth() > 0) && heroes[4].getHealth() > 0) {  //player turn
                    if (enemyStun > 0) {
                        energy -= enemyStun;
                        System.out.println("Player's Turn! Energy: (" + energy + ") Energy reduced due to enemy stun");
                        enemyStun = 0;
                    } else {
                        System.out.println("Player's Turn! Energy: (" + energy + ")");
                    }
                    Displays.clear();
                    do {
                        Displays.displayHeroes(heroes, enemy);
                        System.out.print("Who will move? (0 - for skip and save energy): ");
                        who = input.nextInt();
                        if (who == 0) {
                            break;
                        } else {
                            if (who > 5) {
                                Displays.clear();
                                System.out.println("Invalid number, 1-5 Only");
                                Displays.clear();
                                continue;
                            }
                        }
                        result = Hero.heroSkills(heroes, who);
                        stun += result.getStun();
                    } while (result.getHeal() == 0 && result.getDamage() == 0 && result.getDefense() == 0 && result.getStun() == 0);
                    if (who == 0) {
                        break;
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //heal
                        if(result.getHeal() == 1000){ //revive
                            if(heroes[i].getHealth() <= 0){
                                heroes[i].setHealth(200);
                                break;
                            }else{
                                continue;
                            }
                        }
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setHealth((heroes[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < enemy.length; i++) { //damage to enemies
                        if (enemy[i].getHealth() > 0) {
                            if (enemy[i].getDefense() > 0) {
                                enemy[i].setHealth((int) (enemy[i].getHealth() - (result.getDamage() * (enemy[i].getDefense() / 100.0))));
                            } else {
                                enemy[i].setHealth((enemy[i].getHealth() - result.getDamage()));
                            }
                            enemy[i].setDefense(0);
                            break;
                        }
                    }
                    Displays.clear();
                    energy -= 1;
                }
                Displays.displayHeroes(heroes, enemy);
                System.out.println("Enemy's Turn!");
                enemyEnergy += 3; //add energy

                while ((enemyEnergy != 0) && (heroes[heroes.length - 1].getHealth() > 0) && enemy[enemy.length - 1].getHealth() > 0) {
                    if (stun > 0) {
                        enemyEnergy -= stun;
                        stun = 0;
                        System.out.println("Enemy energy reduced because of stun");
                    }//Enemy Turn
                    result = Enemy.levelThree(enemy);
                    enemyStun += result.getStun();
                    for (i = 0; i < 5; i++) {//defense
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //damage to enemies
                        if (heroes[i].getHealth() > 0) {
                            if (heroes[i].getDefense() > 0) {
                                heroes[i].setHealth((int) (heroes[i].getHealth() - (result.getDamage() * (heroes[i].getDefense() / 100.0))));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            } else {
                                heroes[i].setHealth((heroes[i].getHealth() - result.getDamage()));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            }
                            heroes[i].setDefense(0);
                            break;
                        }
                    }
                    enemyEnergy -= 1;
                }
                Displays.clear();
                if (heroes[4].getHealth() <= 0) { //Winner Checker
                    System.out.println("The heroes were defeated");
                    return -1;
                } else if (enemy[enemy.length - 1].getHealth() <= 0) {
                    System.out.println("You won!");
                    return 1;
                } else {
                    continue;
                }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Please enter a valid number.");
                Displays.clear();
                energy -= 3;
                input.next();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int levelFour(Hero[] heroes, Enemy[] enemy) {
        int i, who;
        int energy = 0, enemyEnergy = 0, stun = 0, enemyStun = 0;
        SkillResults result = new SkillResults(0, 0, 0, 0);
        while (true) {
            try {
                energy += 3; //add energy
                while ((energy != 0) && (enemy[enemy.length - 1].getHealth() > 0) && heroes[4].getHealth() > 0) {  //player turn
                    if (enemyStun > 0) {
                        energy -= enemyStun;
                        System.out.println("Player's Turn! Energy: (" + energy + ") Energy reduced due to enemy stun");
                        enemyStun = 0;
                    } else {
                        System.out.println("Player's Turn! Energy: (" + energy + ")");
                    }
                    Displays.clear();
                    do {
                        Displays.displayHeroes(heroes, enemy);
                        System.out.print("Who will move? (0 - for skip and save energy): ");
                        who = input.nextInt();
                        if (who == 0) {
                            break;
                        } else {
                            if (who > 5) {
                                Displays.clear();
                                System.out.println("Invalid number, 1-5 Only");
                                Displays.clear();
                                continue;
                            }
                        }
                        result = Hero.heroSkills(heroes, who);
                        stun += result.getStun();
                    } while (result.getHeal() == 0 && result.getDamage() == 0 && result.getDefense() == 0 && result.getStun() == 0);
                    if (who == 0) {
                        break;
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //heal
                        if(result.getHeal() == 1000){ //revive
                            if(heroes[i].getHealth() <= 0){
                                heroes[i].setHealth(200);
                                break;
                            }else{
                                continue;
                            }
                        }
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setHealth((heroes[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < enemy.length; i++) { //damage to enemies
                        if (enemy[i].getHealth() > 0) {
                            if (enemy[i].getDefense() > 0) {
                                enemy[i].setHealth((int) (enemy[i].getHealth() - (result.getDamage() * (enemy[i].getDefense() / 100.0))));
                            } else {
                                enemy[i].setHealth((enemy[i].getHealth() - result.getDamage()));
                            }
                            enemy[i].setDefense(0);
                            break;
                        }
                    }
                    Displays.clear();
                    energy -= 1;
                }
                Displays.displayHeroes(heroes, enemy);
                System.out.println("Enemy's Turn!");
                enemyEnergy += 3; //add energy

                while ((enemyEnergy != 0) && (heroes[heroes.length - 1].getHealth() > 0) && enemy[enemy.length - 1].getHealth() > 0) {
                    if (stun > 0) {
                        enemyEnergy -= stun;
                        stun = 0;
                        System.out.println("Enemy energy reduced because of stun");
                    }//Enemy Turn
                    result = Enemy.levelFour(enemy);
                    enemyStun += result.getStun();
                    for (i = 0; i < enemy.length; i++) { //heal
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setHealth((enemy[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //damage to enemies
                        if (heroes[i].getHealth() > 0) {
                            if (heroes[i].getDefense() > 0) {
                                heroes[i].setHealth((int) (heroes[i].getHealth() - (result.getDamage() * (heroes[i].getDefense() / 100.0))));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            } else {
                                heroes[i].setHealth((heroes[i].getHealth() - result.getDamage()));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            }
                            heroes[i].setDefense(0);
                            break;
                        }
                    }
                    enemyEnergy -= 1;
                }
                Displays.clear();
                if (heroes[4].getHealth() <= 0) { //Winner Checker
                    System.out.println("The heroes were defeated");
                    return -1;
                } else if (enemy[enemy.length - 1].getHealth() <= 0) {
                    System.out.println("You won!");
                    return 1;
                } else {
                    continue;
                }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Please enter a valid number.");
                Displays.clear();
                energy -= 3;
                input.next();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int levelFive(Hero[] heroes, Enemy[] enemy) {
        int i, who;
        int energy = 0, enemyEnergy = 0, stun = 0, enemyStun = 0;
        SkillResults result = new SkillResults(0, 0, 0, 0);
        while (true) {
            try {
                energy += 3; //add energy
                while ((energy != 0) && (enemy[enemy.length - 1].getHealth() > 0) && heroes[4].getHealth() > 0) {  //player turn
                    if (enemyStun > 0) {
                        energy -= enemyStun;
                        System.out.println("Player's Turn! Energy: (" + energy + ") Energy reduced due to enemy stun");
                        enemyStun = 0;
                    } else {
                        System.out.println("Player's Turn! Energy: (" + energy + ")");
                    }
                    Displays.clear();
                    do {
                        Displays.displayHeroes(heroes, enemy);
                        System.out.print("Who will move? (0 - for skip and save energy): ");
                        who = input.nextInt();
                        if (who == 0) {
                            break;
                        } else {
                            if (who > 5) {
                                Displays.clear();
                                System.out.println("Invalid number, 1-5 Only");
                                Displays.clear();
                                continue;
                            }
                        }
                        result = Hero.heroSkills(heroes, who);
                        stun += result.getStun();
                    } while (result.getHeal() == 0 && result.getDamage() == 0 && result.getDefense() == 0 && result.getStun() == 0);
                    if (who == 0) {
                        break;
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //heal
                        if(result.getHeal() == 1000){ //revive
                            if(heroes[i].getHealth() <= 0){
                                heroes[i].setHealth(200);
                                break;
                            }else{
                                continue;
                            }
                        }
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setHealth((heroes[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < enemy.length; i++) { //damage to enemies
                        if (enemy[i].getHealth() > 0) {
                            if (enemy[i].getDefense() > 0) {
                                enemy[i].setHealth((int) (enemy[i].getHealth() - (result.getDamage() * (enemy[i].getDefense() / 100.0))));
                            } else {
                                enemy[i].setHealth((enemy[i].getHealth() - result.getDamage()));
                            }
                            enemy[i].setDefense(0);
                            break;
                        }
                    }
                    Displays.clear();
                    energy -= 1;
                }
                Displays.displayHeroes(heroes, enemy);
                System.out.println("Enemy's Turn!");
                enemyEnergy += 3; //add energy

                while ((enemyEnergy != 0) && (heroes[heroes.length - 1].getHealth() > 0) && enemy[enemy.length - 1].getHealth() > 0) {
                    if (stun > 0) {
                        enemyEnergy -= stun;
                        stun = 0;
                        System.out.println("Enemy energy reduced because of stun");
                    }//Enemy Turn
                    result = Enemy.levelFive(enemy);
                    enemyStun += result.getStun();
                    for (i = 0; i < enemy.length; i++) { //heal
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setHealth((enemy[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) {//defense
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 5; i++) { //damage to enemies
                        if (heroes[i].getHealth() > 0) {
                            if (heroes[i].getDefense() > 0) {
                                heroes[i].setHealth((int) (heroes[i].getHealth() - (result.getDamage() * (heroes[i].getDefense() / 100.0))));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            } else {
                                heroes[i].setHealth((heroes[i].getHealth() - result.getDamage()));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            }
                            heroes[i].setDefense(0);
                            break;
                        }
                    }
                    enemyEnergy -= 1;
                }
                Displays.clear();
                if (heroes[4].getHealth() <= 0) { //Winner Checker
                    System.out.println("The heroes were defeated");
                    return -1;
                } else if (enemy[enemy.length - 1].getHealth() <= 0) {
                    System.out.println("You won!");
                    return 1;
                } else {
                    continue;
                }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Please enter a valid number.");
                Displays.clear();
                energy -= 3;
                input.next();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int levelSix(Hero[] heroes, Enemy[] enemy) {
        int i, who;
        int energy = 0, enemyEnergy = 0, stun = 0, enemyStun = 0;
        SkillResults result = new SkillResults(0, 0, 0, 0);
        while (true) {
            try {
                energy += 3; //add energy
                while ((energy != 0) && (enemy[enemy.length - 1].getHealth() > 0) && heroes[3].getHealth() > 0) {  //player turn
                    if (enemyStun > 0) {
                        energy -= enemyStun;
                        System.out.println("Player's Turn! Energy: (" + energy + ") Energy reduced due to enemy stun");
                        enemyStun = 0;
                    } else {
                        System.out.println("Player's Turn! Energy: (" + energy + ")");
                    }
                    Displays.clear();
                    do {
                        Displays.displayHeroes(heroes, enemy);
                        System.out.print("Who will move? (0 - for skip and save energy): ");
                        who = input.nextInt();
                        if (who == 0) {
                            break;
                        }else {
                            if (who > 4) {
                                System.out.println("Invalid number, 1-4 Only");
                                Displays.clear();
                                continue;
                            }
                        }
                        result = Hero.heroSkills(heroes, who);
                        stun += result.getStun();
                    } while (result.getHeal() == 0 && result.getDamage() == 0 && result.getDefense() == 0 && result.getStun() == 0);
                    if (who == 0) {
                        break;
                    }
                    for (i = 0; i < 4; i++) {//defense
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 4; i++) { //heal
                        if(result.getHeal() == 1000){ //revive
                            if(heroes[i].getHealth() <= 0){
                                heroes[i].setHealth(200);
                                break;
                            }else{
                                continue;
                            }
                        }
                        if (heroes[i].getHealth() > 0) {
                            heroes[i].setHealth((heroes[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < enemy.length; i++) { //damage to enemies
                        if (enemy[i].getHealth() > 0) {
                            if (enemy[i].getDefense() > 0) {
                                enemy[i].setHealth((int) (enemy[i].getHealth() - (result.getDamage() * (enemy[i].getDefense() / 100.0))));
                            } else {
                                enemy[i].setHealth((enemy[i].getHealth() - result.getDamage()));
                            }
                            enemy[i].setDefense(0);
                            break;
                        }
                    }
                    Displays.clear();
                    energy -= 1;
                }
                Displays.displayHeroes(heroes, enemy);
                System.out.println("Enemy's Turn!");
                enemyEnergy += 3; //add energy

                while ((enemyEnergy != 0) && (heroes[heroes.length - 1].getHealth() > 0) && enemy[enemy.length - 1].getHealth() > 0) {
                    if (stun > 0) {
                        enemyEnergy -= stun;
                        stun = 0;
                        System.out.println("Enemy energy reduced because of stun");
                    }//Enemy Turn
                    result = Enemy.levelSix(enemy);
                    enemyStun += result.getStun();
                    for (i = 0; i < enemy.length; i++) { //heal
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setHealth((enemy[i].getHealth() + result.getHeal()));
                            break;
                        }
                    }
                    for (i = 0; i < 4; i++) {//defense
                        if (enemy[i].getHealth() > 0) {
                            enemy[i].setDefense(result.getDefense());
                            break;
                        }
                    }
                    for (i = 0; i < 4; i++) { //damage to enemies
                        if (heroes[i].getHealth() > 0) {
                            if (heroes[i].getDefense() > 0) {
                                heroes[i].setHealth((int) (heroes[i].getHealth() - (result.getDamage() * (heroes[i].getDefense() / 100.0))));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            } else {
                                heroes[i].setHealth((heroes[i].getHealth() - result.getDamage()));
                                if(heroes[i].getHealth() <= 0){
                                    death++;
                                }
                            }
                            heroes[i].setDefense(0);
                            break;
                        }
                    }
                    enemyEnergy -= 1;
                }
                Displays.clear();
                if (heroes[3].getHealth() <= 0) { //Winner Checker
                    System.out.println("The heroes were defeated");
                    return -1;
                } else if (enemy[enemy.length - 1].getHealth() <= 0) {
                    System.out.println("You won!");
                    return 1;
                } else {
                    continue;
                }
            } catch (InputMismatchException e) {
                Displays.clear();
                System.out.println("Please enter a valid number.");
                Displays.clear();
                energy -= 3;
                input.next();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
