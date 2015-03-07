import java.util.*;
class Countries{
	public static void main(String[] args) {
		String cities = "Banglore->Singapore";
		String[] splitted = cities.split("->");
		System.out.println(splitted);
		List<List<String>> countries = new ArrayList<List<String>>();
		List<String> aaa = new ArrayList<String>();
		List<String> bbb = new ArrayList<String>();

		aaa.add("Banglore");
		aaa.add("India");
		bbb.add("Singapore");
		bbb.add("Singapore");
		countries.add(aaa);
		countries.add(bbb);
		System.out.println(countries);
		List<String> output = new ArrayList<String>();
		for (String city :splitted ) {
			for (List<String> l :countries ) {
				if(city.equals(l.get(0)) == true){
					city = city+"["+l.get(1)+"]";
					output.add(city);
				}
			}
		}
		// for (String a :splitted ) {
			System.out.println("-------------"+output);
		// }


	}
}