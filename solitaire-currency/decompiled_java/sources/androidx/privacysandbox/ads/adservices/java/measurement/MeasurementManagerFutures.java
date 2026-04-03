package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import com.google.common.util.concurrent.m;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: MeasurementManagerFutures.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MeasurementManagerFutures {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MeasurementManagerFutures.kt */
    static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {

        @NotNull
        private final MeasurementManager mMeasurementManager;

        public Api33Ext5JavaImpl(@NotNull MeasurementManager mMeasurementManager) {
            t.i(mMeasurementManager, "mMeasurementManager");
            this.mMeasurementManager = mMeasurementManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @NotNull
        public m<k0> deleteRegistrationsAsync(@NotNull DeletionRequest deletionRequest) {
            t.i(deletionRequest, "deletionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @NotNull
        public m<Integer> getMeasurementApiStatusAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @NotNull
        public m<k0> registerSourceAsync(@NotNull Uri attributionSource, @Nullable InputEvent inputEvent) {
            t.i(attributionSource, "attributionSource");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, attributionSource, inputEvent, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @NotNull
        public m<k0> registerTriggerAsync(@NotNull Uri trigger) {
            t.i(trigger, "trigger");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, trigger, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @NotNull
        public m<k0> registerWebSourceAsync(@NotNull WebSourceRegistrationRequest request) {
            t.i(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, request, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @NotNull
        public m<k0> registerWebTriggerAsync(@NotNull WebTriggerRegistrationRequest request) {
            t.i(request, "request");
            return CoroutineAdapterKt.asListenableFuture$default(k.b(p0.a(e1.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, request, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: MeasurementManagerFutures.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final MeasurementManagerFutures from(@NotNull Context context) {
            t.i(context, "context");
            MeasurementManager measurementManagerObtain = MeasurementManager.Companion.obtain(context);
            if (measurementManagerObtain != null) {
                return new Api33Ext5JavaImpl(measurementManagerObtain);
            }
            return null;
        }
    }

    @Nullable
    public static final MeasurementManagerFutures from(@NotNull Context context) {
        return Companion.from(context);
    }

    @NotNull
    public abstract m<k0> deleteRegistrationsAsync(@NotNull DeletionRequest deletionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract m<Integer> getMeasurementApiStatusAsync();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract m<k0> registerSourceAsync(@NotNull Uri uri, @Nullable InputEvent inputEvent);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract m<k0> registerTriggerAsync(@NotNull Uri uri);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract m<k0> registerWebSourceAsync(@NotNull WebSourceRegistrationRequest webSourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @NotNull
    public abstract m<k0> registerWebTriggerAsync(@NotNull WebTriggerRegistrationRequest webTriggerRegistrationRequest);
}
