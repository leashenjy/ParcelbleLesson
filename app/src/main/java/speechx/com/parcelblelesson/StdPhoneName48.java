package speechx.com.parcelblelesson;

/**
 * Created by leashen on 2017/8/20.
 */

public enum  StdPhoneName48 {
    aa(0), ae(1), ah(2), ao(3), aw(4), ax(5), ay(6), eh(7), el(8), en(9),
    er(10), ey(11), ih(12), ix(13), iy(14), ow(15), oy(16),  uh(17),  uw(18),
    sil(19), epi(20), cl(21), vcl(22),
    b(23), ch(24), d(25), dh(26), dx(27), f(28),
    g(29), hh(30),  jh(31), k(32), l(33), m(34), n(35), ng(36),  p(37),
    r(38), s(39), sh(40), t(41), th(42), v(43), w(44), y(45), z(46), zh(47);

    StdPhoneName48(int nIndex)
    {

    }

    public static StdPhoneName48 getValue(String v){
        StdPhoneName48[] allStdPhoneName48 = StdPhoneName48.values();
        for(int i=0; i<allStdPhoneName48.length; i++){
            if(allStdPhoneName48[i].name().equals(v)){
                return allStdPhoneName48[i];
            }
        }
        return StdPhoneName48.sil;
    }
}
