package y86.executor;

import y86.Y86;

public class IrmovqExecutor extends Y86Executor {
    private Y86 y86;
    private String order;

    public IrmovqExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        execute();
    }

    public void execute() {
        // 取指
        rA = 0xF;
        rB = OrderReader.readHalf(order, 3);
        valP = y86.getPc() + 20;
        valC = OrderReader.readByte(order, 4, 8);
        // 写回
        y86.getRegister()[rB - 1] = valC;
        // 更新pc
        y86.setPc(valP);
    }


}
