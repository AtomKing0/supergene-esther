package com.facebook.ads.redexgen.core;

import android.view.View;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1935Qh {
    public static String[] A00 = {"X094Ff6hX91n4UOeNZ5q6xBODyRF", "3SZuvdCuB3BE6lfK5qku2XxobaMEdUie", "GC5CoEiK4nrbG2wHW0FtwppW4DiO", "wga3z1tjiA3hov6SpIvZwMukezgQNZlv", "3xUgR2JHsSdawQ9thG1dfHrpvR", "GYcoMrIBN4ZdBxcuGgG7c5lcAAiSjlKe", "4bECUaOSHZBdJ", ""};

    public static int A00(@Nullable C1931Qd c1931Qd, @Nullable Q8 q82, View view, View view2, QO qo, boolean z10) {
        if (qo.A0Y() != 0) {
            int iA03 = c1931Qd.A03();
            if (A00[0].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[1] = "A1oAKfZoAPhZUsftVBl6ZIJw4txQWtbe";
            strArr[5] = "SaLVqq6GZrXjANh28rEV2dsKSTV0teZe";
            if (iA03 == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z10) {
                return Math.abs(qo.A0r(view) - qo.A0r(view2)) + 1;
            }
            int iA0C = q82.A0C(view2) - q82.A0F(view);
            int extend = q82.A0B();
            return Math.min(extend, iA0C);
        }
        return 0;
    }

    public static int A01(@Nullable C1931Qd c1931Qd, @Nullable Q8 q82, View view, View view2, QO qo, boolean z10) {
        if (qo.A0Y() == 0 || c1931Qd.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return c1931Qd.A03();
        }
        int iA0C = q82.A0C(view2) - q82.A0F(view);
        int iA0r = qo.A0r(view);
        int laidOutArea = qo.A0r(view2);
        float fAbs = iA0C / (Math.abs(iA0r - laidOutArea) + 1);
        int laidOutArea2 = c1931Qd.A03();
        return (int) (fAbs * laidOutArea2);
    }

    public static int A02(@Nullable C1931Qd c1931Qd, @Nullable Q8 q82, View view, View view2, QO qo, boolean z10, boolean z11) {
        int laidOutArea;
        if (qo.A0Y() == 0 || c1931Qd.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        int maxPosition = Math.min(qo.A0r(view), qo.A0r(view2));
        int iA0r = qo.A0r(view);
        int minPosition = qo.A0r(view2);
        int iMax = Math.max(iA0r, minPosition);
        if (z11) {
            int minPosition2 = c1931Qd.A03();
            laidOutArea = Math.max(0, (minPosition2 - iMax) - 1);
        } else {
            laidOutArea = Math.max(0, maxPosition);
        }
        if (!z10) {
            return laidOutArea;
        }
        int itemsBefore = q82.A0C(view2);
        int minPosition3 = q82.A0F(view);
        int maxPosition2 = Math.abs(itemsBefore - minPosition3);
        int itemsBefore2 = qo.A0r(view);
        int minPosition4 = qo.A0r(view2);
        float fAbs = laidOutArea * (maxPosition2 / (Math.abs(itemsBefore2 - minPosition4) + 1));
        int itemsBefore3 = q82.A0A();
        int minPosition5 = q82.A0F(view);
        return Math.round(fAbs + (itemsBefore3 - minPosition5));
    }
}
