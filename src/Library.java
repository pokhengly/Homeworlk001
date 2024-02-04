public class LibrarySystem {
    private String name;
    private String address;
    private Book[] books;
    private int bookCount;

    public LibrarySystem(String name, String address, int maxBooks) {
        this.name = name;
        this.address = address;
        this.books = new Book[maxBooks];
        this.bookCount = 0;
    }
}