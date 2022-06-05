/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.graph;

import com.graph.data.Vertex;
import com.graph.structure.Graph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.graph.App.graphBusinessTrip;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void addNodeTest(){
        Graph graph = new Graph();
        graph.addNode("A");
        String val = graph.getNodes();
        String exp = "Vertex{data='A'}[]" ;
        assertEquals(exp , val);
    }

    @Test
    public void addEdgeTest(){
        Graph graph = new Graph();

        graph.addNode("A" );
        graph.addNode("B" );
        graph.addEdge("A","B");

        String val = graph.getNodes();
        String exp = "Vertex{data='A'}[Vertex{data='B'}]Vertex{data='B'}[Vertex{data='A'}]" ;
        assertEquals(exp , val);
    }


    @Test
    public void getNodeTest(){
        Graph graph = new Graph();

        graph.addNode("A" );
        graph.addNode("B" );
        graph.addEdge("A","B");

        String val = graph.getNodes();
        String exp = "Vertex{data='A'}[Vertex{data='B'}]Vertex{data='B'}[Vertex{data='A'}]" ;
        assertEquals(exp , val);
    }


    @Test
    public void getNeighborsTest(){
        Graph graph = new Graph();

        graph.addNode("A" );
        graph.addNode("B" );
        graph.addEdge("A","B");

        List<Vertex> val = graph.getNeighbors("A");
        String exp = "[Vertex{data='B'}]" ;
        assertEquals(exp , val.toString());
    }

    @Test
    public void getNeighborsWeightTest(){
        Graph graph = new Graph();

        graph.addNode("A" );
        graph.addNode("B"  );
        graph.addEdge("A" , "B"  , 4) ;

        List<Vertex> val = graph.getNeighbors("A");
        String exp = "[Vertex{data='B'weight='5'}]" ;
        assertEquals(exp , val.toString());
    }

    @Test
    public void getSizeTest(){
        Graph graph = new Graph();

        graph.addNode("A" );
        graph.addNode("B"  );
        graph.addNode("C"  );
        graph.addNode("D"  );
        graph.addNode("F"  );
        graph.addNode("G"  );

        int val = graph.size();
        int exp = 6;
        assertEquals(exp , val);
    }

    @Test
    public void getOneNodeTest(){
        Graph graph = new Graph();

        graph.addNode("A" );
        graph.addEdge("A" , "A"  ) ;

        String val = graph.getNodes();
        String exp = "Vertex{data='A'}[Vertex{data='A'}, Vertex{data='A'}]" ;
        assertEquals(exp , val);
    }

    @Test
    public void getNullNodeTest(){
        Graph graph = new Graph();


        String val = graph.getNodes();
        String exp = null ;
        assertEquals(exp , val);
    }

    @Test
    public void breadthFirstTest(){
        Graph graph = new Graph();

        graph.addNode("A" );
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A","B");
        graph.addEdge("B","C");
        graph.addEdge("A","C");

        Set<String> set = graph.breadthFirst("A");

        Set<String> exp = new HashSet<>();
        exp.add("A");
        exp.add("B");
        exp.add("C");

        assertEquals( exp.toString() , set.toString());
    }


    @Test
    public void graphBusinessTripTest(){
        Graph graph = new Graph();

        graph.addNode("Pandora" );
        graph.addNode("Arendelle");
        graph.addNode("Monstropolis");
        graph.addNode("Metroville");
        graph.addNode("Naboo");
        graph.addNode("Narnia");


        graph.addEdge("Pandora","Arendelle" , 150);
        graph.addEdge("Arendelle","Metroville" , 99);
        graph.addEdge("Monstropolis","Naboo" , 73);
        graph.addEdge("Arendelle","Monstropolis" , 42);
        graph.addEdge("Naboo","Narnia" , 37);






        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Arendelle");
        arrayList.add("Monstropolis");
        arrayList.add("Naboo");


        int res = graphBusinessTrip(arrayList , graph);

        assertEquals(res , 115);
    }

}
