package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FeatureFlagsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeatureFlagsKt {

    @NotNull
    public static final FeatureFlagsKt INSTANCE = new FeatureFlagsKt();

    /* JADX INFO: compiled from: FeatureFlagsKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final NativeConfigurationOuterClass.FeatureFlags.Builder _builder;

        /* JADX INFO: compiled from: FeatureFlagsKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.FeatureFlags.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.FeatureFlags.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ NativeConfigurationOuterClass.FeatureFlags _build() {
            NativeConfigurationOuterClass.FeatureFlags featureFlagsBuild = this._builder.build();
            t.h(featureFlagsBuild, "_builder.build()");
            return featureFlagsBuild;
        }

        public final void clearBoldSdkNextSessionEnabled() {
            this._builder.clearBoldSdkNextSessionEnabled();
        }

        public final void clearOpenglGpuEnabled() {
            this._builder.clearOpenglGpuEnabled();
        }

        public final void clearOpportunityIdPlacementValidation() {
            this._builder.clearOpportunityIdPlacementValidation();
        }

        public final boolean getBoldSdkNextSessionEnabled() {
            return this._builder.getBoldSdkNextSessionEnabled();
        }

        public final boolean getOpenglGpuEnabled() {
            return this._builder.getOpenglGpuEnabled();
        }

        public final boolean getOpportunityIdPlacementValidation() {
            return this._builder.getOpportunityIdPlacementValidation();
        }

        public final void setBoldSdkNextSessionEnabled(boolean z10) {
            this._builder.setBoldSdkNextSessionEnabled(z10);
        }

        public final void setOpenglGpuEnabled(boolean z10) {
            this._builder.setOpenglGpuEnabled(z10);
        }

        public final void setOpportunityIdPlacementValidation(boolean z10) {
            this._builder.setOpportunityIdPlacementValidation(z10);
        }

        private Dsl(NativeConfigurationOuterClass.FeatureFlags.Builder builder) {
            this._builder = builder;
        }
    }

    private FeatureFlagsKt() {
    }
}
