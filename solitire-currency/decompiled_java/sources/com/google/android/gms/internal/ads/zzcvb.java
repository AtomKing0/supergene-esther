package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcvb implements zzczo, zzdfc {
    private final Context zza;
    private final zzffg zzb;
    private final VersionInfoParcel zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzdun zze;
    private final zzfki zzf;

    public zzcvb(Context context, zzffg zzffgVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.util.zzg zzgVar, zzdun zzdunVar, zzfki zzfkiVar) {
        this.zza = context;
        this.zzb = zzffgVar;
        this.zzc = versionInfoParcel;
        this.zzd = zzgVar;
        this.zze = zzdunVar;
        this.zzf = zzfkiVar;
    }

    private final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdC)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzffg zzffgVar = this.zzb;
            zzfki zzfkiVar = this.zzf;
            com.google.android.gms.ads.internal.zzu.zza().zzc(context, versionInfoParcel, zzffgVar.zzf, zzgVar.zzh(), zzfkiVar);
        }
        this.zze.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zze(@Nullable com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdD)).booleanValue()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zzf(@Nullable String str) {
    }
}
