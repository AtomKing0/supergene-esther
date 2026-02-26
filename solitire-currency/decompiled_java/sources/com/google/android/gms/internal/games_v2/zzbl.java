package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbl implements zzav {
    private final AtomicReference zza = new AtomicReference(zzbi.UNINITIALIZED);
    private final AtomicReference zzb = new AtomicReference(zzbh.AUTOMATIC);
    private final Queue zzc = new ArrayDeque();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final Application zzf;
    private final com.google.android.gms.games.internal.zzg zzg;
    private final zzbm zzh;
    private final com.google.android.gms.games.internal.v2.resolution.zzb zzi;

    zzbl(Application application, com.google.android.gms.games.internal.zzg zzgVar, com.google.android.gms.games.internal.v2.resolution.zzb zzbVar, zzbm zzbmVar, byte[] bArr) {
        this.zzf = application;
        this.zzg = zzgVar;
        this.zzi = zzbVar;
        this.zzh = zzbmVar;
    }

    private static ApiException zzj() {
        return new ApiException(new Status(4));
    }

    private static Task zzk(AtomicReference atomicReference, @Nullable TaskCompletionSource taskCompletionSource) {
        zzbi zzbiVar = zzbi.UNINITIALIZED;
        int iOrdinal = ((zzbi) atomicReference.get()).ordinal();
        if (iOrdinal == 0) {
            return Tasks.forException(new ApiException(new Status(10)));
        }
        if (iOrdinal == 2) {
            return Tasks.forResult(AuthenticationResult.zza);
        }
        if (iOrdinal == 3) {
            return Tasks.forResult(AuthenticationResult.zzb);
        }
        if (taskCompletionSource == null) {
            return Tasks.forResult(AuthenticationResult.zzb);
        }
        Task task = taskCompletionSource.getTask();
        if (task.isSuccessful()) {
            return ((Boolean) task.getResult()).booleanValue() ? Tasks.forResult(AuthenticationResult.zza) : Tasks.forResult(AuthenticationResult.zzb);
        }
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        task.addOnCompleteListener(zzfe.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbb
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                TaskCompletionSource taskCompletionSource3 = taskCompletionSource2;
                if (task2.isSuccessful() && ((Boolean) task2.getResult()).booleanValue()) {
                    taskCompletionSource3.trySetResult(AuthenticationResult.zza);
                } else {
                    taskCompletionSource3.trySetResult(AuthenticationResult.zzb);
                }
            }
        });
        return taskCompletionSource2.getTask();
    }

    private static Task zzl(final zzff zzffVar) {
        if (zzp()) {
            return (Task) zzffVar.zza();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskExecutors.MAIN_THREAD.execute(new Runnable() { // from class: com.google.android.gms.internal.games_v2.zzbe
            @Override // java.lang.Runnable
            public final void run() {
                zzff zzffVar2 = zzffVar;
                final TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                ((Task) zzffVar2.zza()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbc
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        TaskCompletionSource taskCompletionSource3 = taskCompletionSource2;
                        if (task.isSuccessful()) {
                            taskCompletionSource3.trySetResult(task.getResult());
                            return;
                        }
                        Exception exception = task.getException();
                        zzfb.zza(exception);
                        taskCompletionSource3.trySetException(exception);
                    }
                });
            }
        });
        return taskCompletionSource.getTask();
    }

    private final void zzm(final TaskCompletionSource taskCompletionSource, final zzy zzyVar) {
        zzez.zza("GamesApiManager", "Attempting authentication: ".concat(zzyVar.toString()));
        this.zzh.zza(zzyVar).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzba
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzg(taskCompletionSource, zzyVar, task);
            }
        });
    }

    @MainThread
    private final void zzn(final TaskCompletionSource taskCompletionSource, final int i10, @Nullable PendingIntent pendingIntent, boolean z10, boolean z11) {
        Activity activityZza;
        Preconditions.checkMainThread("Must be called on the main thread.");
        if (z10 && pendingIntent != null && (activityZza = this.zzg.zza()) != null) {
            com.google.android.gms.games.internal.v2.resolution.zzb.zzb(activityZza, pendingIntent).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzaz
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.zza.zzh(taskCompletionSource, i10, task);
                }
            });
            zzez.zza("GamesApiManager", "Resolution triggered");
            return;
        }
        boolean zZza = zzay.zza(this.zzb, zzbh.AUTOMATIC_PENDING_EXPLICIT, zzbh.EXPLICIT);
        if (!z11 && zZza) {
            zzez.zza("GamesApiManager", "Consumed pending explicit sign-in. Attempting explicit sign-in");
            zzm(taskCompletionSource, zzy.zzb(0));
            return;
        }
        taskCompletionSource.trySetResult(Boolean.FALSE);
        this.zza.set(zzbi.AUTHENTICATION_FAILED);
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzbk) it.next()).zzc(zzj());
            it.remove();
        }
    }

    @MainThread
    private final void zzo(int i10) {
        StringBuilder sb = new StringBuilder(56);
        sb.append("startAuthenticationIfNecessary() signInType: ");
        sb.append(i10);
        zzez.zza("GamesApiManager", sb.toString());
        Preconditions.checkMainThread("Must be called on the main thread.");
        AtomicReference atomicReference = this.zza;
        zzbi zzbiVar = zzbi.UNINITIALIZED;
        zzbi zzbiVar2 = zzbi.AUTHENTICATING;
        if (zzay.zza(atomicReference, zzbiVar, zzbiVar2) || zzay.zza(this.zza, zzbi.AUTHENTICATION_FAILED, zzbiVar2)) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzd.get();
            if (taskCompletionSource != null) {
                taskCompletionSource.trySetException(new IllegalStateException("New authentication attempt in progress"));
            }
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.zzd.set(taskCompletionSource2);
            this.zzb.set(i10 == 0 ? zzbh.EXPLICIT : zzbh.AUTOMATIC);
            zzm(taskCompletionSource2, zzy.zzb(i10));
            return;
        }
        if (i10 == 0) {
            boolean zZza = zzay.zza(this.zzb, zzbh.AUTOMATIC, zzbh.AUTOMATIC_PENDING_EXPLICIT);
            StringBuilder sb2 = new StringBuilder(88);
            sb2.append("Explicit sign-in during existing authentication. Marking pending explicit sign-in: ");
            sb2.append(zZza);
            zzez.zza("GamesApiManager", sb2.toString());
        }
        zzez.zza("GamesApiManager", "Authentication attempt skipped. Already authenticated or authenticating. State: ".concat(String.valueOf(this.zza.get())));
    }

    private static boolean zzp() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zza() {
        return zzl(new zzff() { // from class: com.google.android.gms.internal.games_v2.zzbf
            @Override // com.google.android.gms.internal.games_v2.zzff
            public final Object zza() {
                return this.zza.zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zzb() {
        return zzl(new zzff() { // from class: com.google.android.gms.internal.games_v2.zzbg
            @Override // com.google.android.gms.internal.games_v2.zzff
            public final Object zza() {
                return this.zza.zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zzc() {
        return zzk(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    @Override // com.google.android.gms.internal.games_v2.zzav
    public final Task zzd(zzap zzapVar) {
        zzbi zzbiVar = (zzbi) this.zza.get();
        zzez.zzf("GamesApiManager", "Executing API call with authentication state: ".concat(String.valueOf(zzbiVar)));
        if (zzbiVar == zzbi.AUTHENTICATED) {
            return zzapVar.zza((GoogleApi) this.zze.get());
        }
        if (zzbiVar == zzbi.AUTHENTICATION_FAILED) {
            return Tasks.forException(zzj());
        }
        if (zzbiVar == zzbi.UNINITIALIZED) {
            return Tasks.forException(new ApiException(new Status(10)));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final zzbk zzbkVar = new zzbk(zzapVar, taskCompletionSource, null);
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.games_v2.zzbd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi(zzbkVar);
            }
        };
        if (zzp()) {
            runnable.run();
        } else {
            TaskExecutors.MAIN_THREAD.execute(runnable);
        }
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ Task zze() {
        zzo(1);
        return zzk(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    final /* synthetic */ Task zzf() {
        zzo(0);
        return zzk(this.zza, (TaskCompletionSource) this.zzd.get());
    }

    final /* synthetic */ void zzg(TaskCompletionSource taskCompletionSource, zzy zzyVar, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfb.zza(exception);
            zzez.zzb("GamesApiManager", "Authentication task failed", exception);
            zzn(taskCompletionSource, zzyVar.zza(), null, false, !zzyVar.zzd());
            return;
        }
        zzbq zzbqVar = (zzbq) task.getResult();
        if (!zzbqVar.zze()) {
            zzez.zza("GamesApiManager", "Failed to authenticate: ".concat(String.valueOf(zzbqVar)));
            zzn(taskCompletionSource, zzyVar.zza(), zzbqVar.zza(), true, !zzyVar.zzd());
            return;
        }
        String strZzd = zzbqVar.zzd();
        if (strZzd == null) {
            zzez.zzg("GamesApiManager", "Unexpected state: game run token absent");
            zzn(taskCompletionSource, zzyVar.zza(), null, false, !zzyVar.zzd());
            return;
        }
        zzez.zza("GamesApiManager", "Successfully authenticated");
        Preconditions.checkMainThread("Must be called on the main thread.");
        com.google.android.gms.games.zzl zzlVarZzb = com.google.android.gms.games.zzn.zzb();
        zzlVarZzb.zzd(2101523);
        zzlVarZzb.zzc(GoogleSignInAccount.createDefault());
        zzlVarZzb.zza(strZzd);
        com.google.android.gms.games.internal.zzj zzjVarZza = com.google.android.gms.games.internal.zzl.zza();
        zzjVarZza.zzb(true);
        zzjVarZza.zzc(true);
        zzjVarZza.zza(true);
        zzlVarZzb.zzb(zzjVarZza.zzd());
        zze zzeVar = new zze(this.zzf, zzlVarZzb.zze());
        this.zze.set(zzeVar);
        this.zza.set(zzbi.AUTHENTICATED);
        taskCompletionSource.trySetResult(Boolean.TRUE);
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzbk) it.next()).zza(zzeVar);
            it.remove();
        }
    }

    final /* synthetic */ void zzh(TaskCompletionSource taskCompletionSource, int i10, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfb.zza(exception);
            zzez.zzh("GamesApiManager", "Resolution failed", exception);
            zzn(taskCompletionSource, i10, null, false, true);
            return;
        }
        com.google.android.gms.games.internal.v2.resolution.zzc zzcVar = (com.google.android.gms.games.internal.v2.resolution.zzc) task.getResult();
        if (zzcVar.zzd()) {
            zzez.zza("GamesApiManager", "Resolution successful");
            zzm(taskCompletionSource, zzy.zzc(i10, zzaf.zza(zzcVar.zza())));
        } else {
            zzez.zza("GamesApiManager", "Resolution attempt was canceled");
            zzn(taskCompletionSource, i10, null, false, true);
        }
    }

    final /* synthetic */ void zzi(zzbk zzbkVar) {
        Preconditions.checkMainThread("Must be called on the main thread.");
        zzbi zzbiVar = (zzbi) this.zza.get();
        if (zzbiVar == zzbi.AUTHENTICATED) {
            zzbkVar.zza((GoogleApi) this.zze.get());
        } else if (zzbiVar == zzbi.AUTHENTICATION_FAILED) {
            zzbkVar.zzc(zzj());
        } else {
            this.zzc.add(zzbkVar);
        }
    }
}
