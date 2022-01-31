import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> testArray = new ArrayList<>();
        testArray.add(1);
        testArray.add(12);
        testArray.add(6);
        testArray.add(9);
        testArray.add(5);
        testArray.add(20);
        testArray.add(10);

//        for (int num : testArray){
//            System.out.println(num);
//            System.out.println(testArray.indexOf(num));
//        }
        System.out.println("The answer should be 20,26,35 = 42 ---> result: "+SolutionClass.problem(testArray,7,4));
    }
}
