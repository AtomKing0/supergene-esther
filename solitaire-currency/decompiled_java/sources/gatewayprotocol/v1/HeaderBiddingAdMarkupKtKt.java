package gatewayprotocol.v1;

import gatewayprotocol.v1.HeaderBiddingAdMarkupKt;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: HeaderBiddingAdMarkupKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HeaderBiddingAdMarkupKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeheaderBiddingAdMarkup, reason: not valid java name */
    public static final HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup m4172initializeheaderBiddingAdMarkup(@NotNull l<? super HeaderBiddingAdMarkupKt.Dsl, k0> block) {
        t.i(block, "block");
        HeaderBiddingAdMarkupKt.Dsl.Companion companion = HeaderBiddingAdMarkupKt.Dsl.Companion;
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.Builder builderNewBuilder = HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        HeaderBiddingAdMarkupKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup copy(@NotNull HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, @NotNull l<? super HeaderBiddingAdMarkupKt.Dsl, k0> block) {
        t.i(headerBiddingAdMarkup, "<this>");
        t.i(block, "block");
        HeaderBiddingAdMarkupKt.Dsl.Companion companion = HeaderBiddingAdMarkupKt.Dsl.Companion;
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.Builder builder = headerBiddingAdMarkup.toBuilder();
        t.h(builder, "this.toBuilder()");
        HeaderBiddingAdMarkupKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
