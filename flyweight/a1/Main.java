public class Main {
    private static BigString[] bigStrings = new BigString[10000];

    public static void main(String[] args) {
        System.out.println("shared:");
        testAllocation(true);
        System.out.println("unshared:");
        testAllocation(false);
    }

    public static void testAllocation(boolean shared) {
        for (int i = 0; i < bigStrings.length; i++) {
            bigStrings[i] = new BigString("1212123", false);
        }
        showMemoryUsage();
    }

    public static void showMemoryUsage() {
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory usage: " + usedMemory);
        System.out.println("Memory usage: " + usedMemory / 1024 / 1024 + " MB");
    }
}
