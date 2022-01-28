package code.example.studentbook;

public class Book {
    private String title;
    private String id;
    private Integer pages;

    public Book(String title, String id, Integer pages) {
        this.title = title;
        this.id = id;
        this.pages = pages;
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return title;
    }


}
