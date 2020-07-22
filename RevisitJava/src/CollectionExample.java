import java.util.*;
public class CollectionExample {
	
	public void understandingSet() {
		/*TreeSet<Integer> mySet = new TreeSet<Integer>();
		mySet.add(10);
		mySet.add(50);
		mySet.add(20);
		mySet.add(30);
		
		for (Integer num : mySet) {
			System.out.println(num);
		}*/
		TreeSet<Employee> employees = new TreeSet<Employee>();
		employees.add(new Employee(101,"Ramu"));
		employees.add(new Employee(102,"Pomu"));
		employees.add(new Employee(103,"Bimu"));
		for (Employee employee : employees) {
			System.out.println(employee);
		}
				
	}

	void understandingMap() {
		/*HashMap<Integer, Integer> myMap = new HashMap<Integer,Integer>();
		myMap.put(101, 12345);
		myMap.put(102, 54321);
		myMap.put(103, 10000);
		myMap.put(104, 12222);
		myMap.put(105, 13333);
		for (int item : myMap.keySet()) {
			System.out.println(myMap.get(item));
		}
		int k = 107;
		if(myMap.containsKey(k))
			System.out.println(k+" already present");
		else
		{
			myMap.put(k, 12333);
			System.out.println("Added");
		}
		System.out.println("After new value");
		for (int item : myMap.keySet()) {
			System.out.println(myMap.get(item));
		}*/
		HashMap<Integer, Employee> myMap = new HashMap<Integer,Employee>();
		myMap.put(101, new Employee(101,"Ramu"));
		myMap.put(102, new Employee(102,"Somu"));
		myMap.put(105, new Employee(105,"Bimu"));
		myMap.put(104, new Employee(104,"Pomu"));
		for (Integer i : myMap.keySet()) {
			System.out.println(myMap.get(i));
		}
		System.out.println(myMap.get(105));	
	}
	
	
	public static void main(String[] args) {
		CollectionExample ce = new CollectionExample();
		ce.understandingMap();

	}

}
class Employee implements Comparable<Employee>{
	int id;
	String name;
	Employee(){}
	Employee(int id,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}
	/*@Override
	public boolean equals(Object obj) {
		Employee e = (Employee)obj;
		if(this.id==e.id)
			return true;
		else
			return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id*100;
	}*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+name;
	}
	
}