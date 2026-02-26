package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzgcf;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzah implements zzgcf {
    final /* synthetic */ zzbtc zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzak zzc;

    zzah(zzak zzakVar, zzbtc zzbtcVar, boolean z10) {
        this.zza = zzbtcVar;
        this.zzb = z10;
        this.zzc = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        try {
            this.zza.zze("Internal error: " + th.getMessage());
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayList<Uri> arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzr || this.zzb) {
                for (Uri uri : arrayList) {
                    if (this.zzc.zzP(uri)) {
                        this.zzc.zzq.zzc(zzak.zzZ(uri, this.zzc.zzA, "1").toString(), null);
                    } else {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgJ)).booleanValue()) {
                            this.zzc.zzq.zzc(uri.toString(), null);
                        }
                    }
                }
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
        }
    }
}
