package collections.studentbook;

class Pair {
    Book book;
    Student stud;

    private Pair(Book book, Student stud) {
        this.book = book;
        this.stud = stud;
    }

    static Pair of(Book book, Student stud) {
        return new Pair(book, stud);
    }

    public Book getBook() {
        return book;
    }

    public Student getStud() {
        return stud;
    }
}
