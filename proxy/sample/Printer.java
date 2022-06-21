public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("Creating instance of Printer");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Creating instance of Printer with name: " + name);
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(String message) {
        System.out.println(message);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("Done");
    }
}