public class MyStack<T extends Comparable<T>> {
    MyArrayList<T> list=new MyArrayList<>();

    public boolean empty(){
        if(list.size()==0) return true;
        return false;
    }

    public int size(){
        return list.size();
    }

    public T push(T item){
        list.add(item);
        return item;
    }

    public T pop(){
        T removed=list.get(list.size()-1);
        list.remove(list.size()-1);
        return removed;
    }

    public T peek(){
        T data=list.get(list.size()-1);
        return data;
    }
}