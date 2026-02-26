package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.core.os.OutcomeReceiverKt;
import androidx.media3.common.PlaybackException;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: MeasurementManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MeasurementManager {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MEASUREMENT_API_STATE_DISABLED = 0;
    public static final int MEASUREMENT_API_STATE_ENABLED = 1;

    /* JADX INFO: compiled from: MeasurementManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @Nullable
        public final MeasurementManager obtain(@NotNull Context context) {
            t.i(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            sb.append(adServicesInfo.version());
            Log.d("MeasurementManager", sb.toString());
            if (adServicesInfo.version() >= 5) {
                return new Api33Ext5Impl(context);
            }
            return null;
        }
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    @Nullable
    public static final MeasurementManager obtain(@NotNull Context context) {
        return Companion.obtain(context);
    }

    @Nullable
    public abstract Object deleteRegistrations(@NotNull DeletionRequest deletionRequest, @NotNull d<? super k0> dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @Nullable
    public abstract Object getMeasurementApiStatus(@NotNull d<? super Integer> dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @Nullable
    public abstract Object registerSource(@NotNull Uri uri, @Nullable InputEvent inputEvent, @NotNull d<? super k0> dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @Nullable
    public abstract Object registerTrigger(@NotNull Uri uri, @NotNull d<? super k0> dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @Nullable
    public abstract Object registerWebSource(@NotNull WebSourceRegistrationRequest webSourceRegistrationRequest, @NotNull d<? super k0> dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @Nullable
    public abstract Object registerWebTrigger(@NotNull WebTriggerRegistrationRequest webTriggerRegistrationRequest, @NotNull d<? super k0> dVar);

    /* JADX INFO: compiled from: MeasurementManager.kt */
    @RequiresExtension(extension = PlaybackException.CUSTOM_ERROR_CODE_BASE, version = 5)
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    private static final class Api33Ext5Impl extends MeasurementManager {

        @NotNull
        private final android.adservices.measurement.MeasurementManager mMeasurementManager;

        public Api33Ext5Impl(@NotNull android.adservices.measurement.MeasurementManager mMeasurementManager) {
            t.i(mMeasurementManager, "mMeasurementManager");
            this.mMeasurementManager = mMeasurementManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.measurement.DeletionRequest convertDeletionRequest(DeletionRequest deletionRequest) {
            android.adservices.measurement.DeletionRequest deletionRequestBuild = new DeletionRequest.Builder().setDeletionMode(deletionRequest.getDeletionMode()).setMatchBehavior(deletionRequest.getMatchBehavior()).setStart(deletionRequest.getStart()).setEnd(deletionRequest.getEnd()).setDomainUris(deletionRequest.getDomainUris()).setOriginUris(deletionRequest.getOriginUris()).build();
            t.h(deletionRequestBuild, "Builder()\n              …\n                .build()");
            return deletionRequestBuild;
        }

        private final List<android.adservices.measurement.WebSourceParams> convertWebSourceParams(List<WebSourceParams> list) {
            ArrayList arrayList = new ArrayList();
            for (WebSourceParams webSourceParams : list) {
                android.adservices.measurement.WebSourceParams webSourceParamsBuild = new WebSourceParams.Builder(webSourceParams.getRegistrationUri()).setDebugKeyAllowed(webSourceParams.getDebugKeyAllowed()).build();
                t.h(webSourceParamsBuild, "Builder(param.registrati…                 .build()");
                arrayList.add(webSourceParamsBuild);
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.measurement.WebSourceRegistrationRequest convertWebSourceRequest(WebSourceRegistrationRequest webSourceRegistrationRequest) {
            android.adservices.measurement.WebSourceRegistrationRequest webSourceRegistrationRequestBuild = new WebSourceRegistrationRequest.Builder(convertWebSourceParams(webSourceRegistrationRequest.getWebSourceParams()), webSourceRegistrationRequest.getTopOriginUri()).setWebDestination(webSourceRegistrationRequest.getWebDestination()).setAppDestination(webSourceRegistrationRequest.getAppDestination()).setInputEvent(webSourceRegistrationRequest.getInputEvent()).setVerifiedDestination(webSourceRegistrationRequest.getVerifiedDestination()).build();
            t.h(webSourceRegistrationRequestBuild, "Builder(\n               …\n                .build()");
            return webSourceRegistrationRequestBuild;
        }

        private final List<android.adservices.measurement.WebTriggerParams> convertWebTriggerParams(List<WebTriggerParams> list) {
            ArrayList arrayList = new ArrayList();
            for (WebTriggerParams webTriggerParams : list) {
                android.adservices.measurement.WebTriggerParams webTriggerParamsBuild = new WebTriggerParams.Builder(webTriggerParams.getRegistrationUri()).setDebugKeyAllowed(webTriggerParams.getDebugKeyAllowed()).build();
                t.h(webTriggerParamsBuild, "Builder(param.registrati…                 .build()");
                arrayList.add(webTriggerParamsBuild);
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.measurement.WebTriggerRegistrationRequest convertWebTriggerRequest(WebTriggerRegistrationRequest webTriggerRegistrationRequest) {
            android.adservices.measurement.WebTriggerRegistrationRequest webTriggerRegistrationRequestBuild = new WebTriggerRegistrationRequest.Builder(convertWebTriggerParams(webTriggerRegistrationRequest.getWebTriggerParams()), webTriggerRegistrationRequest.getDestination()).build();
            t.h(webTriggerRegistrationRequestBuild, "Builder(\n               …\n                .build()");
            return webTriggerRegistrationRequestBuild;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        @DoNotInline
        @Nullable
        public Object deleteRegistrations(@NotNull DeletionRequest deletionRequest, @NotNull d<? super k0> dVar) throws Throwable {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.mMeasurementManager.deleteRegistrations(convertDeletionRequest(deletionRequest), new androidx.media3.exoplayer.dash.offline.a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @Nullable
        public Object getMeasurementApiStatus(@NotNull d<? super Integer> dVar) throws Throwable {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.mMeasurementManager.getMeasurementApiStatus(new androidx.media3.exoplayer.dash.offline.a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @Nullable
        public Object registerSource(@NotNull Uri uri, @Nullable InputEvent inputEvent, @NotNull d<? super k0> dVar) throws Throwable {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.mMeasurementManager.registerSource(uri, inputEvent, new androidx.media3.exoplayer.dash.offline.a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @Nullable
        public Object registerTrigger(@NotNull Uri uri, @NotNull d<? super k0> dVar) throws Throwable {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.mMeasurementManager.registerTrigger(uri, new androidx.media3.exoplayer.dash.offline.a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @Nullable
        public Object registerWebSource(@NotNull WebSourceRegistrationRequest webSourceRegistrationRequest, @NotNull d<? super k0> dVar) throws Throwable {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.mMeasurementManager.registerWebSource(convertWebSourceRequest(webSourceRegistrationRequest), new androidx.media3.exoplayer.dash.offline.a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @Nullable
        public Object registerWebTrigger(@NotNull WebTriggerRegistrationRequest webTriggerRegistrationRequest, @NotNull d<? super k0> dVar) throws Throwable {
            p pVar = new p(a9.c.c(dVar), 1);
            pVar.C();
            this.mMeasurementManager.registerWebTrigger(convertWebTriggerRequest(webTriggerRegistrationRequest), new androidx.media3.exoplayer.dash.offline.a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Api33Ext5Impl(@NotNull Context context) {
            t.i(context, "context");
            Object systemService = context.getSystemService((Class<Object>) android.adservices.measurement.MeasurementManager.class);
            t.h(systemService, "context.getSystemService…:class.java\n            )");
            this((android.adservices.measurement.MeasurementManager) systemService);
        }
    }
}
