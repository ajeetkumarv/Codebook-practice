package code.feature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesStringReadWrite {
    public static void main(String[] args) throws IOException {
        String file = "~/Learning/test.txt";
        String content = """
                This is line one
                This is line two
                123
                last line
                """;
        /* not working */
        Files.writeString(Paths.get(file), content, StandardOpenOption.CREATE_NEW);
        String readBack = Files.readString(Paths.get(file));

        System.out.println(readBack);
    }
}
