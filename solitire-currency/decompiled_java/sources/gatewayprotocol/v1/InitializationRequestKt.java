package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InitializationRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationRequestKt {

    @NotNull
    public static final InitializationRequestKt INSTANCE = new InitializationRequestKt();

    /* JADX INFO: compiled from: InitializationRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final InitializationRequestOuterClass.InitializationRequest.Builder _builder;

        /* JADX INFO: compiled from: InitializationRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(InitializationRequestOuterClass.InitializationRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(InitializationRequestOuterClass.InitializationRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ InitializationRequestOuterClass.InitializationRequest _build() {
            InitializationRequestOuterClass.InitializationRequest initializationRequestBuild = this._builder.build();
            t.h(initializationRequestBuild, "_builder.build()");
            return initializationRequestBuild;
        }

        public final void clearAnalyticsUserId() {
            this._builder.clearAnalyticsUserId();
        }

        public final void clearAuid() {
            this._builder.clearAuid();
        }

        public final void clearAuidString() {
            this._builder.clearAuidString();
        }

        public final void clearCache() {
            this._builder.clearCache();
        }

        public final void clearClientInfo() {
            this._builder.clearClientInfo();
        }

        public final void clearDeviceInfo() {
            this._builder.clearDeviceInfo();
        }

        public final void clearIdfi() {
            this._builder.clearIdfi();
        }

        public final void clearIsFirstInit() {
            this._builder.clearIsFirstInit();
        }

        public final void clearLegacyFlowUserConsent() {
            this._builder.clearLegacyFlowUserConsent();
        }

        public final void clearPrivacy() {
            this._builder.clearPrivacy();
        }

        public final void clearSessionId() {
            this._builder.clearSessionId();
        }

        @NotNull
        public final String getAnalyticsUserId() {
            String analyticsUserId = this._builder.getAnalyticsUserId();
            t.h(analyticsUserId, "_builder.getAnalyticsUserId()");
            return analyticsUserId;
        }

        @NotNull
        public final ByteString getAuid() {
            ByteString auid = this._builder.getAuid();
            t.h(auid, "_builder.getAuid()");
            return auid;
        }

        @NotNull
        public final String getAuidString() {
            String auidString = this._builder.getAuidString();
            t.h(auidString, "_builder.getAuidString()");
            return auidString;
        }

        @NotNull
        public final ByteString getCache() {
            ByteString cache = this._builder.getCache();
            t.h(cache, "_builder.getCache()");
            return cache;
        }

        @NotNull
        public final ClientInfoOuterClass.ClientInfo getClientInfo() {
            ClientInfoOuterClass.ClientInfo clientInfo = this._builder.getClientInfo();
            t.h(clientInfo, "_builder.getClientInfo()");
            return clientInfo;
        }

        @NotNull
        public final InitializationRequestOuterClass.InitializationDeviceInfo getDeviceInfo() {
            InitializationRequestOuterClass.InitializationDeviceInfo deviceInfo = this._builder.getDeviceInfo();
            t.h(deviceInfo, "_builder.getDeviceInfo()");
            return deviceInfo;
        }

        @NotNull
        public final String getIdfi() {
            String idfi = this._builder.getIdfi();
            t.h(idfi, "_builder.getIdfi()");
            return idfi;
        }

        public final boolean getIsFirstInit() {
            return this._builder.getIsFirstInit();
        }

        @NotNull
        public final String getLegacyFlowUserConsent() {
            String legacyFlowUserConsent = this._builder.getLegacyFlowUserConsent();
            t.h(legacyFlowUserConsent, "_builder.getLegacyFlowUserConsent()");
            return legacyFlowUserConsent;
        }

        @NotNull
        public final ByteString getPrivacy() {
            ByteString privacy = this._builder.getPrivacy();
            t.h(privacy, "_builder.getPrivacy()");
            return privacy;
        }

        @NotNull
        public final ByteString getSessionId() {
            ByteString sessionId = this._builder.getSessionId();
            t.h(sessionId, "_builder.getSessionId()");
            return sessionId;
        }

        public final boolean hasAnalyticsUserId() {
            return this._builder.hasAnalyticsUserId();
        }

        public final boolean hasAuid() {
            return this._builder.hasAuid();
        }

        public final boolean hasAuidString() {
            return this._builder.hasAuidString();
        }

        public final boolean hasCache() {
            return this._builder.hasCache();
        }

        public final boolean hasClientInfo() {
            return this._builder.hasClientInfo();
        }

        public final boolean hasDeviceInfo() {
            return this._builder.hasDeviceInfo();
        }

        public final boolean hasLegacyFlowUserConsent() {
            return this._builder.hasLegacyFlowUserConsent();
        }

        public final boolean hasPrivacy() {
            return this._builder.hasPrivacy();
        }

        public final void setAnalyticsUserId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setAnalyticsUserId(value);
        }

        public final void setAuid(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setAuid(value);
        }

        public final void setAuidString(@NotNull String value) {
            t.i(value, "value");
            this._builder.setAuidString(value);
        }

        public final void setCache(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setCache(value);
        }

        public final void setClientInfo(@NotNull ClientInfoOuterClass.ClientInfo value) {
            t.i(value, "value");
            this._builder.setClientInfo(value);
        }

        public final void setDeviceInfo(@NotNull InitializationRequestOuterClass.InitializationDeviceInfo value) {
            t.i(value, "value");
            this._builder.setDeviceInfo(value);
        }

        public final void setIdfi(@NotNull String value) {
            t.i(value, "value");
            this._builder.setIdfi(value);
        }

        public final void setIsFirstInit(boolean z10) {
            this._builder.setIsFirstInit(z10);
        }

        public final void setLegacyFlowUserConsent(@NotNull String value) {
            t.i(value, "value");
            this._builder.setLegacyFlowUserConsent(value);
        }

        public final void setPrivacy(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setPrivacy(value);
        }

        public final void setSessionId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setSessionId(value);
        }

        private Dsl(InitializationRequestOuterClass.InitializationRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private InitializationRequestKt() {
    }
}
