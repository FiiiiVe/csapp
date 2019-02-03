package y86.executor;

import y86.Y86;

public class RetExecutor extends Y86Executor{
    private Y86 y86;
    private String order;

    public RetExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        execute();
    }

    @Override
    public void execute() {
        // 取指
//        valP = y86.getPc() + 2;
        // 译码
        valA = y86.getRegister()[4]; // %rsp
        // 执行
        valE = valA + 8;
        // 访存
        valM = y86.getMemory().get(valA);
        // 写回
        y86.getRegister()[4] = valE;
        // 更新pc
        y86.setPc(valM);
    }
}
