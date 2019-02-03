package y86.executor;

import y86.Y86;

public class PushqExecutor extends Y86Executor{
    private Y86 y86;
    private String order;

    public PushqExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        execute();
    }

    @Override
    public void execute() {
        // 取指
        rA = OrderReader.readHalf(order, 2);
        valP = y86.getPc() + 4;
        // 译码
        valA = y86.getRegister()[rA - 1];
        valB = y86.getRegister()[4]; // %rsp
        // 执行
        valE = valB - 8;
        // 访存
        y86.getMemory().set(valE, valA);
        // 写回
        y86.getRegister()[4] = valE;
        // 更新pc
        y86.setPc(valP);
    }
}
