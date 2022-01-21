public class User {
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
}
}
