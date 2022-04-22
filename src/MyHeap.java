public class MyHeap <T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyHeap() {
        list = new MyArrayList<T>();
    }

    public int size(){
        return list.size();
    }

    public void add(T item){
        list.add(item);
        shiftUp();
    }

    public T removeRoot(){
        T removed=list.get(0);
        list.set(0, list.get(list.size()-1));
        shiftDown();
        return removed;
    }

    public boolean remove(T item){
        if(list.indexOf(item)==(-1)) return false;
        list.set(list.indexOf(item), list.get(list.size()-1));
        shiftDown();
        return true;
    }

    private void shiftUp(){
        int current=list.size()-1;
        while (current>0){
            int p=(current-1)/2;
            T item=list.get(current);
            T parent=list.get(p);
            if(item.compareTo(parent)<0){
                T temp=item;
                item=parent;
                parent=item;
                current=p;
            }
        }
    }

    private void shiftDown(){
        int current=0, leftChild=1;
        while(leftChild<list.size()){
            int rightChild=leftChild+1;
            int compareWith=leftChild;
            T item1=list.get(current);
            T item2=list.get(compareWith);
            if(rightChild<list.size()){
                if(list.get(rightChild).compareTo(list.get(leftChild))<0){
                    compareWith=rightChild;
                }
            }
            if(list.get(current).compareTo(list.get(compareWith))>0){
                T temp=item1;
                item1=item2;
                item2=temp;
                current=compareWith;
                leftChild=current*2+1;
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
