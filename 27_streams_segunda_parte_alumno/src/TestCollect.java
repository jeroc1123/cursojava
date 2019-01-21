import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollect {

	public static void main(String[] args) {
		Stream<String> cads=Stream.of("hola","mañana temprano","adios","bienvenido");
		System.out.println(cads.collect(Collectors.averagingInt(p->p.length())).toString());
		
		Double dob=5.3;
		System.out.println(dob);
	}

}
