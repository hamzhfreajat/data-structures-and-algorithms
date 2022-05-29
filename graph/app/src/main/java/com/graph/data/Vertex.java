package com.graph.data;

import java.util.Objects;

public class Vertex {
    String data;
    int weight = 0;

    public Vertex(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Vertex(String data , int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        if (weight != 0){
            return "Vertex{" +
                    "data='" + data + '\'' +
                    "weight='" + weight + '\'' +
                    '}';
        }else {
            return "Vertex{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
