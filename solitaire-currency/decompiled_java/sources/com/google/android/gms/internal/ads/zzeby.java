package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeby implements zzgcf {
    final /* synthetic */ zzfio zza;

    zzeby(zzebz zzebzVar, zzfio zzfioVar) {
        this.zza = zzfioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to get offline signal database: ".concat(String.valueOf(th.getMessage())));
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Error executing function on offline signal database: ".concat(String.valueOf(e10.getMessage())));
        }
    }
}
