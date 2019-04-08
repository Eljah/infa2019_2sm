package files;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by eljah32 on 4/8/2019.
 */
public class FileTest2 {
    public static void main(String[] args) {
        String fileName = "example2.txt";
        String fileName2 = "example3.txt";
        String str = "Hello";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String str2 = "World";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(' ');
            writer.append(str2);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //
            printWriter.print("Some String");
            printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String str3 = "Hello, рашын";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            //byte[] strToBytes = str3.getBytes();
            //byte[] strToBytes = str3.getBytes(Charset.forName("Cp866"));
            //byte[] strToBytes = str3.getBytes(Charset.forName("UTF-8"));
            byte[] strToBytes = str3.getBytes(Charset.forName("Cp1251"));
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String value = "Hello";
            FileOutputStream fos = new FileOutputStream(fileName2);
            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
            outStream.writeUTF(value);
            outStream.close();

            // verify the results
            String result;
            FileInputStream fis = new FileInputStream(fileName2);
            DataInputStream reader = new DataInputStream(fis);
            result = reader.readUTF();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int data1 = 2014;
        int data2 = 1500;

        try {
            writeToPosition(fileName, data1, 4);
            assert data1==readFromPosition(fileName, 4);

            writeToPosition(fileName2, data2, 4);
            assert data2==readFromPosition(fileName, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeToPosition(String filename, int data, long position)
            throws IOException {
        RandomAccessFile writer = new RandomAccessFile(filename, "rw");
        writer.seek(position);
        writer.writeInt(data);
        writer.close();
    }

    private static int readFromPosition(String filename, long position)
            throws IOException {
        int result = 0;
        RandomAccessFile reader = new RandomAccessFile(filename, "r");
        reader.seek(position);
        result = reader.readInt();
        reader.close();
        return result;
    }
}
