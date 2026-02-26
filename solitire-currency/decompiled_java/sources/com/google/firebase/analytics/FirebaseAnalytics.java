package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile FirebaseAnalytics f10218c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzds f10219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f10220b;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
    public enum a {
        GRANTED,
        DENIED
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
    public enum b {
        AD_STORAGE,
        ANALYTICS_STORAGE,
        AD_USER_DATA,
        AD_PERSONALIZATION
    }

    private FirebaseAnalytics(zzds zzdsVar) {
        Preconditions.checkNotNull(zzdsVar);
        this.f10219a = zzdsVar;
    }

    private final ExecutorService g() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            if (this.f10220b == null) {
                this.f10220b = new com.google.firebase.analytics.a(this, 0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.f10220b;
        }
        return executorService;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f10218c == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f10218c == null) {
                    f10218c = new FirebaseAnalytics(zzds.zza(context));
                }
            }
        }
        return f10218c;
    }

    @Nullable
    @Keep
    public static zzkn getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        zzds zzdsVarZza = zzds.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zzdsVarZza == null) {
            return null;
        }
        return new c(zzdsVarZza);
    }

    @NonNull
    public final Task<String> a() {
        try {
            return Tasks.call(g(), new com.google.firebase.analytics.b(this));
        } catch (RuntimeException e10) {
            this.f10219a.zza(5, "Failed to schedule task for getAppInstanceId", (Object) null, (Object) null, (Object) null);
            return Tasks.forException(e10);
        }
    }

    public final void b(@NonNull @Size(max = 40, min = 1) String str, @Nullable Bundle bundle) {
        this.f10219a.zza(str, bundle);
    }

    public final void c(boolean z10) {
        this.f10219a.zza(Boolean.valueOf(z10));
    }

    public final void d(@NonNull Map<b, a> map) {
        Bundle bundle = new Bundle();
        a aVar = map.get(b.AD_STORAGE);
        if (aVar != null) {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 0) {
                bundle.putString("ad_storage", "granted");
            } else if (iOrdinal == 1) {
                bundle.putString("ad_storage", "denied");
            }
        }
        a aVar2 = map.get(b.ANALYTICS_STORAGE);
        if (aVar2 != null) {
            int iOrdinal2 = aVar2.ordinal();
            if (iOrdinal2 == 0) {
                bundle.putString("analytics_storage", "granted");
            } else if (iOrdinal2 == 1) {
                bundle.putString("analytics_storage", "denied");
            }
        }
        a aVar3 = map.get(b.AD_USER_DATA);
        if (aVar3 != null) {
            int iOrdinal3 = aVar3.ordinal();
            if (iOrdinal3 == 0) {
                bundle.putString("ad_user_data", "granted");
            } else if (iOrdinal3 == 1) {
                bundle.putString("ad_user_data", "denied");
            }
        }
        a aVar4 = map.get(b.AD_PERSONALIZATION);
        if (aVar4 != null) {
            int iOrdinal4 = aVar4.ordinal();
            if (iOrdinal4 == 0) {
                bundle.putString("ad_personalization", "granted");
            } else if (iOrdinal4 == 1) {
                bundle.putString("ad_personalization", "denied");
            }
        }
        this.f10219a.zzc(bundle);
    }

    public final void e(@NonNull @Size(max = 24, min = 1) String str, @Nullable @Size(max = 36) String str2) {
        this.f10219a.zzb(str, str2);
    }

    @NonNull
    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(com.google.firebase.installations.c.p().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new IllegalStateException(e11.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @MainThread
    @Deprecated
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.f10219a.zza(activity, str, str2);
    }
}
