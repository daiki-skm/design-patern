import game.Memento;
import game.Gamer;

public class Main {
    public static final String SAVEFILENAME = "game.dat";

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);

        Memento memento = Memento.loadFromFile(SAVEFILENAME);

        if (memento == null) {
            System.out.println("新規にゲームを開始します");
            memento = gamer.createMemento();
        } else {
            System.out.println("ゲームを復元します");
            gamer.restoreMemento(memento);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("now: " + gamer);

            gamer.bet();

            System.out.println("所持金は" + gamer.getMoney() + "円です");

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("だいぶ増えたので、保存しておく");
                memento = gamer.createMemento();
                if (Memento.saveToFile(SAVEFILENAME, memento)) {
                    System.out.println("保存に成功しました");
                }
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("だいぶ減ったので、復元しておく");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println();
        }
    }
}