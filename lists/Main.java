package lists;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> ls = new LinkedList<>();
		
		for (int i = 0; i < 10; i++)
			ls.add(i);
			
		System.out.println(ls);
		
		ls.add(6, 0);
		System.out.println(ls);
		
		ls.add(90 ,11);
		System.out.println(ls);
		
		System.out.println(ls.contains(11));
		
		System.out.println(ls.get(10));
		
		System.out.println(ls.indexOf(9));
		
		System.out.println(ls);
		ls.remove(0);
		System.out.println(ls);


		ls.remove(0);
		System.out.println(ls);
		System.out.println(ls.size());

		System.out.println(ls.getLast());
		System.out.println(ls.getFirst());
	}

}
