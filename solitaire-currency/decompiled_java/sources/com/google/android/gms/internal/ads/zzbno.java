package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbno {

    @VisibleForTesting
    static final com.google.android.gms.ads.internal.util.zzbd zza = new zzbnm();

    @VisibleForTesting
    static final com.google.android.gms.ads.internal.util.zzbd zzb = new zzbnn();
    private final zzbna zzc;

    public zzbno(Context context, VersionInfoParcel versionInfoParcel, String str, zzfki zzfkiVar) {
        this.zzc = new zzbna(context, versionInfoParcel, str, zza, zzb, zzfkiVar);
    }

    public final zzbne zza(String str, zzbnh zzbnhVar, zzbng zzbngVar) {
        return new zzbns(this.zzc, str, zzbnhVar, zzbngVar);
    }

    public final zzbnx zzb() {
        return new zzbnx(this.zzc);
    }
}
