package com.braze.location;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$3 extends v implements a<String> {
    final /* synthetic */ int $statusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GooglePlayLocationUtils$registerGeofencesWithGeofencingClient$2$3(int i10) {
        super(0);
        this.$statusCode = i10;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Geofences not registered with Google Play Services due to GEOFENCE_NOT_AVAILABLE: " + this.$statusCode;
    }
}
