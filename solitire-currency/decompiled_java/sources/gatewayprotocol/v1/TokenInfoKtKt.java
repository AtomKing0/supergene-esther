package gatewayprotocol.v1;

import gatewayprotocol.v1.BidRequestEventOuterClass;
import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;
import gatewayprotocol.v1.TokenInfoKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TokenInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TokenInfoKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializetokenInfo, reason: not valid java name */
    public static final BidRequestEventOuterClass.TokenInfo m4199initializetokenInfo(@NotNull l<? super TokenInfoKt.Dsl, k0> block) {
        t.i(block, "block");
        TokenInfoKt.Dsl.Companion companion = TokenInfoKt.Dsl.Companion;
        BidRequestEventOuterClass.TokenInfo.Builder builderNewBuilder = BidRequestEventOuterClass.TokenInfo.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        TokenInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.TokenInfo copy(@NotNull BidRequestEventOuterClass.TokenInfo tokenInfo, @NotNull l<? super TokenInfoKt.Dsl, k0> block) {
        t.i(tokenInfo, "<this>");
        t.i(block, "block");
        TokenInfoKt.Dsl.Companion companion = TokenInfoKt.Dsl.Companion;
        BidRequestEventOuterClass.TokenInfo.Builder builder = tokenInfo.toBuilder();
        t.h(builder, "this.toBuilder()");
        TokenInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final HeaderBiddingTokenOuterClass.HeaderBiddingToken getHeaderBiddingTokenOrNull(@NotNull BidRequestEventOuterClass.TokenInfoOrBuilder tokenInfoOrBuilder) {
        t.i(tokenInfoOrBuilder, "<this>");
        if (tokenInfoOrBuilder.hasHeaderBiddingToken()) {
            return tokenInfoOrBuilder.getHeaderBiddingToken();
        }
        return null;
    }
}
