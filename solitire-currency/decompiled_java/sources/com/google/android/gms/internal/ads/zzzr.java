package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzr implements zzabc, zzzj {
    final /* synthetic */ zzzt zza;
    private final Context zzb;
    private final int zzc;
    private final ArrayList zzd;

    @Nullable
    private zzaf zze;
    private long zzf;
    private boolean zzg;
    private long zzh;
    private boolean zzi;
    private long zzj;
    private zzaba zzk;
    private Executor zzl;

    public zzzr(zzzt zzztVar, Context context) {
        this.zza = zzztVar;
        this.zzb = context;
        this.zzc = true != zzet.zzL(context) ? 5 : 1;
        this.zzd = new ArrayList();
        this.zzh = C.TIME_UNSET;
        this.zzk = zzaba.zzb;
        this.zzl = zzzt.zza;
    }

    private final void zzl() {
        if (this.zze == null) {
            return;
        }
        new ArrayList().addAll(this.zzd);
        zzaf zzafVar = this.zze;
        zzafVar.getClass();
        zzdi.zzb(null);
        int i10 = zzafVar.zzs;
        zzag zzagVar = new zzag(zzzt.zzw(zzafVar.zzy), zzafVar.zzr, i10);
        zzagVar.zza(zzafVar.zzv);
        zzagVar.zzb();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zza(zzzt zzztVar) {
        final zzaba zzabaVar = this.zzk;
        this.zzl.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzq
            @Override // java.lang.Runnable
            public final void run() {
                zzabaVar.zza(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zzb(zzzt zzztVar) {
        final zzaba zzabaVar = this.zzk;
        this.zzl.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzp
            @Override // java.lang.Runnable
            public final void run() {
                zzabaVar.zzb(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zzc(zzzt zzztVar, final zzcp zzcpVar) {
        final zzaba zzabaVar = this.zzk;
        this.zzl.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzo
            @Override // java.lang.Runnable
            public final void run() {
                zzabaVar.zzc(this.zza, zzcpVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final long zzd(long j10, boolean z10) {
        zzdi.zzf(false);
        long j11 = this.zzj;
        if (j11 != C.TIME_UNSET) {
            if (!zzzt.zzv(this.zza, j11)) {
                return C.TIME_UNSET;
            }
            zzl();
            this.zzj = C.TIME_UNSET;
        }
        zzdi.zzb(null);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zze() {
        this.zzi = false;
        this.zzh = C.TIME_UNSET;
        zzzt.zzn(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzf(int i10, zzaf zzafVar) {
        zzdi.zzf(false);
        this.zza.zzd.zzk(zzafVar.zzt);
        int i11 = zzet.zza;
        this.zze = zzafVar;
        if (this.zzi) {
            zzdi.zzf(this.zzh != C.TIME_UNSET);
            this.zzj = this.zzh;
        } else {
            zzl();
            this.zzi = true;
            this.zzj = C.TIME_UNSET;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzg(long j10, long j11) throws zzabb {
        try {
            this.zza.zzt(j10, j11);
        } catch (zzhw e10) {
            zzaf zzafVarZzad = this.zze;
            if (zzafVarZzad == null) {
                zzafVarZzad = new zzad().zzad();
            }
            throw new zzabb(e10, zzafVarZzad);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzh(zzaba zzabaVar, Executor executor) {
        this.zzk = zzabaVar;
        this.zzl = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzi(long j10) {
        this.zzg = this.zzf != j10;
        this.zzf = j10;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzj(List list) {
        this.zzd.clear();
        this.zzd.addAll(list);
        zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final boolean zzk() {
        return zzet.zzL(this.zzb);
    }
}
