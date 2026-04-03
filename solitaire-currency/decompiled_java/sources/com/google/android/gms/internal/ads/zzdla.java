package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdla implements zzcxk {
    private final zzdjb zza;
    private final zzdjg zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdla(zzdjb zzdjbVar, zzdjg zzdjgVar, Executor executor, Executor executor2) {
        this.zza = zzdjbVar;
        this.zzb = zzdjgVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(final zzcej zzcejVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdky
            @Override // java.lang.Runnable
            public final void run() {
                zzcejVar.zzd("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        if (this.zzb.zzd()) {
            zzdjb zzdjbVar = this.zza;
            zzeeo zzeeoVarZzu = zzdjbVar.zzu();
            if (zzeeoVarZzu == null && zzdjbVar.zzw() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
                zzdjb zzdjbVar2 = this.zza;
                m mVarZzw = zzdjbVar2.zzw();
                zzbzt zzbztVarZzp = zzdjbVar2.zzp();
                if (mVarZzw == null || zzbztVarZzp == null) {
                    return;
                }
                zzgcj.zzr(zzgcj.zzl(mVarZzw, zzbztVarZzp), new zzdkz(this), this.zzd);
                return;
            }
            if (zzeeoVarZzu != null) {
                zzdjb zzdjbVar3 = this.zza;
                zzcej zzcejVarZzr = zzdjbVar3.zzr();
                zzcej zzcejVarZzs = zzdjbVar3.zzs();
                if (zzcejVarZzr == null) {
                    zzcejVarZzr = zzcejVarZzs != null ? zzcejVarZzs : null;
                }
                if (zzcejVarZzr != null) {
                    zzb(zzcejVarZzr);
                }
            }
        }
    }
}
