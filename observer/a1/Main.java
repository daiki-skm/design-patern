public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);
        Observer o1 = new DigitObserver();
        Observer o2 = new GraphObserver();
        Observer o3 = new ThirdObserver();
        generator.addObserver(o1);
        generator.addObserver(o2);
        generator.addObserver(o3);
        generator.execute();
    }
}