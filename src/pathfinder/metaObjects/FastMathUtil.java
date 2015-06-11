package pathfinder.metaObjects;

/**
 * Collection of fast math functions.
 *
 * @author Jacob Moyer
 *
 */
public class FastMathUtil
{
    private final double[] cos = new double[360];
    private final double[] sin = new double[360];
    private final double[] tan = new double[360];
    private static FastMathUtil table = new FastMathUtil();

    private FastMathUtil()
    {
        for (int i = 0; i < 360; i++)
        {
            sin[i] = Math.sin(Math.toRadians(i));
            cos[i] = Math.cos(Math.toRadians(i));
            tan[i] = Math.tan(Math.toRadians(i));
        }
    }

    public double getSine(int angle)
    {
        final int angleCircle = angle % 360;
        return sin[angleCircle];
    }

    public double getCos(int angle)
    {
        final int angleCircle = angle % 360;
        return cos[angleCircle];
    }

    public double getTan(int angle)
    {
        final int angleCircle = angle % 360;
        return tan[angleCircle];
    }

    public static FastMathUtil getTable()
    {
        return table;
    }

    /**
     * Raises base to the exp power. This is a fast integer math implementation.
     *
     * @param base
     * @param exp
     * @return
     */
    public static int ipow(int base, int exp)
    {
        int result = 1;
        while (exp != 0)
        {
            if ((exp & 1) == 1)
            {
                result *= base;
            }
            exp >>= 1;
            base *= base;
        }

        return result;
    }
}