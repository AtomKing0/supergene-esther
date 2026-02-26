package com.braze.enums;

import com.braze.support.BrazeLogger;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public enum Month {
    JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11);

    public static final Companion Companion = new Companion(null);
    private final int value;

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final Month getMonth(int i10) {
            Month month;
            Month[] monthArrValues = Month.values();
            int length = monthArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    month = null;
                    break;
                }
                month = monthArrValues[i11];
                if (month.getValue() == i10) {
                    break;
                }
                i11++;
            }
            if (month != null) {
                return month;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new d(i10), 6, (Object) null);
            return null;
        }

        private Companion() {
        }
    }

    Month(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
