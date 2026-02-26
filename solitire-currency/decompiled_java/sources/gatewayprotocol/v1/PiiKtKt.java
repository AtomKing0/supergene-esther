package gatewayprotocol.v1;

import gatewayprotocol.v1.PiiKt;
import gatewayprotocol.v1.PiiOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PiiKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PiiKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializepii, reason: not valid java name */
    public static final PiiOuterClass.Pii m4185initializepii(@NotNull l<? super PiiKt.Dsl, k0> block) {
        t.i(block, "block");
        PiiKt.Dsl.Companion companion = PiiKt.Dsl.Companion;
        PiiOuterClass.Pii.Builder builderNewBuilder = PiiOuterClass.Pii.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        PiiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final PiiOuterClass.Pii copy(@NotNull PiiOuterClass.Pii pii, @NotNull l<? super PiiKt.Dsl, k0> block) {
        t.i(pii, "<this>");
        t.i(block, "block");
        PiiKt.Dsl.Companion companion = PiiKt.Dsl.Companion;
        PiiOuterClass.Pii.Builder builder = pii.toBuilder();
        t.h(builder, "this.toBuilder()");
        PiiKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
