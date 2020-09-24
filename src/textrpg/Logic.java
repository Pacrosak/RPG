package textrpg;

import java.util.Scanner;

public class Logic {

    static Hero hero;
    static ShopItems shop;
    public static boolean on;

    static Scanner sc = new Scanner(System.in);

    public static void Clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");

        }

    }

    public static void StartGame() {
        boolean nameChosen = false;
        String name;
        System.out.println("Choose a name: ");
        name = sc.next();
        System.out.println("Name youve chosen: " + name);
        System.out.println("(1) Continue");
        int option = Read(1);
        if (option == 1) {
            nameChosen = true;
            hero = new Hero(name);
            shop = new ShopItems(10, 1, 1, 5, 5, 10, 5, 10);
            on = true;
        }

    }

    public static int Read(int choice) {
        int option;

        option = Integer.parseInt(sc.next());

        if (option < 1 || option > choice) {
            System.out.println("Enter Integer Value");

        }

        return option;

    }

    public static void HeroInformation() {
        Clear();
        System.out.println("Hero name: " + hero.name);
        System.out.println("Hero level: " + hero.level);
        System.out.println("Hero experience: " + hero.experience);
        System.out.println("Hero gold: " + hero.gold);
        System.out.println("Hero Inventory: " + hero.inventory);
        System.out.println("Hero damage: " + hero.damage);
        System.out.println("Hero Defense: " + hero.defense);

    }

    public static void Menu() {
        while (on) {
            System.out.println("");
            System.out.println(" 1 Display hero information: ");
            System.out.println(" 2 Continue Storyline (SHOP TEST): ");
            System.out.println(" 3 Game manual: ");
            System.out.println(" 4 Exit the game: ");
            int option = Read(4);

            switch (option) {
                case 1:
                    HeroInformation();
                    break;

                case 2:
                    Shop();
                    break;
                case 4:
                    on = false;
                    System.out.println("Thanks for playing!");
                    break;

            }

        }

    }

    public static void Continue() {

        System.out.println("Number to continue: ");
        int number = sc.nextInt();
    }

    public static void Shop() {

        Clear();
        System.out.println("Welcome to the shop!");
        System.out.println("Your gold: " + hero.gold);
        System.out.println("SHOP");
        System.out.println("Please enter a number of item you want to purchase! ");
        System.out.printf("(1) Sword of Illusions +5 Attack  --- Stock: %d , Cost: %d ", shop.swordStock, shop.swordPrice);
        System.out.println("");
        System.out.printf("(2) Candy Coated Armor +3 Defense --- Stock: %d , Cost: %d ", shop.armorStock, shop.armorPrice);
        System.out.println("");
        System.out.printf("(3) Potion of Health +100HP       --- Stock: %d , Cost: %d ", shop.hpPotStock, shop.hpPotPrice);
        System.out.println("");
        System.out.printf("(4) Potion of Strenght +2 Attack  --- Stock: %d , Cost: %d ", shop.strenghtPotStock, shop.strenghtPotPrice);
        System.out.println("");
        System.out.println("(5) Exit the shop");
        int option = Read(5);
        switch (option) {
            case 1:
                if (hero.gold >= shop.swordPrice && shop.swordStock > 0) {
                    hero.damage += 5;
                    shop.swordStock = shop.swordStock - 1;

                    hero.gold -= shop.swordPrice;
                    hero.inventory += "Sword of Illusions ";
                    Clear();
                    System.out.println("Youve bought Sword of Illusions from the trader!");
                    System.out.println("Sword of Illusions has been added to your inventory!");
                    System.out.println("Hero attack: " + hero.damage);
                    System.out.println("Hero gold: " + hero.gold);
                    Continue();
                    Shop();

                    break;

                } else {
                    System.out.println("You dont have enough gold or the item is out of stock!");
                    Continue();
                    Shop();
                }

            case 2:
                if (hero.gold >= shop.armorPrice && shop.armorStock > 0) {
                    hero.defense += 3;
                    shop.armorStock = shop.armorStock - 1;

                    hero.gold -= shop.armorPrice;
                    hero.inventory += " Candy Coated Armor ";
                    Clear();
                    System.out.println("Youve bought Candy Coated Armor from the trader!");
                    System.out.println("Candy Coated Armor has been added to your inventory!");
                    System.out.println("Hero Defense: " + hero.defense);
                    System.out.println("Hero gold: " + hero.gold);
                    Continue();
                    Shop();

                    break;

                } else {
                    System.out.println("You dont have enough gold or the item is out of stock!");
                    Continue();
                    Shop();
                }

            case 5:
                System.out.println("Youre exiting the shop");
                Menu();

        }

        Continue();

    }

}
