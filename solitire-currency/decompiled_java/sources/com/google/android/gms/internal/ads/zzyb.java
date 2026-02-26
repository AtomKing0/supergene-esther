package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzyb {

    @Nullable
    private zzya zza;

    @Nullable
    private zzyj zzb;

    @Nullable
    public zzlg zze() {
        throw null;
    }

    @CallSuper
    public void zzj() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzk(zzh zzhVar) {
        throw null;
    }

    public boolean zzn() {
        throw null;
    }

    public abstract zzyc zzo(zzlh[] zzlhVarArr, zzwi zzwiVar, zzui zzuiVar, zzcc zzccVar) throws zzhw;

    public abstract void zzp(@Nullable Object obj);

    protected final zzyj zzq() {
        zzyj zzyjVar = this.zzb;
        zzdi.zzb(zzyjVar);
        return zzyjVar;
    }

    @CallSuper
    public final void zzr(zzya zzyaVar, zzyj zzyjVar) {
        this.zza = zzyaVar;
        this.zzb = zzyjVar;
    }

    protected final void zzs() {
        zzya zzyaVar = this.zza;
        if (zzyaVar != null) {
            zzyaVar.zzi();
        }
    }
}
