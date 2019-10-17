import java.util.Arrays;

public class ArrayList<T> implements List{

    int size;
    Object[] a;

    ArrayList(){
        this.size = 0;
        this.a = new Object[10];
    }

    private void growArray(){
        Object[] copy = Arrays.copyOfRange(a, 0, a.length*2);
        a = copy;
    }

    public void add(Object item) {
        if(size == a.length){
            growArray();
        }
        a[size++] = item;
    }

    public void add(int pos, Object item) {
        if(pos < 0 || pos > size) {
            System.out.println("Position out of bounds");
        }
        if(size == a.length){
            growArray();
        }
        for(int i=size-1; i > pos; i--){
            a[i+1] = a[i];
        }
        a[pos] = item;
        ++size;
    }

    public Object get(int pos) {
        if(pos < 0 || pos > size){
            System.out.println("Out of bounds");
        }
        return a[pos];
    }

    public Object remove(int pos) {
        if(pos < 0 || pos > size){
            System.out.println("Out of bounds");
        }
        Object temp = a[pos];
        for(int i=pos; i<size-1; i++){
            a[i] = a[i+1];
        }
        --size;
        return temp;
    }

    public int size() {
        return this.size;
    }
}
