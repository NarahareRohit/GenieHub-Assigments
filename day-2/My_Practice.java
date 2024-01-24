package lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class My_Practice {
	public static void main(String[] args) {
//		ArrayList list = new ArrayList();
//		list.add(10);
//		list.add("Rohit");
//		list.add(1, 'a');
//		System.out.println(list);
		ArrayList<Integer> list = new ArrayList<>();
//		list.add(10);
//		list.add(20);
//		System.out.println(list);
		
		int[] data = { 10, 2, 34, 11, 5, 4, -10, 2, 10, 30, 20, 109, 100 };
		for(int i:data)
			list.add(i);
		list.add(0,99);
//		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)>50)
				list.set(i, list.get(i)*2);
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}

}
