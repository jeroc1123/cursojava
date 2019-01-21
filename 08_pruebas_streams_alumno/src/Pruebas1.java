import java.util.stream.Stream;

public class Pruebas1 {

	public static void main(String[] args) {
		Stream<Integer> st = Stream.of(29,4,87,4,6,152,34,12,25,60);
		//System.out.println(st.distinct().count());
		//da una excepcion en ejecucion ya que el objeto st ya no existe
		//despues de haber llamado a un metodo
		//System.out.println(st.count());
		
		//muestra los multiplos de 5, no repetidos
		st.distinct()
			.filter(n->n%5==0)
			.forEach(n->System.out.println(n));
	}

}
