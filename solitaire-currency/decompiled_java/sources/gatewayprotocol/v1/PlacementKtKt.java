package gatewayprotocol.v1;

import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.PlacementKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PlacementKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PlacementKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeplacement, reason: not valid java name */
    public static final InitializationResponseOuterClass.Placement m4186initializeplacement(@NotNull l<? super PlacementKt.Dsl, k0> block) {
        t.i(block, "block");
        PlacementKt.Dsl.Companion companion = PlacementKt.Dsl.Companion;
        InitializationResponseOuterClass.Placement.Builder builderNewBuilder = InitializationResponseOuterClass.Placement.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        PlacementKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final InitializationResponseOuterClass.Placement copy(@NotNull InitializationResponseOuterClass.Placement placement, @NotNull l<? super PlacementKt.Dsl, k0> block) {
        t.i(placement, "<this>");
        t.i(block, "block");
        PlacementKt.Dsl.Companion companion = PlacementKt.Dsl.Companion;
        InitializationResponseOuterClass.Placement.Builder builder = placement.toBuilder();
        t.h(builder, "this.toBuilder()");
        PlacementKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
