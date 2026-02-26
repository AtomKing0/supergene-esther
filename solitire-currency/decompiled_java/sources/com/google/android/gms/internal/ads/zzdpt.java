package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdpt implements zzcxl {

    @Nullable
    private final zzcej zza;

    zzdpt(@Nullable zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdj(@Nullable Context context) {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdl(@Nullable Context context) {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdm(@Nullable Context context) {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.onResume();
        }
    }
}
