package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdDataRefreshResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdDataRefreshResponseKt {

    @NotNull
    public static final AdDataRefreshResponseKt INSTANCE = new AdDataRefreshResponseKt();

    /* JADX INFO: compiled from: AdDataRefreshResponseKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder _builder;

        /* JADX INFO: compiled from: AdDataRefreshResponseKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ AdDataRefreshResponseOuterClass.AdDataRefreshResponse _build() {
            AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponseBuild = this._builder.build();
            t.h(adDataRefreshResponseBuild, "_builder.build()");
            return adDataRefreshResponseBuild;
        }

        public final void clearAdData() {
            this._builder.clearAdData();
        }

        public final void clearAdDataRefreshToken() {
            this._builder.clearAdDataRefreshToken();
        }

        public final void clearAdDataVersion() {
            this._builder.clearAdDataVersion();
        }

        public final void clearError() {
            this._builder.clearError();
        }

        public final void clearTrackingToken() {
            this._builder.clearTrackingToken();
        }

        @NotNull
        public final ByteString getAdData() {
            ByteString adData = this._builder.getAdData();
            t.h(adData, "_builder.getAdData()");
            return adData;
        }

        @NotNull
        public final ByteString getAdDataRefreshToken() {
            ByteString adDataRefreshToken = this._builder.getAdDataRefreshToken();
            t.h(adDataRefreshToken, "_builder.getAdDataRefreshToken()");
            return adDataRefreshToken;
        }

        public final int getAdDataVersion() {
            return this._builder.getAdDataVersion();
        }

        @NotNull
        public final ErrorOuterClass.Error getError() {
            ErrorOuterClass.Error error = this._builder.getError();
            t.h(error, "_builder.getError()");
            return error;
        }

        @Nullable
        public final ErrorOuterClass.Error getErrorOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return AdDataRefreshResponseKtKt.getErrorOrNull(dsl._builder);
        }

        @NotNull
        public final ByteString getTrackingToken() {
            ByteString trackingToken = this._builder.getTrackingToken();
            t.h(trackingToken, "_builder.getTrackingToken()");
            return trackingToken;
        }

        public final boolean hasError() {
            return this._builder.hasError();
        }

        public final void setAdData(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setAdData(value);
        }

        public final void setAdDataRefreshToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setAdDataRefreshToken(value);
        }

        public final void setAdDataVersion(int i10) {
            this._builder.setAdDataVersion(i10);
        }

        public final void setError(@NotNull ErrorOuterClass.Error value) {
            t.i(value, "value");
            this._builder.setError(value);
        }

        public final void setTrackingToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setTrackingToken(value);
        }

        private Dsl(AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builder) {
            this._builder = builder;
        }
    }

    private AdDataRefreshResponseKt() {
    }
}
