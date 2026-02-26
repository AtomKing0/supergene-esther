package com.braze;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final class Constants {
    public static final Constants INSTANCE = new Constants();
    private static final boolean isAmazonDevice = kotlin.jvm.internal.t.d("Amazon", Build.MANUFACTURER);

    private Constants() {
    }

    public static final boolean isAmazonDevice() {
        return isAmazonDevice;
    }
}
