import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookshelf = new BookShelf(4);
        bookshelf.appendBook(new Book("Around the World in 80 Days"));
        bookshelf.appendBook(new Book("Bible"));
        bookshelf.appendBook(new Book("Cinderella"));
        bookshelf.appendBook(new Book("Daddy-Long-Legs"));

        Iterator<Book> it = bookshelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        for (Book book : bookshelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}