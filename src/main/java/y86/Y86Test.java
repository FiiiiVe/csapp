package y86;

public class Y86Test {
    public static void main(String[] args) {
        Y86 y86 = new Y86();
        String order = "30f3fcffffffffffffff";
        int pc = y86.getPc().intValue();
        byte icode = (byte) (OrderReader.readByte(order, pc, 1) & 0xFF);
        execute(y86, order, pc, icode);
        System.out.println(y86.getRegister()[2]);
        new RmmovqExecutor(y86, "40330000000000000000");
        System.out.println(y86.getMemory().get(-4));
        new IrmovqExecutor(y86, "30f4fdffffffffffffff");
        System.out.println(y86.getRegister()[3]);
        new MrmovqExecutor(y86, "50340000000000000000");
        System.out.println(y86.getRegister()[3]);
    }

    private static void execute(Y86 y86, String order, int pc, byte icode) {
        if (0x20 == (icode)) {
            new RrmovqExecutor(y86, order.substring(pc, pc + 4));
        } else if (0x30 == (icode)) {
            new IrmovqExecutor(y86, order.substring(pc, pc + 20));
        } else if (0x40 == icode) {
            new RmmovqExecutor(y86, order.substring(pc, pc + 20));
        } else if (0x50 == icode) {
            new MrmovqExecutor(y86, order.substring(pc, pc + 20));
        }
    }

}
