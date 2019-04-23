package files;

import static java.nio.file.StandardOpenOption.*;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

/**
 * Created by eljah32 on 4/23/2019.
 */
public class FileTest7 {
   static boolean read=false;

    public static void main(String[] args) {

        String fileName = UUID.randomUUID().toString();
        Path path = Paths.get("file2.txt");

        AsynchronousFileChannel fileChannel = null;
        try {
            fileChannel = AsynchronousFileChannel.open(
                    path, WRITE, CREATE
                    //, DELETE_ON_CLOSE
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello world".getBytes());
        buffer.flip();

        fileChannel.write(
                buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        System.out.format("%s result, %s attachment\n", result, attachment.asCharBuffer());
                        // result is number of bytes written
                        // attachment is the buffer
                    }
                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.format("%s result, %s attachment\n", exc.getMessage());
                    }
                });


        try {
            fileChannel
                    = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffer = ByteBuffer.allocate(1024);

        System.out.println("Starting reading file");

        //boolean read=false;

        fileChannel.read(
                buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        System.out.format("%s result, %s attachment\n", result, attachment.asCharBuffer());
                        // result is number of bytes read
                        // attachment is the buffer containing content
                        read=true;
                        System.out.println("Ending reading file");
                        String fileContent2 = new String(attachment.array()).trim();
                        System.out.println(fileContent2);
                    }
                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.format("%s result, %s attachment\n", exc.getMessage(), attachment.asCharBuffer());
                    }
                });

        while (!read)
        {
            System.out.println("Loop");
        }
    }
}
