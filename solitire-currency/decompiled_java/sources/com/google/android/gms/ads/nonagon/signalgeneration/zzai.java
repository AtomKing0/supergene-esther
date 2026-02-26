package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzgcf;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzai implements zzgcf {
    final /* synthetic */ zzbtc zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzak zzc;

    zzai(zzak zzakVar, zzbtc zzbtcVar, boolean z10) {
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
        List<Uri> list = (List) obj;
        try {
            zzak.zzH(this.zzc, list);
            this.zza.zzf(list);
            if (this.zzc.zzs || this.zzb) {
                for (Uri uri : list) {
                    if (this.zzc.zzO(uri)) {
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
