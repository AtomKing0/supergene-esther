package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazx {
    private com.google.android.gms.ads.internal.client.zzbu zza;
    private final Context zzb;
    private final String zzc;
    private final com.google.android.gms.ads.internal.client.zzdx zzd;

    @AppOpenAd.AppOpenAdOrientation
    private final int zze;
    private final AppOpenAd.AppOpenAdLoadCallback zzf;
    private final zzboi zzg = new zzboi();
    private final com.google.android.gms.ads.internal.client.zzp zzh = com.google.android.gms.ads.internal.client.zzp.zza;

    public zzazx(Context context, String str, com.google.android.gms.ads.internal.client.zzdx zzdxVar, @AppOpenAd.AppOpenAdOrientation int i10, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzdxVar;
        this.zze = i10;
        this.zzf = appOpenAdLoadCallback;
    }

    public final void zza() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzbu zzbuVarZzd = com.google.android.gms.ads.internal.client.zzay.zza().zzd(this.zzb, com.google.android.gms.ads.internal.client.zzq.zzb(), this.zzc, this.zzg);
            this.zza = zzbuVarZzd;
            if (zzbuVarZzd != null) {
                if (this.zze != 3) {
                    this.zza.zzI(new com.google.android.gms.ads.internal.client.zzw(this.zze));
                }
                this.zzd.zzq(jCurrentTimeMillis);
                this.zza.zzH(new zzazk(this.zzf, this.zzc));
                this.zza.zzab(this.zzh.zza(this.zzb, this.zzd));
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
        }
    }
}
