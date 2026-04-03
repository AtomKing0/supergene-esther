package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcvu;
import com.google.android.gms.internal.ads.zzcvv;
import com.google.android.gms.internal.ads.zzdff;
import com.google.android.gms.internal.ads.zzfiq;
import com.google.android.gms.internal.ads.zzfjf;
import com.google.android.gms.internal.ads.zzfjl;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfu;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzau implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzau(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfjl zzfjlVar = (zzfjl) this.zza.zzb();
        zzaw zzawVarZzb = ((zzax) this.zzb).zzb();
        zzcvu zzcvuVarZzb = ((zzcvv) this.zzc).zzb();
        zzdff zzdffVar = (zzdff) this.zzd.zzb();
        zzfiq zzfiqVarZza = zzfjlVar.zzb(zzfjf.GENERATE_SIGNALS, zzcvuVarZzb.zzc()).zzf(zzawVarZzb).zzi(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS).zza();
        zzgcj.zzr(zzfiqVarZza, new zzam(zzdffVar), zzbzo.zza);
        return zzfiqVarZza;
    }
}
