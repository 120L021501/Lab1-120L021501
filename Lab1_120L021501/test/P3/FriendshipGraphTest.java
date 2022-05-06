package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class FriendshipGraphTest {
	@Test
	public void test()
    {
    	FriendshipGraph graph = new FriendshipGraph();
    	Person A = new Person("A");
    	Person B = new Person("B");
    	Person C = new Person("C");
    	Person D = new Person("D");
    	Person E = new Person("E");
    	graph.addVertex(A);
    	graph.addVertex(B);
    	graph.addVertex(C);
    	graph.addVertex(D);
    	graph.addVertex(E);
    	graph.addEdge(A, B);
    	graph.addEdge(B, A);
    	graph.addEdge(B, C);
    	graph.addEdge(C, B);
    	graph.addEdge(C, D);
    	graph.addEdge(D, C);
    	graph.addEdge(D, E);
    	graph.addEdge(E, D);
    	graph.addEdge(E, A);
    	graph.addEdge(A, E);
    	assertEquals(1, graph.getDistance(A, B));
    	assertEquals(2, graph.getDistance(A, C));
    	assertEquals(2, graph.getDistance(A, D));
    	assertEquals(1, graph.getDistance(A, E));
    	
    }
	@Test
	public void test1()
    {
    	FriendshipGraph graph = new FriendshipGraph();
    	Person A = new Person("A");
    	Person B = new Person("B");
    	Person C = new Person("C");
    	Person D = new Person("D");
    	Person E = new Person("E");
    	graph.addVertex(A);
    	graph.addVertex(B);
    	graph.addVertex(C);
    	graph.addVertex(D);
    	graph.addVertex(E);
    	graph.addEdge(A, B);
    	graph.addEdge(B, A);
    	graph.addEdge(B, C);
    	graph.addEdge(C, B);
    	graph.addEdge(C, D);
    	graph.addEdge(D, C);
    	graph.addEdge(D, E);
    	graph.addEdge(E, D);
    	graph.addEdge(E, A);
    	graph.addEdge(A, E);
    	
    	assertEquals(2, graph.getDistance(A, C));
    	assertEquals(2, graph.getDistance(A, D));
    	assertEquals(1, graph.getDistance(A, E));
    	
    }
	@Test
	public void test2()
    {
    	FriendshipGraph graph = new FriendshipGraph();
    	Person A = new Person("A");
    	Person B = new Person("B");
    	Person C = new Person("C");
    	Person D = new Person("D");
    	Person E = new Person("E");
    	graph.addVertex(A);
    	graph.addVertex(B);
    	graph.addVertex(C);
    	graph.addVertex(D);
    	graph.addVertex(E);
    	graph.addEdge(A, B);
    	graph.addEdge(B, A);
    	graph.addEdge(B, C);
    	graph.addEdge(C, B);
    	graph.addEdge(C, D);
    	graph.addEdge(D, C);
    	graph.addEdge(D, E);
    	graph.addEdge(E, D);
    	graph.addEdge(E, A);
    	graph.addEdge(A, E);
    	assertEquals(2, graph.getDistance(A, D));
    	
    	
    }
	@Test
	public void test3()
    {
    	FriendshipGraph graph = new FriendshipGraph();
    	Person A = new Person("A");
    	Person B = new Person("B");
    	Person C = new Person("C");
    	Person D = new Person("D");
    	Person E = new Person("E");
    	graph.addVertex(A);
    	graph.addVertex(B);
    	graph.addVertex(C);
    	graph.addVertex(D);
    	graph.addVertex(E);
    	graph.addEdge(A, B);
    	graph.addEdge(B, A);
    	graph.addEdge(B, C);
    	graph.addEdge(C, B);
    	graph.addEdge(C, D);
    	graph.addEdge(D, C);
    	graph.addEdge(D, E);
    	graph.addEdge(E, D);
    	graph.addEdge(E, A);
    	graph.addEdge(A, E);
    	assertEquals(1, graph.getDistance(A, E));
    	
    }
}
