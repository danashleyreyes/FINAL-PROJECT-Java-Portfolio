import java.util.Scanner;

public class Lab1JavaReview {

    static Scanner scnr = new Scanner(System.in);

    static String[] books = new String[5];
    static boolean[] isAvailable = new boolean[5];
    static int bookCount = 0;

    public static void main(String[] args) {
        System.out.println("\nCAMPUS LIBRARY MANAGEMENT SYSTEM\n"); 
        while (true) {
                       
            System.out.println("\nPlease select:\n");
            System.out.println("1. Add book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------------");
            System.out.print("Please enter a number (1-5): ");
            String choice = scnr.nextLine();
            try {
                int option = Integer.parseInt(choice);

                switch (option) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        updateBookStatus();
                        break;
                    case 3:
                        showBooks();
                        break;
                    case 4:
                        generateReport();
                        break;
                    case 5:
                        exitProgram();
                        return;
                    default:
                        System.out.println("Invalid input. Please select 1-5 only.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number 1-5 only.");
                }
                }
                }
               public static void addBook() {
    int filledIndex = 0;
    for (int i = 0; i < books.length; i++) {
        if (books[i] != null) {
            filledIndex++;
        }
    }
    if (filledIndex == books.length) {
        System.out.println("\n-----------------------------------------");
        System.out.println(" Bookshelf is full. ");
        System.out.println("-----------------------------------------\n");
        return;
    }

    System.out.print("Enter the title of the new book: ");
    String title = scnr.nextLine().trim();

    if (title.isEmpty()) {
        System.out.println("The book title cannot be empty.");
        return;
    }

    for (int i = 0; i < books.length; i++) {
        if (books[i] == null) { 
            books[i] = title;
             isAvailable[i] = true; 
             bookCount++;
            System.out.println("\n-----------------------------------------");
            System.out.println(" Book \"" + title + "\" added successfully.");
            System.out.println(" Status: Available");
            System.out.println("-----------------------------------------\n");
            break; 
        }
    }
}

 public static void updateBookStatus() {
        if (bookCount == 0) {
            System.out.println("No books have been added yet.");
            return;
        }

        showBooks();
        System.out.print("Enter the book number you want to update: ");
        String input = scnr.nextLine();

        try {
            int bookNum = Integer.parseInt(input);

            if (bookNum < 1 || bookNum > bookCount) {
                System.out.println("Invalid book number.");
                return;
            }

            int index = bookNum - 1;
            if (isAvailable[index]) {
                isAvailable[index] = false;
                System.out.println("The book \"" + books[index] + "\" is now marked as Borrowed.");
            } else {
                isAvailable[index] = true;
                System.out.println("The book \"" + books[index] + "\" is now marked as Available.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nList of Books:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + books[i] + " - " + (isAvailable[i] ? "Available" : "Borrowed"));
        }
    }

    public static void generateReport() {
        if (bookCount == 0) {
            System.out.println("No books have been registered yet.");
            return;
        }

        int availableCount = 0, borrowedCount = 0;
        for (int i = 0; i < bookCount; i++) {
            if (isAvailable[i]) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("\nLibrary Report:");
        System.out.println("Total number of books registered: " + bookCount);
        System.out.println("Total number of books Available: " + availableCount);
        System.out.println("Total number of books Borrowed: " + borrowedCount);
    }

    public static void exitProgram() {
        System.out.println("Thanks a lot for using the Library Book Management System.");
        System.out.println("Bye!");
    }
}
