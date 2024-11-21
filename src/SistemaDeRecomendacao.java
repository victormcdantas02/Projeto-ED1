import java.util.LinkedList;
import java.util.Stack;

public class SistemaDeRecomendacao {
    private BTnode<String> preferencesTree; // Árvore de preferências
    private LinkedList<String> recommendationQueue; // Fila de recomendações
    private Stack<String> historyStack; // Pilha de histórico

    public SistemaDeRecomendacao() {
        preferencesTree = null; // Inicialmente sem preferências
        recommendationQueue = new LinkedList<>();
        historyStack = new Stack<>();
    }

    // Adiciona preferências na árvore
    public void addPreference(String preference) {
        if (preferencesTree == null) {
            preferencesTree = new BTnode<>(preference, null, null);
        } else {
            preferencesTree.insert(preference);
        }
    }

    // Gera recomendações com base na árvore
    public void generateRecommendations() {
        if (preferencesTree != null) {
            traverseTree(preferencesTree);
        }
    }

    // Navega pela árvore para preencher a fila de recomendações
    private void traverseTree(BTnode<String> node) {
        if (node == null) return;

        traverseTree(node.getLeft());
        recommendationQueue.add(node.getValue()); // Adiciona à fila
        traverseTree(node.getRight());
    }

    // Realiza uma ação e armazena no histórico
    public void performAction(String action) {
        historyStack.push(action);
        System.out.println("Ação realizada: " + action);
    }

    // Desfaz a última ação
    public void undoLastAction() {
        if (!historyStack.isEmpty()) {
            String undoneAction = historyStack.pop();
            System.out.println("Ação desfeita: " + undoneAction);
        } else {
            System.out.println("Nenhuma ação para desfazer!");
        }
    }

    // Mostra as recomendações
    public void showRecommendations() {
        System.out.println("Recomendações:");
        while (!recommendationQueue.isEmpty()) {
            System.out.println("- " + recommendationQueue.poll());
        }
    }
}
