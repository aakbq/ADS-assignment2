public class MyQueue<T extends Comparable<T>> {
    MyLinkedList<T> list=new MyLinkedList<T>();


    public boolean empty(){
        if(list.size()==0) return true;
        return false;
    }

    public int size(){
        return list.size();
    }

    public T peek(){
        T data=list.getHead().data;
        return data;
    }

    public T enqueue(T item){
        list.add(item);
        return item;
    }

    public T dequeue(){
        T removed=list.getHead().data;
        list.remove(removed);
        return removed;
    }
}