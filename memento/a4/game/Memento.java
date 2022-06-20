package game;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;

public class Memento {
    private int money;
    private List<String> fruits;

    public int getMoney() {
        return money;
    }

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }

    public static boolean saveToFile(String filename, Memento memento) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d", memento.money));
        sb.append("\n");

        for (String fruit : memento.getFruits()) {
            sb.append(fruit);
            sb.append("\n");
        }

        try {
            Files.writeString(Path.of(filename), sb,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }

        return true;
    }

    public static Memento loadFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            if (lines.size() == 0) {
                System.out.println("File is empty");
                return null;
            }

            int money = 0;
            try {
                money = Integer.parseInt(lines.get(0));
            } catch (NumberFormatException e) {
                System.out.println("Invalid money: " + e);
                return null;
            }

            Memento memento = new Memento(money);

            for (int i = 1; i < lines.size(); i++) {
                memento.addFruit(lines.get(i));
            }

            return memento;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}