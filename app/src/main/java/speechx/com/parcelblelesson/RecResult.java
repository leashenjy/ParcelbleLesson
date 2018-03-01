package speechx.com.parcelblelesson;

/**
 * Created by leashen on 2017/8/20.
 */

public enum RecResult
{
    Error(0), Unclear(1), Fair(2), Correct(3);

    private final int nValue;

    RecResult(int nValue)
    {
        this.nValue = nValue;
    }

    public int get_nValue()
    {
        return nValue;
    }

    public static RecResult getValue(int nIndex)
    {
        RecResult[] pAllRecResult = RecResult.values();
        for(int i = 0; i < pAllRecResult.length; i++)
        {
            if (pAllRecResult[i].ordinal() == nIndex)
            {
                return pAllRecResult[i];
            }
        }

        return RecResult.Unclear;
    }

    public static RecResult getValue(String strValue)
    {
        RecResult[] pAllRecResult = RecResult.values();

        for(int i = 0; i < pAllRecResult.length; i++)
        {
            if (pAllRecResult[i].name().equals(strValue))
            {
                return pAllRecResult[i];
            }
        }

        return RecResult.Unclear;
    }
}
