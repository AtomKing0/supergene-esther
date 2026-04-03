package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
class zzim implements zzio {
    protected final zzho zzu;

    zzim(zzho zzhoVar) {
        Preconditions.checkNotNull(zzhoVar);
        this.zzu = zzhoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public Context zza() {
        return this.zzu.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public Clock zzb() {
        return this.zzu.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public zzad zzd() {
        return this.zzu.zzd();
    }

    public zzae zze() {
        return this.zzu.zzf();
    }

    public zzaz zzf() {
        return this.zzu.zzg();
    }

    public zzfw zzi() {
        return this.zzu.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public zzgb zzj() {
        return this.zzu.zzj();
    }

    public zzgm zzk() {
        return this.zzu.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public zzhh zzl() {
        return this.zzu.zzl();
    }

    public zznt zzq() {
        return this.zzu.zzt();
    }

    public void zzr() {
        this.zzu.zzl().zzr();
    }

    public void zzs() {
        this.zzu.zzy();
    }

    public void zzt() {
        this.zzu.zzl().zzt();
    }
}
