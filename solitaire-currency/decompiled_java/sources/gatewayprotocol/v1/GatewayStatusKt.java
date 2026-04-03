package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GatewayStatusKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GatewayStatusKt {

    @NotNull
    public static final GatewayStatusKt INSTANCE = new GatewayStatusKt();

    /* JADX INFO: compiled from: GatewayStatusKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.GatewayStatus.Builder _builder;

        /* JADX INFO: compiled from: GatewayStatusKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.GatewayStatus.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: GatewayStatusKt.kt */
        public static final class MessageProxy extends DslProxy {
            private MessageProxy() {
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.GatewayStatus.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.GatewayStatus _build() {
            BidRequestEventOuterClass.GatewayStatus gatewayStatusBuild = this._builder.build();
            t.h(gatewayStatusBuild, "_builder.build()");
            return gatewayStatusBuild;
        }

        public final /* synthetic */ void addAllMessage(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllMessage(values);
        }

        public final /* synthetic */ void addMessage(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addMessage(value);
        }

        public final void clearError() {
            this._builder.clearError();
        }

        public final void clearIsError() {
            this._builder.clearIsError();
        }

        public final /* synthetic */ void clearMessage(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearMessage();
        }

        @NotNull
        public final BidRequestEventOuterClass.GatewayError getError() {
            BidRequestEventOuterClass.GatewayError error = this._builder.getError();
            t.h(error, "_builder.getError()");
            return error;
        }

        public final boolean getIsError() {
            return this._builder.getIsError();
        }

        @NotNull
        public final DslList<String, MessageProxy> getMessage() {
            List<String> messageList = this._builder.getMessageList();
            t.h(messageList, "_builder.getMessageList()");
            return new DslList<>(messageList);
        }

        public final boolean hasError() {
            return this._builder.hasError();
        }

        public final boolean hasIsError() {
            return this._builder.hasIsError();
        }

        public final /* synthetic */ void plusAssignAllMessage(DslList<String, MessageProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllMessage(dslList, values);
        }

        public final /* synthetic */ void plusAssignMessage(DslList<String, MessageProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addMessage(dslList, value);
        }

        public final void setError(@NotNull BidRequestEventOuterClass.GatewayError value) {
            t.i(value, "value");
            this._builder.setError(value);
        }

        public final void setIsError(boolean z10) {
            this._builder.setIsError(z10);
        }

        public final /* synthetic */ void setMessage(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setMessage(i10, value);
        }

        private Dsl(BidRequestEventOuterClass.GatewayStatus.Builder builder) {
            this._builder = builder;
        }
    }

    private GatewayStatusKt() {
    }
}
