package files;

import reflection.annotations.Person;

import java.io.*;

/**
 * Created by eljah32 on 4/22/2019.
 */
public class FileTest4 {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Print on console");

        // Store console print stream.
        PrintStream ps_console = System.out;

        File file = new File("file.txt");
        FileOutputStream fos = new FileOutputStream(file);

        // Create new print stream for file.
        PrintStream ps = new PrintStream(fos);

        // Set file print stream.
        System.setOut(ps);
        System.out.println("Print in the file !!");

        // Set console print stream.
        System.setOut(ps_console);
        System.out.println("Console again !!");

        //serialization

        ObjectToSerialize p1=new ObjectToSerialize("Jon Snow", 22,false);
        ObjectToSerialize p2=new ObjectToSerialize("Daenerys Targaryen", 21,true);

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //p1.objectToSerialize=p1;
            //p2.objectToSerialize=p1;

            // Write objects to file
            o.writeObject(p1);
            o.writeObject(p2);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            ObjectToSerialize pr1 = (ObjectToSerialize) oi.readObject();
            ObjectToSerialize pr2 = (ObjectToSerialize) oi.readObject();

            System.out.println(pr1.toString());
            System.out.println(pr2.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
