package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.CampaignStateOuterClass;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;
import gatewayprotocol.v1.InitializationDataOuterClass;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.TimestampsOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HeaderBiddingTokenKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HeaderBiddingTokenKt {

    @NotNull
    public static final HeaderBiddingTokenKt INSTANCE = new HeaderBiddingTokenKt();

    /* JADX INFO: compiled from: HeaderBiddingTokenKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final HeaderBiddingTokenOuterClass.HeaderBiddingToken.Builder _builder;

        /* JADX INFO: compiled from: HeaderBiddingTokenKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(HeaderBiddingTokenOuterClass.HeaderBiddingToken.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(HeaderBiddingTokenOuterClass.HeaderBiddingToken.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ HeaderBiddingTokenOuterClass.HeaderBiddingToken _build() {
            HeaderBiddingTokenOuterClass.HeaderBiddingToken headerBiddingTokenBuild = this._builder.build();
            t.h(headerBiddingTokenBuild, "_builder.build()");
            return headerBiddingTokenBuild;
        }

        public final void clearCampaignState() {
            this._builder.clearCampaignState();
        }

        public final void clearClientInfo() {
            this._builder.clearClientInfo();
        }

        public final void clearDynamicDeviceInfo() {
            this._builder.clearDynamicDeviceInfo();
        }

        public final void clearInitializationData() {
            this._builder.clearInitializationData();
        }

        public final void clearLimitedSessionToken() {
            this._builder.clearLimitedSessionToken();
        }

        public final void clearPii() {
            this._builder.clearPii();
        }

        public final void clearScarSignalsCollected() {
            this._builder.clearScarSignalsCollected();
        }

        public final void clearSessionCounters() {
            this._builder.clearSessionCounters();
        }

        public final void clearSessionToken() {
            this._builder.clearSessionToken();
        }

        public final void clearStaticDeviceInfo() {
            this._builder.clearStaticDeviceInfo();
        }

        public final void clearTcf() {
            this._builder.clearTcf();
        }

        public final void clearTimestamps() {
            this._builder.clearTimestamps();
        }

        public final void clearTokenId() {
            this._builder.clearTokenId();
        }

        public final void clearTokenNumber() {
            this._builder.clearTokenNumber();
        }

        @NotNull
        public final CampaignStateOuterClass.CampaignState getCampaignState() {
            CampaignStateOuterClass.CampaignState campaignState = this._builder.getCampaignState();
            t.h(campaignState, "_builder.getCampaignState()");
            return campaignState;
        }

        @NotNull
        public final ClientInfoOuterClass.ClientInfo getClientInfo() {
            ClientInfoOuterClass.ClientInfo clientInfo = this._builder.getClientInfo();
            t.h(clientInfo, "_builder.getClientInfo()");
            return clientInfo;
        }

        @NotNull
        public final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
            DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = this._builder.getDynamicDeviceInfo();
            t.h(dynamicDeviceInfo, "_builder.getDynamicDeviceInfo()");
            return dynamicDeviceInfo;
        }

        @NotNull
        public final InitializationDataOuterClass.InitializationData getInitializationData() {
            InitializationDataOuterClass.InitializationData initializationData = this._builder.getInitializationData();
            t.h(initializationData, "_builder.getInitializationData()");
            return initializationData;
        }

        @Nullable
        public final InitializationDataOuterClass.InitializationData getInitializationDataOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return HeaderBiddingTokenKtKt.getInitializationDataOrNull(dsl._builder);
        }

        @NotNull
        public final UniversalRequestOuterClass.LimitedSessionToken getLimitedSessionToken() {
            UniversalRequestOuterClass.LimitedSessionToken limitedSessionToken = this._builder.getLimitedSessionToken();
            t.h(limitedSessionToken, "_builder.getLimitedSessionToken()");
            return limitedSessionToken;
        }

        @Nullable
        public final UniversalRequestOuterClass.LimitedSessionToken getLimitedSessionTokenOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return HeaderBiddingTokenKtKt.getLimitedSessionTokenOrNull(dsl._builder);
        }

        @NotNull
        public final PiiOuterClass.Pii getPii() {
            PiiOuterClass.Pii pii = this._builder.getPii();
            t.h(pii, "_builder.getPii()");
            return pii;
        }

        @Nullable
        public final PiiOuterClass.Pii getPiiOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return HeaderBiddingTokenKtKt.getPiiOrNull(dsl._builder);
        }

        public final boolean getScarSignalsCollected() {
            return this._builder.getScarSignalsCollected();
        }

        @NotNull
        public final SessionCountersOuterClass.SessionCounters getSessionCounters() {
            SessionCountersOuterClass.SessionCounters sessionCounters = this._builder.getSessionCounters();
            t.h(sessionCounters, "_builder.getSessionCounters()");
            return sessionCounters;
        }

        @NotNull
        public final ByteString getSessionToken() {
            ByteString sessionToken = this._builder.getSessionToken();
            t.h(sessionToken, "_builder.getSessionToken()");
            return sessionToken;
        }

        @NotNull
        public final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = this._builder.getStaticDeviceInfo();
            t.h(staticDeviceInfo, "_builder.getStaticDeviceInfo()");
            return staticDeviceInfo;
        }

        @NotNull
        public final ByteString getTcf() {
            ByteString tcf = this._builder.getTcf();
            t.h(tcf, "_builder.getTcf()");
            return tcf;
        }

        @NotNull
        public final TimestampsOuterClass.Timestamps getTimestamps() {
            TimestampsOuterClass.Timestamps timestamps = this._builder.getTimestamps();
            t.h(timestamps, "_builder.getTimestamps()");
            return timestamps;
        }

        @NotNull
        public final ByteString getTokenId() {
            ByteString tokenId = this._builder.getTokenId();
            t.h(tokenId, "_builder.getTokenId()");
            return tokenId;
        }

        public final int getTokenNumber() {
            return this._builder.getTokenNumber();
        }

        public final boolean hasCampaignState() {
            return this._builder.hasCampaignState();
        }

        public final boolean hasClientInfo() {
            return this._builder.hasClientInfo();
        }

        public final boolean hasDynamicDeviceInfo() {
            return this._builder.hasDynamicDeviceInfo();
        }

        public final boolean hasInitializationData() {
            return this._builder.hasInitializationData();
        }

        public final boolean hasLimitedSessionToken() {
            return this._builder.hasLimitedSessionToken();
        }

        public final boolean hasPii() {
            return this._builder.hasPii();
        }

        public final boolean hasScarSignalsCollected() {
            return this._builder.hasScarSignalsCollected();
        }

        public final boolean hasSessionCounters() {
            return this._builder.hasSessionCounters();
        }

        public final boolean hasStaticDeviceInfo() {
            return this._builder.hasStaticDeviceInfo();
        }

        public final boolean hasTcf() {
            return this._builder.hasTcf();
        }

        public final boolean hasTimestamps() {
            return this._builder.hasTimestamps();
        }

        public final void setCampaignState(@NotNull CampaignStateOuterClass.CampaignState value) {
            t.i(value, "value");
            this._builder.setCampaignState(value);
        }

        public final void setClientInfo(@NotNull ClientInfoOuterClass.ClientInfo value) {
            t.i(value, "value");
            this._builder.setClientInfo(value);
        }

        public final void setDynamicDeviceInfo(@NotNull DynamicDeviceInfoOuterClass.DynamicDeviceInfo value) {
            t.i(value, "value");
            this._builder.setDynamicDeviceInfo(value);
        }

        public final void setInitializationData(@NotNull InitializationDataOuterClass.InitializationData value) {
            t.i(value, "value");
            this._builder.setInitializationData(value);
        }

        public final void setLimitedSessionToken(@NotNull UniversalRequestOuterClass.LimitedSessionToken value) {
            t.i(value, "value");
            this._builder.setLimitedSessionToken(value);
        }

        public final void setPii(@NotNull PiiOuterClass.Pii value) {
            t.i(value, "value");
            this._builder.setPii(value);
        }

        public final void setScarSignalsCollected(boolean z10) {
            this._builder.setScarSignalsCollected(z10);
        }

        public final void setSessionCounters(@NotNull SessionCountersOuterClass.SessionCounters value) {
            t.i(value, "value");
            this._builder.setSessionCounters(value);
        }

        public final void setSessionToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setSessionToken(value);
        }

        public final void setStaticDeviceInfo(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo value) {
            t.i(value, "value");
            this._builder.setStaticDeviceInfo(value);
        }

        public final void setTcf(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setTcf(value);
        }

        public final void setTimestamps(@NotNull TimestampsOuterClass.Timestamps value) {
            t.i(value, "value");
            this._builder.setTimestamps(value);
        }

        public final void setTokenId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setTokenId(value);
        }

        public final void setTokenNumber(int i10) {
            this._builder.setTokenNumber(i10);
        }

        private Dsl(HeaderBiddingTokenOuterClass.HeaderBiddingToken.Builder builder) {
            this._builder = builder;
        }
    }

    private HeaderBiddingTokenKt() {
    }
}
