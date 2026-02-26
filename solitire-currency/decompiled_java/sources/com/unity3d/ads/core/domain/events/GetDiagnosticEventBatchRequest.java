package com.unity3d.ads.core.domain.events;

import gatewayprotocol.v1.DiagnosticEventRequestKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetDiagnosticEventBatchRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetDiagnosticEventBatchRequest {
    @NotNull
    public final DiagnosticEventRequestOuterClass.DiagnosticEventRequest invoke(@NotNull List<DiagnosticEventRequestOuterClass.DiagnosticEvent> diagnosticEvents) {
        t.i(diagnosticEvents, "diagnosticEvents");
        DiagnosticEventRequestKt.Dsl.Companion companion = DiagnosticEventRequestKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder builderNewBuilder = DiagnosticEventRequestOuterClass.DiagnosticEventRequest.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DiagnosticEventRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.addAllBatch(dsl_create.getBatch(), diagnosticEvents);
        return dsl_create._build();
    }
}
