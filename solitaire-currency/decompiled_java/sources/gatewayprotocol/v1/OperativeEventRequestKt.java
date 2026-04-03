package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.CampaignStateOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OperativeEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OperativeEventRequestKt {

    @NotNull
    public static final OperativeEventRequestKt INSTANCE = new OperativeEventRequestKt();

    /* JADX INFO: compiled from: OperativeEventRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final OperativeEventRequestOuterClass.OperativeEventRequest.Builder _builder;

        /* JADX INFO: compiled from: OperativeEventRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ OperativeEventRequestOuterClass.OperativeEventRequest _build() {
            OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequestBuild = this._builder.build();
            t.h(operativeEventRequestBuild, "_builder.build()");
            return operativeEventRequestBuild;
        }

        public final void clearAdditionalData() {
            this._builder.clearAdditionalData();
        }

        public final void clearCampaignState() {
            this._builder.clearCampaignState();
        }

        public final void clearDynamicDeviceInfo() {
            this._builder.clearDynamicDeviceInfo();
        }

        public final void clearEventId() {
            this._builder.clearEventId();
        }

        public final void clearEventType() {
            this._builder.clearEventType();
        }

        public final void clearImpressionOpportunityId() {
            this._builder.clearImpressionOpportunityId();
        }

        public final void clearSessionCounters() {
            this._builder.clearSessionCounters();
        }

        public final void clearSid() {
            this._builder.clearSid();
        }

        public final void clearStaticDeviceInfo() {
            this._builder.clearStaticDeviceInfo();
        }

        public final void clearTrackingToken() {
            this._builder.clearTrackingToken();
        }

        @NotNull
        public final ByteString getAdditionalData() {
            ByteString additionalData = this._builder.getAdditionalData();
            t.h(additionalData, "_builder.getAdditionalData()");
            return additionalData;
        }

        @NotNull
        public final CampaignStateOuterClass.CampaignState getCampaignState() {
            CampaignStateOuterClass.CampaignState campaignState = this._builder.getCampaignState();
            t.h(campaignState, "_builder.getCampaignState()");
            return campaignState;
        }

        @NotNull
        public final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
            DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = this._builder.getDynamicDeviceInfo();
            t.h(dynamicDeviceInfo, "_builder.getDynamicDeviceInfo()");
            return dynamicDeviceInfo;
        }

        @NotNull
        public final ByteString getEventId() {
            ByteString eventId = this._builder.getEventId();
            t.h(eventId, "_builder.getEventId()");
            return eventId;
        }

        @NotNull
        public final OperativeEventRequestOuterClass.OperativeEventType getEventType() {
            OperativeEventRequestOuterClass.OperativeEventType eventType = this._builder.getEventType();
            t.h(eventType, "_builder.getEventType()");
            return eventType;
        }

        @NotNull
        public final ByteString getImpressionOpportunityId() {
            ByteString impressionOpportunityId = this._builder.getImpressionOpportunityId();
            t.h(impressionOpportunityId, "_builder.getImpressionOpportunityId()");
            return impressionOpportunityId;
        }

        @NotNull
        public final SessionCountersOuterClass.SessionCounters getSessionCounters() {
            SessionCountersOuterClass.SessionCounters sessionCounters = this._builder.getSessionCounters();
            t.h(sessionCounters, "_builder.getSessionCounters()");
            return sessionCounters;
        }

        @NotNull
        public final String getSid() {
            String sid = this._builder.getSid();
            t.h(sid, "_builder.getSid()");
            return sid;
        }

        @NotNull
        public final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = this._builder.getStaticDeviceInfo();
            t.h(staticDeviceInfo, "_builder.getStaticDeviceInfo()");
            return staticDeviceInfo;
        }

        @NotNull
        public final ByteString getTrackingToken() {
            ByteString trackingToken = this._builder.getTrackingToken();
            t.h(trackingToken, "_builder.getTrackingToken()");
            return trackingToken;
        }

        public final boolean hasCampaignState() {
            return this._builder.hasCampaignState();
        }

        public final boolean hasDynamicDeviceInfo() {
            return this._builder.hasDynamicDeviceInfo();
        }

        public final boolean hasSessionCounters() {
            return this._builder.hasSessionCounters();
        }

        public final boolean hasStaticDeviceInfo() {
            return this._builder.hasStaticDeviceInfo();
        }

        public final void setAdditionalData(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setAdditionalData(value);
        }

        public final void setCampaignState(@NotNull CampaignStateOuterClass.CampaignState value) {
            t.i(value, "value");
            this._builder.setCampaignState(value);
        }

        public final void setDynamicDeviceInfo(@NotNull DynamicDeviceInfoOuterClass.DynamicDeviceInfo value) {
            t.i(value, "value");
            this._builder.setDynamicDeviceInfo(value);
        }

        public final void setEventId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setEventId(value);
        }

        public final void setEventType(@NotNull OperativeEventRequestOuterClass.OperativeEventType value) {
            t.i(value, "value");
            this._builder.setEventType(value);
        }

        public final void setImpressionOpportunityId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setImpressionOpportunityId(value);
        }

        public final void setSessionCounters(@NotNull SessionCountersOuterClass.SessionCounters value) {
            t.i(value, "value");
            this._builder.setSessionCounters(value);
        }

        public final void setSid(@NotNull String value) {
            t.i(value, "value");
            this._builder.setSid(value);
        }

        public final void setStaticDeviceInfo(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo value) {
            t.i(value, "value");
            this._builder.setStaticDeviceInfo(value);
        }

        public final void setTrackingToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setTrackingToken(value);
        }

        private Dsl(OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private OperativeEventRequestKt() {
    }
}
