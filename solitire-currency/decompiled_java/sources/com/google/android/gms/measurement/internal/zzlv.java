package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlv implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zzd;
    private final /* synthetic */ zzla zze;

    zzlv(zzla zzlaVar, String str, String str2, zzn zznVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zznVar;
        this.zzd = zzdiVar;
        this.zze = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzfq zzfqVar = this.zze.zzb;
            if (zzfqVar == null) {
                this.zze.zzj().zzg().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            ArrayList<Bundle> arrayListZzb = zznt.zzb(zzfqVar.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzam();
            this.zze.zzq().zza(this.zzd, arrayListZzb);
        } catch (RemoteException e10) {
            this.zze.zzj().zzg().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e10);
        } finally {
            this.zze.zzq().zza(this.zzd, arrayList);
        }
    }
}
