package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfl implements zzfs {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;

    @Nullable
    private zzfy zzd;

    protected zzfl(boolean z10) {
        this.zza = z10;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzf(zzgu zzguVar) {
        zzguVar.getClass();
        if (this.zzb.contains(zzguVar)) {
            return;
        }
        this.zzb.add(zzguVar);
        this.zzc++;
    }

    protected final void zzg(int i10) {
        zzfy zzfyVar = this.zzd;
        int i11 = zzet.zza;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            ((zzgu) this.zzb.get(i12)).zza(this, zzfyVar, this.zza, i10);
        }
    }

    protected final void zzh() {
        zzfy zzfyVar = this.zzd;
        int i10 = zzet.zza;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            ((zzgu) this.zzb.get(i11)).zzb(this, zzfyVar, this.zza);
        }
        this.zzd = null;
    }

    protected final void zzi(zzfy zzfyVar) {
        for (int i10 = 0; i10 < this.zzc; i10++) {
            ((zzgu) this.zzb.get(i10)).zzc(this, zzfyVar, this.zza);
        }
    }

    protected final void zzj(zzfy zzfyVar) {
        this.zzd = zzfyVar;
        for (int i10 = 0; i10 < this.zzc; i10++) {
            ((zzgu) this.zzb.get(i10)).zzd(this, zzfyVar, this.zza);
        }
    }
}
