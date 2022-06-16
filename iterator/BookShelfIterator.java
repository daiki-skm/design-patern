import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookshelf;
    private int index;

    public BookShelfIterator(BookShelf bookshelf) {
        this.bookshelf = bookshelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookshelf.getLength();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return bookshelf.getBookAt(index++);
    }
}