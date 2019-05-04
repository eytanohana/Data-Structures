package lists;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < 10; i++)
			list.add(i);
			
		System.out.println(list);
		
		list.add(0, 6);
		System.out.println(list);
		
		list.add(11 ,4);
		System.out.println(list);
	}

}
