package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AllowedPiiKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AllowedPiiKt {

    @NotNull
    public static final AllowedPiiKt INSTANCE = new AllowedPiiKt();

    /* JADX INFO: compiled from: AllowedPiiKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final AllowedPiiOuterClass.AllowedPii.Builder _builder;

        /* JADX INFO: compiled from: AllowedPiiKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(AllowedPiiOuterClass.AllowedPii.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(AllowedPiiOuterClass.AllowedPii.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ AllowedPiiOuterClass.AllowedPii _build() {
            AllowedPiiOuterClass.AllowedPii allowedPiiBuild = this._builder.build();
            t.h(allowedPiiBuild, "_builder.build()");
            return allowedPiiBuild;
        }

        public final void clearIdfa() {
            this._builder.clearIdfa();
        }

        public final void clearIdfv() {
            this._builder.clearIdfv();
        }

        public final boolean getIdfa() {
            return this._builder.getIdfa();
        }

        public final boolean getIdfv() {
            return this._builder.getIdfv();
        }

        public final void setIdfa(boolean z10) {
            this._builder.setIdfa(z10);
        }

        public final void setIdfv(boolean z10) {
            this._builder.setIdfv(z10);
        }

        private Dsl(AllowedPiiOuterClass.AllowedPii.Builder builder) {
            this._builder = builder;
        }
    }

    private AllowedPiiKt() {
    }
}
