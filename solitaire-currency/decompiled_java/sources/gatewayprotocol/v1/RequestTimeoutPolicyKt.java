package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestTimeoutPolicyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RequestTimeoutPolicyKt {

    @NotNull
    public static final RequestTimeoutPolicyKt INSTANCE = new RequestTimeoutPolicyKt();

    /* JADX INFO: compiled from: RequestTimeoutPolicyKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder _builder;

        /* JADX INFO: compiled from: RequestTimeoutPolicyKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ NativeConfigurationOuterClass.RequestTimeoutPolicy _build() {
            NativeConfigurationOuterClass.RequestTimeoutPolicy requestTimeoutPolicyBuild = this._builder.build();
            t.h(requestTimeoutPolicyBuild, "_builder.build()");
            return requestTimeoutPolicyBuild;
        }

        public final void clearConnectTimeoutMs() {
            this._builder.clearConnectTimeoutMs();
        }

        public final void clearOverallTimeoutMs() {
            this._builder.clearOverallTimeoutMs();
        }

        public final void clearReadTimeoutMs() {
            this._builder.clearReadTimeoutMs();
        }

        public final void clearWriteTimeoutMs() {
            this._builder.clearWriteTimeoutMs();
        }

        public final int getConnectTimeoutMs() {
            return this._builder.getConnectTimeoutMs();
        }

        public final int getOverallTimeoutMs() {
            return this._builder.getOverallTimeoutMs();
        }

        public final int getReadTimeoutMs() {
            return this._builder.getReadTimeoutMs();
        }

        public final int getWriteTimeoutMs() {
            return this._builder.getWriteTimeoutMs();
        }

        public final void setConnectTimeoutMs(int i10) {
            this._builder.setConnectTimeoutMs(i10);
        }

        public final void setOverallTimeoutMs(int i10) {
            this._builder.setOverallTimeoutMs(i10);
        }

        public final void setReadTimeoutMs(int i10) {
            this._builder.setReadTimeoutMs(i10);
        }

        public final void setWriteTimeoutMs(int i10) {
            this._builder.setWriteTimeoutMs(i10);
        }

        private Dsl(NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder builder) {
            this._builder = builder;
        }
    }

    private RequestTimeoutPolicyKt() {
    }
}
