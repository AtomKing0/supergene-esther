package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxp implements zzdyo {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdwq zzb;
    private final zzgcu zzc;
    private final zzffg zzd;
    private final ScheduledExecutorService zze;
    private final zzecd zzf;
    private final zzfkf zzg;
    private final Context zzh;

    zzdxp(Context context, zzffg zzffgVar, zzdwq zzdwqVar, zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzecd zzecdVar, zzfkf zzfkfVar) {
        this.zzh = context;
        this.zzd = zzffgVar;
        this.zzb = zzdwqVar;
        this.zzc = zzgcuVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzecdVar;
        this.zzg = zzfkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final m zzb(zzbvb zzbvbVar) {
        Context context = this.zzh;
        m mVarZzc = this.zzb.zzc(zzbvbVar);
        zzfju zzfjuVarZza = zzfjt.zza(context, 11);
        zzfke.zzd(mVarZzc, zzfjuVarZza);
        m mVarZzn = zzgcj.zzn(mVarZzc, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxm
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc((zzdyq) obj);
            }
        }, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeT)).booleanValue()) {
            mVarZzn = zzgcj.zzf(zzgcj.zzo(mVarZzn, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxn
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    return zzgcj.zzg(new zzdwl(5));
                }
            }, zzbzo.zzf);
        }
        zzfke.zza(mVarZzn, this.zzg, zzfjuVarZza);
        zzgcj.zzr(mVarZzn, new zzdxo(this), zzbzo.zzf);
        return mVarZzn;
    }

    final /* synthetic */ m zzc(zzdyq zzdyqVar) throws Exception {
        return zzgcj.zzh(new zzfex(new zzfeu(this.zzd), zzfew.zza(new InputStreamReader(zzdyqVar.zzb()), zzdyqVar.zza())));
    }
}
