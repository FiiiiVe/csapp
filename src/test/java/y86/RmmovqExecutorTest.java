package y86;

import org.junit.Test;

import static org.junit.Assert.*;

public class RmmovqExecutorTest {

    @Test
    public void test(){
        Y86 y86 = new Y86();
        String order = "30f3fcffffffffffffff";
        int pc = y86.getPc().intValue();
        new IrmovqExecutor(y86, order.substring(pc, pc + 20));
        System.out.println(y86.getRegister()[2]);
        new RmmovqExecutor(y86, "40330000000000000000");
        System.out.println(y86.getMemory().get(-4));
    }

}