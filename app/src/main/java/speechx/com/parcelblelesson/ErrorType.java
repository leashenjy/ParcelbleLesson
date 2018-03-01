package speechx.com.parcelblelesson;

/**
 * Created by leashen on 2017/8/20.
 */

public enum  ErrorType
{
    Del(0), Ins(1), Sub(2), Sil(3), Correct(4);

    private final int nValue; ///...

    ErrorType(int nValue)
    {
        this.nValue = nValue;
    }

    public static ErrorType getValue(int nIndex)
    {
        ErrorType[] pAllErrorType = ErrorType.values();
        for(int i = 0; i < pAllErrorType.length; i++)
        {
            if (pAllErrorType[i].ordinal() == nIndex)
            {
                return pAllErrorType[i];
            }
        }

        return ErrorType.Correct;
    }

    public int get_nValue()
    {
        return nValue;
    }

    public static ErrorType getValue(String strValue)
    {
        ErrorType[] pAllErrorType = ErrorType.values();

        for(int i = 0; i < pAllErrorType.length; i++)
        {
            if (pAllErrorType[i].name().equals(strValue))
            {
                return pAllErrorType[i];
            }
        }

        return ErrorType.Sil;
    }
}