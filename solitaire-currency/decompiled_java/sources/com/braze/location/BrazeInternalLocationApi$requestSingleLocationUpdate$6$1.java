package com.braze.location;

import android.location.Location;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeInternalLocationApi$requestSingleLocationUpdate$6$1 extends v implements a<String> {
    final /* synthetic */ Location $location;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeInternalLocationApi$requestSingleLocationUpdate$6$1(Location location) {
        super(0);
        this.$location = location;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Location manager getCurrentLocation got location: " + this.$location;
    }
}
