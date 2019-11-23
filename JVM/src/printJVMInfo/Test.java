package printJVMInfo;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(ExtremeJavaUtils.fullVMArguments());

		System.out.println(ExtremeJavaUtils.printSystemProperties());
		
		System.out.println(ExtremeJavaUtils.printHeapStatistics());
		

		
	}

	

}