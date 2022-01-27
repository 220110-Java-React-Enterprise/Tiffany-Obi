package Utils;

import java.util.Iterator;

/**
 * A fairly simple arraylist implementation extending custom list interface.
 * Default size is 2, grows by size * 2 when needed.
 * When an element is added or removed at an index other elements are not re-arranged.
 *
// * @param <e>
 */
public class CustomArrayList<E> implements CustomListInterface<E>,Iterable<E> {
    private Object[] array;
    private int size;
    private int maxSize;

    /**
     * Default constructor, creates an empty underlying array with maxSize 2
     */
    public CustomArrayList() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];

    }

    /**
     * Sized constructor, creates an empty object with maxSize size
     *
     * @param size the initial size of the underlying array
     */
    public CustomArrayList(int size) {
        maxSize = size;
        size = 0;
        array = new Object[size];
    }

    /**
     * Element list constructor, takes in variable number of objects and creates an underlying
     * array large enough to fit them.
     *
     * @param e
     */
    public CustomArrayList(E... e) {
        maxSize = size = e.length;
        array = new Object[size];

        for (int i = 0; i < size; ++i) {
            array[i] = e[i];
        }
    }


    /**
     * Adds an object to the underlying array after all previously added objects.
     * If array needs to grow, it invokes grow method.
     *
     * param o object to be added
     */
    @Override
    public void add(E e) {
        //Implement this method
        // NOTE: if size >= maxSize we need to grow array

        if (size >= maxSize) {
            growArray();
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = e;
                break;
            }
        }
        size++;
    }

    private void arrayBuilder(E e){

    }

    /**
     * Adds object at specified index, advancing the size of the underlying array. This will
     * require us to shift all later elements further down the index order
     *
     * @param index index location where object will be inserted
     * @param e     element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(E e, int index) throws IndexOutOfBoundsException {
        //Implement this method

        CustomArrayList<E> prevArr = new CustomArrayList<>();
        CustomArrayList<E> postArr = new CustomArrayList<>();

        if (size >= maxSize) {
            growArray();
        }
        try {
            for (int i = 0; i < index; i++) {
            prevArr.add((E) array[i]);
            }

            for (int j = index; j < this.size(); j++){
                postArr.add((E) array[j]);
            }

            this.clear();

            for (E element: prevArr){
                this.add(element);
            }

            this.add(e);
            for (E element2: postArr){
                this.add(element2);
            }

        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

    }

    /**
     * gets the object located at supplied index
     *
     * @param index index of object to get
     * @return object located at index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index){
      if (index >= array.length - 1){
          return null;
      } else {
          return (E) array[index];
      }

    }

    /**
     * Emptys the underlying array by setting it's private reference to null and allowing
     * the old array to be garbage collected.
     */
    @Override
    public void clear() {
        maxSize = 2;
        array = new Object[maxSize];

        size = 0;
    }

    /**
     * Check if object o is found within underlying array, using Object.equals() method
     *
     * param o object to search for
     * @return index location of first instance of matching object. -1 if not found.
     */
    @Override
    public boolean contains(E e) {
       for (int i = 0; i < array.length; i++){
           if(array[i]==e){
               return true;
           }
       }
        return false;
    }

    /**
     * Removes object at specified index from underlying array, we will then
     * need to shift the remaining elements up in the index order to fill in the gap
     *
     * @param index index of object to remove from array
     */
    @Override
    public void remove(int index) {

        CustomArrayList<E> tempArr = new CustomArrayList<>();

       array[index] = null;

       for(Object element: array){
        if (element != null){
            tempArr.add((E) element);
        }
       }

       this.clear();

        for(E e:tempArr){
            this.add(e);
        }

    }

    /**
     * returns size of array. This is the one greater than the index of the most advanced stored object,
     * not the maxSize which controls growth of the underlying array.
     *
     * @return one greater than index of most advanced stored object
     */
    @Override
    public int size() {

        int count = 0;
        for(Object element:array){
            if (element != null){
                count++;
            }
        }
        size = count;

        return size;
    }


    /**
     * Doubles the size of the underlying array by creating a new array and copying the
     * contents of the previous array into it.
     */
    private void growArray() {
        //System.out.println("Growing Array from " + maxSize + " to " + maxSize * 2);
        //set up new array
        maxSize = maxSize * 2;
        Object[] tempArray = array;
        array = new Object[maxSize];

        //copy to new array
        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (cursor <= size - 1) {
                    return true;
                }
                return false;
            }


            @Override
            public E next() {
                return (E) array[cursor++];
            }

        };

    }
}
