import java.util.ArrayList;
import java.util.List;

public class Library {
    private static int counter;
    private List<Book> catalog = new ArrayList<>();
    private int counterId;

    public Library() {
        counter++;
        counterId = counter;
    }

    public List<Book> getCatalog() {
        return catalog;
    }

    public void addBook(Book book) {
        catalog.add(book);
        System.out.println("Книга №" + getCountBook() + " " + book.getBookInfo());
    }

    public void removeBook(int id) {
        catalog.remove(id);
    }

    public int getCountBook() {
        return catalog.size();

    }

    public String getBookInfoById(int id) {
        for (int i = 0; i < catalog.size(); i++) {
            return catalog.get(id).getBookInfo();
        }
        return null;
    }

    public int searchBookByName(String text) {
        String nameBook;
        for (int i = 0; i < getCountBook(); i++) {
            nameBook = catalog.get(i).getName().toLowerCase();
            if (nameBook.contains(text.toLowerCase())) {
                System.out.println(catalog.get(i).getBookInfo());
                counter++;
            }
        }
        if (counter == 0) {
            counter = searchBookByWriter(text);
        }
        return counter;
    }

    public int searchBookByWriter(String text) {
        String nameWriter;
        for (int i = 0; i < getCountBook(); i++) {
            nameWriter = catalog.get(i).getAuthor().toLowerCase();
            if (nameWriter.contains(text.toLowerCase())) {
                System.out.println(catalog.get(i).getBookInfo());
                counter++;
            }
        }
        return counter;
    }
}
