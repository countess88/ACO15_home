package week4;

import javafx.stage.DirectoryChooser;

import javax.naming.spi.DirectoryManager;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ladapodborska on 9/2/16.
 */
public class IBashImpl implements IBash {
    @Override
    public String less(String path) throws FileNotFoundException {
        Reader reader = new FileReader(path);
        String res = "";

        try {
            int singleCharCode = -1;

            while ((singleCharCode = reader.read()) != -1) {
                res += (char) singleCharCode;
            }

            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public void writeInto(String path, String content) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void appendTo(String path, String content) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(path, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bufferedWriter)) {

            out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> ls(String currentDirPath) {

        File directory = new File(currentDirPath);

        List<String> directoryContent = new ArrayList<>();
        String[] listOfFiles = directory.list();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i] != null) {
                directoryContent.add(listOfFiles[i]);
            }
        }
        return directoryContent;
    }

    @Override
    public boolean touch(String path) {

        File file = new File(path);

        try {
            FileOutputStream fos = new FileOutputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!file.exists()) {

            try {

                return file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(String path) {

        try {

            File file = new File(path);

            if (file.delete()) {
                System.out.println(file.getName() + " was deleted!");

            } else {
                System.out.println("Delete operation was failed.");
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean copy(String src, String dest) {

        FileChannel inputChannel = null;
        FileChannel outputChannel = null;

        try {
            inputChannel = new FileInputStream(src).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();

            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<String> grep(String src, String keyWord) {

        StringReader stringReader = new StringReader(src);
        LineNumberReader lineNumberReader = new LineNumberReader(stringReader);


        return null;
    }

    @Override
    public Object clone(Object obj) {
        return null;
    }

    @Override
    public byte[] toByteArr(Object obj) {
        return new byte[0];
    }

    @Override
    public Object fromByteArr(byte[] arr) {
        return null;
    }

    @Override
    public Object cloneDeep(Object obj) {
        return null;
    }

    @Override
    public void saveObjToFile(Object obj, String filePath) {

    }

    @Override
    public void downloadFile(String url, String localPathName) {

    }

    @Override
    public List<String> find(File dir, String keyWord) {
        return null;
    }
}
