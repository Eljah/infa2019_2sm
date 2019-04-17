package files;

import sun.nio.ch.DirectBuffer;

import java.io.File;
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
        String filename = "example4.txt";
        Path pathToFile = Paths.get(filename);

        //CharBuffer charBuffer = null;

        CharBuffer charBuffer = CharBuffer
                .wrap("This will be written to the file");

//        if (!Files.exists(pathToFile)) {
//            Files.createFile(pathToFile);
//        }

        File file = new File(filename);
        if (file.createNewFile()) {
            System.out.println(filename + " File Created");
        } else System.out.println("File " + filename + " already exists");

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
            //fileChannel.close();
            unmap(mappedByteBuffer);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                pathToFile, EnumSet.of(StandardOpenOption.READ))) {

            MappedByteBuffer mappedByteBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            if (mappedByteBuffer != null) {
                charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            }

            System.out.println(charBuffer.toString());
            //fileChannel.close();
            unmap(mappedByteBuffer);
        }

        long fileSize = 0;
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                pathToFile, EnumSet.of(StandardOpenOption.READ))) {

            fileSize = fileChannel.size();
            System.out.format("File size is %d", fileSize);
            //fileChannel.close();
        }

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                pathToFile, EnumSet.of(StandardOpenOption.READ))) {

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long fileSizeNew = fileChannel.size();
            System.out.format("New file size is %d", fileSizeNew);
            MappedByteBuffer mappedByteBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, fileSize, fileSizeNew - fileSize);

            if (mappedByteBuffer != null) {
                charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
                System.out.println(charBuffer.position());
                System.out.println(charBuffer.hasRemaining());
                //if (charBuffer.hasRemaining()) {
                System.out.println();
                System.out.format("Another process wrote: %s", charBuffer.toString());
                //}
            }
            fileSize = fileChannel.size();
            unmap(mappedByteBuffer);
        }
    }

    public static void unmap(MappedByteBuffer buffer) {
        sun.misc.Cleaner cleaner = ((DirectBuffer) buffer).cleaner();
        cleaner.clean();
    }
}
