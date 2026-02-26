package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgs {
    private final String zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzgm zze;

    public zzgs(zzgm zzgmVar, String str, String str2) {
        this.zze = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = null;
    }

    @WorkerThread
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getString(this.zza, null);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(String str) {
        SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
        editorEdit.putString(this.zza, str);
        editorEdit.apply();
        this.zzd = str;
    }
}
