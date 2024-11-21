public class Arvore<T extends Comparable<T>> {
    private T value;         
    private Arvore<T> left; 
    private Arvore<T> right; 

    
    public Arvore(T v, Arvore<T> l, Arvore<T> r) {
        value = v;
        left = l;
        right = r;
    }

    public T getValue() { 
        return value; 
    }
    public Arvore<T> getLeft() { 
        return left; 
    }
    public Arvore<T> getRight() { 
        return right; 
    }
    public void setValue(T v) { 
        value = v; 
    }
    public void setLeft(Arvore<T> l) { 
        left = l; 
    }
    public void setRight(Arvore<T> r) { 
        right = r; 
    }

    public void insert(T newValue) {
        if (newValue.compareTo(value) < 0) {
            if (left == null) {
                left = new Arvore<>(newValue, null, null);
            } else {
                left.insert(newValue);
            }
        } else if (newValue.compareTo(value) > 0) {
            if (right == null) {
                right = new Arvore<>(newValue, null, null);
            } else {
                right.insert(newValue);
            }
        }
    }


    public Arvore<T> search(T targetValue) {
        if (targetValue.equals(value)) {
            return this;
        } else if (targetValue.compareTo(value) < 0) {
            return (left != null) ? left.search(targetValue) : null;
        } else {
            return (right != null) ? right.search(targetValue) : null;
        }
    }


    public Arvore<T> remove(T targetValue) {
        if (targetValue.compareTo(value) < 0) {
            if (left != null) {
                left = left.remove(targetValue);
            }
        } else if (targetValue.compareTo(value) > 0) {
            if (right != null) {
                right = right.remove(targetValue);
            }
        } else {

            if (left == null && right == null) {
                return null;
            }

            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            }
            Arvore<T> minValueNode = right.findMin();
            value = minValueNode.getValue();
            right = right.remove(minValueNode.getValue());
        }
        return this;
    }

    private Arvore<T> findMin() {
        return (left == null) ? this : left.findMin();
    }
}
