package code.otherrepo.collections.studentbook;

import java.util.List;

public class Student {
    private Integer id;
    private String firstName;
    private List<Book> books;

    public Student(Integer id, String firstName, List<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Book> getBooks() {
        return books;
    }
}
