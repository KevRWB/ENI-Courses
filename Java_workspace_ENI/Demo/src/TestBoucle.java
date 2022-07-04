
public class TestBoucle {

	public static void main(String[] args) {

		for(int i = 0; i < 5; i++) {
			System.out.println("i = " + i);
		}
		
		int nb = 10;
		
		while(nb < 100) {
			System.out.println("nombre =" + nb);
			nb*=2;
			
		}
		
		do {
			System.out.println(nb);
			nb /= 2;
		}while(nb > 0);
		
	}

}
