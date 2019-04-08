package files;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.functions.Function;
import containers.map.Student;
import containers.streams.StudentInGroup;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
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
        File file=new File("test.txt");
        //File file=new File("file:/test.txt");
//        File file = null;
//        try {
//            file = new File(new URI("file:/D:/Java/projects/infa2019_2sm/test.txt"));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
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
//
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
            System.out.println(filePath.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("leon").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(filePath, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
//
        file.setReadOnly();

//
        file.setExecutable(true, true);
//
//
        //File directory = file.getParentFile();
        System.out.println("Workaround: "+new File(file.getAbsolutePath()).getParent());
        File directory=new File(new File(file.getAbsolutePath()).getParent());
        //File directory = new File(file.getParentFile().getAbsolutePath());
        System.out.println(directory.getAbsolutePath()); //null for the file initialized as relative in the working directory!
        System.out.println(directory.isDirectory());
        for (File dirFile : directory.listFiles()) {
            System.out.println(dirFile);
        }
//
//
        System.out.println();

//        for (File dirFile : directory.listFiles(e -> {
//            if(!e.canRead()){
//               return false;
//            }
//            boolean flag = false;
//           try{
//                flag = new BufferedReader(new FileReader(e)).lines().anyMatch(s -> s.contains("Hello"));
//            }
//            catch(IOException t){
//               //  t.printStackTrace();
//            return false;
//            }
//            return flag;
//        })) {
//
//            try ( BufferedReader reader = new BufferedReader(new FileReader(dirFile))) {
//                System.out.println(dirFile);
//
//                while (reader.ready()) {
//                    String currentLine = reader.readLine();
//                    System.out.println(currentLine);
//                }
//                //reader.close();
//            } catch (IOException i) {
//                i.printStackTrace();
//            } finally {
//
//            }
//        }

        //todo lambda exercises

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();


        try (Closeable closeable=new Cloooze();)
        {
            System.err.println("Doing something normal");
            //throw new RuntimeException("Interrupting the try with cloaseble resource");

        } catch (IOException e) {
            System.err.println("Before the stacktrace shown for IO");
            //e.printStackTrace();
        }
        catch (RuntimeException e) {
            System.err.println("Before the stacktrace shown for Runtime");
            e.printStackTrace();
        }
        finally {
            System.err.println("Doing something inside the finally block");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileReader fileReader=null;
        try {
            fileReader=new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("read file "+fileReader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        try {
            String gotFromReadLine=bufferedReader.readLine();
            System.out.println("First read line "+gotFromReadLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Second read line "+bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        //just to remind that the below is possible!
        Comparable comparable= new Student("2","2")::compareTo;

        Comparable comparable1=new Comparable() {
            @Override
            public int compareTo(Object o) {
                return new Student("2","2").compareTo(o);
            }

            @Override
            public String toString()
            {
                System.out.println("Retuning to String of anonymously created class");
                return "Hehe!";
            }
        };

        System.out.println(comparable1.toString());
        comparable1.compareTo(new Student("5","5"));

        System.out.println(comparable.toString());
        comparable.compareTo(new Student("3","3"));

//
        Closeable c2=bufferedReader::close;

        Closeable c3=new Closeable() {
            @Override
            public void close() throws IOException {
                bufferedReader.close();
            }
        };


        System.out.println();

        try {
            //try(new Cloooze())
            //try(Closeable c=new Cloooze())
//            try(Closeable c=new Closeable() {
//                {
//                    System.out.println("Load");
//                }
//
//                @Override
//                public void close() throws IOException {
//                    System.out.println("Close!");
//                }
//            })
            try(Closeable c=new Cloooze())
            //try(Closeable c=new Cloooze()::close)
             //try(Closeable c=bufferedReader::close;)
            //try(Closeable c=file::deleteOnExit;)
            //try(Closeable c=comparable1::toString;)
            //try(Closeable c=new Student("4","4")::toString;)
            {
                //c.close();
                System.out.println(bufferedReader.readLine());
                System.out.println(c.toString());
                System.out.println("do something");
                System.out.println("Third read line "+bufferedReader.readLine());
                //throw new RuntimeException("Interrupting the try with cloaseble resource");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("And try if from finally");
        }

//        try {
//            System.out.println("5th line "+bufferedReader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //todo to talk about transient keyword in File
//
        File file2 = new File("test3.txt");
        try {
            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileChannel channel = null;
        FileLock lock = null;
        try {
            channel = new RandomAccessFile(file2, "rw").getChannel();
            channel.force(true);
            //FileChannel channel = new RandomAccessFile(file, "r").getChannel();
            //lock = channel.lock(0, 10, false);
//            lock = channel.lock(0, 10, true);
//            lock = channel.lock();

//            System.out.println("Lock is shared " + lock.isShared());
//            System.out.println("Lock is valid " + lock.isValid());
//            System.out.println(lock.position());
//            System.out.println(lock.size());

            try {
                while (true) {
                    lock = channel.tryLock();
                    System.out.println("Waiting for lock released");
                }
            } catch (OverlappingFileLockException e) {
                e.printStackTrace();
            }

            while (true) {
                Thread.sleep(1000);
                String str = "Hello1\n";
//                try (FileWriter fw = new FileWriter(file,true);
//                     BufferedWriter bw = new BufferedWriter(fw);
//                     PrintWriter out = new PrintWriter(bw)) {
//                    out.println(str);
//                    //more code
//                } catch (IOException e) {
//                    //exception handling left as an exercise for the reader
//                    e.printStackTrace();
//                }

                channel.position(channel.size());
                //channel.position(0);
                channel.write(ByteBuffer.wrap(str.getBytes()));
                System.out.println("We have wrote "+str+" to the file");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lock != null) {
                    lock.release();
                }
                channel.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }


    }

    public static class Cloooze implements Closeable
    {

        public Cloooze()
        {
            System.out.println("Doing something inside resource constructor");
        }

        @Override
        public void close() throws IOException {
            System.out.println("Closing! Closing!");
        }
    }
}
