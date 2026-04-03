package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LimitedSessionTokenKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LimitedSessionTokenKt {

    @NotNull
    public static final LimitedSessionTokenKt INSTANCE = new LimitedSessionTokenKt();

    /* JADX INFO: compiled from: LimitedSessionTokenKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final UniversalRequestOuterClass.LimitedSessionToken.Builder _builder;

        /* JADX INFO: compiled from: LimitedSessionTokenKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(UniversalRequestOuterClass.LimitedSessionToken.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(UniversalRequestOuterClass.LimitedSessionToken.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ UniversalRequestOuterClass.LimitedSessionToken _build() {
            UniversalRequestOuterClass.LimitedSessionToken limitedSessionTokenBuild = this._builder.build();
            t.h(limitedSessionTokenBuild, "_builder.build()");
            return limitedSessionTokenBuild;
        }

        public final void clearCustomMediationName() {
            this._builder.clearCustomMediationName();
        }

        public final void clearDeviceMake() {
            this._builder.clearDeviceMake();
        }

        public final void clearDeviceModel() {
            this._builder.clearDeviceModel();
        }

        public final void clearGameId() {
            this._builder.clearGameId();
        }

        public final void clearIdfi() {
            this._builder.clearIdfi();
        }

        public final void clearMediationProvider() {
            this._builder.clearMediationProvider();
        }

        public final void clearMediationVersion() {
            this._builder.clearMediationVersion();
        }

        public final void clearOsVersion() {
            this._builder.clearOsVersion();
        }

        public final void clearPlatform() {
            this._builder.clearPlatform();
        }

        public final void clearSdkVersion() {
            this._builder.clearSdkVersion();
        }

        public final void clearSdkVersionName() {
            this._builder.clearSdkVersionName();
        }

        public final void clearSessionId() {
            this._builder.clearSessionId();
        }

        @NotNull
        public final String getCustomMediationName() {
            String customMediationName = this._builder.getCustomMediationName();
            t.h(customMediationName, "_builder.getCustomMediationName()");
            return customMediationName;
        }

        @NotNull
        public final String getDeviceMake() {
            String deviceMake = this._builder.getDeviceMake();
            t.h(deviceMake, "_builder.getDeviceMake()");
            return deviceMake;
        }

        @NotNull
        public final String getDeviceModel() {
            String deviceModel = this._builder.getDeviceModel();
            t.h(deviceModel, "_builder.getDeviceModel()");
            return deviceModel;
        }

        @NotNull
        public final String getGameId() {
            String gameId = this._builder.getGameId();
            t.h(gameId, "_builder.getGameId()");
            return gameId;
        }

        @NotNull
        public final String getIdfi() {
            String idfi = this._builder.getIdfi();
            t.h(idfi, "_builder.getIdfi()");
            return idfi;
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
        public final String getOsVersion() {
            String osVersion = this._builder.getOsVersion();
            t.h(osVersion, "_builder.getOsVersion()");
            return osVersion;
        }

        @NotNull
        public final ClientInfoOuterClass.Platform getPlatform() {
            ClientInfoOuterClass.Platform platform = this._builder.getPlatform();
            t.h(platform, "_builder.getPlatform()");
            return platform;
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

        @NotNull
        public final ByteString getSessionId() {
            ByteString sessionId = this._builder.getSessionId();
            t.h(sessionId, "_builder.getSessionId()");
            return sessionId;
        }

        public final boolean hasCustomMediationName() {
            return this._builder.hasCustomMediationName();
        }

        public final boolean hasMediationVersion() {
            return this._builder.hasMediationVersion();
        }

        public final boolean hasSessionId() {
            return this._builder.hasSessionId();
        }

        public final void setCustomMediationName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCustomMediationName(value);
        }

        public final void setDeviceMake(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDeviceMake(value);
        }

        public final void setDeviceModel(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDeviceModel(value);
        }

        public final void setGameId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setGameId(value);
        }

        public final void setIdfi(@NotNull String value) {
            t.i(value, "value");
            this._builder.setIdfi(value);
        }

        public final void setMediationProvider(@NotNull ClientInfoOuterClass.MediationProvider value) {
            t.i(value, "value");
            this._builder.setMediationProvider(value);
        }

        public final void setMediationVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setMediationVersion(value);
        }

        public final void setOsVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setOsVersion(value);
        }

        public final void setPlatform(@NotNull ClientInfoOuterClass.Platform value) {
            t.i(value, "value");
            this._builder.setPlatform(value);
        }

        public final void setSdkVersion(int i10) {
            this._builder.setSdkVersion(i10);
        }

        public final void setSdkVersionName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setSdkVersionName(value);
        }

        public final void setSessionId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setSessionId(value);
        }

        private Dsl(UniversalRequestOuterClass.LimitedSessionToken.Builder builder) {
            this._builder = builder;
        }
    }

    private LimitedSessionTokenKt() {
    }
}
