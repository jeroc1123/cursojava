import java.util.stream.Stream;

public class Pruebas1 {

	public static void main(String[] args) {
		Stream<Integer> st=Stream.of(29,4,87,4,6,12,34,12,27,60,15,60);
		//System.out.println(st.distinct().count());
		//System.out.println(st.count()); no se puede usar un Stream después de haber llamado a un método
		//muestra los múltiplos de 5, no repetidos
		st.distinct()
			.filter(n->n%5==0)
			.forEach(n->System.out.println(n));
		
	}

}
