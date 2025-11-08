package hw08;
import java.util.HashMap;
import java.util.HashSet;

/*
 * Реалізувати клас неорієнтований граф, що представлений списком суміжності.
 * Клас має містити методи додавання та видалення вершин, а також методи
 * додавання та видалення ребер. Використати клас HashMap.
 * 
 */

public class t08_03 {
    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();

        graph.addTop("A");
        graph.addTop("B");
        graph.addTop("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        System.out.println("Граф:");
        graph.printGraph();
        graph.removeEdge("A", "C");
        System.out.println("\nГраф після видалення ребра A-C:");
        graph.printGraph();
        graph.removeTop("B");
        System.out.println("\nГраф після видалення вершини B:");
        graph.printGraph();
    }
}


class UndirectedGraph {
    private HashMap<String, HashSet<String>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addTop(String vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }

    public void removeTop(String vertex) {
        if (adjacencyList.containsKey(vertex)) {
        } else {
            return;
        }

        HashSet<String> neighbors = adjacencyList.get(vertex);

        String[] neighborsArray = new String[neighbors.size()];
        neighbors.toArray(neighborsArray);

        for (int i = 0; i < neighborsArray.length; i++) {
            String neighbor = neighborsArray[i];
            HashSet<String> neighborEdges = adjacencyList.get(neighbor);
            neighborEdges.remove(vertex);
        }
    }

    public void addEdge(String v1, String v2) {
        addTop(v1);
        addTop(v2);

        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    public void removeEdge(String v1, String v2) {
        if (adjacencyList.containsKey(v1)) {
            adjacencyList.get(v1).remove(v2);
        }
        if (adjacencyList.containsKey(v2)) {
            adjacencyList.get(v2).remove(v1);
        }
    }

    public void printGraph() {
        String[] vertices = new String[adjacencyList.size()];
        adjacencyList.keySet().toArray(vertices);

        for (int i = 0; i < vertices.length; i++) {
            String vertex = vertices[i];
            HashSet<String> neighbors = adjacencyList.get(vertex);
            System.out.println(vertex + " -> " + neighbors);
        }
    }
}