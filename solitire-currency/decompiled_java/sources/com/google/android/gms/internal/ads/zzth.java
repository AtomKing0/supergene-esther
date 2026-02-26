package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzth implements zzuk {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzur zzc = new zzur();
    private final zzrd zzd = new zzrd();

    @Nullable
    private Looper zze;

    @Nullable
    private zzcc zzf;

    @Nullable
    private zznz zzg;

    @Override // com.google.android.gms.internal.ads.zzuk
    public /* synthetic */ zzcc zzM() {
        return null;
    }

    protected final zznz zzb() {
        zznz zznzVar = this.zzg;
        zzdi.zzb(zznzVar);
        return zznzVar;
    }

    protected final zzrd zzc(@Nullable zzui zzuiVar) {
        return this.zzd.zza(0, zzuiVar);
    }

    protected final zzrd zzd(int i10, @Nullable zzui zzuiVar) {
        return this.zzd.zza(0, zzuiVar);
    }

    protected final zzur zze(@Nullable zzui zzuiVar) {
        return this.zzc.zza(0, zzuiVar);
    }

    protected final zzur zzf(int i10, @Nullable zzui zzuiVar) {
        return this.zzc.zza(0, zzuiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzg(Handler handler, zzre zzreVar) {
        this.zzd.zzb(handler, zzreVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzh(Handler handler, zzus zzusVar) {
        this.zzc.zzb(handler, zzusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzi(zzuj zzujVar) {
        boolean z10 = !this.zzb.isEmpty();
        this.zzb.remove(zzujVar);
        if (z10 && this.zzb.isEmpty()) {
            zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzk(zzuj zzujVar) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(zzujVar);
        if (zIsEmpty) {
            zzl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzm(zzuj zzujVar, @Nullable zzgu zzguVar, zznz zznzVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z10 = true;
        if (looper != null && looper != looperMyLooper) {
            z10 = false;
        }
        zzdi.zzd(z10);
        this.zzg = zznzVar;
        zzcc zzccVar = this.zzf;
        this.zza.add(zzujVar);
        if (this.zze == null) {
            this.zze = looperMyLooper;
            this.zzb.add(zzujVar);
            zzn(zzguVar);
        } else if (zzccVar != null) {
            zzk(zzujVar);
            zzujVar.zza(this, zzccVar);
        }
    }

    protected abstract void zzn(@Nullable zzgu zzguVar);

    protected final void zzo(zzcc zzccVar) {
        this.zzf = zzccVar;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((zzuj) arrayList.get(i10)).zza(this, zzccVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzp(zzuj zzujVar) {
        this.zza.remove(zzujVar);
        if (!this.zza.isEmpty()) {
            zzi(zzujVar);
            return;
        }
        this.zze = null;
        this.zzf = null;
        this.zzg = null;
        this.zzb.clear();
        zzq();
    }

    protected abstract void zzq();

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzr(zzre zzreVar) {
        this.zzd.zzc(zzreVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public final void zzs(zzus zzusVar) {
        this.zzc.zzh(zzusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public /* synthetic */ void zzt(zzbc zzbcVar) {
        throw null;
    }

    protected final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzuk
    public /* synthetic */ boolean zzv() {
        return true;
    }

    protected void zzj() {
    }

    protected void zzl() {
    }
}
