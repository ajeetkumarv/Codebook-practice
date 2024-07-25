package code.otherrepo.migratetofunctionaljava;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file);

        File[] children = file.listFiles();

        //Imperative style of coding of concat file using delimiter comma
        //and struggling with cases like String immutibility, null, empty, remove last comma
        //damn
        if (children != null) {
            for (File child: children) {
                System.out.print(child.getName().toUpperCase() + ", ");
            }
        }

        System.out.println("\n---USING JAVA 8 JOINING----");
        //Arrays.stream(children) OR
        if (children != null) {
           String fileNamesCsv = Stream.of(children)
                    .map(File::getName)
                    .map(String::toUpperCase)
                    .collect(Collectors.joining(","));

            System.out.println(fileNamesCsv);
        }

    }

}
