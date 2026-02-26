package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza extends zzd {
    private final Map<String, Long> zza;
    private final Map<String, Integer> zzb;
    private long zzc;

    public zza(zzho zzhoVar) {
        super(zzhoVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    static /* synthetic */ void zzb(zza zzaVar, String str, long j10) {
        zzaVar.zzt();
        Preconditions.checkNotEmpty(str);
        Integer num = zzaVar.zzb.get(str);
        if (num == null) {
            zzaVar.zzj().zzg().zza("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzks zzksVarZza = zzaVar.zzn().zza(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            zzaVar.zzb.put(str, Integer.valueOf(iIntValue));
            return;
        }
        zzaVar.zzb.remove(str);
        Long l10 = zzaVar.zza.get(str);
        if (l10 == null) {
            zzaVar.zzj().zzg().zza("First ad unit exposure time was never set");
        } else {
            long jLongValue = j10 - l10.longValue();
            zzaVar.zza.remove(str);
            zzaVar.zza(str, jLongValue, zzksVarZza);
        }
        if (zzaVar.zzb.isEmpty()) {
            long j11 = zzaVar.zzc;
            if (j11 == 0) {
                zzaVar.zzj().zzg().zza("First ad exposure time was never set");
            } else {
                zzaVar.zza(j10 - j11, zzksVarZza);
                zzaVar.zzc = 0L;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static /* synthetic */ void zza(zza zzaVar, String str, long j10) {
        zzaVar.zzt();
        Preconditions.checkNotEmpty(str);
        if (zzaVar.zzb.isEmpty()) {
            zzaVar.zzc = j10;
        }
        Integer num = zzaVar.zzb.get(str);
        if (num != null) {
            zzaVar.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzaVar.zzb.size() >= 100) {
            zzaVar.zzj().zzu().zza("Too many ads visible");
        } else {
            zzaVar.zzb.put(str, 1);
            zzaVar.zza.put(str, Long.valueOf(j10));
        }
    }

    public final void zza(String str, long j10) {
        if (str != null && str.length() != 0) {
            zzl().zzb(new zzc(this, str, j10));
        } else {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        }
    }

    @WorkerThread
    private final void zza(long j10, zzks zzksVar) {
        if (zzksVar == null) {
            zzj().zzp().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            zzj().zzp().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j10);
        zznt.zza(zzksVar, bundle, true);
        zzm().zzc("am", "_xa", bundle);
    }

    public final void zzb(String str, long j10) {
        if (str != null && str.length() != 0) {
            zzl().zzb(new zzb(this, str, j10));
        } else {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        }
    }

    @WorkerThread
    private final void zza(String str, long j10, zzks zzksVar) {
        if (zzksVar == null) {
            zzj().zzp().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            zzj().zzp().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j10);
        zznt.zza(zzksVar, bundle, true);
        zzm().zzc("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzb(long j10) {
        Iterator<String> it = this.zza.keySet().iterator();
        while (it.hasNext()) {
            this.zza.put(it.next(), Long.valueOf(j10));
        }
        if (this.zza.isEmpty()) {
            return;
        }
        this.zzc = j10;
    }

    @WorkerThread
    public final void zza(long j10) {
        zzks zzksVarZza = zzn().zza(false);
        for (String str : this.zza.keySet()) {
            zza(str, j10 - this.zza.get(str).longValue(), zzksVarZza);
        }
        if (!this.zza.isEmpty()) {
            zza(j10 - this.zzc, zzksVarZza);
        }
        zzb(j10);
    }
}
