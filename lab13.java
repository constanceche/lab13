import java.util.ArrayList;

public class lab13 {
	public static ArrayList<Integer> list;
	
	public void readData (String filename) {
		list = new ArrayList<>();
		try
        {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String inn;
            while ( (inn = input.readLine() ) != null) {   
                list.add (Integer.valueOf(inn.trim()));
            }
            input.close();
        }
        catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	public long getTotalCount(){
		return list.stream().count();
	}

	public long getOddCount(){
		return list.stream().filter(x -> x % 2 == 1).count();
	}

	public long getEvenCount(){
		return list.stream().filter(x -> x % 2 == 0).count();
	}

	public long getDistinctGreaterThanFiveCount(){
		return list.stream().distinct().filter(x -> x > 5).count();
	}

	public Integer[] getResult1(){
		Integer [] list1;
		list1 = list.stream()
			.sorted()
			.filter(x -> x % 2 == 0 && x > 5 && x < 50)
			.toArray(Integer[]::new);
	
		return list1;
	}

	public Integer[] getResult2(){
		Integer [] list2;
		list2 = list.stream()
			.limit(50)
			.map(x -> (x*x)*3)
			.toArray(Integer[]::new);
	
		return list2;
	}

	public Integer[] getResult3(){
		Integer [] list3;
		list3 = list.stream()
			.filter(x -> x % 2 == 1)
			.map(x -> x*2)
			.sorted()
			.skip(20)
			.distinct()
			.toArray(Integer[]::new);
		return list3;
	}
}
