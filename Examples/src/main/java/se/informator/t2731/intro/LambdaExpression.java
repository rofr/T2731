package se.informator.t2731.intro;

import java.util.function.BiFunction;

public class LambdaExpression {

	public static void main(String[] args) {
		
		int x=2, y=5, z;
//		String text = "Defining max using"; 
		var text = "Defining max using";  // type can use var from Java 10
		
		z = Math.max(x,  y);
		System.out.println(text + " method Math.max, " + z);

		BiFunction<Integer, Integer, Integer> maxFunction 
			= (Integer a, Integer b) -> {return (a>b)? a: b;};

		z = maxFunction.apply(x, y);			
		System.out.println(text + " a lambda expression, " + z);

	}

}
