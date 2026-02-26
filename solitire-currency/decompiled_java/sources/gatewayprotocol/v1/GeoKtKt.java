package gatewayprotocol.v1;

import gatewayprotocol.v1.BidRequestEventOuterClass;
import gatewayprotocol.v1.GeoKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: GeoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GeoKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializegeo, reason: not valid java name */
    public static final BidRequestEventOuterClass.Geo m4170initializegeo(@NotNull l<? super GeoKt.Dsl, k0> block) {
        t.i(block, "block");
        GeoKt.Dsl.Companion companion = GeoKt.Dsl.Companion;
        BidRequestEventOuterClass.Geo.Builder builderNewBuilder = BidRequestEventOuterClass.Geo.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        GeoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.Geo copy(@NotNull BidRequestEventOuterClass.Geo geo, @NotNull l<? super GeoKt.Dsl, k0> block) {
        t.i(geo, "<this>");
        t.i(block, "block");
        GeoKt.Dsl.Companion companion = GeoKt.Dsl.Companion;
        BidRequestEventOuterClass.Geo.Builder builder = geo.toBuilder();
        t.h(builder, "this.toBuilder()");
        GeoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
