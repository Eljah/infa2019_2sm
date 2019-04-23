package files;

import java.io.*;

/**
 * Created by eljah32 on 4/23/2019.
 */
public class FileTest5 {
    public static void main(String[] args) throws IOException {
        String toWrite = "Hello";
        File tmpFile = File.createTempFile("test", ".tmp");
        System.out.println(tmpFile.getAbsolutePath());
        FileWriter writer = new FileWriter(tmpFile);
        writer.write(toWrite);
        writer.close();
        BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
        reader.close();
    }
}
