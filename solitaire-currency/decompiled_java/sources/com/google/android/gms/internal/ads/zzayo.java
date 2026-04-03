package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzayo implements Application.ActivityLifecycleCallbacks {

    @Nullable
    private Activity zza;
    private Context zzb;
    private Runnable zzh;
    private long zzj;
    private final Object zzc = new Object();
    private boolean zzd = true;
    private boolean zze = false;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private boolean zzi = false;

    zzayo() {
    }

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zza = activity;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 == null) {
                return;
            }
            if (activity2.equals(activity)) {
                this.zza = null;
            }
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    if (((zzazd) it.next()).zza()) {
                        it.remove();
                    }
                } catch (Exception e10) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    ((zzazd) it.next()).zzb();
                } catch (Exception e10) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AppActivityTracker.ActivityListener.onActivityPaused");
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                }
            }
        }
        this.zze = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzt.zza.removeCallbacks(runnable);
        }
        zzfru zzfruVar = com.google.android.gms.ads.internal.util.zzt.zza;
        zzayn zzaynVar = new zzayn(this);
        this.zzh = zzaynVar;
        zzfruVar.postDelayed(zzaynVar, this.zzj);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z10 = !this.zzd;
        this.zzd = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzt.zza.removeCallbacks(runnable);
        }
        synchronized (this.zzc) {
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                try {
                    ((zzazd) it.next()).zzc();
                } catch (Exception e10) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AppActivityTracker.ActivityListener.onActivityResumed");
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
                }
            }
            if (z10) {
                Iterator it2 = this.zzf.iterator();
                while (it2.hasNext()) {
                    try {
                        ((zzayp) it2.next()).zza(true);
                    } catch (Exception e11) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzh("", e11);
                    }
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zze("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    @Nullable
    public final Activity zza() {
        return this.zza;
    }

    @Nullable
    public final Context zzb() {
        return this.zzb;
    }

    public final void zzf(zzayp zzaypVar) {
        synchronized (this.zzc) {
            this.zzf.add(zzaypVar);
        }
    }

    public final void zzg(Application application, Context context) {
        if (this.zzi) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            zzk((Activity) context);
        }
        this.zzb = application;
        this.zzj = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaJ)).longValue();
        this.zzi = true;
    }

    public final void zzh(zzayp zzaypVar) {
        synchronized (this.zzc) {
            this.zzf.remove(zzaypVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
