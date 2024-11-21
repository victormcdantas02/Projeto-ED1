public class NoArvore<T> {
    private T value;
    private NoArvore<T> left;  
    private NoArvore<T> right; 
 
    NoArvore(T v, NoArvore<T> l, NoArvore<T> r) {
       value = v;
       left = l;
       right = r;
    }
 
    public T getValue() {
        return value;
    }
    public NoArvore<T> getLeft() {
        return left;
    }
    public NoArvore<T> getRight() {
        return right;
    }
    public void setValue(T v) {
        value = v;
    }
    public void setLeft(NoArvore<T> l) {
        left = l;
    }
    public void setRight(NoArvore<T> r) {
        right = r;
    }
 }