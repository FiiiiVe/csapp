package y86.executor;

import java.math.BigInteger;

public abstract class Y86Executor {
    public byte icode;
    public byte funCode;
    public byte rA;
    public byte rB;
    public long valP;
    public long valA;
    public long valB;
    public long valC;
    public long valE;
    public long valM;

    public abstract void execute();

}
