package y86;

import org.junit.Test;
import y86.executor.*;


public class JumopExecutorTest {
    private static boolean isDone = false;

    @Test
    public void test() {
        Y86 y86 = new Y86();
        /*
        int i = 4;
        if (i!=10){
            i ++;
        }

         */
        String order = "30f3040000000000000030f40100000000000000604330f50a00000000000000613574280000000000000000";
        while (y86.getPc() != order.length()){
            int pc = (int) y86.getPc();
            byte icode = OrderReader.readHalf(order, pc);
            execute(y86, order, pc, icode);
            if (isDone) {
                System.out.println("Y86 is closed");
                break;
            }
        }


        System.out.println(y86.getRegister()[2]);
    }

    public static void execute(Y86 y86, String order, int pc, byte icode) {
        switch (icode) {
            case 0x0:
                isDone = true;
                break;
            case 0x2:
                new RrmovqExecutor(y86, order.substring(pc, pc + 4));
                break;
            case 0x3:
                System.out.println();
                new IrmovqExecutor(y86, order.substring(pc, pc + 20));
                break;
            case 0x4:
                new RmmovqExecutor(y86, order.substring(pc, pc + 20));
                break;
            case 0x5:
                new MrmovqExecutor(y86, order.substring(pc, pc + 20));
                break;
            case 0x6:
                new OPqExecutor(y86, order.substring(pc, pc + 4));
                break;
            case 0x7:
                new JumopExecutor(y86, order.substring(pc, pc + 18));
                break;
            default:
                throw new RuntimeException("wrong order at index : " + pc + ", icode : " + Integer.toHexString(icode));
        }
    }


}