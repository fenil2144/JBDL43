package Session3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimitiveandParallelStream {
	
	public static void main(String args[]) {
		
		int[] integers = {1,2,3,4,5,6};
		IntStream intStream = Arrays.stream(integers);
		
		System.out.println(intStream.min().getAsInt());
		
//		List<Integer> listOfIntegers = intStream.boxed().collect(Collectors.toList());
		
		List<String> list = Arrays.asList("b","c","d","e","g",
				"f","g","f");
		
		list.parallelStream().forEach(System.out::print);
		//fggfbdec
		//fggcbefd
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
	}

}
