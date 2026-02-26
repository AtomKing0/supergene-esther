package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbnf {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbno zzc;
    private zzbno zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbno zza(Context context, VersionInfoParcel versionInfoParcel, @Nullable zzfki zzfkiVar) {
        zzbno zzbnoVar;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbno(zzc(context), versionInfoParcel, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zza), zzfkiVar);
            }
            zzbnoVar = this.zzc;
        }
        return zzbnoVar;
    }

    public final zzbno zzb(Context context, VersionInfoParcel versionInfoParcel, zzfki zzfkiVar) {
        zzbno zzbnoVar;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbno(zzc(context), versionInfoParcel, (String) zzbec.zza.zze(), zzfkiVar);
            }
            zzbnoVar = this.zzd;
        }
        return zzbnoVar;
    }
}
