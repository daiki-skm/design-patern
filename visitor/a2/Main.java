public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");
        root.add(bin);
        root.add(tmp);
        root.add(usr);
        bin.add(new File("vi", 100));
        bin.add(new File("vim", 200));
        root.accept(new ListVisitor());
        System.out.println("");

        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");
        usr.add(yuki);
        usr.add(hanako);
        usr.add(tomura);
        yuki.add(new File("diary.html", 100));
        yuki.add(new File("comic.html", 200));
        hanako.add(new File("game.html", 300));
        tomura.add(new File("movie.html", 500));
        tomura.add(new File("movie.js", 600));
        root.accept(new ListVisitor());
    }
}