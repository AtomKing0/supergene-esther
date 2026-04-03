package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfoh {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    zzfoh(@NonNull Context context, @NonNull Executor executor, @NonNull Task task, boolean z10) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z10;
    }

    public static zzfoh zza(@NonNull final Context context, @NonNull Executor executor, boolean z10) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z10) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfof
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(zzfqj.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfog
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(zzfqj.zzc());
                }
            });
        }
        return new zzfoh(context, executor, taskCompletionSource.getTask(), z10);
    }

    static void zzg(int i10) {
        zzf = i10;
    }

    private final Task zzh(final int i10, long j10, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfod
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Boolean.valueOf(task.isSuccessful());
                }
            });
        }
        Context context = this.zzb;
        final zzara zzaraVarZza = zzare.zza();
        zzaraVarZza.zza(context.getPackageName());
        zzaraVarZza.zze(j10);
        zzaraVarZza.zzg(zzf);
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzaraVarZza.zzf(stringWriter.toString());
            zzaraVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzaraVarZza.zzb(str2);
        }
        if (str != null) {
            zzaraVarZza.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfoe
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i11 = zzfoh.zza;
                if (!task.isSuccessful()) {
                    return Boolean.FALSE;
                }
                int i12 = i10;
                zzfqi zzfqiVarZza = ((zzfqj) task.getResult()).zza(((zzare) zzaraVarZza.zzbr()).zzaV());
                zzfqiVarZza.zza(i12);
                zzfqiVarZza.zzc();
                return Boolean.TRUE;
            }
        });
    }

    public final Task zzb(int i10, String str) {
        return zzh(i10, 0L, null, null, null, str);
    }

    public final Task zzc(int i10, long j10, Exception exc) {
        return zzh(i10, j10, exc, null, null, null);
    }

    public final Task zzd(int i10, long j10) {
        return zzh(i10, j10, null, null, null, null);
    }

    public final Task zze(int i10, long j10, String str) {
        return zzh(i10, j10, null, null, null, str);
    }

    public final Task zzf(int i10, long j10, String str, Map map) {
        return zzh(i10, j10, null, str, null, null);
    }
}
