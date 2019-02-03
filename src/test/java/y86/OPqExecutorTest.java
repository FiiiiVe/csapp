package y86;

import org.junit.Test;

import static org.junit.Assert.*;

public class OPqExecutorTest {
    @Test
    public void test() {
        Y86 y86 = new Y86();
        String order = "30f30400000000000070";
        int pc = y86.getPc().intValue();
        new IrmovqExecutor(y86, order.substring(pc, pc + 20)); // -3
        new IrmovqExecutor(y86, "30f4040000000000007f"); // 3
        new OPqExecutor(y86, "6034");
        System.out.println(y86.getRegister()[3]);
    }

}