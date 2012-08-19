import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gabriel
 * Date: 8/19/12
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Week1_TestTiming {
    public static void main(String[] args){
        int n=200;
        int step=30;
        int max=1300;
        int seed = 551783;

        double logn;
        double logResult;
        long now ;
        long after;

        now = System.currentTimeMillis();
        Timing.trial(n, seed);
        after= System.currentTimeMillis();

        logn=Math.log(n)/Math.log(2.0d);
        logResult=Math.log(after - now)/Math.log(2.0d);
        List<Double> results = new ArrayList<Double>();
        for (int i=n+step; i<=max; i +=step) {
            now = System.currentTimeMillis();
            Timing.trial(i, seed);
            after= System.currentTimeMillis();

            double logn2=Math.log(i)/Math.log(2.0d);
            double logResult2=Math.log(after - now)/Math.log(2.0d);
            double res = (logResult2 - logResult)/(logn2- logn);
            System.out.println("i: "+i+" result"+res);
            logn = logn2;
            logResult = logResult2;
            results.add(res);
/**
 *
 System.out.println("Pour "+n+" : Temps : "+(after - now));
 System.out.println("Temps : "+(after - now));
 */
        }
        double s=0;
        for(Double d : results)
        {
            s+=d;
            System.out.print(d);
        }
        System.out.println("");
        System.out.print("moyenne"+s/results.size());
    }
    private double lg(double n){
         return Math.log(n)/Math.log(2);
    }
}
