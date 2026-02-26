package gatewayprotocol.v1;

import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.BannerSizeKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BannerSizeKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BannerSizeKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializebannerSize, reason: not valid java name */
    public static final AdRequestOuterClass.BannerSize m4152initializebannerSize(@NotNull l<? super BannerSizeKt.Dsl, k0> block) {
        t.i(block, "block");
        BannerSizeKt.Dsl.Companion companion = BannerSizeKt.Dsl.Companion;
        AdRequestOuterClass.BannerSize.Builder builderNewBuilder = AdRequestOuterClass.BannerSize.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        BannerSizeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final AdRequestOuterClass.BannerSize copy(@NotNull AdRequestOuterClass.BannerSize bannerSize, @NotNull l<? super BannerSizeKt.Dsl, k0> block) {
        t.i(bannerSize, "<this>");
        t.i(block, "block");
        BannerSizeKt.Dsl.Companion companion = BannerSizeKt.Dsl.Companion;
        AdRequestOuterClass.BannerSize.Builder builder = bannerSize.toBuilder();
        t.h(builder, "this.toBuilder()");
        BannerSizeKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
