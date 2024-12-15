import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Displays displays = new Displays();
        Hero[] heroes = new Hero[5];
        Hero hero = new Hero();
        Enemy enemy = new Enemy();
        Enemy[] enemiesOne = new Enemy[1];
        Enemy[] enemiesTwo = new Enemy[3];
        Enemy[] enemiesThree = new Enemy[3];
        Enemy[] enemiesFour = new Enemy[5];
        Enemy[] enemiesFive = new Enemy[1];
        Enemy[] enemiesSix = new Enemy[1];
        int choices, i, ctr1 = 0, ctr2 = 0, ctr3 = 0, ctr4 = 0, ctr5 = 0, tryAgain;
        int menuChoice;
        String name = "";
        do {
            try {
                System.out.println("Welcome to Ruined light!");
                System.out.println("1. Start adventure");
                System.out.println("2. Leaderboard");
                System.out.println("3. Characters");
                System.out.println("4. About/Glossary");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                menuChoice = input.nextInt();
                Displays.clear();
            }catch(InputMismatchException e){
                Displays.clear();
                System.out.println("Invalid input. 1-5 only");
                input.nextLine();
                Displays.clear();
                continue;
            }
            switch (menuChoice) {
                case 1:
                    input.nextLine();
                    while(true) {
                        System.out.println("Mechanics: the player will receive 3 energy per turn to use on skills, can skip to save energy and burst enemies.");
                        System.out.println("Using all energies during the turn will automatically skip your turn.");
                        System.out.println("Remember: Enemy stuns reduces your energy next turn!");
                        System.out.print("Enter the player name: ");
                        name = input.nextLine().trim();
                        if (name.isEmpty()) {
                            System.out.println("Please enter a non-empty name.");
                            continue;
                        }else{
                            break;
                        }
                    }
                    Player player = new Player(name);
                    Displays.clear();
                    for (i = 0; i < 5; i++) {
                        heroes[i] = new Hero(null, 0);
                    }
                    for (i = 0; i < 5; i++) {
                        try {
                            System.out.println("Choose the hero in the front (1 - front, 5 - back).");
                            displays.characterChoices();
                            System.out.print("Position " + (i + 1) + ": ");
                            choices = input.nextInt();
                            switch (choices) {
                                case 1:
                                    if (ctr1 != 0) {
                                        System.out.println("You already choose Knight, pick another ");
                                        i--;
                                        continue;
                                    }
                                    ctr1++;
                                    break;
                                case 2:
                                    if (ctr2 != 0) {
                                        System.out.println("You already choose Assassin, pick another ");
                                        i--;
                                        continue;
                                    }
                                    ctr2++;
                                    break;
                                case 3:
                                    if (ctr3 != 0) {
                                        System.out.println("You already choose Warrior, pick another ");
                                        i--;
                                        continue;
                                    }
                                    ctr3++;
                                    break;
                                case 4:
                                    if (ctr4 != 0) {
                                        System.out.println("You already choose Wizard, pick another ");
                                        i--;
                                        continue;
                                    }
                                    ctr4++;
                                    break;
                                case 5:
                                    if (ctr5 != 0) {
                                        System.out.println("You already choose Priest, pick another ");
                                        i--;
                                        continue;
                                    }
                                    ctr5++;
                                    break;
                                default:
                                    System.out.println("Invalid Choice!");
                                    i--;
                                    continue;
                            }
                            heroes[i] = new Hero(hero.getName(choices - 1), hero.getHealth(choices - 1));
                            System.out.println("You chose " + heroes[i].getName() + " at position " + (i + 1));
                            Displays.clear();
                        }catch(InputMismatchException e){
                            System.out.println("Invalid input, please try again");
                            input.nextLine();
                            Displays.clear();
                            --i;
                            continue;
                        }
                    }
                    for (i = 0; i < enemiesOne.length; i++) {
                        enemiesOne[i] = new Enemy(enemy.getName(0), enemy.getHealth(0));
                    }
                    for (i = 0; i < enemiesTwo.length; i++) {
                        enemiesTwo[i] = new Enemy(enemy.getName(1), enemy.getHealth(1));
                    }
                    for (i = 0; i < enemiesThree.length; i++) {
                        enemiesThree[i] = new Enemy(enemy.getName(2), enemy.getHealth(2));
                    }
                    for (i = 0; i < enemiesFour.length; i++) {
                        enemiesFour[i] = new Enemy(enemy.getName(3), enemy.getHealth(3));
                    }
                    for (i = 0; i < enemiesFive.length; i++) {
                        enemiesFive[i] = new Enemy(enemy.getName(4), enemy.getHealth(4));
                    }
                    for (i = 0; i < enemiesSix.length; i++) {
                        enemiesSix[i] = new Enemy(enemy.getName(5), enemy.getHealth(5));
                    }

                    int skipDialogue;
                    while(true) {
                        try {
                            System.out.print("Do you want skip the dialogue(1 - Yes, AnyNumber - No)? ");
                            skipDialogue = input.nextInt();
                            if (skipDialogue != 1) {
                                Displays.clear();
                                Displays.dialogue(0);
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            Displays.clear();
                            continue;
                        }
                    }
                    Displays.typewriter("Entering Level 1...");
                    int win1 = Game.levelOne(heroes,enemiesOne);
                    if(win1 == 1){
                        player.setScore(10);
                        Displays.typewriter("Level 1 complete!");
                        System.out.print("Type anything continue: ");
                        input.nextLine();
                    }else{
                        break;
                    }
                    while(true) {
                        try {
                            System.out.print("Do you want skip the dialogue(1 - Yes, AnyNumber - No)? ");
                            skipDialogue = input.nextInt();
                            if (skipDialogue != 1) {
                                Displays.clear();
                                Displays.dialogue(1);
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            Displays.clear();
                            continue;
                        }
                    }
                    Displays.typewriter("Entering Level 2...");
                    int win2 = Game.levelTwo(heroes, enemiesTwo);
                    if(win2 == 1){
                        player.setScore(14);
                        Displays.typewriter("Level 2 complete!");
                        System.out.print("Type anything continue: ");
                        input.nextLine();
                    }else{
                        break;
                    }
                    while(true) {
                        try {
                            System.out.print("Do you want skip the dialogue(1 - Yes, AnyNumber - No)? ");
                            skipDialogue = input.nextInt();
                            if (skipDialogue != 1) {
                                Displays.clear();
                                Displays.dialogue(2);
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            Displays.clear();
                            continue;
                        }
                    }
                    Displays.typewriter("Entering Level 3...");
                    int win3 = Game.levelThree(heroes, enemiesThree);
                    if(win3 == 1){
                        player.setScore(16);
                        Displays.typewriter("Level 3 complete!");
                        System.out.print("Type anything continue: ");
                        input.nextLine();
                    }else{
                        break;
                    }
                    while(true) {
                        try {
                            System.out.print("Do you want skip the dialogue(1 - Yes, AnyNumber - No)? ");
                            skipDialogue = input.nextInt();
                            if (skipDialogue != 1) {
                                Displays.clear();
                                Displays.dialogue(3);
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            Displays.clear();
                            continue;
                        }
                    }
                    Displays.typewriter("Entering Level 4...");
                    int win4 = Game.levelFour(heroes, enemiesFour);
                    if(win4 == 1){
                        player.setScore(18);
                        Displays.typewriter("Level 4 complete!");
                        System.out.print("Type anything continue: ");
                        input.nextLine();
                    }else{
                        break;
                    }
                    while(true) {
                        try {
                            System.out.print("Do you want skip the dialogue(1 - Yes, AnyNumber - No)? ");
                            skipDialogue = input.nextInt();
                            if (skipDialogue != 1) {
                                Displays.clear();
                                Displays.dialogue(4);
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            Displays.clear();
                            continue;
                        }
                    }
                    Displays.typewriter("Entering Level 5...");
                    int win5 = Game.levelFive(heroes, enemiesFive);
                    if(win5 == 1){
                        player.setScore(20);
                        Displays.typewriter("Level 5 complete!");
                        System.out.print("Type anything continue: ");
                        input.nextLine();
                    }else{
                        break;
                    }
                    while(true) {
                        try {
                            System.out.print("Do you want skip the dialogue(1 - Yes, AnyNumber - No)? ");
                            skipDialogue = input.nextInt();
                            if (skipDialogue != 1) {
                                Displays.clear();
                                Displays.dialogue(5);
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            Displays.clear();
                            continue;
                        }
                    }
                    heroes = Hero.removePriest(heroes);
                    Displays.typewriter("Entering Final Level 6...");
                    int win6 = Game.levelSix(heroes,enemiesSix);
                    if(win6 == 1){
                        player.setScore(22);
                        Displays.typewriter("Level 6 complete!");
                        System.out.print("Type anything continue: ");
                        input.nextLine();
                    }else{
                        break;
                    }
                    while(true) {
                        try {
                            System.out.print("Do you want skip the dialogue(1 - Yes, AnyNumber - No)? ");
                            skipDialogue = input.nextInt();
                            if (skipDialogue != 1) {
                                Displays.clear();
                                Displays.dialogue(6);
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                            Displays.clear();
                            continue;
                        }
                    }
                    player.totalScore(Game.getDeath());
                    player.writeScoreToFile();
                    Player.displayHighScores();
                    break;
                case 2:
                    System.out.println("LeaderBoard of highscorers");
                    Player.displayHighScores();
                    System.out.print("Type anything to go back: ");
                    input.nextLine();input.nextLine();
                    Displays.clear();
                    continue;
                case 3:
                    do {
                        displays.character();
                        do {
                            try {
                                System.out.print("Do you like to check others out? (1-Yes/0-No): ");
                                tryAgain = input.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input, only numbers");
                                input.nextLine();
                                Displays.clear();
                                continue;
                            }
                            Displays.clear();
                            if (tryAgain != 0 && tryAgain != 1) {
                                System.out.println("Invalid Option. Please try again");
                                Displays.clear();
                                continue;
                            } else {
                                break;
                            }
                        } while (true);
                    } while (tryAgain != 0);
                    break;
                case 4:
                    displays.about();
                    System.out.print("Type anything to go back to the menu: ");
                    input.nextLine();input.nextLine();
                    Displays.clear();
                    break;
                case 5:
                    displays.quit();
                    break;
                default:
                    System.out.println("Invalid input, try again.");
                    Displays.clear();
                    continue;
            }
        }while(true);
    }
}