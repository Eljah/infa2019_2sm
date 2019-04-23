package files;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by eljah32 on 4/23/2019.
 */
public class FileTest6 {
    public static void main(String[] args) {

        //Path path2 = Paths.get(
        //        URI.create(FileTest6.class.getClassLoader().getResource("file.txt").toString()));
        Path path = Paths.get("file.txt");

        AsynchronousFileChannel fileChannel = null;
        try {
            fileChannel = AsynchronousFileChannel.open(
                    path, StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Future<Integer> operation = fileChannel.read(buffer, 0);

        while (!operation.isDone())
        {
            System.out.println("Output!");
        }
        // run other code as operation continues in background
        try {
            operation.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String fileContent = new String(buffer.array()).trim();
        buffer.clear();

        AsynchronousFileChannel fileChannel2 = null;
        try {
            fileChannel2 = AsynchronousFileChannel.open(
                    path, StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer buffer2 = ByteBuffer.allocate(1024);

        Future<Integer> operation2 = fileChannel.read(buffer2, 0);

        while (!operation2.isDone())
        {
            System.out.println("Output2!");
        }

        // run other code as operation continues in background
        try {
            operation2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String fileContent2 = new String(buffer2.array()).trim();
        buffer2.clear();
        System.out.println(fileContent2);
    }
}
