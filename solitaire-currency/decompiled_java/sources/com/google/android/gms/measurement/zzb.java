package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zziu;
import com.google.android.gms.measurement.internal.zzix;
import com.google.android.gms.measurement.internal.zziy;
import com.google.android.gms.measurement.internal.zzno;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzb extends AppMeasurement.zza {
    private final zzho zza;
    private final zziy zzb;

    public zzb(@NonNull zzho zzhoVar) {
        super();
        Preconditions.checkNotNull(zzhoVar);
        this.zza = zzhoVar;
        this.zzb = zzhoVar.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Double zzb() {
        return this.zzb.zzab();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Integer zzc() {
        return this.zzb.zzac();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Long zzd() {
        return this.zzb.zzad();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final String zze() {
        return this.zzb.zzai();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final long zzf() {
        return this.zza.zzt().zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzg() {
        return this.zzb.zzae();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzh() {
        return this.zzb.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzi() {
        return this.zzb.zzag();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final String zzj() {
        return this.zzb.zzae();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Boolean zza() {
        return this.zzb.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zzb(String str) {
        this.zza.zze().zza(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zzc(String str) {
        this.zza.zze().zzb(str, this.zza.zzb().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final Object zza(int i10) {
        if (i10 == 0) {
            return zze();
        }
        if (i10 == 1) {
            return zzd();
        }
        if (i10 == 2) {
            return zzb();
        }
        if (i10 == 3) {
            return zzc();
        }
        if (i10 != 4) {
            return null;
        }
        return zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zzb(zzix zzixVar) {
        this.zzb.zzb(zzixVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final List<Bundle> zza(String str, String str2) {
        return this.zzb.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Map<String, Object> zza(boolean z10) {
        List<zzno> listZza = this.zzb.zza(z10);
        ArrayMap arrayMap = new ArrayMap(listZza.size());
        for (zzno zznoVar : listZza) {
            Object objZza = zznoVar.zza();
            if (objZza != null) {
                arrayMap.put(zznoVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final Map<String, Object> zza(String str, String str2, boolean z10) {
        return this.zzb.zza(str, str2, z10);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zza(String str, String str2, Bundle bundle, long j10) {
        this.zzb.zza(str, str2, bundle, true, false, j10);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zza(zzix zzixVar) {
        this.zzb.zza(zzixVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zza(Bundle bundle) {
        this.zzb.zzb(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final void zza(zziu zziuVar) {
        this.zzb.zza(zziuVar);
    }
}
