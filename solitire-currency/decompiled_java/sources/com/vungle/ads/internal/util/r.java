package com.vungle.ads.internal.util;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RangeUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r {

    @NotNull
    public static final r INSTANCE = new r();

    private r() {
    }

    public static /* synthetic */ boolean isInRange$default(r rVar, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        return rVar.isInRange(i10, i11, i12);
    }

    public final boolean isInRange(float f10, float f11, float f12) {
        return f11 <= f10 && f10 <= f12;
    }

    public static /* synthetic */ boolean isInRange$default(r rVar, float f10, float f11, float f12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f12 = Float.MAX_VALUE;
        }
        return rVar.isInRange(f10, f11, f12);
    }

    public final boolean isInRange(int i10, int i11, int i12) {
        return i11 <= i10 && i10 <= i12;
    }
}
