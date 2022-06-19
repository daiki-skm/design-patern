public class Main {
    public static void main(String[] args) {
        Directory rootdir = new Directory("root");

        Directory usrdir = new Directory("usr");
        rootdir.add(usrdir);

        Directory yuki = new Directory("yuki");
        usrdir.add(yuki);

        File a = new File("a", 10);
        yuki.add(a);
        rootdir.printList();

        System.out.println();
        System.out.println("file = " + a.getFullPath());
        System.out.println("yuki = " + yuki.getFullPath());
    }
}