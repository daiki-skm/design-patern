public class ThirdObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("ThirdObserver: " + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}