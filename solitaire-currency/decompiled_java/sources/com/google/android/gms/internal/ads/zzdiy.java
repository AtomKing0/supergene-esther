package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdiy {

    @Nullable
    private zzbfa zza;

    public zzdiy(zzdik zzdikVar) {
        this.zza = zzdikVar;
    }

    @Nullable
    public final synchronized zzbfa zza() {
        return this.zza;
    }

    public final synchronized void zzb(@Nullable zzbfa zzbfaVar) {
        this.zza = zzbfaVar;
    }
}
