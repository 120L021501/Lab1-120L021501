package P3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Person {
	public String name;
	public boolean visited;
	public int step;
	public List<Person> friends=new ArrayList<>(); 
	public Person(String s)
	{
		name=s;
	}
	
	

}
