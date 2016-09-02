package week4;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ladapodborska on 9/2/16.
 */
public class IBashImplV2 implements IBash{
    @Override
    public String less(String path) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();

        try {
            String line = null;
            while((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
    public void writeInto(String path, String content) throws FileNotFoundException {

    }

    @Override
    public void appendTo(String path, String content) throws FileNotFoundException {

    }

    @Override
    public List<String> ls(String currentDirPath) {
        return null;
    }

    @Override
    public boolean touch(String path) {
        return false;
    }

    @Override
    public boolean delete(String path) {
        return false;
    }

    @Override
    public boolean copy(String src, String dest) {
        return false;
    }

    @Override
    public List<String> grep(String src, String keyWord) {


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
