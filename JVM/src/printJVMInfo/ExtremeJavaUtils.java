package printJVMInfo;

//Printing Info about our JVM
import java.lang.management.ManagementFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ExtremeJavaUtils {

	private final static int MB = 1024 * 1024;

	public static String fullVMArguments() {

		String name = javaVmName();
		StringBuilder buf = new StringBuilder();
		buf.append("\n" + "******************** My JVM Full VM Arguments ********************" + "\n");
		buf.append(name + "\n");
		buf.append((contains(name, "Server") ? "-server " : contains(name, "Client") ? "-client " : "")
				+ joinWithSpace(vmArguments()) + "\n");
		return buf.toString();
	}

	public static List<String> vmArguments() {
		return ManagementFactory.getRuntimeMXBean().getInputArguments();
	}

	public static boolean contains(String s, String b) {
		return s != null && s.indexOf(b) >= 0;
	}

	public static String javaVmName() {
		return System.getProperty("java.vm.name");
	}

	public static String joinWithSpace(Collection<String> c) {
		return join(" ", c);
	}

	public static String join(String glue, Iterable<String> strings) {
		if (strings == null)
			return "";
		StringBuilder buf = new StringBuilder();
		Iterator<String> i = strings.iterator();
		if (i.hasNext()) {
			buf.append(i.next());
			while (i.hasNext())
				buf.append(glue).append(i.next());
		}
		return buf.toString();
	}

	public static String printSystemProperties() {
		StringBuilder buf = new StringBuilder();
		buf.append("\n" + "******************** My JVM System Properties ********************" + "\n");
		buf.append("java.vm.name               = " + System.getProperty("java.vm.name") + "\n");
		buf.append("java.vm.info               = " + System.getProperty("java.vm.info") + "\n");
		buf.append("java.home                  = " + System.getProperty("java.home") + "\n");
		buf.append("java.vendor                = " + System.getProperty("java.vendor") + "\n");
		buf.append("java.version               = " + System.getProperty("java.version") + "\n");
		buf.append("java.specification.vendor  = " + System.getProperty("java.specification.vendor") + "\n");
		return buf.toString();

	}

	public static String printHeapStatistics() {
		StringBuilder buf = new StringBuilder();
		buf.append("\n" + "******************** JVM Heap Statistics [MB] ********************" + "\n");

		// Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();

		// Used memory
		buf.append("\n" +"Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / MB + "\n");
		// Free memory
		buf.append("Free Memory:" + runtime.freeMemory() / MB + "\n");
		// Total available memory
		buf.append("Total Memory:" + runtime.totalMemory() / MB + "\n");
		// Maximum available memory
		buf.append("Max Memory:" + runtime.maxMemory() / MB + "\n");
		return buf.toString();
	}
}