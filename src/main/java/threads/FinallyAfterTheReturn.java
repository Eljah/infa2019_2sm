package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class FinallyAfterTheReturn {

        public static void main(String[] args)
        {
            System.out.println("before");
            System.out.println(test());
            System.out.println("after");
        }

        static String test()
        {
            try
            {
                System.out.println("inside");
                return "return";
            }
            finally
            {
                System.out.println("finally");
            }
        }

}
