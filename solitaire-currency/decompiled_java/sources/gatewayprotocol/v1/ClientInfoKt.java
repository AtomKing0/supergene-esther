package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.ClientInfoOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ClientInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClientInfoKt {

    @NotNull
    public static final ClientInfoKt INSTANCE = new ClientInfoKt();

    /* JADX INFO: compiled from: ClientInfoKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final ClientInfoOuterClass.ClientInfo.Builder _builder;

        /* JADX INFO: compiled from: ClientInfoKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(ClientInfoOuterClass.ClientInfo.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(ClientInfoOuterClass.ClientInfo.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ ClientInfoOuterClass.ClientInfo _build() {
            ClientInfoOuterClass.ClientInfo clientInfoBuild = this._builder.build();
            t.h(clientInfoBuild, "_builder.build()");
            return clientInfoBuild;
        }

        public final void clearCustomMediationName() {
            this._builder.clearCustomMediationName();
        }

        public final void clearGameId() {
            this._builder.clearGameId();
        }

        public final void clearMediationProvider() {
            this._builder.clearMediationProvider();
        }

        public final void clearMediationVersion() {
            this._builder.clearMediationVersion();
        }

        public final void clearOmidPartnerVersion() {
            this._builder.clearOmidPartnerVersion();
        }

        public final void clearOmidVersion() {
            this._builder.clearOmidVersion();
        }

        public final void clearPlatform() {
            this._builder.clearPlatform();
        }

        public final void clearScarVersionName() {
            this._builder.clearScarVersionName();
        }

        public final void clearSdkDevelopmentPlatform() {
            this._builder.clearSdkDevelopmentPlatform();
        }

        public final void clearSdkVersion() {
            this._builder.clearSdkVersion();
        }

        public final void clearSdkVersionName() {
            this._builder.clearSdkVersionName();
        }

        public final void clearTest() {
            this._builder.clearTest();
        }

        @NotNull
        public final String getCustomMediationName() {
            String customMediationName = this._builder.getCustomMediationName();
            t.h(customMediationName, "_builder.getCustomMediationName()");
            return customMediationName;
        }

        @NotNull
        public final String getGameId() {
            String gameId = this._builder.getGameId();
            t.h(gameId, "_builder.getGameId()");
            return gameId;
        }

        @NotNull
        public final ClientInfoOuterClass.MediationProvider getMediationProvider() {
            ClientInfoOuterClass.MediationProvider mediationProvider = this._builder.getMediationProvider();
            t.h(mediationProvider, "_builder.getMediationProvider()");
            return mediationProvider;
        }

        @NotNull
        public final String getMediationVersion() {
            String mediationVersion = this._builder.getMediationVersion();
            t.h(mediationVersion, "_builder.getMediationVersion()");
            return mediationVersion;
        }

        @NotNull
        public final String getOmidPartnerVersion() {
            String omidPartnerVersion = this._builder.getOmidPartnerVersion();
            t.h(omidPartnerVersion, "_builder.getOmidPartnerVersion()");
            return omidPartnerVersion;
        }

        @NotNull
        public final String getOmidVersion() {
            String omidVersion = this._builder.getOmidVersion();
            t.h(omidVersion, "_builder.getOmidVersion()");
            return omidVersion;
        }

        @NotNull
        public final ClientInfoOuterClass.Platform getPlatform() {
            ClientInfoOuterClass.Platform platform = this._builder.getPlatform();
            t.h(platform, "_builder.getPlatform()");
            return platform;
        }

        @NotNull
        public final String getScarVersionName() {
            String scarVersionName = this._builder.getScarVersionName();
            t.h(scarVersionName, "_builder.getScarVersionName()");
            return scarVersionName;
        }

        @NotNull
        public final String getSdkDevelopmentPlatform() {
            String sdkDevelopmentPlatform = this._builder.getSdkDevelopmentPlatform();
            t.h(sdkDevelopmentPlatform, "_builder.getSdkDevelopmentPlatform()");
            return sdkDevelopmentPlatform;
        }

        public final int getSdkVersion() {
            return this._builder.getSdkVersion();
        }

        @NotNull
        public final String getSdkVersionName() {
            String sdkVersionName = this._builder.getSdkVersionName();
            t.h(sdkVersionName, "_builder.getSdkVersionName()");
            return sdkVersionName;
        }

        public final boolean getTest() {
            return this._builder.getTest();
        }

        public final boolean hasCustomMediationName() {
            return this._builder.hasCustomMediationName();
        }

        public final boolean hasMediationVersion() {
            return this._builder.hasMediationVersion();
        }

        public final boolean hasOmidPartnerVersion() {
            return this._builder.hasOmidPartnerVersion();
        }

        public final boolean hasOmidVersion() {
            return this._builder.hasOmidVersion();
        }

        public final boolean hasScarVersionName() {
            return this._builder.hasScarVersionName();
        }

        public final boolean hasSdkDevelopmentPlatform() {
            return this._builder.hasSdkDevelopmentPlatform();
        }

        public final void setCustomMediationName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCustomMediationName(value);
        }

        public final void setGameId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setGameId(value);
        }

        public final void setMediationProvider(@NotNull ClientInfoOuterClass.MediationProvider value) {
            t.i(value, "value");
            this._builder.setMediationProvider(value);
        }

        public final void setMediationVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setMediationVersion(value);
        }

        public final void setOmidPartnerVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setOmidPartnerVersion(value);
        }

        public final void setOmidVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setOmidVersion(value);
        }

        public final void setPlatform(@NotNull ClientInfoOuterClass.Platform value) {
            t.i(value, "value");
            this._builder.setPlatform(value);
        }

        public final void setScarVersionName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setScarVersionName(value);
        }

        public final void setSdkDevelopmentPlatform(@NotNull String value) {
            t.i(value, "value");
            this._builder.setSdkDevelopmentPlatform(value);
        }

        public final void setSdkVersion(int i10) {
            this._builder.setSdkVersion(i10);
        }

        public final void setSdkVersionName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setSdkVersionName(value);
        }

        public final void setTest(boolean z10) {
            this._builder.setTest(z10);
        }

        private Dsl(ClientInfoOuterClass.ClientInfo.Builder builder) {
            this._builder = builder;
        }
    }

    private ClientInfoKt() {
    }
}
