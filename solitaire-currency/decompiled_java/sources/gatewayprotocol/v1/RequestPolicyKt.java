package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestPolicyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RequestPolicyKt {

    @NotNull
    public static final RequestPolicyKt INSTANCE = new RequestPolicyKt();

    /* JADX INFO: compiled from: RequestPolicyKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final NativeConfigurationOuterClass.RequestPolicy.Builder _builder;

        /* JADX INFO: compiled from: RequestPolicyKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.RequestPolicy.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.RequestPolicy.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ NativeConfigurationOuterClass.RequestPolicy _build() {
            NativeConfigurationOuterClass.RequestPolicy requestPolicyBuild = this._builder.build();
            t.h(requestPolicyBuild, "_builder.build()");
            return requestPolicyBuild;
        }

        public final void clearRetryPolicy() {
            this._builder.clearRetryPolicy();
        }

        public final void clearTimeoutPolicy() {
            this._builder.clearTimeoutPolicy();
        }

        @NotNull
        public final NativeConfigurationOuterClass.RequestRetryPolicy getRetryPolicy() {
            NativeConfigurationOuterClass.RequestRetryPolicy retryPolicy = this._builder.getRetryPolicy();
            t.h(retryPolicy, "_builder.getRetryPolicy()");
            return retryPolicy;
        }

        @NotNull
        public final NativeConfigurationOuterClass.RequestTimeoutPolicy getTimeoutPolicy() {
            NativeConfigurationOuterClass.RequestTimeoutPolicy timeoutPolicy = this._builder.getTimeoutPolicy();
            t.h(timeoutPolicy, "_builder.getTimeoutPolicy()");
            return timeoutPolicy;
        }

        public final boolean hasRetryPolicy() {
            return this._builder.hasRetryPolicy();
        }

        public final boolean hasTimeoutPolicy() {
            return this._builder.hasTimeoutPolicy();
        }

        public final void setRetryPolicy(@NotNull NativeConfigurationOuterClass.RequestRetryPolicy value) {
            t.i(value, "value");
            this._builder.setRetryPolicy(value);
        }

        public final void setTimeoutPolicy(@NotNull NativeConfigurationOuterClass.RequestTimeoutPolicy value) {
            t.i(value, "value");
            this._builder.setTimeoutPolicy(value);
        }

        private Dsl(NativeConfigurationOuterClass.RequestPolicy.Builder builder) {
            this._builder = builder;
        }
    }

    private RequestPolicyKt() {
    }
}
