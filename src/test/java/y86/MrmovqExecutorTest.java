package y86;

import org.junit.Test;


public class MrmovqExecutorTest {
    @Test
    public void test() {
        Y86 y86 = new Y86();
        String order = "30f3fcffffffffffffff";
        int pc = (int) y86.getPc();
        new IrmovqExecutor(y86, order.substring(pc, pc + 20));
        System.out.println(y86.getRegister()[2]);
        new RmmovqExecutor(y86, "40330000000000000000");
        System.out.println(y86.getMemory().get(-4));
        new MrmovqExecutor(y86, "50340000000000000000");
        System.out.println(y86.getRegister()[3]);
    }

}