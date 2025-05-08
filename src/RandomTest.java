import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import edu.uwm.cs.random.AbstractRandomTest;
import edu.uwm.cs.random.Command;
import edu.uwm.cs351.StringPriorityQueue;

public class RandomTest extends AbstractRandomTest<PriorityQueue<String>,StringPriorityQueue>{

	private static final int MAX_TESTS = 1_000_000;
	private static final int DEFAULT_MAX_TEST_LENGTH = 1_000;
		
	public static final int NUM_TILES = 10;
		
	@SuppressWarnings("unchecked")
	private static Class<PriorityQueue<String>> refClass = (Class<PriorityQueue<String>>)(Class<?>)PriorityQueue.class;

	protected RandomTest() {
		super(refClass, StringPriorityQueue.class, "StringPriorityQueue", "pq", MAX_TESTS, DEFAULT_MAX_TEST_LENGTH);
	}
	
	protected String randomString(Random r) {
		StringBuilder sb = new StringBuilder();
		while (r.nextBoolean()) {
			int i = r.nextInt(8);
			sb.append((char)(i+'A'));	
		};
		return sb.toString();
	}
	
	private Command<?> newPQCommand = newCommand();
    private Function<Integer,Command<?>> isEmptyCommand = build(lift(PriorityQueue<String>::isEmpty), lift(StringPriorityQueue::isEmpty), "isEmpty"); 
    private Function<Integer, Command<?>> removeCommand = build(lift((PriorityQueue<String> pq) -> pq.remove()), lift(StringPriorityQueue::remove), "remove");
    private BiFunction<Integer, String, Command<?>> addCommand = build(lift(PriorityQueue<String>::add), lift(StringPriorityQueue::add), "add");
    @Override
    protected Command<?> randomCommand(Random r) {
    	int n = mainClass.size();
    	if (n == 0) return newPQCommand;
    	int w = r.nextInt(n);

    	switch (r.nextInt(7)) {
    	default:
    	case 0:
    		return newPQCommand;
    	case 1:
    	case 2:
    		return addCommand.apply(w, randomString(r));
    	case 3:
    	case 4:
    		return isEmptyCommand.apply(w);
    	case 5:
    	case 6:
    		return removeCommand.apply(w);
    	}
    }


	@Override
	public void printImports() {	
		super.printImports();
		System.out.println("import edu.uwm.cs351.StringPriorityQueue;\n");
	}
	
	public static void main(String[] args) {
		RandomTest rt = new RandomTest();
		rt.run();
	}

}
