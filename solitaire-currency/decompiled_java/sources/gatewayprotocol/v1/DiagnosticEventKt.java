package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.TimestampsOuterClass;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DiagnosticEventKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DiagnosticEventKt {

    @NotNull
    public static final DiagnosticEventKt INSTANCE = new DiagnosticEventKt();

    /* JADX INFO: compiled from: DiagnosticEventKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder _builder;

        /* JADX INFO: compiled from: DiagnosticEventKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: DiagnosticEventKt.kt */
        public static final class IntTagsProxy extends DslProxy {
            private IntTagsProxy() {
            }
        }

        /* JADX INFO: compiled from: DiagnosticEventKt.kt */
        public static final class StringTagsProxy extends DslProxy {
            private StringTagsProxy() {
            }
        }

        public /* synthetic */ Dsl(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ DiagnosticEventRequestOuterClass.DiagnosticEvent _build() {
            DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEventBuild = this._builder.build();
            t.h(diagnosticEventBuild, "_builder.build()");
            return diagnosticEventBuild;
        }

        public final void clearAdType() {
            this._builder.clearAdType();
        }

        public final void clearCustomEventType() {
            this._builder.clearCustomEventType();
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

        public final /* synthetic */ void clearIntTags(DslMap dslMap) {
            t.i(dslMap, "<this>");
            this._builder.clearIntTags();
        }

        public final void clearIsHeaderBidding() {
            this._builder.clearIsHeaderBidding();
        }

        public final void clearPlacementId() {
            this._builder.clearPlacementId();
        }

        public final /* synthetic */ void clearStringTags(DslMap dslMap) {
            t.i(dslMap, "<this>");
            this._builder.clearStringTags();
        }

        public final void clearTimeValue() {
            this._builder.clearTimeValue();
        }

        public final void clearTimestamps() {
            this._builder.clearTimestamps();
        }

        @NotNull
        public final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
            DiagnosticEventRequestOuterClass.DiagnosticAdType adType = this._builder.getAdType();
            t.h(adType, "_builder.getAdType()");
            return adType;
        }

        @NotNull
        public final String getCustomEventType() {
            String customEventType = this._builder.getCustomEventType();
            t.h(customEventType, "_builder.getCustomEventType()");
            return customEventType;
        }

        public final int getEventId() {
            return this._builder.getEventId();
        }

        @NotNull
        public final DiagnosticEventRequestOuterClass.DiagnosticEventType getEventType() {
            DiagnosticEventRequestOuterClass.DiagnosticEventType eventType = this._builder.getEventType();
            t.h(eventType, "_builder.getEventType()");
            return eventType;
        }

        @NotNull
        public final ByteString getImpressionOpportunityId() {
            ByteString impressionOpportunityId = this._builder.getImpressionOpportunityId();
            t.h(impressionOpportunityId, "_builder.getImpressionOpportunityId()");
            return impressionOpportunityId;
        }

        public final /* synthetic */ DslMap getIntTagsMap() {
            Map<String, Integer> intTagsMap = this._builder.getIntTagsMap();
            t.h(intTagsMap, "_builder.getIntTagsMap()");
            return new DslMap(intTagsMap);
        }

        public final boolean getIsHeaderBidding() {
            return this._builder.getIsHeaderBidding();
        }

        @NotNull
        public final String getPlacementId() {
            String placementId = this._builder.getPlacementId();
            t.h(placementId, "_builder.getPlacementId()");
            return placementId;
        }

        public final /* synthetic */ DslMap getStringTagsMap() {
            Map<String, String> stringTagsMap = this._builder.getStringTagsMap();
            t.h(stringTagsMap, "_builder.getStringTagsMap()");
            return new DslMap(stringTagsMap);
        }

        public final double getTimeValue() {
            return this._builder.getTimeValue();
        }

        @NotNull
        public final TimestampsOuterClass.Timestamps getTimestamps() {
            TimestampsOuterClass.Timestamps timestamps = this._builder.getTimestamps();
            t.h(timestamps, "_builder.getTimestamps()");
            return timestamps;
        }

        public final boolean hasAdType() {
            return this._builder.hasAdType();
        }

        public final boolean hasCustomEventType() {
            return this._builder.hasCustomEventType();
        }

        public final boolean hasImpressionOpportunityId() {
            return this._builder.hasImpressionOpportunityId();
        }

        public final boolean hasIsHeaderBidding() {
            return this._builder.hasIsHeaderBidding();
        }

        public final boolean hasPlacementId() {
            return this._builder.hasPlacementId();
        }

        public final boolean hasTimeValue() {
            return this._builder.hasTimeValue();
        }

        public final boolean hasTimestamps() {
            return this._builder.hasTimestamps();
        }

        public final /* synthetic */ void putAllIntTags(DslMap dslMap, Map map) {
            t.i(dslMap, "<this>");
            t.i(map, "map");
            this._builder.putAllIntTags(map);
        }

        public final /* synthetic */ void putAllStringTags(DslMap dslMap, Map map) {
            t.i(dslMap, "<this>");
            t.i(map, "map");
            this._builder.putAllStringTags(map);
        }

        public final void putIntTags(@NotNull DslMap<String, Integer, IntTagsProxy> dslMap, @NotNull String key, int i10) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            this._builder.putIntTags(key, i10);
        }

        public final void putStringTags(@NotNull DslMap<String, String, StringTagsProxy> dslMap, @NotNull String key, @NotNull String value) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            t.i(value, "value");
            this._builder.putStringTags(key, value);
        }

        public final /* synthetic */ void removeIntTags(DslMap dslMap, String key) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            this._builder.removeIntTags(key);
        }

        public final /* synthetic */ void removeStringTags(DslMap dslMap, String key) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            this._builder.removeStringTags(key);
        }

        public final void setAdType(@NotNull DiagnosticEventRequestOuterClass.DiagnosticAdType value) {
            t.i(value, "value");
            this._builder.setAdType(value);
        }

        public final void setCustomEventType(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCustomEventType(value);
        }

        public final void setEventId(int i10) {
            this._builder.setEventId(i10);
        }

        public final void setEventType(@NotNull DiagnosticEventRequestOuterClass.DiagnosticEventType value) {
            t.i(value, "value");
            this._builder.setEventType(value);
        }

        public final void setImpressionOpportunityId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setImpressionOpportunityId(value);
        }

        public final /* synthetic */ void setIntTags(DslMap<String, Integer, IntTagsProxy> dslMap, String key, int i10) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            putIntTags(dslMap, key, i10);
        }

        public final void setIsHeaderBidding(boolean z10) {
            this._builder.setIsHeaderBidding(z10);
        }

        public final void setPlacementId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setPlacementId(value);
        }

        public final /* synthetic */ void setStringTags(DslMap<String, String, StringTagsProxy> dslMap, String key, String value) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            t.i(value, "value");
            putStringTags(dslMap, key, value);
        }

        public final void setTimeValue(double d10) {
            this._builder.setTimeValue(d10);
        }

        public final void setTimestamps(@NotNull TimestampsOuterClass.Timestamps value) {
            t.i(value, "value");
            this._builder.setTimestamps(value);
        }

        private Dsl(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder) {
            this._builder = builder;
        }
    }

    private DiagnosticEventKt() {
    }
}
