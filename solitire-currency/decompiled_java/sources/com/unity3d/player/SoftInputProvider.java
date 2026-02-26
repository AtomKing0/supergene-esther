package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
abstract class SoftInputProvider {
    public static int a() {
        int iNativeGetSoftInputType = nativeGetSoftInputType();
        for (int i10 : y6.a.b(3)) {
            if (y6.d.a(i10) == iNativeGetSoftInputType) {
                return i10;
            }
        }
        return 1;
    }

    private static final native int nativeGetSoftInputType();
}
