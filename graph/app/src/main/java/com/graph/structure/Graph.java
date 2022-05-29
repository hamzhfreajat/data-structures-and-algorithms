package com.graph.structure;

import com.graph.data.Vertex;

import java.util.*;

public class Graph {
    private Map<Vertex,List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public void addNode(String data) {
        Vertex vertex = new Vertex(data);
        adjVertices.putIfAbsent(vertex,new ArrayList<>());
    }
    public void addNode(String data , int weight) {
        Vertex vertex = new Vertex(data ,weight);
        adjVertices.putIfAbsent(vertex,new ArrayList<>());
    }

    public void addEdge(String data1,String data2){
        Vertex vertex1 = new Vertex(data1);
        Vertex vertex2 = new Vertex(data2);
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }

    public void addEdge(String data1, int weight1 , String data2 , int weight2){
        Vertex vertex1 = new Vertex(data1 , weight1);
        Vertex vertex2 = new Vertex(data2 , weight2);
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }
    public String getNodes() {
        StringBuilder strBuilder = new StringBuilder();
        for (Vertex vertex : adjVertices.keySet()) {
            strBuilder.append(vertex);
            strBuilder.append(adjVertices.get(vertex));
        }
        if (strBuilder.isEmpty()) return null;
        return strBuilder.toString();
    }

    public Set<String> breadthFirst( String root){
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()){
            String vertex = queue.poll();
            for(Vertex v : this.getNeighbors(vertex)){
                if(!visited.contains((v.getData())))
                {
                    queue.add(v.getData());
                    visited.add(v.getData());

                }
            }
        }
        return visited;
    }

    public List<Vertex> getNeighbors(String data){
        return adjVertices.get(new Vertex(data));
    }

    public int size(){
        return adjVertices.size();
    }
}
