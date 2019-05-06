package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGeneratorNonThreadSafe1 implements IntegerGenerator{
    //volatile
    int value=0;

    public int getNext(){
        value++;
        value++;
        //value=value+2;
        return value;
    }

}
