package y86;

import java.math.BigInteger;

public class RrmovqExecutor extends Y86Executor {

    private Y86 y86;
    private String order;

    public RrmovqExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        execute();
    }

    public void execute() {
        // 取指
        rA = OrderReader.readHalf(order, 2);
        rB = OrderReader.readHalf(order, 3);
        valP = y86.getPc().add(new BigInteger("4"));
        // 译码
        valA = y86.getRegister()[rA - 1];
        // 写回
        y86.getRegister()[rB - 1] = valA;
        // 更新pc
        y86.setPc(valP);
    }
}
