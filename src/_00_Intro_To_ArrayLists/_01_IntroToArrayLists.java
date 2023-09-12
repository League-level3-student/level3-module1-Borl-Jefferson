package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
        ArrayList<String> shapes = new ArrayList<String>();
        // 2. Add five Strings to your list
shapes.add("rhombus");
shapes.add("trapezoid");
shapes.add("rectangle");
shapes.add("kite");
shapes.add("parallelogram");
        // 3. Print all the Strings using a standard for-loop
for (int i = 0; i < shapes.size(); i++) {
	System.out.println(shapes.get(i));
}
System.out.println("");
        // 4. Print all the Strings using a for-each loop
for(String s : shapes) {
System.out.println(s);
}
System.out.println();
        // 5. Print only the even numbered elements in the list.
for (int i = 0; i < shapes.size(); i++) {
	if(i%2==1) {
		System.out.println(shapes.get(i));
	}
}
System.out.println();
        // 6. Print all the Strings in reverse order.
for (int i = shapes.size()-1; i > -1; i--) {
	System.out.println(shapes.get(i));
}
        // 7. Print only the Strings that have the letter 'e' in them.
        System.out.println();
        
        for (int i = 0; i < shapes.size(); i++) {
			for (int j = 0; j < shapes.get(i).length(); j++) {
				if(shapes.get(i).charAt(j)=='e') {
					System.out.println(shapes.get(i));
					j=shapes.get(i).length();
				}
		}
			}
        	
    }
}
