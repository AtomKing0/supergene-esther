package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzzw extends zzse {
    public zzzw(Throwable th, @Nullable zzsf zzsfVar, @Nullable Surface surface) {
        super(th, zzsfVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
    }
}
