package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgr {
    private final String zza;
    private final long zzb;
    private boolean zzc;
    private long zzd;
    private final /* synthetic */ zzgm zze;

    public zzgr(zzgm zzgmVar, String str, long j10) {
        this.zze = zzgmVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = j10;
    }

    @WorkerThread
    public final long zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getLong(this.zza, this.zzb);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(long j10) {
        SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
        editorEdit.putLong(this.zza, j10);
        editorEdit.apply();
        this.zzd = j10;
    }
}
