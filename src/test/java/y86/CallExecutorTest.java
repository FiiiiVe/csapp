package y86;

import org.junit.Test;
import y86.executor.*;

public class CallExecutorTest{

    private static boolean isDone = false;
    @Test
    public void test() {
        /*
        int i = 4;
        if (i!=10){
            increase();
        }

        increase(){
            i++;
        }

         */
        Y86 y86 = new Y86();
        String order = "30f1040000000000000030f2010000000000000080680000000000000030f30a0000000000000061137428000000000000000000602190";
        while (y86.getPc() != order.length()){
            int pc = (int) y86.getPc();
            byte icode = OrderReader.readHalf(order, pc);
            System.out.println();
            execute(y86, order, pc, icode);
            if (isDone) {
                System.out.println("Y86 is closed");
                break;
            }
        }
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
            case 0x8:
                new CallExecutor(y86, order.substring(pc, pc + 18));
                break;
            case 0x9:
                System.out.println();
                new RetExecutor(y86, order.substring(pc, pc + 2));
                break;
            case 0xA:
                new PushqExecutor(y86, order.substring(pc, pc + 4));
                break;
            case 0xB:
                new PopqExecutor(y86, order.substring(pc, pc + 4));
                break;
            default:
                throw new RuntimeException("wrong order at index : " + pc + ", icode : " + Integer.toHexString(icode));
        }
    }
}