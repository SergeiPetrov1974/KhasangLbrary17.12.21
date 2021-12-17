public class Menu {
    static Library library = new Library();
    static Reader reader = new Reader();


    public static void start() {
        int chooseAction = 0;
        System.out.println("Сейчас в каталоге книг - " + library.getCountBook());
        for (int i = 0; i < 10; i++) {
            System.out.println("Что будем делать: 0-Добавить книгу; 1-Найти книгу; 2-Удалить книгу; 3 - Закрыть программу;");
            chooseAction = selectAction(reader);
            switch (chooseAction) {
                case 0:
                    addLibraryBook(reader, library);
                    System.out.println("В каталоге книг - " + library.getCountBook());
                    break;
                case 1:
                    if (library.getCountBook() == 0) {
                        System.out.println("Каталог пустой.");
                    } else {
                        searchBooks();
                    }
                    break;

                case 2:
                    if (library.getCountBook() > 0) {
                        removeLibraryBook(reader, library);
                        System.out.println("В каталоге осталось книг - " + library.getCountBook());
                    } else {
                        System.out.println("В каталоге пусто. Нет книг для удаления");
                    }


                case 3:
                    if (chooseAction == 3) {
                        System.out.println("Работа программы завершена ");
                        System.exit(0);

                    }
            }
        }
    }


    static int selectAction(Reader reader) {
        int action;
        do {
            action = reader.getAnswer();
            if (action != 0 & action != 1 & action != 2 & action != 3) {
                System.out.println("Укажите что нужно сделать: 0-Добавить книгу; 1-Найти книгу по названию" + " 2-Удалить книгу" + " 3 - Закрыть программу");
            }
        } while (action != 0 & action != 1 & action != 2 & action != 3);
        return action;
    }

    public static void searchBooks() {
        System.out.println("Какую книгу вы ищете сегодня?");
        String bookSearch = reader.getString();
        for (Book book : library.getCatalog()) {
            if (book.getName().contains(bookSearch) || book.getAuthor().contains(bookSearch)) {
                System.out.println("Книга найдена " + book.getBookInfo());
            } else {
                System.out.println("Книга не найдена ");
            }
        }
    }

    static void addLibraryBook(Reader reader, Library library) {
        String name = null;
        String author = null;
        int publicationYear = 0;
        System.out.println("Укажите название книги");
        name = reader.getString();
        System.out.println("Укажите автора книги");
        author = reader.getString();
        System.out.println("Укажите год публикации");
        publicationYear = Integer.parseInt(reader.getString());
        library.addBook(new Book(name, author, publicationYear));
        System.out.println("Книга добавлена в каталог");
    }

    static void removeLibraryBook(Reader reader, Library catalog) {
        int numBook;
        System.out.println("В каталоге книг - " + catalog.getCountBook());
        System.out.println("Укажите номер удаляемой книги");
        do {
            numBook = reader.getAnswer();
        } while (numBook < 1 || numBook > catalog.getCountBook());
        --numBook;
        System.out.println("Вы уверены что хотите удалить книгу: " + catalog.getBookInfoById(numBook) + "?");
        System.out.println("0-нет; 1-да");
        int ans;
        do {
            ans = reader.getAnswer();
        } while (ans != 0 & ans != 1);
        if (ans == 1) {
            catalog.removeBook(numBook);
        }
    }
}

