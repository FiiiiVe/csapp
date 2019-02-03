package y86.executor;

import y86.Y86;

public class MrmovqExecutor extends Y86Executor {
    private Y86 y86;
    private String order;

    public MrmovqExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        execute();
    }

    public void execute() {
        // 取指
        rA = OrderReader.readHalf(order, 2);
        rB = OrderReader.readHalf(order, 3);
        valC = OrderReader.readByte(order, 4, 8);
        valP = y86.getPc() + 20;
        // 译码
        valA = y86.getRegister()[rA - 1];
        // 执行
        valE = valA + valC;
        // 访存
        valM = y86.getMemory().get(valE);
        // 写回
        y86.getRegister()[rB - 1] = valM;
        // 更新pc
        y86.setPc(valP);
    }
}
