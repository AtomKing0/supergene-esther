package com.onetrust.otpublishers.headless.gpp;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static String a(int i10) {
        ArrayList arrayList = new ArrayList();
        if (i10 >= 1) {
            arrayList.add(1);
            int i11 = 2;
            if (i10 >= 2) {
                arrayList.add(2);
                while (true) {
                    int i12 = i11 - 1;
                    int i13 = i11 - 2;
                    if (i10 < ((Integer) arrayList.get(i13)).intValue() + ((Integer) arrayList.get(i12)).intValue()) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(((Integer) arrayList.get(i13)).intValue() + ((Integer) arrayList.get(i12)).intValue()));
                    i11++;
                }
            }
        }
        StringBuilder sb = new StringBuilder("1");
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int iIntValue = ((Integer) arrayList.get(size)).intValue();
            if (i10 >= iIntValue) {
                sb.insert(0, "1");
                i10 -= iIntValue;
            } else {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }
}
