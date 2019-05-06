package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGenerator {
    //volatile
    static int value=0;

    public static int getNext(){
        value++;
        value++;
        return value;
    }

}
