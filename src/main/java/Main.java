import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {public static void main(String[] args)
{
    List<Book> books = new ArrayList<>();
    books.add(new Book("The Shadow of The Wind", new Author("Carlos", "Zafon")));
    books.add(new Book("Neverwhere", new Author("Neil", "Gaiman")));
    books.add(new Book("Alchemist", new Author("Paulo", "Coelho")));
    books.add(new Book("Oscar and the Lady in Pink", new Author("Eric", "Schmitt")));
    books.add(new Book("Prelude to Foundation", new Author("Isaac", "Asimov")));
    books.add(new Book("Reaper Man", new Author("Terry", "Pratchett")));
    books.add(new Book("Blood of Elves: Witcher", new Author("Andrzej", "Sapkowski")));
    books.add(new Book("The Colour Of Magic", new Author("Terry", "Pratchett")));
    books.add(new Book("The Little Prince", new Author("Antoine", "De Saint-Exupéry")));
    books.add(new Book("One Flew Over the Cuckoo's Nest", new Author("Ken", "Kesey")));
    books.add(new Book("Hyperion", new Author("Dan", "Simmons")));
    books.add(new Book("Sandman: Overture", new Author("Neil", "Gaiman")));
    books.add(new Book("Antifragile", new Author("Nassim", "Taleb")));
    books.add(new Book("Forward the Foundation", new Author("Isaac", "Asimov")));
    books.add(new Book("Going Postal", new Author("Terry", "Pratchett")));

    System.out.println("Before sorting:");
    for (Book b : books)
    {
        System.out.println(b);
    }

    // Books sorting.
    List<Book> sortedBooks = books.stream()
            .sorted(Comparator.comparing((Book book) -> book.getAuthor().getLastname())
                    .thenComparing(book -> book.getAuthor().getFirstname())
                    .thenComparing(Book::getTitle))
            .toList();


    // Sorting and filtering in one stream.
    List<Book> sortedAndFilteredBooks = books.stream()
            .filter(book -> book.getAuthor().getLastname().startsWith("S"))
            .sorted(Comparator.comparing((Book book) -> book.getAuthor().getLastname())
                    .thenComparing(book -> book.getAuthor().getFirstname())
                    .thenComparing(Book::getTitle))
            .toList();

    // Listing unique authors.
    List<String> uniqueAuthors = books.stream()
            .map(book -> book.getAuthor().getFirstname() + " " + book.getAuthor().getLastname())
            .distinct()
            .sorted()
            .toList();

    // Displaying the results.
    System.out.println("\nSorted books:");
    sortedBooks.forEach(book -> System.out.println(book.getAuthor().getLastname()
            + " - " + book.getAuthor().getFirstname() + " - " + book.getTitle()));

    System.out.println("\nSorted and filtered books, for books whose author's last name begins with 'S':");
    sortedAndFilteredBooks.forEach(book -> System.out.println(book.getAuthor().getLastname()
            + " - " + book.getAuthor().getFirstname() +" - " + book.getTitle()));

    System.out.println("\nAll authors:");
    uniqueAuthors.forEach(System.out::println);
    }
}