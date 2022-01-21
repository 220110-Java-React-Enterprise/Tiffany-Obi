public class Main {
public static void main(String[] args){
    Integer[] intArray = {23, 4, 67, 89, 3, 17, 2, 500, 74, -56};
    CustomArrayList<Integer> arrayList = new CustomArrayList<Integer>(intArray);

    System.out.println(arrayList.size());
    System.out.println(arrayList.contains(89));
    System.out.println(arrayList.get(7));
    arrayList.add(200);
    System.out.println(arrayList.size());
    System.out.println(arrayList);

    arrayList.add(101,2);
    System.out.println(arrayList.size());

    for(Integer element: arrayList){
        System.out.println(element);
    }

    arrayList.add(1001,7);
    System.out.println(arrayList.size());

    for(Integer element: arrayList){
        System.out.print(element + ", ");
    }

    arrayList.remove(9);
    System.out.println("\n"+arrayList.size());

    for(Integer element: arrayList){
        System.out.print(element + ", ");
    }

}
}
