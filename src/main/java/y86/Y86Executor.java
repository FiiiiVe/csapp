package y86;

import java.math.BigInteger;

public abstract class Y86Executor {
    public byte rA;
    public byte rB;
    public BigInteger valP;
    public Long valA;
    public Long valB;
    public Long valC;
    public Long valE;
    public Long valM;

    public abstract void execute();

}
