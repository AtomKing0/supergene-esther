package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbcy;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzfgf;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;
import com.google.android.gms.internal.ads.zzhfu;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzal implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;
    private final zzhfu zzg;
    private final zzhfu zzh;
    private final zzhfu zzi;
    private final zzhfu zzj;
    private final zzhfu zzk;

    public zzal(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5, zzhfu zzhfuVar6, zzhfu zzhfuVar7, zzhfu zzhfuVar8, zzhfu zzhfuVar9, zzhfu zzhfuVar10, zzhfu zzhfuVar11, zzhfu zzhfuVar12) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar6;
        this.zzf = zzhfuVar7;
        this.zzg = zzhfuVar8;
        this.zzh = zzhfuVar9;
        this.zzi = zzhfuVar10;
        this.zzj = zzhfuVar11;
        this.zzk = zzhfuVar12;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcgj zzcgjVar = (zzcgj) this.zza.zzb();
        Context contextZza = ((zzcgp) this.zzb).zza();
        zzauo zzauoVar = (zzauo) this.zzc.zzb();
        zzfgf zzfgfVar = (zzfgf) this.zzd.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzak(zzcgjVar, contextZza, zzauoVar, zzfgfVar, zzgcuVar, (ScheduledExecutorService) this.zze.zzb(), (zzdsp) this.zzf.zzb(), (zzfll) this.zzg.zzb(), ((zzchc) this.zzh).zza(), ((zzbcy) this.zzi).zzb(), (zzffk) this.zzj.zzb(), (zze) this.zzk.zzb());
    }
}
