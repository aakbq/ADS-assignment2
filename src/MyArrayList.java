public class MyArrayList<T extends Comparable<T>>  implements MyList<T>{
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }


    public void set(int index, T item){
        arr[index]=item;
    }

    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if(length==capacity)
            increaseCapacity();

        for(int i=length; i>=index; i--){
            arr[i]=arr[i-1];
        }
        arr[index]=item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        int index=indexOf(item);
        if(index==-1) return false;
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        for(int i=index; i<length; i++){
            arr[i]=arr[i+1];
        }
        length--;

        return (T)arr[index];
    }

    @Override
    public void clear() {
        length=0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i<length; i++){
            if(o.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i=length-1; i>=0; i--){
            if(o.equals(arr[i])){
                return i;
            }
        }
        return 0;
    }

    @Override
    public void sort() {
        for(int i=0; i<length; i++){
            Object temp;
            for(int j=0; j<length-1; j++){
                T a=(T) arr[j];
                T b=(T) arr[j+1];
                if(a.compareTo(b)>0){
                    temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0; i<length; i++){
            if(arr[i].equals(o)) return true;
        }
        return false;
    }
}
