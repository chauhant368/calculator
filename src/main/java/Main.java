import com.tushar.calculator.client.CalculatorCLIClient;
import com.tushar.calculator.service.CalculatorServiceImpl;
import com.tushar.calculator.service.ICalculatorService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CalculatorCLIClient client = new CalculatorCLIClient();
        client.calculatorExecution();
    }

    /*public static void main(String[] args) {
        testAdd();
        testSubtract();
        testMultiply();
        testDivide();
    }*/

    /*public static void main(String[] args) {
        int sum = 0;
        sum = recSum(0,10,sum);
        System.out.println(sum);
    }*/

    private static int getSum(int sum) {
        for(int i=1;i<=10;i++){
            sum = sum +i;
        }
        return sum;
    }

    public static int recSum(int iteration, int limit, int acc){
        acc = acc + iteration;
        if(iteration ==limit){
            return acc;
        }else{
            return recSum(++iteration,limit,acc);
        }
    }


    public static void testAdd(){
        ICalculatorService calculatorService = new CalculatorServiceImpl();
        long result = calculatorService.add(10,5);
        System.out.println(result);
        assert(result==15);
    }

    public static void testSubtract(){
        ICalculatorService calculatorService = new CalculatorServiceImpl();
        long result = calculatorService.subtract(10,5);
        System.out.println(result);
        assert(result==5);
    }

    public static void testMultiply(){
        ICalculatorService calculatorService = new CalculatorServiceImpl();
        long result = calculatorService.multiply(10,5);
        System.out.println(result);
        assert(result==50);
    }

    public static void testDivide(){
        ICalculatorService calculatorService = new CalculatorServiceImpl();
        long result = calculatorService.divide(10,5);
        System.out.println(result);
        assert(result==2);
    }
}