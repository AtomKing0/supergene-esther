package com.braze.location;

import android.content.Context;
import com.braze.support.BrazeLogger;
import h9.a;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
final class GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$1 extends v implements l<Void, k0> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<String> $obsoleteGeofenceIds;

    /* JADX INFO: renamed from: com.braze.location.GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: GooglePlayLocationUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Geofences successfully un-registered with Google Play Services.";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GooglePlayLocationUtils$removeGeofencesRegisteredWithGeofencingClient$1(Context context, List<String> list) {
        super(1);
        this.$context = context;
        this.$obsoleteGeofenceIds = list;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Void r12) {
        invoke2(r12);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r92) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        GooglePlayLocationUtils googlePlayLocationUtils = GooglePlayLocationUtils.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) googlePlayLocationUtils, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 7, (Object) null);
        googlePlayLocationUtils.removeGeofencesFromSharedPrefs(this.$context, this.$obsoleteGeofenceIds);
    }
}
