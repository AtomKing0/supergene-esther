package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgp {
    private final String zza;
    private final boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private final /* synthetic */ zzgm zze;

    public zzgp(zzgm zzgmVar, String str, boolean z10) {
        this.zze = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = z10;
    }

    @WorkerThread
    public final void zza(boolean z10) {
        SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
        editorEdit.putBoolean(this.zza, z10);
        editorEdit.apply();
        this.zzd = z10;
    }

    @WorkerThread
    public final boolean zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getBoolean(this.zza, this.zzb);
        }
        return this.zzd;
    }
}
