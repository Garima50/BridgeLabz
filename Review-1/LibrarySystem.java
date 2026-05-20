
// Question:
// 4) Create a library system with:
// A Book class (Title, Author, ISBN, Availability).
// A LibraryMember class (Name, MemberID, BorrowedBooks).
// A Librarian class (IssueBook, ReturnBook).
// Implement a borrow limit for different member types (e.g., StudentMember can borrow up to 5 books, FacultyMember can borrow 10 books).






class Book {

    private String title;
    private String author;
    private int ISBN;
    protected boolean availability;

    public Book(String title, String author, int ISBN, boolean availability) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availability = availability;
    }

    public String gettitle() {
        return title;
    }

    public String getauthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean getavailability() {
        return availability;
    }
}


interface borrow {

    // DESIGN ISSUE:
    // Passing type as parameter is weak design.

    // Better:
    // int borrowlimit();

    public int borrowlimit(String type);
}


class LibraryMember implements borrow {

    private int ID;
    private String name;
    private String type;

    // DESIGN ISSUE:
    // One member can only borrow one book here.

    // Better:
    // Book[] borrowedBooks;

    protected Book borrowedBook;


    // ERROR CODE (not needed)
    /*
    public LibraryMember(String title, String author, int ISBN, boolean availability) {
        super(title, author, ISBN, availability);
    }
    */

    // Problem:
    // LibraryMember does not extend Book,
    // so super() is invalid here.


    public LibraryMember(int ID, String name, String type, Book borrowedBook) {

        this.ID = ID;
        this.name = name;
        this.type = type;
        this.borrowedBook = borrowedBook;
    }


    @Override
    public int borrowlimit(String type) {

        int limit = 1;

        if(type.contentEquals("Student")) {

            limit = 5;
        }

        else if(type.contentEquals("Teacher")) {

            limit = 10;
        }

        return limit;
    }
}



// ERROR:
// class Librarian extends Book implements borrow

// Problems:
// 1. Librarian IS NOT a Book
// 2. Librarian does not need borrow interface

// CORRECT:
class Librarian {

    // ERROR CODE
    /*
    public Librarian(String title, String author, int ISBN, boolean availability) {
        super(title, author, ISBN, availability);
    }
    */

    // Problem:
    // Since Librarian no longer extends Book,
    // super() constructor is invalid.


    public void issueBook(Book b) {

        if(b.availability == true) {

            b.availability = false;

            System.out.println("Book issued");
        }

        else {

            System.out.println("Book unavailable");
        }
    }


    public void returnBook(Book b) {

        b.availability = true;

        System.out.println("Book returned");
    }
}




public class LibrarySystem {

    public static void main(String[] args) {

        Book b1 = new Book("The Encyclopedia", "ABC", 1234, true);

        Book b2 = new Book("The Atlas", "DEF", 4321, false);


        LibraryMember l1 =
                new LibraryMember(1, "Chris", "Student", b1);

        LibraryMember l2 =
                new LibraryMember(2, "Jia", "Teacher", b2);


        int a = l1.borrowlimit("Student");

        System.out.println("Borrow limit = " + a);


        Librarian lib = new Librarian();
        lib.issueBook(b1);
    }
}