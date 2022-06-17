import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String filename = htmlBuilder.getHTMLResult();
            System.out.println("HTMLファイルを生成しました: " + filename);
            return;
        }
        if (args[0].equals("text")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String text = textBuilder.getTextResult();
            System.out.println(text);
            return;
        }
        usage();
        System.exit(0);
    }

    private static void usage() {
        System.out.println("Usage: java Main [html|text]");
    }
}