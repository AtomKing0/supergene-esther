package gatewayprotocol.v1;

import gatewayprotocol.v1.AllowedPiiKt;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AllowedPiiKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AllowedPiiKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeallowedPii, reason: not valid java name */
    public static final AllowedPiiOuterClass.AllowedPii m4150initializeallowedPii(@NotNull l<? super AllowedPiiKt.Dsl, k0> block) {
        t.i(block, "block");
        AllowedPiiKt.Dsl.Companion companion = AllowedPiiKt.Dsl.Companion;
        AllowedPiiOuterClass.AllowedPii.Builder builderNewBuilder = AllowedPiiOuterClass.AllowedPii.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AllowedPiiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final AllowedPiiOuterClass.AllowedPii copy(@NotNull AllowedPiiOuterClass.AllowedPii allowedPii, @NotNull l<? super AllowedPiiKt.Dsl, k0> block) {
        t.i(allowedPii, "<this>");
        t.i(block, "block");
        AllowedPiiKt.Dsl.Companion companion = AllowedPiiKt.Dsl.Companion;
        AllowedPiiOuterClass.AllowedPii.Builder builder = allowedPii.toBuilder();
        t.h(builder, "this.toBuilder()");
        AllowedPiiKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
