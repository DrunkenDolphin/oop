package prackt_8;



import java.util.Iterator;

public class MyArrayList<T> implements Iterator<Object>{
    private final int ARRAY_SIZE = 5;
    private int pointer = 0;
    private int index;
    private int current = 0;
    private Object[] array = new Object[ARRAY_SIZE];


    private void resize(int new_length){
        Object[] new_array = new Object[new_length];
        System.arraycopy(array,0,new_array,0, pointer);
        array = new_array;
    }

    public void add(T new_element){
        if(pointer == array.length-1)
            resize(array.length+1);
        array[pointer] = new_element;
        pointer++;
    }
    @Override
    public boolean hasNext(){
        return current<this.size();
    }
    @Override
    public Object next(){
        return array[current++];
    }
    @Override
    public void remove(){
        this.delete(current);
    }

    public void add(T new_element,int index){
        if(pointer == array.length-1)
            resize(array.length+1);
        for (int i = array.length-1; i>index; i--)
            array[i]=array[i-1];
        array[index]=new_element;
        pointer++;
    }

    public void delete(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        resize(array.length - 1);
    }

    public void delete(T element){
        for (int i = 0; i < pointer; i++)
            if(array[i].equals(element))
                index = i;
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        resize(array.length - 1);
    }

    public int size(){
        return array.length;
    }
    public void set(T new_element,int index){
        if(index>array.length-1)
            resize(array.length*3);
        array[index] = new_element;
    }
    public T get(int index){
        return (T) array[index];
    }

}
