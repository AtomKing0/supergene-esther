package com.google.android.gms.internal.base;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zan {
    @ChecksSdkIntAtLeast(api = 33)
    static boolean zaa() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
