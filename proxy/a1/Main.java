public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice", "Printer");
        System.out.println(p.getPrinterName());
        p.setPrinterName("Bob");
        System.out.println(p.getPrinterName());
        p.print("Hello, world!");
    }
}