package com.braze.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.LocationProviderName;
import com.braze.location.BrazeInternalLocationApi;
import com.braze.models.IBrazeLocation;
import com.braze.models.outgoing.BrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import com.braze.support.PermissionUtils;
import h9.a;
import h9.l;
import java.util.EnumSet;
import java.util.function.Consumer;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeInternalLocationApi implements IBrazeLocationApi {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private EnumSet<LocationProviderName> allowedLocationProviders;
    private BrazeConfigurationProvider appConfigurationProvider;
    private Context context;
    private LocationManager locationManager;

    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$getLastKnownGpsLocationIfValid$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ long $ageMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j10) {
            super(0);
            this.$ageMs = j10;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Last known GPS location is too old and will not be used. Age ms: " + this.$ageMs;
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$getLastKnownGpsLocationIfValid$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        final /* synthetic */ Location $lastKnownGpsLocation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Location location) {
            super(0);
            this.$lastKnownGpsLocation = location;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Using last known GPS location: " + this.$lastKnownGpsLocation;
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$isLocationCollectionEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class C10701 extends v implements a<String> {
        public static final C10701 INSTANCE = new C10701();

        C10701() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Location collection enabled via sdk configuration.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$isLocationCollectionEnabled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class C10712 extends v implements a<String> {
        public static final C10712 INSTANCE = new C10712();

        C10712() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Location collection disabled via sdk configuration.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$requestSingleLocationUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class C10721 extends v implements a<String> {
        public static final C10721 INSTANCE = new C10721();

        C10721() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Did not request single location update. Location collection is disabled.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$requestSingleLocationUpdate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class C10732 extends v implements a<String> {
        public static final C10732 INSTANCE = new C10732();

        C10732() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Did not request single location update. Neither fine nor coarse location permissions found.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$requestSingleLocationUpdate$3, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ Location $lastKnownGpsLocationIfValid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Location location) {
            super(0);
            this.$lastKnownGpsLocationIfValid = location;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting user location to last known GPS location: " + this.$lastKnownGpsLocationIfValid;
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$requestSingleLocationUpdate$4, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Could not request single location update. Could not find suitable location provider.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$requestSingleLocationUpdate$5, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        final /* synthetic */ String $provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str) {
            super(0);
            this.$provider = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Requesting single location update with provider: " + this.$provider;
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$requestSingleLocationUpdate$7, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class AnonymousClass7 extends v implements a<String> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        AnonymousClass7() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to request single location update due to security exception from insufficient permissions.";
        }
    }

    /* JADX INFO: renamed from: com.braze.location.BrazeInternalLocationApi$requestSingleLocationUpdate$8, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeInternalLocationApi.kt */
    static final class AnonymousClass8 extends v implements a<String> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        AnonymousClass8() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to request single location update due to exception.";
        }
    }

    private final boolean isLocationCollectionEnabled() {
        BrazeConfigurationProvider brazeConfigurationProvider = this.appConfigurationProvider;
        if (brazeConfigurationProvider == null) {
            t.A("appConfigurationProvider");
            brazeConfigurationProvider = null;
        }
        if (brazeConfigurationProvider.isLocationCollectionEnabled()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) C10701.INSTANCE, 6, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) C10712.INSTANCE, 6, (Object) null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestSingleLocationUpdate$lambda$0(BrazeInternalLocationApi this$0, l manualLocationUpdateCallback, Location location) {
        t.i(this$0, "this$0");
        t.i(manualLocationUpdateCallback, "$manualLocationUpdateCallback");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new BrazeInternalLocationApi$requestSingleLocationUpdate$6$1(location), 7, (Object) null);
        if (location != null) {
            manualLocationUpdateCallback.invoke(new BrazeLocation(location));
        }
    }

    private final void requestSingleUpdateFromLocationManager(String str) {
        Intent intent = new Intent("com.braze.action.receiver.SINGLE_LOCATION_UPDATE");
        Context context = this.context;
        LocationManager locationManager = null;
        if (context == null) {
            t.A("context");
            context = null;
        }
        Intent intent2 = intent.setClass(context, BrazeActionReceiver.class);
        t.h(intent2, "Intent(Constants.BRAZE_A…tionReceiver::class.java)");
        int mutablePendingIntentFlags = 134217728 | IntentUtils.getMutablePendingIntentFlags();
        Context context2 = this.context;
        if (context2 == null) {
            t.A("context");
            context2 = null;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context2, 0, intent2, mutablePendingIntentFlags);
        LocationManager locationManager2 = this.locationManager;
        if (locationManager2 == null) {
            t.A("locationManager");
        } else {
            locationManager = locationManager2;
        }
        locationManager.requestSingleUpdate(str, broadcast);
    }

    @VisibleForTesting
    @Nullable
    public final Location getLastKnownGpsLocationIfValid(@NotNull LocationManager locationManager) {
        Location lastKnownLocation;
        t.i(locationManager, "locationManager");
        if (!locationManager.isProviderEnabled("gps") || (lastKnownLocation = locationManager.getLastKnownLocation("gps")) == null) {
            return null;
        }
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds() - lastKnownLocation.getTime();
        if (jNowInMilliseconds > 600000) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass1(jNowInMilliseconds), 6, (Object) null);
            return null;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass2(lastKnownLocation), 7, (Object) null);
        return lastKnownLocation;
    }

    @Nullable
    public final String getSuitableLocationProvider(@NotNull LocationManager locationManager, @NotNull EnumSet<LocationProviderName> allowedProviders, boolean z10, boolean z11) {
        t.i(locationManager, "locationManager");
        t.i(allowedProviders, "allowedProviders");
        if (z10 && allowedProviders.contains(LocationProviderName.GPS) && locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if ((z11 || z10) && allowedProviders.contains(LocationProviderName.NETWORK) && locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (z10 && allowedProviders.contains(LocationProviderName.PASSIVE) && locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    @Override // com.braze.location.IBrazeLocationApi
    public void initWithContext(@NotNull Context context, @NotNull EnumSet<LocationProviderName> allowedProviders, @NotNull BrazeConfigurationProvider appConfigurationProvider) {
        t.i(context, "context");
        t.i(allowedProviders, "allowedProviders");
        t.i(appConfigurationProvider, "appConfigurationProvider");
        this.context = context;
        this.appConfigurationProvider = appConfigurationProvider;
        this.allowedLocationProviders = allowedProviders;
        Object systemService = context.getSystemService("location");
        t.g(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
    }

    @Override // com.braze.location.IBrazeLocationApi
    public boolean requestSingleLocationUpdate(@NotNull final l<? super IBrazeLocation, k0> manualLocationUpdateCallback) {
        t.i(manualLocationUpdateCallback, "manualLocationUpdateCallback");
        if (!isLocationCollectionEnabled()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) C10721.INSTANCE, 6, (Object) null);
            return false;
        }
        Context context = this.context;
        if (context == null) {
            t.A("context");
            context = null;
        }
        boolean zHasPermission = PermissionUtils.hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
        Context context2 = this.context;
        if (context2 == null) {
            t.A("context");
            context2 = null;
        }
        boolean zHasPermission2 = PermissionUtils.hasPermission(context2, "android.permission.ACCESS_COARSE_LOCATION");
        if (!zHasPermission2 && !zHasPermission) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) C10732.INSTANCE, 6, (Object) null);
            return false;
        }
        if (zHasPermission) {
            LocationManager locationManager = this.locationManager;
            if (locationManager == null) {
                t.A("locationManager");
                locationManager = null;
            }
            Location lastKnownGpsLocationIfValid = getLastKnownGpsLocationIfValid(locationManager);
            if (lastKnownGpsLocationIfValid != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass3(lastKnownGpsLocationIfValid), 7, (Object) null);
                manualLocationUpdateCallback.invoke(new BrazeLocation(lastKnownGpsLocationIfValid));
                return true;
            }
        }
        LocationManager locationManager2 = this.locationManager;
        if (locationManager2 == null) {
            t.A("locationManager");
            locationManager2 = null;
        }
        EnumSet<LocationProviderName> enumSet = this.allowedLocationProviders;
        if (enumSet == null) {
            t.A("allowedLocationProviders");
            enumSet = null;
        }
        String suitableLocationProvider = getSuitableLocationProvider(locationManager2, enumSet, zHasPermission, zHasPermission2);
        if (suitableLocationProvider == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass4.INSTANCE, 7, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass5(suitableLocationProvider), 7, (Object) null);
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                LocationManager locationManager3 = this.locationManager;
                if (locationManager3 == null) {
                    t.A("locationManager");
                    locationManager3 = null;
                }
                locationManager3.getCurrentLocation(suitableLocationProvider, null, s1.a(e1.b()), new Consumer() { // from class: f0.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        BrazeInternalLocationApi.requestSingleLocationUpdate$lambda$0(this.f25530a, manualLocationUpdateCallback, (Location) obj);
                    }
                });
            } else {
                requestSingleUpdateFromLocationManager(suitableLocationProvider);
            }
            return true;
        } catch (SecurityException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass7.INSTANCE, 4, (Object) null);
            return false;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (a) AnonymousClass8.INSTANCE, 4, (Object) null);
            return false;
        }
    }
}
