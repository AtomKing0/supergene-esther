package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidSendDiagnosticEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidSendDiagnosticEvent implements SendDiagnosticEvent {

    @NotNull
    private final DiagnosticEventRepository diagnosticEventRepository;

    @NotNull
    private final GetDiagnosticEventRequest getDiagnosticEventRequest;

    public AndroidSendDiagnosticEvent(@NotNull DiagnosticEventRepository diagnosticEventRepository, @NotNull GetDiagnosticEventRequest getDiagnosticEventRequest) {
        t.i(diagnosticEventRepository, "diagnosticEventRepository");
        t.i(getDiagnosticEventRequest, "getDiagnosticEventRequest");
        this.diagnosticEventRepository = diagnosticEventRepository;
        this.getDiagnosticEventRequest = getDiagnosticEventRequest;
    }

    @Override // com.unity3d.ads.core.domain.SendDiagnosticEvent
    public void invoke(@NotNull String event, @Nullable Double d10, @Nullable Map<String, String> map, @Nullable Map<String, Integer> map2, @Nullable AdObject adObject) {
        ByteString opportunityId;
        String placementId;
        DiagnosticEventRequestOuterClass.DiagnosticAdType adType;
        Boolean boolIsHeaderBidding;
        t.i(event, "event");
        boolean zBooleanValue = (adObject == null || (boolIsHeaderBidding = adObject.isHeaderBidding()) == null) ? false : boolIsHeaderBidding.booleanValue();
        if (adObject == null || (opportunityId = adObject.getOpportunityId()) == null) {
            opportunityId = ByteString.EMPTY;
        }
        ByteString opportunityId2 = opportunityId;
        if (adObject == null || (placementId = adObject.getPlacementId()) == null) {
            placementId = "";
        }
        String str = placementId;
        if (adObject == null || (adType = adObject.getAdType()) == null) {
            adType = DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_UNSPECIFIED;
        }
        GetDiagnosticEventRequest getDiagnosticEventRequest = this.getDiagnosticEventRequest;
        t.h(opportunityId2, "opportunityId");
        this.diagnosticEventRepository.addDiagnosticEvent(getDiagnosticEventRequest.invoke(event, map, map2, d10, zBooleanValue, opportunityId2, str, adType));
    }
}
