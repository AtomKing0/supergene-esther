package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzmy extends zzmz {
    private boolean zza;

    zzmy(zznd zzndVar) {
        super(zzndVar);
        this.zzf.zzu();
    }

    protected final void zzak() {
        if (!zzam()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzc();
        this.zzf.zzt();
        this.zza = true;
    }

    final boolean zzam() {
        return this.zza;
    }

    protected abstract boolean zzc();
}
