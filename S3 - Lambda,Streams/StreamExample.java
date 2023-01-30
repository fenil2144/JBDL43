package Session3;

import java.util.Arrays;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample {
	
	public static void main(String args[]) {
		
		List<Integer> number = Arrays.asList(2,3,4,5);
		
		
		System.out.println(number.stream().map(x -> x%2 == 0).collect(Collectors.toList()));
		System.out.println(number);
		
		List<String> names = Arrays.asList("fenil","shah","java","spring");
		List<String> result = names.stream().filter(s-> s.startsWith("j")).collect(Collectors.toList());
		
		System.out.println(names);
		System.out.println(result);
		
		names.stream().filter(p-> p.startsWith("s") && p.length()>2)
		.map(p-> p.toUpperCase())
		.sorted()
		.forEach(p-> System.out.println(p));
		
		
	}

}
