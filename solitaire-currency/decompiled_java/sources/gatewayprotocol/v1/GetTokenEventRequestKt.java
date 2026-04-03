package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.GetTokenEventRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetTokenEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetTokenEventRequestKt {

    @NotNull
    public static final GetTokenEventRequestKt INSTANCE = new GetTokenEventRequestKt();

    /* JADX INFO: compiled from: GetTokenEventRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder _builder;

        /* JADX INFO: compiled from: GetTokenEventRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ GetTokenEventRequestOuterClass.GetTokenEventRequest _build() {
            GetTokenEventRequestOuterClass.GetTokenEventRequest getTokenEventRequestBuild = this._builder.build();
            t.h(getTokenEventRequestBuild, "_builder.build()");
            return getTokenEventRequestBuild;
        }

        public final void clearBanner() {
            this._builder.clearBanner();
        }

        public final void clearInterstitial() {
            this._builder.clearInterstitial();
        }

        public final void clearRewarded() {
            this._builder.clearRewarded();
        }

        public final void clearTokenId() {
            this._builder.clearTokenId();
        }

        @NotNull
        public final ByteString getBanner() {
            ByteString banner = this._builder.getBanner();
            t.h(banner, "_builder.getBanner()");
            return banner;
        }

        @NotNull
        public final ByteString getInterstitial() {
            ByteString interstitial = this._builder.getInterstitial();
            t.h(interstitial, "_builder.getInterstitial()");
            return interstitial;
        }

        @NotNull
        public final ByteString getRewarded() {
            ByteString rewarded = this._builder.getRewarded();
            t.h(rewarded, "_builder.getRewarded()");
            return rewarded;
        }

        @NotNull
        public final ByteString getTokenId() {
            ByteString tokenId = this._builder.getTokenId();
            t.h(tokenId, "_builder.getTokenId()");
            return tokenId;
        }

        public final boolean hasBanner() {
            return this._builder.hasBanner();
        }

        public final boolean hasInterstitial() {
            return this._builder.hasInterstitial();
        }

        public final boolean hasRewarded() {
            return this._builder.hasRewarded();
        }

        public final void setBanner(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setBanner(value);
        }

        public final void setInterstitial(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setInterstitial(value);
        }

        public final void setRewarded(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setRewarded(value);
        }

        public final void setTokenId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setTokenId(value);
        }

        private Dsl(GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private GetTokenEventRequestKt() {
    }
}
