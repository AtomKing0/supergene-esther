package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TokenInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TokenInfoKt {

    @NotNull
    public static final TokenInfoKt INSTANCE = new TokenInfoKt();

    /* JADX INFO: compiled from: TokenInfoKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.TokenInfo.Builder _builder;

        /* JADX INFO: compiled from: TokenInfoKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.TokenInfo.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.TokenInfo.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.TokenInfo _build() {
            BidRequestEventOuterClass.TokenInfo tokenInfoBuild = this._builder.build();
            t.h(tokenInfoBuild, "_builder.build()");
            return tokenInfoBuild;
        }

        public final void clearHeaderBiddingToken() {
            this._builder.clearHeaderBiddingToken();
        }

        public final void clearIsBoldSdk() {
            this._builder.clearIsBoldSdk();
        }

        public final void clearTokenType() {
            this._builder.clearTokenType();
        }

        @NotNull
        public final HeaderBiddingTokenOuterClass.HeaderBiddingToken getHeaderBiddingToken() {
            HeaderBiddingTokenOuterClass.HeaderBiddingToken headerBiddingToken = this._builder.getHeaderBiddingToken();
            t.h(headerBiddingToken, "_builder.getHeaderBiddingToken()");
            return headerBiddingToken;
        }

        @Nullable
        public final HeaderBiddingTokenOuterClass.HeaderBiddingToken getHeaderBiddingTokenOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return TokenInfoKtKt.getHeaderBiddingTokenOrNull(dsl._builder);
        }

        public final boolean getIsBoldSdk() {
            return this._builder.getIsBoldSdk();
        }

        @NotNull
        public final BidRequestEventOuterClass.TokenType getTokenType() {
            BidRequestEventOuterClass.TokenType tokenType = this._builder.getTokenType();
            t.h(tokenType, "_builder.getTokenType()");
            return tokenType;
        }

        public final boolean hasHeaderBiddingToken() {
            return this._builder.hasHeaderBiddingToken();
        }

        public final boolean hasIsBoldSdk() {
            return this._builder.hasIsBoldSdk();
        }

        public final boolean hasTokenType() {
            return this._builder.hasTokenType();
        }

        public final void setHeaderBiddingToken(@NotNull HeaderBiddingTokenOuterClass.HeaderBiddingToken value) {
            t.i(value, "value");
            this._builder.setHeaderBiddingToken(value);
        }

        public final void setIsBoldSdk(boolean z10) {
            this._builder.setIsBoldSdk(z10);
        }

        public final void setTokenType(@NotNull BidRequestEventOuterClass.TokenType value) {
            t.i(value, "value");
            this._builder.setTokenType(value);
        }

        private Dsl(BidRequestEventOuterClass.TokenInfo.Builder builder) {
            this._builder = builder;
        }
    }

    private TokenInfoKt() {
    }
}
