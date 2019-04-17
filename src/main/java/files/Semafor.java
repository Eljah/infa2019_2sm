package files;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Scanner;

public class Semafor {
    public static void main(String[] args) {
        File file = new File("testfile.txt");
        FileChannel channel = null;
        FileLock lock = null;
        try {
            channel = new RandomAccessFile(file, "rw").getChannel();
            channel.force(true);
            //lock = channel.lock();
            while (lock == null) {
                System.out.println("Try to lock the file");
                lock = channel.tryLock();
                Thread.sleep(1000);
            }
            System.out.println("Введите STOP");
            Scanner scanner = new Scanner(System.in);
            String s = "";
            while (!s.equals("STOP")) {
                s = scanner.next();
            }
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
