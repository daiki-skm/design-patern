//public class PrintBanner extends Banner implements Print {
public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String string) {
//        super(string);
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}