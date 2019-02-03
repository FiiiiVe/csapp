package y86.executor;

import y86.Y86;

public class CallExecutor extends Y86Executor{

    private Y86 y86;
    private String order;

    public CallExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        execute();
    }

    public void execute() {
        // 取指
        valC = OrderReader.readByte(order, 2, 8);
        valP = y86.getPc() + 18;
        // 译码
        valB = y86.getRegister()[4];// %rsp
        // 执行
        valE = valB - 8;
        // 访存
        y86.getMemory().set(valE, valP);
        // 写回
        y86.getRegister()[4] = valE;
        // 更新pc
        y86.setPc(valC);
    }
}
