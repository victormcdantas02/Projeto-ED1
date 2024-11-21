public class BTnode<T extends Comparable<T>> {
    private T value;         // Valor guardado no nó
    private BTnode<T> left;  // Filho esquerdo
    private BTnode<T> right; // Filho direito

    // Construtor
    public BTnode(T v, BTnode<T> l, BTnode<T> r) {
        value = v;
        left = l;
        right = r;
    }

    // Getters e Setters
    public T getValue() { return value; }
    public BTnode<T> getLeft() { return left; }
    public BTnode<T> getRight() { return right; }
    public void setValue(T v) { value = v; }
    public void setLeft(BTnode<T> l) { left = l; }
    public void setRight(BTnode<T> r) { right = r; }

    // Função para inserir um novo valor na árvore
    public void insert(T newValue) {
        if (newValue.compareTo(value) < 0) {
            if (left == null) {
                left = new BTnode<>(newValue, null, null);
            } else {
                left.insert(newValue);
            }
        } else if (newValue.compareTo(value) > 0) {
            if (right == null) {
                right = new BTnode<>(newValue, null, null);
            } else {
                right.insert(newValue);
            }
        }
    }

    // Função para buscar um valor na árvore
    public BTnode<T> search(T targetValue) {
        if (targetValue.equals(value)) {
            return this;
        } else if (targetValue.compareTo(value) < 0) {
            return (left != null) ? left.search(targetValue) : null;
        } else {
            return (right != null) ? right.search(targetValue) : null;
        }
    }

    // Função para remover um valor da árvore
    public BTnode<T> remove(T targetValue) {
        if (targetValue.compareTo(value) < 0) {
            if (left != null) {
                left = left.remove(targetValue);
            }
        } else if (targetValue.compareTo(value) > 0) {
            if (right != null) {
                right = right.remove(targetValue);
            }
        } else {
            // Caso 1: Nó sem filhos
            if (left == null && right == null) {
                return null;
            }
            // Caso 2: Nó com apenas um filho
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            }
            // Caso 3: Nó com dois filhos
            BTnode<T> minValueNode = right.findMin();
            value = minValueNode.getValue();
            right = right.remove(minValueNode.getValue());
        }
        return this;
    }

    // Função auxiliar para encontrar o menor valor em uma subárvore
    private BTnode<T> findMin() {
        return (left == null) ? this : left.findMin();
    }
}
