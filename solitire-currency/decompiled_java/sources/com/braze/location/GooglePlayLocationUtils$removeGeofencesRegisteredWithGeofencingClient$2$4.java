package com.braze.location;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$4 extends v implements a<String> {
    public static final GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$4 INSTANCE = new GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$4();

    GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$2$4() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Received Geofence un-registration success code in failure block with Google Play Services.";
    }
}
