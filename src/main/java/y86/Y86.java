package y86;

import java.math.BigInteger;
import java.util.HashMap;

public class Y86 {

    public class Memory {
        private HashMap<Long, Long> memory = new HashMap<>();

        public void set(long index, long num) {
            memory.put(index, num);
        }

        public Long get(long index) {
            return memory.get(index);
        }
    }

    Memory memory = new Memory();
    BigInteger pc = new BigInteger("0");
    Long[] register = new Long[16];
    Boolean ZF = null;
    Boolean SF = null;
    Boolean OF = null;

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public BigInteger getPc() {
        return pc;
    }

    public void setPc(BigInteger pc) {
        this.pc = pc;
    }

    public Long[] getRegister() {
        return register;
    }

    public void setRegister(Long[] register) {
        this.register = register;
    }

    public Boolean getZF() {
        return ZF;
    }

    public void setZF(Boolean ZF) {
        this.ZF = ZF;
    }

    public Boolean getSF() {
        return SF;
    }

    public void setSF(Boolean SF) {
        this.SF = SF;
    }

    public Boolean getOF() {
        return OF;
    }

    public void setOF(Boolean OF) {
        this.OF = OF;
    }
}
