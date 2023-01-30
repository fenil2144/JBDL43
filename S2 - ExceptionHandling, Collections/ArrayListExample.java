import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class ArrayListExample {
	
	public static void main(String args[]) {
		List<Integer> list1 = new ArrayList<Integer>();
		
		List<Integer> list2 = new LinkedList<Integer>();
		


		list1.add(1);
		list1.add(2);
		list1.add(5);
		
		list1.remove(0);
		System.out.println(list1.size());

		list1.set(1, 4);
		System.out.println(list1);
		
		Iterator<Integer> iteratorObj = list1.iterator();
		
		while(iteratorObj.hasNext()) {
			
			System.out.println("Iterator "+iteratorObj.next());
		}
		
		for(Integer x: list1) {
			System.out.println(x);
		}
		
		
		Deque<Integer> arrDeque = new ArrayDeque<Integer>();
		
		arrDeque.addFirst(1);
		arrDeque.removeLast();
		
		HashMap<Integer, String> phoneDirectory = new HashMap<Integer, String>();
		phoneDirectory.put(123456, "gfg");
		phoneDirectory.put(78998, "newContact");
		
		for(Integer phone : phoneDirectory.keySet()) {
			System.out.println(phone);
		}
		
		for(String name : phoneDirectory.values()) {
			System.out.println(name);
		}
		
		for(Entry<Integer, String> entry : phoneDirectory.entrySet()) {
			System.out.println(entry);
		}
		
		System.out.println(phoneDirectory);



	}
	
	
	

}
