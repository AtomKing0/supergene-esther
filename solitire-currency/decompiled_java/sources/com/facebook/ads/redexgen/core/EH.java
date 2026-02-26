package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class EH {
    public static String[] A00 = {"94gd2lHaz6driogpt3Nl1tWsjXgriMxS", "VA5F17cuoV6wg6So0a0DluDefxsQAbFW", "BZfou2TK48MMfd1yJcRZTZ4JcnnWlmHT", "ilV1kn3efEuJyycOIV0UyN70TAMLymqY", "v19hT7CAJaCb1rntEZC2LQpyBVrX3IkZ", "rkpPVUKbY", "FKwb9S", "XsKsPoEAnPyrLBiotdeURrQ5Q46xoiIz"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C3019o6 A01(EC ec, List<? extends EE>[] listArr) {
        C13071h c13071h = new C13071h();
        int i10 = 0;
        loop0: while (true) {
            boolean z10 = false;
            if (i10 >= ec.A02()) {
                C2901mA c2901mAA06 = ec.A06();
                for (int i11 = 0; i11 < c2901mAA06.A01; i11++) {
                    C3030oH c3030oHA05 = c2901mAA06.A05(i11);
                    int[] iArr = new int[c3030oHA05.A01];
                    Arrays.fill(iArr, 0);
                    c13071h.A04(new C3020o7(c3030oHA05, false, iArr, new boolean[c3030oHA05.A01]));
                }
                return new C3019o6(c13071h.A05());
            }
            C2901mA c2901mAA07 = ec.A07(i10);
            List<? extends EE> list = listArr[i10];
            int i12 = 0;
            while (i12 < c2901mAA07.A01) {
                C3030oH c3030oHA052 = c2901mAA07.A05(i12);
                int iA05 = ec.A05(i10, i12, z10);
                String[] strArr = A00;
                if (strArr[7].charAt(11) != strArr[0].charAt(11)) {
                    break loop0;
                }
                String[] strArr2 = A00;
                strArr2[7] = "wVGS7RX5kLdrLFKtRIe7uQsNtd1z6IxW";
                strArr2[0] = "7aERijPLyLRrdgSw5lQfoyda5cW2h3c0";
                boolean z11 = iA05 != 0;
                int[] iArr2 = new int[c3030oHA052.A01];
                boolean[] zArr = new boolean[c3030oHA052.A01];
                for (int i13 = 0; i13 < c3030oHA052.A01; i13++) {
                    iArr2[i13] = ec.A04(i10, i12, i13);
                    boolean z12 = false;
                    if (A00[5].length() != 9) {
                        break loop0;
                    }
                    String[] strArr3 = A00;
                    strArr3[2] = "3DHxmUKuGZITV4091m9MLUNqu1ZkNm0q";
                    strArr3[3] = "2BQZhu0LL1SbQMNt9wHOkoks63NLimX3";
                    int i14 = 0;
                    while (true) {
                        if (i14 < list.size()) {
                            EE ee = list.get(i14);
                            if (ee.A9D().equals(c3030oHA052) && ee.A9y(i13) != -1) {
                                z12 = true;
                                break;
                            }
                            i14++;
                        }
                    }
                    zArr[i13] = z12;
                }
                c13071h.A04(new C3020o7(c3030oHA052, z11, iArr2, zArr));
                i12++;
                z10 = false;
            }
            i10++;
        }
        throw new RuntimeException();
    }

    public static C3019o6 A00(EC ec, EE[] eeArr) {
        List listA01;
        List[] listArr = new List[eeArr.length];
        for (int i10 = 0; i10 < eeArr.length; i10++) {
            EE ee = eeArr[i10];
            if (ee != null) {
                listA01 = AbstractC1531Am.A04(ee);
            } else {
                listA01 = MetaExoPlayerCustomizedCollections.A01();
            }
            listArr[i10] = listA01;
        }
        return A01(ec, listArr);
    }
}
