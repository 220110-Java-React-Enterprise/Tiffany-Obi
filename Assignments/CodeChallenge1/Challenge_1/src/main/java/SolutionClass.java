import java.util.ArrayList;
import java.util.Collections;

public class SolutionClass {



//    You are at a local youth soccer game. There are a bunch of children of all ages
//    running around chasing a ball in a field. A giant Lovecraftian horror
//    suddenly appears and begins to feast upon all the adorable little children.
//    You have only a limited time to save as many children as possible, and you decide to
//    try and save the youngest ones. You can save one child per minute
//    and are given only K minutes. you will be given an array of length N which
//    represents the soccer field full of children, and K minutes. Your goal is to search
//    the array for the youngest children and save them by removing them from the array.
//    After you have removed K children, the monster eats the rest.
//    Remember, you want to save the youngest children.


    public static Integer problem(ArrayList<Integer> arrayList, int N, int K) {

        //Write your code here
            Collections.sort(arrayList);
            int i = 0;

           while(i < K){
                arrayList.remove(0);
                i++;
            }


        Integer yummyChildrenEaten = 0;
        for (Integer integer:arrayList) {
            yummyChildrenEaten += integer;
        }
        return yummyChildrenEaten;

    }







}
