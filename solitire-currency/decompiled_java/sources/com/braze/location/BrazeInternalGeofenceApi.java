package com.braze.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.braze.models.BrazeGeofence;
import com.braze.support.IntentUtils;
import com.google.android.gms.location.LocationServices;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeInternalGeofenceApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeInternalGeofenceApi implements IBrazeGeofenceApi {
    @Override // com.braze.location.IBrazeGeofenceApi
    @NotNull
    public PendingIntent getGeofenceTransitionPendingIntent(@NotNull Context context) {
        t.i(context, "context");
        Intent intent = new Intent("com.braze.action.receiver.BRAZE_GEOFENCE_UPDATE").setClass(context, BrazeActionReceiver.class);
        t.h(intent, "Intent(Constants.BRAZE_A…tionReceiver::class.java)");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728 | IntentUtils.getMutablePendingIntentFlags());
        t.h(broadcast, "getBroadcast(context, 0, geofenceIntent, flags)");
        return broadcast;
    }

    @Override // com.braze.location.IBrazeGeofenceApi
    public void registerGeofences(@NotNull Context context, @NotNull List<BrazeGeofence> geofenceList, @NotNull PendingIntent geofenceRequestIntent) {
        t.i(context, "context");
        t.i(geofenceList, "geofenceList");
        t.i(geofenceRequestIntent, "geofenceRequestIntent");
        GooglePlayLocationUtils.registerGeofencesWithGooglePlayIfNecessary$default(context, geofenceList, geofenceRequestIntent, null, null, 24, null);
    }

    @Override // com.braze.location.IBrazeGeofenceApi
    public void teardownGeofences(@NotNull Context applicationContext, @NotNull PendingIntent intent) {
        t.i(applicationContext, "applicationContext");
        t.i(intent, "intent");
        LocationServices.getGeofencingClient(applicationContext).removeGeofences(intent);
    }
}
