package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class LimitedResource {
    synchronized
    public void use(int i)
    {
        System.out.println("Achived by "+i);

        try {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            System.out.println("Done in finally "+i);
        };
        System.out.println("Released by "+i);
    }

}
