package com.braze.location;

import com.braze.models.BrazeGeofence;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class GooglePlayLocationUtils$storeGeofencesToSharedPrefs$1 extends v implements a<String> {
    final /* synthetic */ BrazeGeofence $brazeGeofence;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GooglePlayLocationUtils$storeGeofencesToSharedPrefs$1(BrazeGeofence brazeGeofence) {
        super(0);
        this.$brazeGeofence = brazeGeofence;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Geofence with id: " + this.$brazeGeofence.getId() + " added to shared preferences.";
    }
}
