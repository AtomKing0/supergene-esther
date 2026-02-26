package gatewayprotocol.v1;

import gatewayprotocol.v1.AppKt;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AppKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeapp, reason: not valid java name */
    public static final BidRequestEventOuterClass.App m4151initializeapp(@NotNull l<? super AppKt.Dsl, k0> block) {
        t.i(block, "block");
        AppKt.Dsl.Companion companion = AppKt.Dsl.Companion;
        BidRequestEventOuterClass.App.Builder builderNewBuilder = BidRequestEventOuterClass.App.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AppKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.App copy(@NotNull BidRequestEventOuterClass.App app, @NotNull l<? super AppKt.Dsl, k0> block) {
        t.i(app, "<this>");
        t.i(block, "block");
        AppKt.Dsl.Companion companion = AppKt.Dsl.Companion;
        BidRequestEventOuterClass.App.Builder builder = app.toBuilder();
        t.h(builder, "this.toBuilder()");
        AppKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
