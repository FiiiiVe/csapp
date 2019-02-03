package y86.executor;

import y86.Y86;

public class JumopExecutor extends Y86Executor{
    private Y86 y86;
    private String order;

    public JumopExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        this.funCode = OrderReader.readHalf(order, 1);
        execute();
    }

    public void execute() {
        // 取指
        valC = OrderReader.readByte(order, 2, 8);
        valP = y86.getPc() + 18;
        // 执行
        boolean cnd = cond();
        // 更新pc
        y86.setPc(cnd ? valC : valP);
    }

    private boolean cond() {
        switch (funCode) {
            case 0x0: // jmp
                return true;
            case 0x1: // jle
                return (y86.getSF() ^ y86.getOF()) | y86.getZF();
            case 0x2: // jl
                return y86.getSF() ^ y86.getOF();
            case 0x3: // je
                return y86.getZF();
            case 0x4: // jne
                return !y86.getZF();
            case 0x5: // jge
                return y86.getSF() == y86.getOF();
            case 0x6: // jg
                return (y86.getSF() == y86.getOF()) & (!y86.getZF());
            default:
                throw new RuntimeException("wrong jump order");
        }
    }
}
