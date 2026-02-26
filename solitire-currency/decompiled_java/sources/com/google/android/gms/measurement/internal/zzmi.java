package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzmi extends zzg {
    protected final zzmq zza;
    protected final zzmo zzb;
    private Handler zzc;
    private boolean zzd;
    private final zzmn zze;

    zzmi(zzho zzhoVar) {
        super(zzhoVar);
        this.zzd = true;
        this.zza = new zzmq(this);
        this.zzb = new zzmo(this);
        this.zze = new zzmn(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzab() {
        zzt();
        if (this.zzc == null) {
            this.zzc = new com.google.android.gms.internal.measurement.zzdc(Looper.getMainLooper());
        }
    }

    @WorkerThread
    final boolean zzaa() {
        zzt();
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zziy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkv zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzla zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmi zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    static /* synthetic */ void zza(zzmi zzmiVar, long j10) {
        zzmiVar.zzt();
        zzmiVar.zzab();
        zzmiVar.zzj().zzp().zza("Activity paused, time", Long.valueOf(j10));
        zzmiVar.zze.zza(j10);
        if (zzmiVar.zze().zzv()) {
            zzmiVar.zzb.zzb(j10);
        }
    }

    static /* synthetic */ void zzb(zzmi zzmiVar, long j10) {
        zzmiVar.zzt();
        zzmiVar.zzab();
        zzmiVar.zzj().zzp().zza("Activity resumed, time", Long.valueOf(j10));
        if (zzmiVar.zze().zza(zzbh.zzcm)) {
            if (zzmiVar.zze().zzv() || zzmiVar.zzd) {
                zzmiVar.zzb.zzc(j10);
            }
        } else if (zzmiVar.zze().zzv() || zzmiVar.zzk().zzn.zza()) {
            zzmiVar.zzb.zzc(j10);
        }
        zzmiVar.zze.zza();
        zzmq zzmqVar = zzmiVar.zza;
        zzmqVar.zza.zzt();
        if (zzmqVar.zza.zzu.zzac()) {
            zzmqVar.zza(zzmqVar.zza.zzb().currentTimeMillis(), false);
        }
    }

    @WorkerThread
    final void zza(boolean z10) {
        zzt();
        this.zzd = z10;
    }

    public final boolean zza(boolean z10, boolean z11, long j10) {
        return this.zzb.zza(z10, z11, j10);
    }
}
