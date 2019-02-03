package y86;

public class OrderReader {
    public static Long readByte(String order, int start, int length) {
        long l = 0L;
        for (int i = start; i < start + length * 2; i += 2) {
            long b1 = transition(order.substring(i, i + 1));
            long b2 = transition(order.substring(i + 1, i + 2));
            l += ((b1 << 4) + b2) << ((i - start) * 4);
        }
        return l;
    }

    public static Byte readHalf(String order, int start) {
        return (byte) (transition(order.substring(start, start + 1)) & 0xFF);
    }

    private static long transition(String c) {
        if ("0".equals(c)) {
            return 0x0L;
        } else if ("1".equals(c)) {
            return 0x1L;
        } else if ("2".equals(c)) {
            return 0x2L;
        } else if ("3".equals(c)) {
            return 0x3L;
        } else if ("4".equals(c)) {
            return 0x4L;
        } else if ("5".equals(c)) {
            return 0x5L;
        } else if ("6".equals(c)) {
            return 0x6L;
        } else if ("7".equals(c)) {
            return 0x7L;
        } else if ("8".equals(c)) {
            return 0x8L;
        } else if ("9".equals(c)) {
            return 0x9L;
        } else if ("A".equals(c) || "a".equals(c)) {
            return 0xAL;
        } else if ("B".equals(c) || "b".equals(c)) {
            return 0xBL;
        } else if ("C".equals(c) || "c".equals(c)) {
            return 0xCL;
        } else if ("D".equals(c) || "d".equals(c)) {
            return 0xDL;
        } else if ("E".equals(c) || "e".equals(c)) {
            return 0xEL;
        } else if ("F".equals(c) || "f".equals(c)) {
            return 0xFL;
        }
        throw new RuntimeException("wrong order");
    }
}
