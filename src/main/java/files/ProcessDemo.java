package files;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by eljah32 on 4/22/2019.
 */
public class ProcessDemo {

    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new
                    ProcessBuilder("cmd.exe", "/c","dir", "/q");
            final Process p=pb.start();
            BufferedReader br=new BufferedReader(
                    new InputStreamReader(
                            p.getInputStream()));
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}