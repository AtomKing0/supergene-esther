package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgq {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final /* synthetic */ zzgm zze;

    @WorkerThread
    private final long zzb() {
        return this.zze.zzg().getLong(this.zza, 0L);
    }

    @WorkerThread
    private final void zzc() {
        this.zze.zzt();
        long jCurrentTimeMillis = this.zze.zzb().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
        editorEdit.remove(this.zzb);
        editorEdit.remove(this.zzc);
        editorEdit.putLong(this.zza, jCurrentTimeMillis);
        editorEdit.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zza() {
        long jAbs;
        this.zze.zzt();
        this.zze.zzt();
        long jZzb = zzb();
        if (jZzb == 0) {
            zzc();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jZzb - this.zze.zzb().currentTimeMillis());
        }
        long j10 = this.zzd;
        if (jAbs < j10) {
            return null;
        }
        if (jAbs > (j10 << 1)) {
            zzc();
            return null;
        }
        String string = this.zze.zzg().getString(this.zzc, null);
        long j11 = this.zze.zzg().getLong(this.zzb, 0L);
        zzc();
        return (string == null || j11 <= 0) ? zzgm.zza : new Pair<>(string, Long.valueOf(j11));
    }

    private zzgq(zzgm zzgmVar, String str, long j10) {
        this.zze = zzgmVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j10 > 0);
        this.zza = str + ":start";
        this.zzb = str + ":count";
        this.zzc = str + ":value";
        this.zzd = j10;
    }

    @WorkerThread
    public final void zza(String str, long j10) {
        this.zze.zzt();
        if (zzb() == 0) {
            zzc();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.zze.zzg().getLong(this.zzb, 0L);
        if (j11 <= 0) {
            SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
            editorEdit.putString(this.zzc, str);
            editorEdit.putLong(this.zzb, 1L);
            editorEdit.apply();
            return;
        }
        long j12 = j11 + 1;
        boolean z10 = (this.zze.zzq().zzv().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j12;
        SharedPreferences.Editor editorEdit2 = this.zze.zzg().edit();
        if (z10) {
            editorEdit2.putString(this.zzc, str);
        }
        editorEdit2.putLong(this.zzb, j12);
        editorEdit2.apply();
    }
}
