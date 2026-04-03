package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OperativeEventErrorDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OperativeEventErrorDataKt {

    @NotNull
    public static final OperativeEventErrorDataKt INSTANCE = new OperativeEventErrorDataKt();

    /* JADX INFO: compiled from: OperativeEventErrorDataKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final OperativeEventRequestOuterClass.OperativeEventErrorData.Builder _builder;

        /* JADX INFO: compiled from: OperativeEventErrorDataKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ OperativeEventRequestOuterClass.OperativeEventErrorData _build() {
            OperativeEventRequestOuterClass.OperativeEventErrorData operativeEventErrorDataBuild = this._builder.build();
            t.h(operativeEventErrorDataBuild, "_builder.build()");
            return operativeEventErrorDataBuild;
        }

        public final void clearErrorType() {
            this._builder.clearErrorType();
        }

        public final void clearMessage() {
            this._builder.clearMessage();
        }

        @NotNull
        public final OperativeEventRequestOuterClass.OperativeEventErrorType getErrorType() {
            OperativeEventRequestOuterClass.OperativeEventErrorType errorType = this._builder.getErrorType();
            t.h(errorType, "_builder.getErrorType()");
            return errorType;
        }

        @NotNull
        public final String getMessage() {
            String message = this._builder.getMessage();
            t.h(message, "_builder.getMessage()");
            return message;
        }

        public final void setErrorType(@NotNull OperativeEventRequestOuterClass.OperativeEventErrorType value) {
            t.i(value, "value");
            this._builder.setErrorType(value);
        }

        public final void setMessage(@NotNull String value) {
            t.i(value, "value");
            this._builder.setMessage(value);
        }

        private Dsl(OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builder) {
            this._builder = builder;
        }
    }

    private OperativeEventErrorDataKt() {
    }
}
