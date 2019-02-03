package y86;

import org.junit.Test;
import y86.executor.IrmovqExecutor;
import y86.executor.OPqExecutor;


public class OPqExecutorTest {
    @Test
    public void test() {
        Y86 y86 = new Y86();
        String order = "30f30400000000000070";
        int pc = (int) y86.getPc();
        new IrmovqExecutor(y86, order.substring(pc, pc + 20)); // -3
        new IrmovqExecutor(y86, "30f4040000000000007f"); // 3
        new OPqExecutor(y86, "6034");
        System.out.println(y86.getRegister()[3]);
    }

}