package files;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 * Created by eljah32 on 4/17/2019.
 */
public class FileTest3 {
    public static void main(String[] args) throws IOException {
        String filename="example4.txt";
        Path pathToFile= Paths.get(filename);

        //CharBuffer charBuffer = null;

        CharBuffer charBuffer = CharBuffer
                .wrap("This will be written to the file");

        if (!Files.exists(pathToFile)) {
            Files.createFile(pathToFile);
        }

        try (FileChannel fileChannel = (FileChannel) Files
                .newByteChannel(pathToFile, EnumSet.of(
                        StandardOpenOption.READ,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.TRUNCATE_EXISTING))) {

            MappedByteBuffer mappedByteBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_WRITE, 0, charBuffer.length());

            if (mappedByteBuffer != null) {
                mappedByteBuffer.put(
                        Charset.forName("utf-8").encode(charBuffer));
            }
        }

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                pathToFile, EnumSet.of(StandardOpenOption.READ))) {

            MappedByteBuffer mappedByteBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            if (mappedByteBuffer != null) {
                charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            }

            System.out.println(charBuffer.toString());
        }


    }
}
