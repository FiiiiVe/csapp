package y86;

import java.math.BigInteger;
import java.util.HashMap;

public class Y86 {

    public class Memory {
        private HashMap<Long, Long> memory = new HashMap<>();

        public void set(long index, long num) {
            memory.put(index, num);
        }

        // TODO handle when index is not 8n
        public Long get(long index) {
            return memory.get(index);
        }
    }

    Memory memory = new Memory();
    long pc = 0;
    long[] register = new long[16];
    Boolean ZF = null;
    Boolean SF = null;
    Boolean OF = null;

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public long getPc() {
        return pc;
    }

    public void setPc(long pc) {
        this.pc = pc;
    }

    public long[] getRegister() {
        return register;
    }

    public void setRegister(long[] register) {
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
