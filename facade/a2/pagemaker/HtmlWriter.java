package pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<!DOCTYPE html>");
        writer.write("<html><head><title>" + title + "</title></head><body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }

    public void link(String href, String caption) throws IOException {
        writer.write("<a href=\"" + href + "\">" + caption + "</a>\n");
    }

    public void mailto(String mailaddr, String caption) throws IOException {
        link("mailto:" + mailaddr, caption);
    }

    public void close() throws IOException {
        writer.write("</body></html>\n");
        writer.close();
    }
}