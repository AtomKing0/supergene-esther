package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final char[] f19330a;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        kotlin.jvm.internal.t.h(charArray, "this as java.lang.String).toCharArray()");
        f19330a = charArray;
    }

    @NotNull
    public static final String a(@NotNull byte[] bArr) {
        kotlin.jvm.internal.t.i(bArr, "<this>");
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = f19330a;
            cArr[i11] = cArr2[(b10 & 255) >>> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }
}
