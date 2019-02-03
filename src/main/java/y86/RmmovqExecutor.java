package y86;

import java.math.BigInteger;

public class RmmovqExecutor extends Y86Executor {


    private Y86 y86;
    private String order;

    public RmmovqExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        execute();
    }

    public void execute() {
        // 取指
        rA = OrderReader.readHalf(order, 2);
        rB = OrderReader.readHalf(order, 3);
        valC = OrderReader.readByte(order, 4, 8);
        valP = y86.getPc().add(new BigInteger("20"));
        // 译码
        valA = y86.getRegister()[rA - 1];
        valB = y86.getRegister()[rB - 1];
        // 执行
        valE = valB + valC;
        // 访存
        y86.getMemory().set(valE, valA);
        // 更新pc
        y86.setPc(valP);
    }
}
