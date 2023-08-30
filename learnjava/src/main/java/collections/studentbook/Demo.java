package collections.studentbook;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        List<Student> studs = createStudents();

        var data = studs.stream()
                .flatMap(s -> s.getBooks()
                        .stream()
                        .map(b -> Pair.of(b, s)))
                .collect(Collectors.groupingBy(
                        Pair::getBook,
                        Collectors.mapping(p -> p.getStud().getFirstName(), Collectors.toList())));
        System.out.println("All books: " + data);

        // Use this instead of Pair
        //AbstractMap.SimpleEntry<Integer, Integer>;

        Optional<Student> hasMostBooks = createStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(s -> s.getBooks().size())));
        System.out.println("Has max book: " + hasMostBooks.get().getFirstName());

        System.out.println("-------------------------");
        List<List<Book>> booksInGroups = studs.stream().map(Student::getBooks).collect(Collectors.toList());
        List<Book> allBooksMerged = studs.stream().flatMap(s -> s.getBooks().stream()).collect(Collectors.toList());
    }

    private static List<Student> createStudents() {
        Book javaCompleteReference = new Book("Java Complete Reference");
        Book ocjp = new Book("Java OCJP");
        Book sql = new Book("SQL");
        Book spring = new Book("SPRING in Action");

        return List.of(
                new Student(1, "A", List.of(javaCompleteReference, spring)),
                new Student(2, "B", List.of(spring, sql, ocjp)),
                new Student(3, "C", List.of(javaCompleteReference, sql))
        );
    }
}
