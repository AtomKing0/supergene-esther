package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c8 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11543a;

        static {
            int[] iArr = new int[h8.values().length];
            try {
                iArr[h8.Pacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h8.ShowCount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h8.Delivery.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11543a = iArr;
        }
    }

    public final int a(@NotNull h8 cappingType) {
        kotlin.jvm.internal.t.i(cappingType, "cappingType");
        int i10 = a.f11543a[cappingType.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return 3000;
        }
        if (i10 == 3) {
            return 3001;
        }
        throw new v8.q();
    }
}
