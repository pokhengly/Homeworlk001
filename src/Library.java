import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Date;
import java.util.Scanner;

public class Library {

    private final Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private Date date;
    private int bookCount;
    private Book[] books = new Book[100];

    public void setUpLibrary() {

        System.out.println("=================== SET UP LIBRARY ====================");

        System.out.print("=> Enter Library's Name: ");
        name = scanner.nextLine();
        System.out.print("=> Enter Library's Address: ");
        address = scanner.nextLine();

        date = new Date();
        System.out.print(Color.ANSI_BLUE.getColor() + "\"" + name + "\"" + " Library is already created in " + "\"" + address + "\"" + " address successfully on " + date + Color.ANSI_RESET.getColor());
    }

    public void displayMenu() {

        int option;

        do {
            System.out.println("\n=================== " + name + " ," + address + " ====================");
            System.out.println("1- Add Book");
            System.out.println("2- Show All Books");
            System.out.println("3- Show Available Books");
            System.out.println("4- Borrow Book");
            System.out.println("5- Return Book");
            System.out.println("6- Exit");
            System.out.println("---------------------------------------------------");
            System.out.print("=> Choose option(1-6): ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    showAvailableBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        } while (option != 6);

    }

    public Library() {
        Author author1 = new Author("J.K. Rowling", "1965-");
        Author author2 = new Author("George Orwell", "1903-1950");
        Author author3 = new Author("Harper Lee", "1926-2016");
        Author author4 = new Author("J.R.R. Tolkien", "1892-1973");
        Author author5 = new Author("Agatha Christie", "1890-1976");
        Author author6 = new Author("F. Scott Fitzgerald", "1896-1940");

        books[0] = new Book(1, "Harry Potter and the Sorcerer's Stone", author1, "1997", Status.UNAVAILABLE);
        books[1] = new Book(2, "1984", author2, "1949", Status.AVAILABLE);
        books[2] = new Book(3, "To Kill a Mockingbird", author3, "1960", Status.AVAILABLE);
        books[3] = new Book(4, "The Hobbit", author4, "1937", Status.AVAILABLE);
        books[4] = new Book(5, "Murder on the Orient Express", author5, "1934", Status.AVAILABLE);
        books[5] = new Book(6, "The Great Gatsby", author6, "1925", Status.AVAILABLE);

        bookCount = 6;
    }

    private void addBook() {

        String bookName;
        String authorName;
        String authorYearActive;
        String publishedYear;

        System.out.println("=================== ADD BOOK INFO ====================");
        System.out.print("=> Enter Book's Name : ");
        bookName = scanner.nextLine();

        while (!bookName.matches("^[a-zA-Z ]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Book Name should contain only characters." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Book's Name: ");
            bookName = scanner.nextLine();
        }

        System.out.print("=> Enter Book's Author Name : ");
        authorName = scanner.nextLine();

        while (!authorName.matches("^[a-zA-Z ]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Author Name should contain only characters." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Book's Author Name: ");
            authorName = scanner.nextLine();
        }

        System.out.print("=> Enter Author Year Active : ");
        authorYearActive = scanner.nextLine();

        // Use regex to check if authorYearActive contains only characters
        while (!authorYearActive.matches("^[a-zA-Z0-9 ]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Author Year Active should contain only characters and numbers." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Author Year Active: ");
            authorYearActive = scanner.nextLine();
        }

        System.out.print("=> Enter Published Year : ");
        publishedYear = scanner.nextLine();

        // Use regex to check if publishedYear contains only numbers
        while (!publishedYear.matches("^[0-9]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Published Year should contain only numbers." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Published Year: ");
            publishedYear = scanner.nextLine();
        }

        Author author = new Author(authorName, authorYearActive);

        books[bookCount] = new Book(bookCount + 1, bookName, author, publishedYear, Status.AVAILABLE);
        bookCount++;

        System.out.println(Color.ANSI_GREEN.getColor() + "Book is added successfully..." + Color.ANSI_RESET.getColor());
    }

    private void showAllBooks() {

        System.out.println("=================== ALL BOOKS INFO ====================");

        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle numberCellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

        table.addCell(Color.ANSI_BLUE.getColor() + "ID" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "TITLE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "AUTHOR" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "PUBLISH DATE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "STATUS" + Color.ANSI_BLUE.getColor(), numberCellStyle);


        table.setColumnWidth(0, 10, 15);
        table.setColumnWidth(1, 25, 60);
        table.setColumnWidth(2, 25, 60);
        table.setColumnWidth(3, 25, 25);
        table.setColumnWidth(4, 25, 25);

        for (int i = 0; i < bookCount; i++) {
            table.addCell(Color.ANSI_BLUE.getColor() + String.valueOf(books[i].getId()) + Color.ANSI_BLUE.getColor(), numberCellStyle);
            table.addCell(Color.ANSI_PINk.getColor() + books[i].getTitle() + Color.ANSI_BLUE.getColor(), numberCellStyle);
            table.addCell(Color.ANSI_YELLOW.getColor() + books[i].getAuthor().getName() + Color.ANSI_YELLOW.getColor(), numberCellStyle);
            table.addCell(Color.ANSI_PURPLE.getColor() + books[i].getYearPublished() + Color.ANSI_PURPLE.getColor(), numberCellStyle);
            table.addCell((books[i].getStatus() == Status.AVAILABLE) ? Color.ANSI_GREEN.getColor() + books[i].getStatus().toString() + Color.ANSI_GREEN.getColor() : Color.ANSI_RED.getColor() + books[i].getStatus().toString() + Color.ANSI_RED.getColor(), numberCellStyle);
        }
        System.out.println(table.render());
    }

    private void showAvailableBooks() {

        System.out.println("=================== AVAILABLE BOOKS INFO ====================");

        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle numberCellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

        table.addCell(Color.ANSI_BLUE.getColor() + "ID" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "TITLE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "AUTHOR" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "PUBLISH DATE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "STATUS" + Color.ANSI_BLUE.getColor(), numberCellStyle);

        table.setColumnWidth(0, 10, 15);
        table.setColumnWidth(1, 25, 60);
        table.setColumnWidth(2, 25, 60);
        table.setColumnWidth(3, 25, 25);
        table.setColumnWidth(4, 25, 25);

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getStatus() == Status.AVAILABLE) {
                table.addCell(Color.ANSI_BLUE.getColor() + String.valueOf(books[i].getId()) + Color.ANSI_BLUE.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_PINk.getColor() + books[i].getTitle() + Color.ANSI_BLUE.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_YELLOW.getColor() + books[i].getAuthor().getName() + Color.ANSI_YELLOW.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_PURPLE.getColor() + books[i].getYearPublished() + Color.ANSI_PURPLE.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_GREEN.getColor() + books[i].getStatus().toString() + Color.ANSI_GREEN.getColor(), numberCellStyle);
            }
        }
        System.out.println(table.render());
    }

    private void borrowBook() {

        System.out.println("=================== BORROW BOOK INFO ====================");

        System.out.print("=> Enter Book ID to Borrow : ");
        int bookId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == bookId) {
                if (books[i].getStatus() == Status.AVAILABLE) {
                    books[i].setStatus(Status.UNAVAILABLE);

                    System.out.println("Book ID: " + bookId);
                    System.out.println("Book Title: " + books[i].getTitle());
                    System.out.println("Book Author: " + books[i].getAuthor().getName());
                    System.out.println("Book Published Date: " + books[i].getYearPublished() + Color.ANSI_GREEN.getColor() + " is borrow successfully..." + Color.ANSI_RESET.getColor());
                } else {
                    System.out.println(Color.ANSI_RED.getColor() + "Book ID: " + bookId + " is failed to borrow!" + Color.ANSI_RESET.getColor());
                }
                return;
            }
        }
    }

    private void returnBook() {

        System.out.println("=================== RETURN BOOK INFO ====================");

        System.out.print("=> Enter Book ID to Return : ");
        int bookId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == bookId) {
                if (books[i].getStatus() == Status.UNAVAILABLE) {
                    books[i].setStatus(Status.AVAILABLE);

                    System.out.println("Book ID: " + bookId);
                    System.out.println("Book Title: " + books[i].getTitle());
                    System.out.println("Book Author: " + books[i].getAuthor().getName());
                    System.out.println("Book Published Date: " + books[i].getYearPublished() + Color.ANSI_GREEN.getColor() + " is returned successfully..." + Color.ANSI_RESET.getColor());

                } else {
                    System.out.println(Color.ANSI_RED.getColor() + "Book ID: " + bookId + " is failed to return!" + Color.ANSI_RESET.getColor());
                }
                return;
            }
        }
    }

    private void exit() {
        System.out.println(Color.ANSI_PINk.getColor() + "(^-^) Good bye! (^-^)" + Color.ANSI_RESET.getColor());
    }


    public Library(String name, String address, Date date) {

        this.name = name;
        this.address = address;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                '}';
    }
}