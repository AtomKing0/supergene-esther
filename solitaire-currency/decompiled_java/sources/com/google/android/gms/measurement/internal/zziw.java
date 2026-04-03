package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class zziw {
    final Context zza;

    @Nullable
    String zzb;

    @Nullable
    String zzc;

    @Nullable
    String zzd;

    @Nullable
    Boolean zze;
    long zzf;

    @Nullable
    com.google.android.gms.internal.measurement.zzdq zzg;
    boolean zzh;

    @Nullable
    Long zzi;

    @Nullable
    String zzj;

    @VisibleForTesting
    public zziw(Context context, @Nullable com.google.android.gms.internal.measurement.zzdq zzdqVar, @Nullable Long l10) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l10;
        if (zzdqVar != null) {
            this.zzg = zzdqVar;
            this.zzb = zzdqVar.zzf;
            this.zzc = zzdqVar.zze;
            this.zzd = zzdqVar.zzd;
            this.zzh = zzdqVar.zzc;
            this.zzf = zzdqVar.zzb;
            this.zzj = zzdqVar.zzh;
            Bundle bundle = zzdqVar.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
