package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NativeConfigurationKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NativeConfigurationKt {

    @NotNull
    public static final NativeConfigurationKt INSTANCE = new NativeConfigurationKt();

    /* JADX INFO: compiled from: NativeConfigurationKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final NativeConfigurationOuterClass.NativeConfiguration.Builder _builder;

        /* JADX INFO: compiled from: NativeConfigurationKt.kt */
        public static final class AdditionalStorePackagesProxy extends DslProxy {
            private AdditionalStorePackagesProxy() {
            }
        }

        /* JADX INFO: compiled from: NativeConfigurationKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.NativeConfiguration.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.NativeConfiguration.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ NativeConfigurationOuterClass.NativeConfiguration _build() {
            NativeConfigurationOuterClass.NativeConfiguration nativeConfigurationBuild = this._builder.build();
            t.h(nativeConfigurationBuild, "_builder.build()");
            return nativeConfigurationBuild;
        }

        public final /* synthetic */ void addAdditionalStorePackages(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addAdditionalStorePackages(value);
        }

        public final /* synthetic */ void addAllAdditionalStorePackages(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllAdditionalStorePackages(values);
        }

        public final void clearAdOperations() {
            this._builder.clearAdOperations();
        }

        public final void clearAdPolicy() {
            this._builder.clearAdPolicy();
        }

        public final /* synthetic */ void clearAdditionalStorePackages(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearAdditionalStorePackages();
        }

        public final void clearDiagnosticEvents() {
            this._builder.clearDiagnosticEvents();
        }

        public final void clearEnableIapEvent() {
            this._builder.clearEnableIapEvent();
        }

        public final void clearEnableOm() {
            this._builder.clearEnableOm();
        }

        public final void clearFeatureFlags() {
            this._builder.clearFeatureFlags();
        }

        public final void clearInitPolicy() {
            this._builder.clearInitPolicy();
        }

        public final void clearOperativeEventPolicy() {
            this._builder.clearOperativeEventPolicy();
        }

        public final void clearOtherPolicy() {
            this._builder.clearOtherPolicy();
        }

        @NotNull
        public final NativeConfigurationOuterClass.AdOperationsConfiguration getAdOperations() {
            NativeConfigurationOuterClass.AdOperationsConfiguration adOperations = this._builder.getAdOperations();
            t.h(adOperations, "_builder.getAdOperations()");
            return adOperations;
        }

        @NotNull
        public final NativeConfigurationOuterClass.RequestPolicy getAdPolicy() {
            NativeConfigurationOuterClass.RequestPolicy adPolicy = this._builder.getAdPolicy();
            t.h(adPolicy, "_builder.getAdPolicy()");
            return adPolicy;
        }

        @NotNull
        public final DslList<String, AdditionalStorePackagesProxy> getAdditionalStorePackages() {
            List<String> additionalStorePackagesList = this._builder.getAdditionalStorePackagesList();
            t.h(additionalStorePackagesList, "_builder.getAdditionalStorePackagesList()");
            return new DslList<>(additionalStorePackagesList);
        }

        @NotNull
        public final NativeConfigurationOuterClass.DiagnosticEventsConfiguration getDiagnosticEvents() {
            NativeConfigurationOuterClass.DiagnosticEventsConfiguration diagnosticEvents = this._builder.getDiagnosticEvents();
            t.h(diagnosticEvents, "_builder.getDiagnosticEvents()");
            return diagnosticEvents;
        }

        public final boolean getEnableIapEvent() {
            return this._builder.getEnableIapEvent();
        }

        public final boolean getEnableOm() {
            return this._builder.getEnableOm();
        }

        @NotNull
        public final NativeConfigurationOuterClass.FeatureFlags getFeatureFlags() {
            NativeConfigurationOuterClass.FeatureFlags featureFlags = this._builder.getFeatureFlags();
            t.h(featureFlags, "_builder.getFeatureFlags()");
            return featureFlags;
        }

        @NotNull
        public final NativeConfigurationOuterClass.RequestPolicy getInitPolicy() {
            NativeConfigurationOuterClass.RequestPolicy initPolicy = this._builder.getInitPolicy();
            t.h(initPolicy, "_builder.getInitPolicy()");
            return initPolicy;
        }

        @NotNull
        public final NativeConfigurationOuterClass.RequestPolicy getOperativeEventPolicy() {
            NativeConfigurationOuterClass.RequestPolicy operativeEventPolicy = this._builder.getOperativeEventPolicy();
            t.h(operativeEventPolicy, "_builder.getOperativeEventPolicy()");
            return operativeEventPolicy;
        }

        @NotNull
        public final NativeConfigurationOuterClass.RequestPolicy getOtherPolicy() {
            NativeConfigurationOuterClass.RequestPolicy otherPolicy = this._builder.getOtherPolicy();
            t.h(otherPolicy, "_builder.getOtherPolicy()");
            return otherPolicy;
        }

        public final boolean hasAdOperations() {
            return this._builder.hasAdOperations();
        }

        public final boolean hasAdPolicy() {
            return this._builder.hasAdPolicy();
        }

        public final boolean hasDiagnosticEvents() {
            return this._builder.hasDiagnosticEvents();
        }

        public final boolean hasFeatureFlags() {
            return this._builder.hasFeatureFlags();
        }

        public final boolean hasInitPolicy() {
            return this._builder.hasInitPolicy();
        }

        public final boolean hasOperativeEventPolicy() {
            return this._builder.hasOperativeEventPolicy();
        }

        public final boolean hasOtherPolicy() {
            return this._builder.hasOtherPolicy();
        }

        public final /* synthetic */ void plusAssignAdditionalStorePackages(DslList<String, AdditionalStorePackagesProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addAdditionalStorePackages(dslList, value);
        }

        public final /* synthetic */ void plusAssignAllAdditionalStorePackages(DslList<String, AdditionalStorePackagesProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllAdditionalStorePackages(dslList, values);
        }

        public final void setAdOperations(@NotNull NativeConfigurationOuterClass.AdOperationsConfiguration value) {
            t.i(value, "value");
            this._builder.setAdOperations(value);
        }

        public final void setAdPolicy(@NotNull NativeConfigurationOuterClass.RequestPolicy value) {
            t.i(value, "value");
            this._builder.setAdPolicy(value);
        }

        public final /* synthetic */ void setAdditionalStorePackages(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setAdditionalStorePackages(i10, value);
        }

        public final void setDiagnosticEvents(@NotNull NativeConfigurationOuterClass.DiagnosticEventsConfiguration value) {
            t.i(value, "value");
            this._builder.setDiagnosticEvents(value);
        }

        public final void setEnableIapEvent(boolean z10) {
            this._builder.setEnableIapEvent(z10);
        }

        public final void setEnableOm(boolean z10) {
            this._builder.setEnableOm(z10);
        }

        public final void setFeatureFlags(@NotNull NativeConfigurationOuterClass.FeatureFlags value) {
            t.i(value, "value");
            this._builder.setFeatureFlags(value);
        }

        public final void setInitPolicy(@NotNull NativeConfigurationOuterClass.RequestPolicy value) {
            t.i(value, "value");
            this._builder.setInitPolicy(value);
        }

        public final void setOperativeEventPolicy(@NotNull NativeConfigurationOuterClass.RequestPolicy value) {
            t.i(value, "value");
            this._builder.setOperativeEventPolicy(value);
        }

        public final void setOtherPolicy(@NotNull NativeConfigurationOuterClass.RequestPolicy value) {
            t.i(value, "value");
            this._builder.setOtherPolicy(value);
        }

        private Dsl(NativeConfigurationOuterClass.NativeConfiguration.Builder builder) {
            this._builder = builder;
        }
    }

    private NativeConfigurationKt() {
    }
}
