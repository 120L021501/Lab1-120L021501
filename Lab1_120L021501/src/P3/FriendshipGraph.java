package P3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendshipGraph {
    public List<Person> people=new ArrayList<>();
    private int step=0,min=100,detect=0;
    private Queue<Person> a=new LinkedList<>();
    private boolean checksame(Person jia)
    {
    	for(int i=0;i<people.size();i++)
    	{
    		if(jia.name==people.get(i).name) 
    		{
    			System.out.println("in put the same name!");
    			System.exit(0);
    			//return false;
    		}
    	}
    	return true;
    }
    public void addVertex(Person jia)
    {
    	if(checksame(jia)==true)
    	{
    		people.add(jia);
    	}
    }
    public void addEdge(Person jia, Person yi)
    {
    	jia.friends.add(yi);
    	//yi.friends.add(jia);
    }
    /*
    private int search(Person jia,Person yi,int path)
    {
    	jia.step=path;
    	jia.visited=true;
    	
    	for(int i=0;i<jia.friends.size();i++)
    	{
    		if(jia.friends.get(i).visited==false)
    		{
    			
    			jia.friends.get(i).visited=true;
    			if(jia.friends.get(i)==yi) 
    			{
    				if(jia.step<min) min=jia.step+1;
    				detect=1;
    				//step=0;
    				return 1;
    			}
    			//System.out.print(jia.friends.get(i).name);
    			search(jia.friends.get(i),yi,(jia.step+1));
    		}
    	}
    	//step=0;
    	
    	return 0;
    }
    */
    private int search(Person jia,Person yi,int path)
    {
    	
    	jia.visited=true;
    	//a.clear();
    	//min++;
    	for(int i=0;i<jia.friends.size();i++)
    	{
    		if(jia.friends.get(i).visited==false)
    		{
    			
    			jia.friends.get(i).visited=true;
    			
    			if(jia.friends.get(i)==yi) 
    			{
    				if(path+1<min) min=path+1;
    				//System.out.print("here I found:"+jia.friends.get(i).name+"\n");
    				detect=1;
    				jia.friends.get(i).step=path;
    				while(a.size()!=0)
    				{
    					a.clear();
    				}
    				//step=0;
    				return 1;
    			}
    			a.offer(jia.friends.get(i));
    			
    			//System.out.print("I search:"+jia.friends.get(i).name+"\n");
    			
    		}
    	}
    	//System.out.print("¶ÓÁÐ¶¥ÊÇÉ¶:"+a.peek().name+"\n");
    	if(a.size()==0) return -1;
    	else search(a.remove(),yi,(jia.step+1));
    	//step=0;
    	
    	return 0;
    }
    public int getDistance(Person jia, Person yi)
    {
    	detect=0;
    	int path=0;
    	min=100;
    	if(jia.name==yi.name) return 0;
    	for(int i=0;i<people.size();i++)
    	{
    		people.get(i).visited=false;
    		people.get(i).step=0;
    	}
    	a.add(jia);
    	//System.out.print("search start:\n");
    	search(a.remove(),yi,path);
    	if(detect==0) return -1;
    	return min;
    }
	public static void main(String[] args) {
		
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		
		System.out.println(graph.getDistance(rachel, ross)); 
		//should print 1
		System.out.println(graph.getDistance(rachel, ben)); 
		//should print 2
		System.out.println(graph.getDistance(rachel, rachel)); 
		//should print 0
		System.out.println(graph.getDistance(rachel, kramer)); 
		//should print -1
		
//		FriendshipGraph graph = new FriendshipGraph();
//    	Person A = new Person("A");
//    	Person B = new Person("B");
//    	Person C = new Person("C");
//    	Person D = new Person("D");
//    	Person E = new Person("E");
//    	Person F = new Person("F");
//    	graph.addVertex(A);
//    	graph.addVertex(B);
//    	graph.addVertex(C);
//    	graph.addVertex(D);
//    	graph.addVertex(E);
//    	graph.addVertex(F);
//    	graph.addEdge(A, B);
//    	graph.addEdge(B, A);
//    	graph.addEdge(B, C);
//    	graph.addEdge(C, B);
//    	graph.addEdge(C, D);
//    	graph.addEdge(D, C);
//    	graph.addEdge(D, E);
//    	graph.addEdge(E, D);
//    	graph.addEdge(E, A);
//    	graph.addEdge(A, E);
//    	System.out.println(graph.getDistance(A, B));
//    	System.out.println(graph.getDistance(A, C));
//    	System.out.println(graph.getDistance(A, D));
//    	System.out.println(graph.getDistance(A, E));
//    	System.out.println(graph.getDistance(A, F));
//    	//System.out.println(graph.getDistance(, E));
		
		  
		 
	}

}
