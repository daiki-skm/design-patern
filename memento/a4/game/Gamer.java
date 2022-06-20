package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();

    private static String[] fruitsName = {"りんご", "ぶどう", "バナナ", "みかん"};

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("フルーツ(" + f + ")を手に入れました");
            fruits.add(f);
        } else {
            System.out.println("何も起こりませんでした");
        }
    }

    public Memento createMemento() {
        Memento m = new Memento(money);
        for (String f : fruits) {
            if (f.startsWith("おいしい")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento m) {
        this.money = m.getMoney();
        this.fruits = m.getFruits();
    }

    @Override
    public String toString() {
        return "money = " + money + ", fruits = " + fruits;
    }

    private String getFruit() {
        int index = random.nextInt(fruitsName.length);
        String f = fruitsName[index];
        if (random.nextBoolean()) {
            return "おいしい" + f;
        }
        return f;
    }
}