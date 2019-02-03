package y86;

public class Y86Main {
    private static boolean isDone = false;

    public static void main(String[] args) {
        Y86 y86 = new Y86();
        String order = "30f3fcffffffffffffff";
        while (y86.getPc() != order.length()){
            // String only support type int
            // TODO handle the question above
            int pc = (int) y86.getPc();
            byte icode = OrderReader.readHalf(order, pc);
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
