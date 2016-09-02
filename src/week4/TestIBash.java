package week4;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by ladapodborska on 9/2/16.
 */
public class TestIBash {
    public static final String FILE_PATH = "//Users/ladapodborska/lada.txt";
    public static final String PATH_FOR_DIRECTORIES = "//Users/ladapodborska";

    public static void main(String[] args) {
        IBash iBash = new IBashImpl();

        //less method
        try {

            byte[] arr = Files.readAllBytes(new File(FILE_PATH).toPath());
            String expected = new String(arr);

            String actual =
                    iBash.less(FILE_PATH);

            System.out.printf("result %s", expected.equals(actual));
            System.out.println(actual);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //appendTo method
        try {
            iBash.appendTo(FILE_PATH, "dadada");

            String result = iBash.less(FILE_PATH);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //writeInto method
        try {
            iBash.writeInto(FILE_PATH, "new text");

            String res = iBash.less(FILE_PATH);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //ls method
        String directoryContent = iBash.ls(PATH_FOR_DIRECTORIES).toString();
        System.out.println(directoryContent);

        //touch method
        iBash.touch("//Users/ladapodborska/danya.txt");

        //delete method
        iBash.delete("//Users/ladapodborska/danya.txt");

        //copy method
        iBash.copy(FILE_PATH, "//Users/ladapodborska/lada1.txt");

    }
}