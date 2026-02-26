package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AdPlayerConfigRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdPlayerConfigRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdPlayerConfigRequestKt {

    @NotNull
    public static final AdPlayerConfigRequestKt INSTANCE = new AdPlayerConfigRequestKt();

    /* JADX INFO: compiled from: AdPlayerConfigRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder _builder;

        /* JADX INFO: compiled from: AdPlayerConfigRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest _build() {
            AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequestBuild = this._builder.build();
            t.h(adPlayerConfigRequestBuild, "_builder.build()");
            return adPlayerConfigRequestBuild;
        }

        public final void clearConfigurationToken() {
            this._builder.clearConfigurationToken();
        }

        public final void clearImpressionOpportunityId() {
            this._builder.clearImpressionOpportunityId();
        }

        public final void clearPlacementId() {
            this._builder.clearPlacementId();
        }

        public final void clearWebviewVersion() {
            this._builder.clearWebviewVersion();
        }

        @NotNull
        public final ByteString getConfigurationToken() {
            ByteString configurationToken = this._builder.getConfigurationToken();
            t.h(configurationToken, "_builder.getConfigurationToken()");
            return configurationToken;
        }

        @NotNull
        public final ByteString getImpressionOpportunityId() {
            ByteString impressionOpportunityId = this._builder.getImpressionOpportunityId();
            t.h(impressionOpportunityId, "_builder.getImpressionOpportunityId()");
            return impressionOpportunityId;
        }

        @NotNull
        public final String getPlacementId() {
            String placementId = this._builder.getPlacementId();
            t.h(placementId, "_builder.getPlacementId()");
            return placementId;
        }

        public final int getWebviewVersion() {
            return this._builder.getWebviewVersion();
        }

        public final boolean hasWebviewVersion() {
            return this._builder.hasWebviewVersion();
        }

        public final void setConfigurationToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setConfigurationToken(value);
        }

        public final void setImpressionOpportunityId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setImpressionOpportunityId(value);
        }

        public final void setPlacementId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setPlacementId(value);
        }

        public final void setWebviewVersion(int i10) {
            this._builder.setWebviewVersion(i10);
        }

        private Dsl(AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private AdPlayerConfigRequestKt() {
    }
}
