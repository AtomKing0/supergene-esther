package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfby {
    private final zzfgu zza;
    private final zzcvx zzb;
    private final Executor zzc;
    private zzfbx zzd;

    public zzfby(zzfgu zzfguVar, zzcvx zzcvxVar, Executor executor) {
        this.zza = zzfguVar;
        this.zzb = zzcvxVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzfhe zze() {
        zzffg zzffgVarZzg = this.zzb.zzg();
        return this.zza.zzc(zzffgVarZzg.zzd, zzffgVarZzg.zzf, zzffgVarZzg.zzj);
    }

    public final m zzc() {
        m mVarZze;
        zzfbx zzfbxVar = this.zzd;
        if (zzfbxVar != null) {
            return zzgcj.zzh(zzfbxVar);
        }
        if (((Boolean) zzbdz.zza.zze()).booleanValue()) {
            mVarZze = zzgcj.zze(zzgcj.zzm(zzgca.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfbv(this), this.zzc), zzdyp.class, new zzfbu(this), this.zzc);
        } else {
            zzfbx zzfbxVar2 = new zzfbx(null, zze(), null);
            this.zzd = zzfbxVar2;
            mVarZze = zzgcj.zzh(zzfbxVar2);
        }
        return zzgcj.zzm(mVarZze, new zzful() { // from class: com.google.android.gms.internal.ads.zzfbt
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return (zzfbx) obj;
            }
        }, this.zzc);
    }
}
