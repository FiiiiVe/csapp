package y86;

import org.junit.Test;
import y86.executor.IrmovqExecutor;


public class IrmovqExecutorTest {
    @Test
    public void test() {
        Y86 y86 = new Y86();
        String order = "30f3fcffffffffffffff";
        int pc = (int) y86.getPc();
        new IrmovqExecutor(y86, order.substring(pc, pc + 20));
        System.out.println(y86.getRegister()[2]);
    }
}