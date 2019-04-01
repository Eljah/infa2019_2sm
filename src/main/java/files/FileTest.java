package files;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by eljah32 on 4/1/2019.
 */
public class FileTest {
    public static void main(String[] args) {
        //File file=new File("test.txt");
        //File file=new File("file:/test.txt");
        File file= null;
        try {
            file = new File(new URI("file:/D:/Java/projects/infa2019_2sm/test.txt"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile().getName());
        System.out.println(file.toURI());
        try {
            System.out.println(file.toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println(file.length());
        System.out.println(file.getParentFile());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getTotalSpace());
        System.out.println(file.canWrite());
        System.out.println(file.canRead());
        System.out.println(file.canExecute());
        System.out.println(file.isHidden());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.lastModified());
        Path filePath = file.toPath();
        try {
            System.out.println(filePath.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("ilya").getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(filePath, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());


        //file.setReadOnly();


        File file2=new File("test3.txt");
        try {
            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileChannel channel=null;
        FileLock lock=null;
        try {
            channel = new RandomAccessFile(file2, "rw").getChannel();
            //FileChannel channel = new RandomAccessFile(file, "r").getChannel();
            lock = channel.lock(0,10,false);
            //lock = channel.lock();

            System.out.println("Lock is shared "+lock.isShared());
            System.out.println("Lock is valid "+lock.isValid());
            System.out.println(lock.position());
            System.out.println(lock.size());

//            try {
//                lock = channel.tryLock();
//            } catch (OverlappingFileLockException e) {
//                e.printStackTrace();
//            }

            while (true)
            {
                Thread.sleep(10000);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
           try {
               if (lock != null) {
                   lock.release();
               }
               channel.close();
           }
           catch (IOException exception)
            {
                exception.printStackTrace();
            }
        }

    }
}
