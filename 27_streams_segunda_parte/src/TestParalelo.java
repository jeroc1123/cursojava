import java.util.stream.Stream;

public class TestParalelo {

	public static void main(String[] args) {
		Stream<Integer> st=Stream.of(6,8,2,9,4,11,7);
		//st.forEach(n->System.out.println(n));
		//st.parallel().forEach(n->System.out.println(n));
		
		//System.out.println(st.mapToInt(n->n).parallel().sum());
		//st.parallel().sorted().forEach(s->System.out.println(s));
		//st.parallel().sequential().forEach(s->System.out.println(s));
		//st.parallel().sorted().sequential().forEach(s->System.out.println(s));
	}

}
