package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AdPlayerConfigResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.WebviewConfiguration;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdPlayerConfigResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdPlayerConfigResponseKt {

    @NotNull
    public static final AdPlayerConfigResponseKt INSTANCE = new AdPlayerConfigResponseKt();

    /* JADX INFO: compiled from: AdPlayerConfigResponseKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse.Builder _builder;

        /* JADX INFO: compiled from: AdPlayerConfigResponseKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse _build() {
            AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse adPlayerConfigResponseBuild = this._builder.build();
            t.h(adPlayerConfigResponseBuild, "_builder.build()");
            return adPlayerConfigResponseBuild;
        }

        public final void clearAdDataRefreshToken() {
            this._builder.clearAdDataRefreshToken();
        }

        public final void clearError() {
            this._builder.clearError();
        }

        public final void clearImpressionConfiguration() {
            this._builder.clearImpressionConfiguration();
        }

        public final void clearImpressionConfigurationVersion() {
            this._builder.clearImpressionConfigurationVersion();
        }

        public final void clearTrackingToken() {
            this._builder.clearTrackingToken();
        }

        public final void clearWebviewConfiguration() {
            this._builder.clearWebviewConfiguration();
        }

        @NotNull
        public final ByteString getAdDataRefreshToken() {
            ByteString adDataRefreshToken = this._builder.getAdDataRefreshToken();
            t.h(adDataRefreshToken, "_builder.getAdDataRefreshToken()");
            return adDataRefreshToken;
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
            return AdPlayerConfigResponseKtKt.getErrorOrNull(dsl._builder);
        }

        @NotNull
        public final ByteString getImpressionConfiguration() {
            ByteString impressionConfiguration = this._builder.getImpressionConfiguration();
            t.h(impressionConfiguration, "_builder.getImpressionConfiguration()");
            return impressionConfiguration;
        }

        public final int getImpressionConfigurationVersion() {
            return this._builder.getImpressionConfigurationVersion();
        }

        @NotNull
        public final ByteString getTrackingToken() {
            ByteString trackingToken = this._builder.getTrackingToken();
            t.h(trackingToken, "_builder.getTrackingToken()");
            return trackingToken;
        }

        @NotNull
        public final WebviewConfiguration.WebViewConfiguration getWebviewConfiguration() {
            WebviewConfiguration.WebViewConfiguration webviewConfiguration = this._builder.getWebviewConfiguration();
            t.h(webviewConfiguration, "_builder.getWebviewConfiguration()");
            return webviewConfiguration;
        }

        @Nullable
        public final WebviewConfiguration.WebViewConfiguration getWebviewConfigurationOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return AdPlayerConfigResponseKtKt.getWebviewConfigurationOrNull(dsl._builder);
        }

        public final boolean hasError() {
            return this._builder.hasError();
        }

        public final boolean hasWebviewConfiguration() {
            return this._builder.hasWebviewConfiguration();
        }

        public final void setAdDataRefreshToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setAdDataRefreshToken(value);
        }

        public final void setError(@NotNull ErrorOuterClass.Error value) {
            t.i(value, "value");
            this._builder.setError(value);
        }

        public final void setImpressionConfiguration(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setImpressionConfiguration(value);
        }

        public final void setImpressionConfigurationVersion(int i10) {
            this._builder.setImpressionConfigurationVersion(i10);
        }

        public final void setTrackingToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setTrackingToken(value);
        }

        public final void setWebviewConfiguration(@NotNull WebviewConfiguration.WebViewConfiguration value) {
            t.i(value, "value");
            this._builder.setWebviewConfiguration(value);
        }

        private Dsl(AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse.Builder builder) {
            this._builder = builder;
        }
    }

    private AdPlayerConfigResponseKt() {
    }
}
