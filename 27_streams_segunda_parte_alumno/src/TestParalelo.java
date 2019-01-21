import java.util.stream.Stream;

public class TestParalelo {

	public static void main(String[] args) {
		Stream<Integer> st=Stream.of(6,8,2,9,4,11,7).parallel();
		//st.forEach(p-> System.out.println(p));
		//st.parallel().forEach(p-> System.out.println(p));
		//System.out.println(st.mapToInt(p->p).parallel().sum());
		//st.parallel().sorted().forEach(s->System.out.println(s));
		st.sequential().forEach(s->System.out.println(s));
	}
}