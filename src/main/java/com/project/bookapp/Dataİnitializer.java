package com.project.bookapp;

import com.project.bookapp.entity.Book;
import com.project.bookapp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
class DataInitializer implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    private static final String BASE_URL = "http://10.10.224.179:8080";

    @Override
    public void run(String... args) {
        Book[] books = new Book[]{
                createBook("To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 7, 11), "9780446310789", "Fiction", true, BASE_URL + "/images/To%20Kill%20a%20Mockingbird.jpg"),
                createBook("1984", "George Orwell", LocalDate.of(1949, 6, 8), "9780451524935", "Science Fiction", true, BASE_URL + "/images/1984.jpg"),
                createBook("Pride and Prejudice", "Jane Austen", LocalDate.of(1813, 1, 28), "9780141439518", "Romance", true, BASE_URL + "/images/Pride%20and%20Prejudice.jpg"),
                createBook("The Great Gatsby", "F. Scott Fitzgerald", LocalDate.of(1925, 4, 10), "9780743273565", "Fiction", true, BASE_URL + "/images/The%20Great%20Gatsby.jpg"),
                createBook("One Hundred Years of Solitude", "Gabriel García Márquez", LocalDate.of(1967, 5, 30), "9780060883287", "Magic Realism", true, BASE_URL + "/images/One%20Hundred%20Years%20of%20Solitude.jpg"),
                createBook("Moby-Dick", "Herman Melville", LocalDate.of(1851, 10, 18), "9780142437247", "Adventure", true, BASE_URL + "/images/Moby-Dick.jpg"),
                createBook("The Catcher in the Rye", "J.D. Salinger", LocalDate.of(1951, 7, 16), "9780316769174", "Fiction", true, BASE_URL + "/images/The%20Catcher%20in%20the%20Rye.jpg"),
                createBook("Jane Eyre", "Charlotte Brontë", LocalDate.of(1847, 10, 16), "9780141441146", "Gothic Fiction", true, BASE_URL + "/images/Jane%20Eyre.jpg"),
                createBook("The Hobbit", "J.R.R. Tolkien", LocalDate.of(1937, 9, 21), "9780547928227", "Fantasy", true, BASE_URL + "/images/The%20Hobbit.jpg"),
                createBook("Brave New World", "Aldous Huxley", LocalDate.of(1932, 6, 1), "9780060850524", "Science Fiction", true, BASE_URL + "/images/Brave%20New%20World.jpg"),
                createBook("The Alchemist", "Paulo Coelho", LocalDate.of(1988, 1, 1), "9780062315007", "Fiction", true, BASE_URL + "/images/The%20Alchemist.jpg"),
                createBook("The Little Prince", "Antoine de Saint-Exupéry", LocalDate.of(1943, 4, 6), "9780156012195", "Children's Literature", true, BASE_URL + "/images/The%20Little%20Prince.jpg"),
                createBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", LocalDate.of(1979, 10, 12), "9780345391803", "Science Fiction", true, BASE_URL + "/images/The%20Hitchhiker's%20Guide%20to%20the%20Galaxy.jpg"),
                createBook("Fahrenheit 451", "Ray Bradbury", LocalDate.of(1953, 10, 19), "9781451673319", "Dystopian Fiction", false, BASE_URL + "/images/Fahrenheit%20451.jpg"),
                createBook("The Lord of the Rings", "J.R.R. Tolkien", LocalDate.of(1954, 7, 29), "9780618640157", "Fantasy", false, BASE_URL + "/images/The%20Lord%20of%20the%20Rings.jpg"),
                createBook("Crime and Punishment", "Fyodor Dostoevsky", LocalDate.of(1866, 1, 1), "9780140449136", "Psychological Fiction", true, BASE_URL + "/images/Crime%20and%20Punishment.jpg"),
                createBook("The Chronicles of Narnia", "C.S. Lewis", LocalDate.of(1950, 10, 16), "9780066238500", "Fantasy", true, BASE_URL + "/images/The%20Chronicles%20of%20Narnia.jpg"),
                createBook("The Grapes of Wrath", "John Steinbeck", LocalDate.of(1939, 4, 14), "9780143039433", "Fiction", true, BASE_URL + "/images/The%20Grapes%20of%20Wrath.jpg"),
                createBook("Wuthering Heights", "Emily Brontë", LocalDate.of(1847, 12, 1), "9780141439556", "Gothic Fiction", true, BASE_URL + "/images/Wuthering%20Heights.jpg"),
                createBook("The Da Vinci Code", "Dan Brown", LocalDate.of(2003, 3, 18), "9780307474278", "Thriller", true, BASE_URL + "/images/The%20Da%20Vinci%20Code.jpg"),
                createBook("The Catcher in the Rye", "J.D. Salinger", LocalDate.of(1951, 7, 16), "9780316769179", "Fiction", false, BASE_URL + "/images/The%20Catcher%20in%20the%20Rye.jpg"),
                createBook("Les Misérables", "Victor Hugo", LocalDate.of(1862, 1, 1), "9780451472000", "Historical Fiction", true, BASE_URL + "/images/LesMiserables.jpeg"),
                createBook("The Picture of Dorian Gray", "Oscar Wilde", LocalDate.of(1890, 1, 1), "9780141439570", "Philosophical Fiction", true, BASE_URL + "/images/The%20Picture%20of%20Dorian%20Gray.jpg"),
                createBook("War and Peace", "Leo Tolstoy", LocalDate.of(1869, 1, 1), "9780199232765", "Historical Fiction", false, BASE_URL + "/images/War%20and%20Peace.jpg"),
                createBook("The Brothers Karamazov", "Fyodor Dostoevsky", LocalDate.of(1880, 1, 1), "9780140449242", "Philosophical Fiction", true, BASE_URL + "/images/The%20Brothers%20Karamazov.jpg"),
                createBook("Anna Karenina", "Leo Tolstoy", LocalDate.of(1878, 1, 1), "9780199233656", "Historical Fiction", true, BASE_URL + "/images/Anna%20Karenina.jpg"),
                createBook("The Sound and the Fury", "William Faulkner", LocalDate.of(1929, 1, 1), "9780679732242", "Southern Gothic", true, BASE_URL + "/images/The%20Sound%20and%20the%20Fury.jpg"),
                createBook("The Bell Jar", "Sylvia Plath", LocalDate.of(1963, 1, 1), "9780060831953", "Fiction", true, BASE_URL + "/images/The%20Bell%20Jar.jpg"),
                createBook("A Tale of Two Cities", "Charles Dickens", LocalDate.of(1859, 1, 1), "9780192544528", "Historical Fiction", true, BASE_URL + "/images/A%20Tale%20of%20Two%20Cities.jpg"),
                createBook("The Old Man and the Sea", "Ernest Hemingway", LocalDate.of(1952, 1, 1), "9780684801223", "Fiction", false, BASE_URL + "/images/The%20Old%20Man%20and%20the%20Sea.jpg"),
                createBook("The Kite Runner", "Khaled Hosseini", LocalDate.of(2003, 5, 29), "9781594631931", "Historical Fiction", true, BASE_URL + "/images/The%20Kite%20Runner.jpg"),
                createBook("The Fault in Our Stars", "John Green", LocalDate.of(2012, 1, 1), "9780525478812", "Young Adult", false, BASE_URL + "/images/The%20Fault%20in%20Our%20Stars.jpg"),
                createBook("Animal Farm", "George Orwell", LocalDate.of(1945, 8, 17), "978-0451526342", "Fiction", true, BASE_URL + "/images/Animal%20Farm.jpeg"),
                createBook("The Book Thief", "Markus Zusak", LocalDate.of(2005, 1, 1), "9780375831003", "Historical Fiction", true, BASE_URL + "/images/The%20Book%20Thief.jpg"),
                createBook("The Night Circus", "Erin Morgenstern", LocalDate.of(2011, 9, 13), "9780385534635", "Fantasy", true, BASE_URL + "/images/The%20Night%20Circus.jpg"),
                createBook("The Immortal Life of Henrietta Lacks", "Rebecca Skloot", LocalDate.of(2010, 2, 2), "9781400052189", "Biography", true, BASE_URL + "/images/The%20Immortal%20Life%20of%20Henrietta%20Lacks.jpg"),
                createBook("Atomic Habits", "James Clear", LocalDate.of(2018, 10, 16), "9780735211292", "Self-Help", true, BASE_URL + "/images/Atomic%20Habits.jpg"),
                createBook("The Power of Now", "Eckhart Tolle", LocalDate.of(1997, 1, 1), "9781577314806", "Self-Help", true, BASE_URL + "/images/The%20Power%20of%20Now.jpg"),
                createBook("Think and Grow Rich", "Napoleon Hill", LocalDate.of(1937, 1, 1), "9781585424337", "Self-Help", true, BASE_URL + "/images/Think%20and%20Grow%20Rich.jpg"),
                createBook("The 7 Habits of Highly Effective People", "Stephen R. Covey", LocalDate.of(1989, 8, 15), "9780743269513", "Self-Help", true, BASE_URL + "/images/The%207%20Habits%20of%20Highly%20Effective%20People.jpg"),
                createBook("How to Win Friends and Influence People", "Dale Carnegie", LocalDate.of(1936, 10, 1), "9780671027032", "Self-Help", true, BASE_URL + "/images/How%20to%20Win%20Friends%20and%20Influence%20People.jpg"),
                createBook("The Subtle Art of Not Giving a F*ck", "Mark Manson", LocalDate.of(2016, 9, 13), "9780062457714", "Self-Help", true, BASE_URL + "/images/The%20Subtle%20Art%20of%20Not%20Giving%20a%20F*ck.jpg"),
                createBook("You Are a Badass", "Jen Sincero", LocalDate.of(2013, 4, 23), "9780762447695", "Self-Help", true, BASE_URL + "/images/You%20Are%20a%20Badass.jpg"),
                createBook("Awaken the Giant Within", "Tony Robbins", LocalDate.of(1991, 11, 1), "9780671791544", "Self-Help", true, BASE_URL + "/images/Awaken%20the%20Giant%20Within.jpg"),
                createBook("The Power of Your Subconscious Mind", "Joseph Murphy", LocalDate.of(1963, 1, 1), "9780735201255", "Self-Help", true, BASE_URL + "/images/The%20Power%20of%20Your%20Subconscious%20Mind.jpg"),
                createBook("The Secret", "Rhonda Byrne", LocalDate.of(2006, 11, 26), "9781582701707", "Self-Help", true, BASE_URL + "/images/The%20Secret.jpg"),
                createBook("Unlimited Power", "Tony Robbins", LocalDate.of(1986, 1, 1), "9780743409391", "Self-Help", true, BASE_URL + "/images/Unlimited%20Power.jpg"),
                createBook("Çalıkuşu", "Reşat Nuri Güntekin", LocalDate.of(1922, 1, 1), "9789750744017", "Fiction", true, BASE_URL + "/images/Çalıkuşu.jpg"),
                createBook("Ateşten Gömlek", "Halide Edib Adıvar", LocalDate.of(1923, 1, 1), "9789751420396", "Fiction", true, BASE_URL + "/images/AteştenGömlek.jpg"),
                createBook("Beyaz Zambaklar Ülkesinde", "Grigory Petrov", LocalDate.of(1929, 1, 1), "9789758708594", "Fiction", true, BASE_URL + "/images/BeyazZambaklarÜlkesinde.jpg"),
                createBook("Kürk Mantolu Madonna", "Sabahattin Ali", LocalDate.of(1943, 1, 1), "9786052971718", "Fiction", true, BASE_URL + "/images/KürkMantoluMadonna.jpg"),
                createBook("Aşk ve Gurur", "Jane Austen", LocalDate.of(1813, 1, 28), "9786050412652", "Fiction", true, BASE_URL + "/images/AşkveGurur.jpg"),
                createBook("Bülbülü Öldürmek", "Harper Lee", LocalDate.of(1960, 7, 11), "9789750730470", "Fiction", true, BASE_URL + "/images/BülbülüÖldürmek.jpg"),
                createBook("Fareler ve İnsanlar", "John Steinbeck", LocalDate.of(1937, 1, 1), "9780142000670", "Fiction", true, BASE_URL + "/images/Farelerveİnsanlar.jpg"),


        };

        bookRepository.saveAll(Arrays.asList(books));
    }

    private Book createBook(String title, String author, LocalDate publishedDate, String isbn, String category, boolean available, String coverImage) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(publishedDate);
        book.setIsbn(isbn);
        book.setCategory(category);
        book.setAvailable(available);
        book.setCoverImage(coverImage);
        return book;
    }
}
