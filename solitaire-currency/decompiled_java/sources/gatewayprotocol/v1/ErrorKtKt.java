package gatewayprotocol.v1;

import gatewayprotocol.v1.ErrorKt;
import gatewayprotocol.v1.ErrorOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ErrorKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeerror, reason: not valid java name */
    public static final ErrorOuterClass.Error m4167initializeerror(@NotNull l<? super ErrorKt.Dsl, k0> block) {
        t.i(block, "block");
        ErrorKt.Dsl.Companion companion = ErrorKt.Dsl.Companion;
        ErrorOuterClass.Error.Builder builderNewBuilder = ErrorOuterClass.Error.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        ErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final ErrorOuterClass.Error copy(@NotNull ErrorOuterClass.Error error, @NotNull l<? super ErrorKt.Dsl, k0> block) {
        t.i(error, "<this>");
        t.i(block, "block");
        ErrorKt.Dsl.Companion companion = ErrorKt.Dsl.Companion;
        ErrorOuterClass.Error.Builder builder = error.toBuilder();
        t.h(builder, "this.toBuilder()");
        ErrorKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
