package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by ladapodborska on 9/2/16.
 */
public interface IBash {

    // show file content
    String less(String path) throws FileNotFoundException;

    void writeInto(String path, String content) throws FileNotFoundException;

    void appendTo(String path, String content) throws FileNotFoundException;

    // show files in current directory
    List<String> ls(String currentDirPath);
    // use File
    // create new file
    boolean touch(String path);

    boolean delete(String path);

    boolean copy(String src, String dest);

    List<String> grep(String src, String keyWord);

    //shallow copy
    // use standard clone mechanism in java
    Object clone(Object obj);

    byte[] toByteArr(Object obj);

    Object fromByteArr(byte[] arr);

    // do deep copy via Java Serialization, use above methods
    Object cloneDeep(Object obj);

    void saveObjToFile(Object obj, String filePath);

    void downloadFile(String url, String localPathName);

    // implement recursive search (find in curr directory, then find in child dir, then repeat...)
    List<String> find(File dir, String keyWord);
}
