package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccn extends com.google.android.gms.ads.internal.util.zzb {
    final zzcbk zza;
    final zzccv zzb;
    private final String zzc;
    private final String[] zzd;

    zzccn(zzcbk zzcbkVar, zzccv zzccvVar, String str, String[] strArr) {
        this.zza = zzcbkVar;
        this.zzb = zzccvVar;
        this.zzc = str;
        this.zzd = strArr;
        com.google.android.gms.ads.internal.zzu.zzy().zzb(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzccm(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final m zzb() {
        return (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbM)).booleanValue() && (this.zzb instanceof zzcde)) ? zzbzo.zze.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzccl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        }) : super.zzb();
    }

    final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
