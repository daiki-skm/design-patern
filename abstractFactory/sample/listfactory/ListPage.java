package listfactory;

import factory.Item;
import factory.Page;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html><head><title>" + title + "</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>" + title + "</h1>\n");
        sb.append("<ul>\n");
        for (Item item : content) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n");
        sb.append("<hr><address>" + author + "</address>\n");
        sb.append("</body></html>\n");
        return sb.toString();
    }
}