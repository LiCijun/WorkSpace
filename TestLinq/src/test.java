import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import net.hydromatic.linq4j.Linq4j;
import net.hydromatic.linq4j.function.Function1;

public class test {

	public static void main(String[] args) {
		List<A> aList = new ArrayList<A>();
		A item = new A();
		item.x = 2;
		item.aaString = "BB";
		aList.add(item);

		item = new A();
		item.x = 2;
		item.aaString = "AA";

		item = new A();
		item.x = 3;
		item.aaString = "AA3";

		aList.add(item);

		aList = Linq4j.asEnumerable(aList).orderBy(new Function1<A, String>() {

			@Override
			public String apply(A arg0) {
				return arg0.aaString;
			}
		}, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}
		}).toList();

		System.out.print(aList.get(0).aaString);
		System.out.print(aList.get(0).aaString);
		System.out.print(aList.get(0).aaString);

	}

}
