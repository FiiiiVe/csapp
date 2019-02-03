package y86;

import java.math.BigInteger;

public class OPqExecutor extends Y86Executor {

    private Y86 y86;
    private String order;

    public OPqExecutor(Y86 y86, String order) {
        this.y86 = y86;
        this.order = order;
        this.funCode = OrderReader.readHalf(order, 1);
        execute();
    }

    public void execute() {
        // 取指
        rA = OrderReader.readHalf(order, 2);
        rB = OrderReader.readHalf(order, 3);
        valP = y86.getPc().add(new BigInteger("4"));
        // 译码
        valA = y86.getRegister()[rA - 1];
        valB = y86.getRegister()[rB - 1];
        // 执行
        valE = opq();
        setCC();
        // 写回
        y86.getRegister()[rB - 1] = valE;
        // 更新pc
        y86.setPc(valP);
    }

    private void setCC() {
        if (valE == 0) {
            y86.setZF(true);
        } else {
            y86.setZF(false);
        }

        if (valE < 0) {
            y86.setSF(true);
        } else {
            y86.setSF(false);
        }

        switch (funCode){
            case 0x0:
                if ((valA > 0 && valB > 0 && valE < 0) || (valA < 0 && valB < 0 && valE > 0)){
                    y86.setOF(true);
                } else {
                    y86.setOF(false);
                }
                break;
            case 0x1:
                if ((valA > 0 && valB < 0 && valE > 0) || (valA < 0 && valB > 0 && valE < 0)){
                    y86.setOF(true);
                } else {
                    y86.setOF(false);
                }
                break;
            default:
                y86.setOF(false);
        }
    }

    private Long opq() {
        switch (funCode) {
            case 0x0:
                return addq();
            case 0x1:
                return subq();
            case 0x2:
                return andq();
            case 0x3:
                return xorq();
            default:
                throw new RuntimeException("wrong OPq order");
        }
    }

    private Long xorq() {
        return valA ^ valB;
    }

    private Long andq() {
        return valA & valB;
    }

    private Long subq() {
        return valB - valA;
    }

    private Long addq() {
        return valA + valB;
    }
}
