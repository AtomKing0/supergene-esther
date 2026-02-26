package gatewayprotocol.v1;

import gatewayprotocol.v1.OperativeEventErrorDataKt;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OperativeEventErrorDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OperativeEventErrorDataKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeoperativeEventErrorData, reason: not valid java name */
    public static final OperativeEventRequestOuterClass.OperativeEventErrorData m4183initializeoperativeEventErrorData(@NotNull l<? super OperativeEventErrorDataKt.Dsl, k0> block) {
        t.i(block, "block");
        OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builderNewBuilder = OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        OperativeEventErrorDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final OperativeEventRequestOuterClass.OperativeEventErrorData copy(@NotNull OperativeEventRequestOuterClass.OperativeEventErrorData operativeEventErrorData, @NotNull l<? super OperativeEventErrorDataKt.Dsl, k0> block) {
        t.i(operativeEventErrorData, "<this>");
        t.i(block, "block");
        OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builder = operativeEventErrorData.toBuilder();
        t.h(builder, "this.toBuilder()");
        OperativeEventErrorDataKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
