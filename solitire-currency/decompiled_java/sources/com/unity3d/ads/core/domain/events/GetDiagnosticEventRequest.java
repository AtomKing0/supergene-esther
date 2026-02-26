package com.unity3d.ads.core.domain.events;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import gatewayprotocol.v1.DiagnosticEventKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetDiagnosticEventRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetDiagnosticEventRequest {

    @NotNull
    private final GetSharedDataTimestamps getSharedDataTimestamps;

    public GetDiagnosticEventRequest(@NotNull GetSharedDataTimestamps getSharedDataTimestamps) {
        t.i(getSharedDataTimestamps, "getSharedDataTimestamps");
        this.getSharedDataTimestamps = getSharedDataTimestamps;
    }

    @NotNull
    public final DiagnosticEventRequestOuterClass.DiagnosticEvent invoke(@NotNull String eventName, @Nullable Map<String, String> map, @Nullable Map<String, Integer> map2, @Nullable Double d10, boolean z10, @NotNull ByteString opportunityId, @NotNull String placement, @NotNull DiagnosticEventRequestOuterClass.DiagnosticAdType adType) {
        t.i(eventName, "eventName");
        t.i(opportunityId, "opportunityId");
        t.i(placement, "placement");
        t.i(adType, "adType");
        DiagnosticEventKt.Dsl.Companion companion = DiagnosticEventKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builderNewBuilder = DiagnosticEventRequestOuterClass.DiagnosticEvent.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DiagnosticEventKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setEventType(DiagnosticEventRequestOuterClass.DiagnosticEventType.DIAGNOSTIC_EVENT_TYPE_CUSTOM);
        dsl_create.setTimestamps(this.getSharedDataTimestamps.invoke());
        dsl_create.setCustomEventType(eventName);
        if (map != null) {
            dsl_create.putAllStringTags(dsl_create.getStringTagsMap(), map);
        }
        if (map2 != null) {
            dsl_create.putAllIntTags(dsl_create.getIntTagsMap(), map2);
        }
        if (d10 != null) {
            dsl_create.setTimeValue(d10.doubleValue());
        }
        dsl_create.setIsHeaderBidding(z10);
        dsl_create.setImpressionOpportunityId(opportunityId);
        dsl_create.setPlacementId(placement);
        dsl_create.setAdType(adType);
        return dsl_create._build();
    }
}
