package j5;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import i5.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f28694c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private final AppMeasurementSdk f28695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final Map<String, Object> f28696b;

    private b(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f28695a = appMeasurementSdk;
        this.f28696b = new ConcurrentHashMap();
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static a c(@NonNull e eVar, @NonNull Context context, @NonNull t5.d dVar) {
        Preconditions.checkNotNull(eVar);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(dVar);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f28694c == null) {
            synchronized (b.class) {
                if (f28694c == null) {
                    Bundle bundle = new Bundle(1);
                    if (eVar.t()) {
                        dVar.b(i5.b.class, new Executor() { // from class: j5.d
                            @Override // java.util.concurrent.Executor
                            public final void execute(Runnable runnable) {
                                runnable.run();
                            }
                        }, new t5.b() { // from class: j5.c
                            @Override // t5.b
                            public final void a(t5.a aVar) {
                                b.d(aVar);
                            }
                        });
                        bundle.putBoolean("dataCollectionDefaultEnabled", eVar.s());
                    }
                    f28694c = new b(zzds.zza(context, (String) null, (String) null, (String) null, bundle).zzb());
                }
            }
        }
        return f28694c;
    }

    static /* synthetic */ void d(t5.a aVar) {
        boolean z10 = ((i5.b) aVar.a()).f26591a;
        synchronized (b.class) {
            ((b) Preconditions.checkNotNull(f28694c)).f28695a.zza(z10);
        }
    }

    @Override // j5.a
    @KeepForSdk
    public void a(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.b.e(str) && com.google.firebase.analytics.connector.internal.b.b(str2, bundle) && com.google.firebase.analytics.connector.internal.b.d(str, str2, bundle)) {
            com.google.firebase.analytics.connector.internal.b.a(str, str2, bundle);
            this.f28695a.logEvent(str, str2, bundle);
        }
    }

    @Override // j5.a
    @KeepForSdk
    public void b(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (com.google.firebase.analytics.connector.internal.b.e(str) && com.google.firebase.analytics.connector.internal.b.c(str, str2)) {
            this.f28695a.setUserProperty(str, str2, obj);
        }
    }
}
