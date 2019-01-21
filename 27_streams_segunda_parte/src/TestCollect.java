import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollect {

	public static void main(String[] args) {
		Stream<String> cads=Stream.of("hola","mañana temprano","adios","bienevenido");
		System.out.println(cads.collect(Collectors.averagingDouble(s->s.length())).doubleValue());

		
		
	}

}
