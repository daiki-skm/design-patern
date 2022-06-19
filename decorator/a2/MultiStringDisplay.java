import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    private List<String> body = new ArrayList<>();
    private int columns = 0;

    public void add(String string) {
        body.add(string);
        if (columns < string.length()) {
            columns = string.length();
        }
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    private void updatePadding() {
        for (int i = 0; i < body.size(); i++) {
            String s = body.get(i);
            int padding = columns - s.length();
            if (padding > 0) {
                body.set(i, s + spaces(padding));
            }
        }
    }

    private String spaces(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}