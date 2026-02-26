package com.braze.location;

import com.braze.models.BrazeGeofence;
import com.google.android.gms.location.Geofence;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayLocationUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final Geofence toGeofence(@NotNull BrazeGeofence brazeGeofence) {
        t.i(brazeGeofence, "<this>");
        Geofence.Builder builder = new Geofence.Builder();
        builder.setRequestId(brazeGeofence.getId()).setCircularRegion(brazeGeofence.getLatitude(), brazeGeofence.getLongitude(), brazeGeofence.getRadiusMeter()).setNotificationResponsiveness(brazeGeofence.getNotificationResponsivenessMs()).setExpirationDuration(-1L);
        boolean enterEvents = brazeGeofence.getEnterEvents();
        int i10 = enterEvents;
        if (brazeGeofence.getExitEvents()) {
            i10 = (enterEvents ? 1 : 0) | 2;
        }
        builder.setTransitionTypes(i10);
        Geofence geofenceBuild = builder.build();
        t.h(geofenceBuild, "builder.build()");
        return geofenceBuild;
    }
}
