package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import com.braze.location.BrazeInternalGeofenceApi;
import com.braze.location.IBrazeGeofenceApi;

/* JADX INFO: loaded from: classes2.dex */
public final class qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBrazeGeofenceApi f3695a;

    public qa() {
        IBrazeGeofenceApi iBrazeGeofenceApi;
        try {
            Object objNewInstance = BrazeInternalGeofenceApi.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type com.braze.location.IBrazeGeofenceApi");
            iBrazeGeofenceApi = (IBrazeGeofenceApi) objNewInstance;
        } catch (Exception unused) {
            iBrazeGeofenceApi = null;
        }
        this.f3695a = iBrazeGeofenceApi;
    }

    public final PendingIntent a(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        IBrazeGeofenceApi iBrazeGeofenceApi = this.f3695a;
        if (iBrazeGeofenceApi != null) {
            return iBrazeGeofenceApi.getGeofenceTransitionPendingIntent(context);
        }
        return null;
    }

    public final boolean a() {
        return this.f3695a != null;
    }
}
