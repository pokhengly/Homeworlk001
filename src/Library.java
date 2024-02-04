import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Date;
import java.util.Scanner;

// Library class
public class Library {

    // fields
    private final Scanner scanner = new Scanner(System.in);
    private String name;
    private String address;
    private Date date;
    private int bookCount;
    private Book[] books = new Book[100];

    // Set Up Library method
    public void setUpLibrary() {

        System.out.println("=================== SET UP LIBRARY ====================");
        System.out.print("=> Enter Library's Name: ");
        name = scanner.nextLine();
        System.out.print("=> Enter Library's Address: ");
        address = scanner.nextLine();

        // Create a new Date object
        date = new Date();
        System.out.print(Color.ANSI_BLUE.getColor() + "\"" + name + "\"" + " Library is already created in " + "\"" + address + "\"" + " address successfully on " + date + Color.ANSI_RESET.getColor());
    }
    // End of the setUpLibrary method

    // Display Menu method
    public void displayMenu() {

        int option;

        // Display the menu
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
    // End of the displayMenu method

    // Default constructor
    public Library() {
        // Create 6 authors
        Author author1 = new Author("J.K. Rowling", "1965-");
        Author author2 = new Author("George Orwell", "1903-1950");
        Author author3 = new Author("Harper Lee", "1926-2016");
        Author author4 = new Author("J.R.R. Tolkien", "1892-1973");
        Author author5 = new Author("Agatha Christie", "1890-1976");
        Author author6 = new Author("F. Scott Fitzgerald", "1896-1940");

        // Create 6 books
        books[0] = new Book(1, "Harry Potter and the Sorcerer's Stone", author1, "1997", Status.UNAVAILABLE);
        books[1] = new Book(2, "1984", author2, "1949", Status.AVAILABLE);
        books[2] = new Book(3, "To Kill a Mockingbird", author3, "1960", Status.AVAILABLE);
        books[3] = new Book(4, "The Hobbit", author4, "1937", Status.AVAILABLE);
        books[4] = new Book(5, "Murder on the Orient Express", author5, "1934", Status.AVAILABLE);
        books[5] = new Book(6, "The Great Gatsby", author6, "1925", Status.AVAILABLE);

        bookCount = 6;
    }
    // End of Default constructor

    // addBook method
    private void addBook() {

        String bookName;
        String authorName;
        String authorYearActive;
        String publishedYear;

        System.out.println("=================== ADD BOOK INFO ====================");
        System.out.print("=> Enter Book's Name : ");
        bookName = scanner.nextLine();

        // Use regex to  check if bookName contains only characters
        while (!bookName.matches("^[a-zA-Z ]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Book Name should contain only characters." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Book's Name: ");
            bookName = scanner.nextLine();
        }
        // end of while loop

        System.out.print("=> Enter Book's Author Name : ");
        authorName = scanner.nextLine();

        // Use regex to check if authorName contains only characters
        while (!authorName.matches("^[a-zA-Z ]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Author Name should contain only characters." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Book's Author Name: ");
            authorName = scanner.nextLine();
        }
        // end of the while loop

        System.out.print("=> Enter Author Year Active : ");
        authorYearActive = scanner.nextLine();

        // Use regex to check if authorYearActive contains only characters
        while (!authorYearActive.matches("^[a-zA-Z0-9 ]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Author Year Active should contain only characters and numbers." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Author Year Active: ");
            authorYearActive = scanner.nextLine();
        }
        // end of the while loop

        System.out.print("=> Enter Published Year : ");
        publishedYear = scanner.nextLine();

        // Use regex to check if publishedYear contains only numbers
        while (!publishedYear.matches("^[0-9]+$")) {
            System.out.println(Color.ANSI_RED.getColor() + "Invalid input! Published Year should contain only numbers." + Color.ANSI_RESET.getColor());
            System.out.print("=> Enter Published Year: ");
            publishedYear = scanner.nextLine();
        }
        // end of the while loop

        // Create a new Author object
        Author author = new Author(authorName, authorYearActive);

        // Add the new book to the books array
        books[bookCount] = new Book(bookCount + 1, bookName, author, publishedYear, Status.AVAILABLE);
        bookCount++;

        // Print a message
        System.out.println(Color.ANSI_GREEN.getColor() + "Book is added successfully..." + Color.ANSI_RESET.getColor());
    }

    // Show All Books method
    private void showAllBooks() {

        System.out.println("=================== ALL BOOKS INFO ====================");

        // Create a table with 5 columns
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle numberCellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

        // Add cells to the table
        table.addCell(Color.ANSI_BLUE.getColor() + "ID" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "TITLE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "AUTHOR" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "PUBLISH DATE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "STATUS" + Color.ANSI_BLUE.getColor(), numberCellStyle);

        // Set the width of the columns
        table.setColumnWidth(0, 10, 15);
        table.setColumnWidth(1, 25, 60);
        table.setColumnWidth(2, 25, 60);
        table.setColumnWidth(3, 25, 25);
        table.setColumnWidth(4, 25, 25);

        // Add data to the table
        for (int i = 0; i < bookCount; i++) {
            table.addCell(Color.ANSI_BLUE.getColor() + String.valueOf(books[i].getId()) + Color.ANSI_BLUE.getColor(), numberCellStyle);
            table.addCell(Color.ANSI_PINk.getColor() + books[i].getTitle() + Color.ANSI_BLUE.getColor(), numberCellStyle);
            table.addCell(Color.ANSI_YELLOW.getColor() + books[i].getAuthor().getName() + Color.ANSI_YELLOW.getColor(), numberCellStyle);
            table.addCell(Color.ANSI_PURPLE.getColor() + books[i].getYearPublished() + Color.ANSI_PURPLE.getColor(), numberCellStyle);
            table.addCell((books[i].getStatus() == Status.AVAILABLE) ? Color.ANSI_GREEN.getColor() + books[i].getStatus().toString() + Color.ANSI_GREEN.getColor() : Color.ANSI_RED.getColor() + books[i].getStatus().toString() + Color.ANSI_RED.getColor(), numberCellStyle);
        }
        // end of the for loop

        System.out.println(table.render());
    }
    // End of the showAllBooks method

    // Show Available Books method
    private void showAvailableBooks() {

        System.out.println("=================== AVAILABLE BOOKS INFO ====================");

        // Create a table with 5 columns
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle numberCellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

        // Add cells to the table
        table.addCell(Color.ANSI_BLUE.getColor() + "ID" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "TITLE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "AUTHOR" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "PUBLISH DATE" + Color.ANSI_BLUE.getColor(), numberCellStyle);
        table.addCell(Color.ANSI_BLUE.getColor() + "STATUS" + Color.ANSI_BLUE.getColor(), numberCellStyle);

        // Set the width of the columns
        table.setColumnWidth(0, 10, 15);
        table.setColumnWidth(1, 25, 60);
        table.setColumnWidth(2, 25, 60);
        table.setColumnWidth(3, 25, 25);
        table.setColumnWidth(4, 25, 25);

        // Add data to the table
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getStatus() == Status.AVAILABLE) {
                table.addCell(Color.ANSI_BLUE.getColor() + String.valueOf(books[i].getId()) + Color.ANSI_BLUE.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_PINk.getColor() + books[i].getTitle() + Color.ANSI_BLUE.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_YELLOW.getColor() + books[i].getAuthor().getName() + Color.ANSI_YELLOW.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_PURPLE.getColor() + books[i].getYearPublished() + Color.ANSI_PURPLE.getColor(), numberCellStyle);
                table.addCell(Color.ANSI_GREEN.getColor() + books[i].getStatus().toString() + Color.ANSI_GREEN.getColor(), numberCellStyle);
            }
        }
        // end of the for loop

        System.out.println(table.render());
    }
    // End of the showAvailableBooks method

    // Borrow Book method
    private void borrowBook() {

        System.out.println("=================== BORROW BOOK INFO ====================");
        System.out.print("=> Enter Book ID to Borrow : ");
        int bookId = Integer.parseInt(scanner.nextLine());

        // Check if the book is available
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
        // end of the for loop
    }
    // End of the borrowBook method

    // Return Book method
    private void returnBook() {

        System.out.println("=================== RETURN BOOK INFO ====================");
        System.out.print("=> Enter Book ID to Return : ");
        int bookId = Integer.parseInt(scanner.nextLine());

        // Check if the book is available
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
        // end of the for loop
    }
    // End of the returnBook method

    // Exit method
    private void exit() {
        System.out.println(Color.ANSI_PINk.getColor() + "(^-^) Good bye! (^-^)" + Color.ANSI_RESET.getColor());
    }
    // End of the exit method

    // Constructor
    public Library(String name, String address, Date date) {
        this.name = name;
        this.address = address;
        this.date = date;
    }

    // Getters and Setters methods
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

    // toString method
    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                '}';
    }
}
// End of the Library class
