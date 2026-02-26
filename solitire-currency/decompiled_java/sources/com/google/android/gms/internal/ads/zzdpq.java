package com.google.android.gms.internal.ads;

import android.view.InputEvent;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdpq {
    private InputEvent zza;

    @VisibleForTesting(otherwise = 3)
    public zzdpq() {
    }

    public final InputEvent zza() {
        return this.zza;
    }

    public final void zzb(InputEvent inputEvent) {
        this.zza = inputEvent;
    }
}
