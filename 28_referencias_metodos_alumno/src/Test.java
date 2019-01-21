import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		Stream<Integer> st=Stream.of(6,8,2,9,4,11,7);
		//st.forEach(p-> System.out.println(p));
		st.forEach(System.out::println);

		Map<Integer,String> mapa=new HashMap<>();
		mapa.put(100, "Java");
		mapa.put(340, "NET");
		mapa.put(260, "PHP");
		mapa.forEach((k,v)->System.out.println(k+v));
		//mapa.forEach(System.out::println); //Asi no se puede por que no puede deducir del contexto lo que tiene que imprimir
		
		BiPredicate<String, String> pr=(a,b)->a.equals(b);
		//Aqui si puede determinar por el contexto los objetos que se quieren comparar
		BiPredicate<String, String> pr2=String::equals;
		
		BinaryOperator<Integer> bo=(a,b)->Math.max(a,b);
		BinaryOperator<Integer> bo2=Math::max;
		
		Function<char[],String> fn=ar->new String(ar);
		Function<char[],String> fn2=String::new;
		
		Consumer<String> con = s->s.toUpperCase();
		Consumer<String> con2= String::toUpperCase;
	}

}
