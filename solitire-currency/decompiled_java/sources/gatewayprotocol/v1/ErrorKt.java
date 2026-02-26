package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.ErrorOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ErrorKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorKt {

    @NotNull
    public static final ErrorKt INSTANCE = new ErrorKt();

    /* JADX INFO: compiled from: ErrorKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final ErrorOuterClass.Error.Builder _builder;

        /* JADX INFO: compiled from: ErrorKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(ErrorOuterClass.Error.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(ErrorOuterClass.Error.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ ErrorOuterClass.Error _build() {
            ErrorOuterClass.Error errorBuild = this._builder.build();
            t.h(errorBuild, "_builder.build()");
            return errorBuild;
        }

        public final void clearErrorText() {
            this._builder.clearErrorText();
        }

        @NotNull
        public final String getErrorText() {
            String errorText = this._builder.getErrorText();
            t.h(errorText, "_builder.getErrorText()");
            return errorText;
        }

        public final void setErrorText(@NotNull String value) {
            t.i(value, "value");
            this._builder.setErrorText(value);
        }

        private Dsl(ErrorOuterClass.Error.Builder builder) {
            this._builder = builder;
        }
    }

    private ErrorKt() {
    }
}
