package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestRetryPolicyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RequestRetryPolicyKt {

    @NotNull
    public static final RequestRetryPolicyKt INSTANCE = new RequestRetryPolicyKt();

    /* JADX INFO: compiled from: RequestRetryPolicyKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final NativeConfigurationOuterClass.RequestRetryPolicy.Builder _builder;

        /* JADX INFO: compiled from: RequestRetryPolicyKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.RequestRetryPolicy.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.RequestRetryPolicy.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ NativeConfigurationOuterClass.RequestRetryPolicy _build() {
            NativeConfigurationOuterClass.RequestRetryPolicy requestRetryPolicyBuild = this._builder.build();
            t.h(requestRetryPolicyBuild, "_builder.build()");
            return requestRetryPolicyBuild;
        }

        public final void clearMaxDuration() {
            this._builder.clearMaxDuration();
        }

        public final void clearRetryJitterPct() {
            this._builder.clearRetryJitterPct();
        }

        public final void clearRetryMaxInterval() {
            this._builder.clearRetryMaxInterval();
        }

        public final void clearRetryScalingFactor() {
            this._builder.clearRetryScalingFactor();
        }

        public final void clearRetryWaitBase() {
            this._builder.clearRetryWaitBase();
        }

        public final void clearShouldStoreLocally() {
            this._builder.clearShouldStoreLocally();
        }

        public final int getMaxDuration() {
            return this._builder.getMaxDuration();
        }

        public final float getRetryJitterPct() {
            return this._builder.getRetryJitterPct();
        }

        public final int getRetryMaxInterval() {
            return this._builder.getRetryMaxInterval();
        }

        public final float getRetryScalingFactor() {
            return this._builder.getRetryScalingFactor();
        }

        public final int getRetryWaitBase() {
            return this._builder.getRetryWaitBase();
        }

        public final boolean getShouldStoreLocally() {
            return this._builder.getShouldStoreLocally();
        }

        public final void setMaxDuration(int i10) {
            this._builder.setMaxDuration(i10);
        }

        public final void setRetryJitterPct(float f10) {
            this._builder.setRetryJitterPct(f10);
        }

        public final void setRetryMaxInterval(int i10) {
            this._builder.setRetryMaxInterval(i10);
        }

        public final void setRetryScalingFactor(float f10) {
            this._builder.setRetryScalingFactor(f10);
        }

        public final void setRetryWaitBase(int i10) {
            this._builder.setRetryWaitBase(i10);
        }

        public final void setShouldStoreLocally(boolean z10) {
            this._builder.setShouldStoreLocally(z10);
        }

        private Dsl(NativeConfigurationOuterClass.RequestRetryPolicy.Builder builder) {
            this._builder = builder;
        }
    }

    private RequestRetryPolicyKt() {
    }
}
