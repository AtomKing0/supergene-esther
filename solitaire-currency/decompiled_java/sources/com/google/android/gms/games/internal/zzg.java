package com.google.android.gms.games.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.compose.animation.core.d;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import io.sentry.protocol.SentryStackFrame;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzg {
    private static final AtomicReference zza = new AtomicReference();
    private final Application zzb;

    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private WeakReference zzf;
    private final Application.ActivityLifecycleCallbacks zzc = new zzf(this, null);
    private final Object zzd = new Object();

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final Set zze = Collections.newSetFromMap(new WeakHashMap());

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private boolean zzg = false;

    @VisibleForTesting(otherwise = 2)
    public zzg(Application application) {
        this.zzb = application;
    }

    public static zzg zzb(Application application) {
        Preconditions.checkNotNull(application);
        AtomicReference atomicReference = zza;
        zzg zzgVar = (zzg) atomicReference.get();
        if (zzgVar != null) {
            return zzgVar;
        }
        zzg zzgVar2 = new zzg(application);
        while (!d.a(atomicReference, null, zzgVar2) && atomicReference.get() == null) {
        }
        return (zzg) zza.get();
    }

    public static zzg zzc(Context context) {
        return zzb((Application) context.getApplicationContext());
    }

    static /* bridge */ /* synthetic */ void zzd(zzg zzgVar, Activity activity) {
        synchronized (zzgVar.zzd) {
            WeakReference weakReference = zzgVar.zzf;
            if (weakReference == null) {
                return;
            }
            if (weakReference.get() == activity) {
                zzgVar.zzf = null;
            }
        }
    }

    static /* bridge */ /* synthetic */ void zze(zzg zzgVar, Activity activity) {
        Preconditions.checkNotNull(activity);
        synchronized (zzgVar.zzd) {
            if (zzgVar.zza() == activity) {
                return;
            }
            zzgVar.zzf = new WeakReference(activity);
            Iterator it = zzgVar.zze.iterator();
            while (it.hasNext()) {
                ((zzd) it.next()).zza(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final void zzg(zzd zzdVar) {
        Activity activityZza = zza();
        if (activityZza == null) {
            return;
        }
        zzdVar.zza(activityZza);
    }

    @Nullable
    public final Activity zza() {
        Activity activity;
        synchronized (this.zzd) {
            WeakReference weakReference = this.zzf;
            activity = weakReference == null ? null : (Activity) weakReference.get();
        }
        return activity;
    }

    public final void zzf(final zzd zzdVar) {
        Preconditions.checkNotNull(zzdVar);
        synchronized (this.zzd) {
            this.zze.add(zzdVar);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzg(zzdVar);
        } else {
            TaskExecutors.MAIN_THREAD.execute(new Runnable() { // from class: com.google.android.gms.games.internal.zzc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg(zzdVar);
                }
            });
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            if (!this.zzg) {
                this.zzb.registerActivityLifecycleCallbacks(this.zzc);
                this.zzg = true;
            }
        }
    }
}
