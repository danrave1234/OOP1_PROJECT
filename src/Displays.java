import java.util.*;
public class Displays {
    Scanner input = new Scanner(System.in);
    public static void displayHeroes(Hero[] heroes, Enemy[] enemy) {

        int i;
        System.out.println("Current Heroes and Health:");
        for (i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0) {
                System.out.printf("%d. %-15s is down\t\t", i + 1, heroes[i].getName());
            } else {
                System.out.printf("%d. %-15s %d health\t\t", i + 1, heroes[i].getName(), heroes[i].getHealth());
            }

            if (enemy.length > i) {
                if (enemy[i].getHealth() <= 0) {
                    System.out.printf("%d. %s is down", i + 1, enemy[i].getName());
                }else{
                    System.out.printf("%d. %-15s %d health\t\t", i + 1, enemy[i].getName(), enemy[i].getHealth());
                }
            }
            System.out.println();
        }
    }

    public static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void characterChoices(){
        System.out.println("Characters:");
        System.out.println("1. Knight   500 health");
        System.out.println("2. Assassin 450 health");
        System.out.println("3. Warrior  600 health");
        System.out.println("4. Wizard   400 health");
        System.out.println("5. Priest   400 health");
    }
    public void quit(){
        System.out.println("Thanks for playing. Goodbye!");
        System.exit(1);
    }
    public void about(){
        System.out.println("*********** Glosarry ***********");
        System.out.println("Energy - Used to use skills and abilities of heroes");
        System.out.println("Stun - reduces the energy next turn");
        System.out.println("Ultimates - Will be available when the specific hero is used depending on the hero requirements");
        System.out.println("Defense - Reduces the damage taken for the enemy's first turn of attack. Lasts only the next turn or when receiving an attack");
    }
    public void character(){
        int characterChoice, backToMain;
        Displays displays = new Displays();
        do {
            try {
                displays.characterChoices();
                System.out.print("Choose a character to know more about: ");
                characterChoice = input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Please enter a valid number (1-5).");
                Displays.clear();
                continue;
            }
            if(characterChoice > 5 || characterChoice < 1){
                System.out.println("Choices are 1-5 Only. Please try again");
                continue;
            }
            Displays.clear();
            switch (characterChoice) {
                case 1:
                    System.out.println("About the Knight");
                    System.out.println("Simon is one of the strongest warrior in kingdom of transylvania");
                    System.out.println("Many creatures of the night fear before him");
                    System.out.println("Stats: 500 Health");
                    System.out.println("*********** Skills ***********");
                    System.out.println("Skill 1: Slash, deals 60 damage");
                    System.out.println("Skill 2: Sweep, deals 40-80 damage");
                    System.out.println("Skill 3: Holy Shield, grants 40 defense");
                    System.out.println("Ultimate 4: Excalibur, deals 100 damage and grants 20 defense. 3 turns to use");
                    break;
                case 2:
                    System.out.println("About the Assassin");
                    System.out.println("Leonore the Assassin born on the mountain of bandits ruthless and courageous");
                    System.out.println("She was reconized as the master of stealth");
                    System.out.println("Stats: 450 Health");
                    System.out.println("*********** Skills ***********");
                    System.out.println("Skill 1: Back Stab - deals 70 damage with the chance of critical hit");
                    System.out.println("Skill 2: Swift Dagger - deals 50-100 damage");
                    System.out.println("Skill 3: Cloak - Avoid one attack");
                    System.out.println("Ultimate 4: Assassin's Mark - deals 90 damage with the higher chance of critical hit. 3 turns to use");
                    break;
                case 3:
                    System.out.println("About the Warrior");
                    System.out.println("Kyle was born as a lone wolf trained hard after his parents died of protecting");
                    System.out.println("from the night creatures. He sworn to protect the weak and get stronger");
                    System.out.println("Stats: 600 Health");
                    System.out.println("*********** Skills ***********");
                    System.out.println("Skill 1: Cleave - deals 60 damage and heal 10 to self");
                    System.out.println("Skill 2: Meditate - heals 40 and 30 defense");
                    System.out.println("Skill 3: Iron defense - reduced next incoming damage by 50%");
                    System.out.println("Ultimate 4: ThunderStomp - deals 80 damage and heal self 30% of the damage dealt. 2 turns to use");
                    break;
                case 4:
                    System.out.println("About the Wizard");
                    System.out.println("Ka-el the magician of elements studied in anemancy, pyromancy, hydromancy and black magic");
                    System.out.println("Stats: 400 Health");
                    System.out.println("*********** Skills ***********");
                    System.out.println("Skill 1: Fireball - deals 70 damage");
                    System.out.println("Skill 2: IceShards - deals 30 - 100 damage and chance to stun");
                    System.out.println("Skill 3: Slicing wind - deals 60 - 80 damage");
                    System.out.println("Ultimate 4: Dark Magic - deals 100 damage and stuns. 2 turns to use");
                    break;
                case 5:
                    System.out.println("About the Priest");
                    System.out.println("Khai, the champion of light, the high priest of the catholic church");
                    System.out.println("was the most outstanding warrior and many night creatures and demons fear before him");
                    System.out.println("Was recognized as the hero of Transylvania");
                    System.out.println("Stats: 400 Health");
                    System.out.println("*********** Skills ***********");
                    System.out.println("Skill 1: Heal - heals 60 the front most living hero");
                    System.out.println("Skill 2: Holy Blessing - gives 30 defense and heal the front most living hero");
                    System.out.println("Skill 3: Rain of Destiny - deals 30-60 and heals 30-60 the front most living hero");
                    System.out.println("Ultimate 4: Renascence: Revive a fallen ally in the front most with 200 hp. 4 turns to use");
                    break;
                default:
                    System.out.println("Choices are 1-5 Only. Please try again");
                    continue;
            }
            Displays.clear();
            break;
        }while(true);

    }
    public static void typewriter(String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            if (c == '.' || c == '!' || c == '?') {
                Thread.sleep(800);
            } else {
                Thread.sleep(20);
            }
        }
        System.out.println();
    }
    public static void dialogue(int level) throws InterruptedException {
        if(level == 0){
            typewriter("In the 13th century the kingdom of Transylvania, the village of Azeroth was rotten and suffered from the mysterious plague,");
            typewriter("The Kingdom of the Holy Church, where the high priest and the Bishop noticed something was odd about the plague.They summon ");
            typewriter("the greatest warrior the champion of light the priest himself Khai, the greatest warrior in the kingdom of the Catholic church");
            typewriter("the high priest himself was ordered to find the relic to cure the disease Khai himself agree and called one of the best people");
            typewriter("to go on an adventure, Simon, Leonore, Kyle and Ka-el went on the quest to find the relic to cure the scourging plague that");
            typewriter("that Azeroth was suffered from. To the castle where the evil lurks in a scoundrel  of undead minions. The journey begins of the");
            typewriter("bravest warrior from the kingdom of Transylvania\n");

            typewriter("Khai- “Let’s travel along to the cursed forest where evil lies ahead”\n");
            typewriter("Simon - “Lets’ get it on!”\n");
            typewriter("Leonore - “In the name of my ancestor failure is not an option”\n");
            typewriter("Kyle - “Ashtafalanar! To the village of Azeroth!”\n");
            typewriter("Ka-el - “In the name of magic and sorcery we shall prevail!”\n");

            typewriter("As the heroes were sent by the bishop of the catholic church, they went forward to the conquest to find the cure for");
            typewriter("the village's mysterious illness. Will they succeed in saving the village? Or will they fall just like the people");
            typewriter("failed before them?\n");

            typewriter("As they travel through the cursed forest where wicked and evil draws near they sense");
            typewriter("something is going to scoundrel upon them. The heroes were ambushed  by a wicked evil.\n");
            typewriter("scout troll.\n");

            typewriter("Khai- “That  mischievous creature is a scout troll, quick before he’s  going to report his fellow comrades about our presence.\n");
        }else if(level == 1){
            typewriter("Leonore- “Tell everything you know wicked troll”\n");
            typewriter("Troll- “I won't tell you everything you wicked heroes");
            typewriter("haha! You don’t  even think that i will tell you");
            typewriter("what i really know about hehe");
            typewriter("Kyle- “You devilish troll, I won't even hesitate to decapitate you.”\n");
            typewriter("Ka-el - “Should I use cursed magic towards you my little troll?”\n");
            typewriter("Simon - “Maybe he should taste some of my fist”\n");
            typewriter("Khai - “That’s enough, all of you. I’ll do the infiltration towards the troll”\n");
            typewriter("*After talking to the scout troll they received the information that they gathered.*\n");
            typewriter("Khai - “Our destination is the castle that lies within the forest,");
            typewriter("where evil is the source of everything.”\n" + "\n");
        }else if(level == 2){
            typewriter("Devilish Orch Guards- “curses!, i can’t believe I am defeated.. *heavy breathing*”\n");
            typewriter("Khai- “May the light extinguish you!”\n");
            typewriter("The heroes defeated the Devilish Orc Guards who guarded the castle that evil lurks within,");
            typewriter("shrouded by negative energy from the castle within, our heroes proceed to walk in towards");
            typewriter("strange castle in Transylvania where death itself consumes whoever enters.\n");
            typewriter("Ka-el - “i sense some evil magic in the area”\n");
            typewriter("Kyle- “I can feel my axe shivers as my skin crawls”\n");
            typewriter("Leonore - “I can hear a sad soul is screaming”\n");
            typewriter("Simon - “Be ready evil draws close”\n");
            typewriter("Khai -”Show yourself!”\n");
            typewriter("As the heroes walk the castle hall a wings with red devilish appeared before them\n");
            typewriter("Succubus- “ Greetings and welcome to the castle of our Dark Lord”\n");
            typewriter("Khai- “You wicked scum! You shall be compelled from the light!”\n");
            typewriter("Succubus - “Will see about that high priest hehe”\n");
            typewriter("Entering Level 3...");
        }else if(level == 3){
            typewriter("Succubus- “rahhh you can’t defeat our Handsome Dark Lord you will all die and perish!”\n");
            typewriter("Khai- “In the name of God and the light you shall perish and descend to God!\n");
            typewriter("Succubus- “Noooooo!! Ughhh!!”\n");
            typewriter("The heroes were victorious in defeating the devilish succubus who are loyal to the DarkLord");
            typewriter("himself. Realizing that they are almost achieving on seeking their conquest towards the");
            typewriter("destiny of the village of Azeroth. The fate of Azeroth is at the hands of the heroes who");
            typewriter("who are seeking the truth, the truth that lies ahead of this castle. As they move forward..");
            typewriter("They faced many obstacles.. Solving puzzles, to find the throne entrance, to find the DarkLord");
            typewriter("himself who was the cause of the fate of Azeroth. As soon as they the weird looking door they");
            typewriter("were astonished that they believed this is the throne entrance. But a weird looking foe was");
            typewriter("calling upon them\n");
            typewriter("Royal undead Guards- “You cannot pass, death is your prevail once you took one step closer”\n");
            typewriter("Khai- “Then light will guide you on the way to the afterlife!”\n");
            typewriter("Khai and 4 brave warriors are ready to battle the royal undead guards.\n");
        }else if(level == 4){
            typewriter("Royal Undead Guard- “*groans in pain* ughh.. Arghh… I sense something within you priest..");
            typewriter("You.. you have some different motives among those 4..”\n");
            typewriter("Khai- “My motives is to defeat the Dark Lord and take back what is ours!”\n");
            typewriter("*Khai exorcist the royal undead Guard*\n");
            typewriter("Khai- “This is the moment of truth, this will be the ultimate battle");
            typewriter("to seek the rune to cure the land of Azeroth once and for all!”\n");
            typewriter("Leonore - “May our ancestors guide us”\n");
            typewriter("Simon - “May the light shine through my armor!”");
            typewriter("Kyle - “Heave- ho! Let’s get it on!”\n");
            typewriter("Ka-el - “Let magic upon! In the name of Quas Wex and Exort magic shall guide us through!”\n");
            typewriter("After defeating the guards who are guiding the main entrance of the throne, Khai uses holy");
            typewriter("magic to open the gates of the evil that is behind this door. As soon as it opens the DarkLord ");
            typewriter("Himself sitting on his throne watching them like little mice who are lost in the dark woods.");
            typewriter("Dark Lord- “hehehehe welcome i’ve been expecting you”\n");
            typewriter("Khai- “You devil! come down from the throne! Like an”");
            typewriter("evil lurker you are!”\n");
            typewriter("*Dark Lord intimates the 5 brave warriors*\n");
            typewriter("Dark Lord- “Well well well, Seems like you folks are”");
            typewriter("ready to be perished in hell”\n");
            typewriter("Khai- “The Light himself is upon us and we are not");
            typewriter("scared to fight you devil!”\n");
            typewriter("Pimot- “Before we start i would like to be called as”");
            typewriter("‘Pimot’ the Dark Lord himself\n");
            typewriter("Khai- “Pimot!. In the name of God you shall perish!");
            typewriter("For the crimes you’ve committed from the suffering of Azeroth!”\n");
            typewriter("Pimot- “Azeroth? What wretched name is that? A place? A kingdom?");
            typewriter(" I have no concern from that place you foul priest”\n");
            typewriter("Khai- “Enough with your lies! Everyone hold strong!”\n");
        }else if(level == 5){
            typewriter("Khai-“It’s over time for your last wishes Pimot!”");
            typewriter("Pimot-“I have nothing concern towards the named called ‘Azeroth’, Priest!”\n");
            typewriter("Khai- “Save your prayers and enough with your lies time to finished this");
            typewriter("once and for all’\n");
            typewriter("After defeating the Dark Lord the heroes were victorious in the battle");
            typewriter("of the Dark Lord, but as soon as Dark Lord himself faded. the priest.");
            typewriter("Khai.. Was acting strange and his motives and movements were different.\n");
            typewriter("Leonore- “”We did it, we did it!”");
            typewriter("Simon - “Time to save Azeroth”");
            typewriter("Kyle- “I’m so strong haha!, we finally did it”");
            typewriter("Ka-el -”Hold your horses at least we did it”\n");
            typewriter("(Ka-el notice something was off)”\n");
            typewriter("As soon as Khai retrieves the runes he was acting strange towards the artifact that they retrieved");
            typewriter(" the artifact that can cure the village of Azeroth. Or maybe there is another reason for this to happen.\n");
            typewriter("Khai-. . .*evil laughs* mwahahahahaha, finally this is the moment of truth! The moment I was waiting for!”\n ");
            typewriter("As soon  as Khai absorbs the power and becomes the truth behind everything on their journey.\n");
            typewriter("Leonore- “What’s the meaning of this?”\n");
            typewriter("Simon- “What’s going on!?”\n");
            typewriter("Kyle- “What monstrosity is this?!”\n");
            typewriter("Ka-el- “What sorcery is this?”\n");
            typewriter("As soon as the transformation was complete Khai became the real truth.");
            typewriter("The real reason why the journey has a purpose for it.\n");
            typewriter("Ka-el - “I knew something was off. when the royal guard was talking to you, and the Dark Lord himself!”\n");
            typewriter("Khai- “To be fair my goal was to achieve this power, the village of Azeroth was my doing.");
            typewriter(" I planned this everything all along hahahahahaha!. According to my plan.\n");
            typewriter("Leonore- “Then why are you used as tools for your own selfishness Priest Khai?”");
            typewriter("Simon- “I thought we were doing this for God..”");
            typewriter("Kyle- “The village.. The disease.. You were the one behind all of this??! How cruel you are!”");
            typewriter("Ka-el- “You're just an empty soul priest!”\n");
            typewriter("Khai achieve everything according to his plan. The plan he made was successful after analyzing");
            typewriter("and using his comrades for the sake of his own selfishness\n");
            typewriter("Khai- “hahahahaha! You wretched fools do you think it’s for God? No im doing this because I'm");
            typewriter("going to punish the sinners who does not follow God!I'm using this dark powers to punish them");
            typewriter("as I will hahahaha!\n");
            typewriter("Ka-el - “No priest you're not doing this for God.. you're doing this on your own selfishness. .");
            typewriter("God doesn’t want this”\n");
            typewriter("Simon - “You’re lost.. God doesn’t want this to happen..”\n");
            typewriter("Kyle- “God wanted us to save the village and not making it worse”\n");
            typewriter("Ka-el - “God wants us to love one another and forgive one another.. Look at yourself, priest..");
            typewriter("you're not an angel but the reincarnation of evil.. It’s time to you to stop this!”\n");
            typewriter("Khai- “Then have it your own way!. Have at you!”\n");
        }else if(level == 6){
            typewriter("Khai- “No this cannot be… NOOOOOOO!!!!!”\n");
            typewriter("The 4 brave heroes defeated Khai, the high priest who was lost in his own mind.");
            typewriter("Now the heroes wonder what would be their next after this incident.\n");
            typewriter("Ka-el - “Everyone it’s over..”\n");
            typewriter("Kyle- all was just for nothing..");
            typewriter("Leonore- . . . \n");
            typewriter("Simon- “What about the village?..”\n");
            typewriter("The 4 heroes realized that the mission was nothing but a foolish game.Now they decided to go");
            typewriter("back to the village of Azeroth. As soon as they arrived they realized the Village was saved.");
            typewriter("Ka-el explains how this was happen.\n");
            typewriter("Ka-el- “He was the source of everything.Khai himself.in order to free them from the disease is");
            typewriter("to eliminate the source of it, we did it everyone we save Azeroth!”\n");
            typewriter("The 4 heroes celebrate their victory towards the adventure and battle they went through");
            typewriter("Seeing the efforts were not wasted. The kingdom of the Holy Church Summon upon them.");
            typewriter("Giving them awards and respectfully. As soon as Ka-el The elemental wizard explains");
            typewriter("everything on what happened and regarding khai's plan and his purpose.The High priest");
            typewriter("the Bishop were saddened by the tragedy of khai’s will and purpose. The village was saved.");
            typewriter(" And the heroes celebrated their wins and the Kingdom of Church will guide the priest of");
            typewriter("of the path of light where God shall be with them.\n" +"\n");

            typewriter("THE END.");
        }
    }
}
