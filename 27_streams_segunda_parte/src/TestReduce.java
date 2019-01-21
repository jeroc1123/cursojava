import java.util.stream.Stream;

public class TestReduce {

	public static void main(String[] args) {
		Stream<Integer> st=Stream.of(6,8,2,9,4,11,7);
		System.out.println(st.parallel().reduce((a,b)->a+b));

	}

}
