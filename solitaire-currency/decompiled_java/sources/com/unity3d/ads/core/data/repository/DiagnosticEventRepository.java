package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import s9.c0;

/* JADX INFO: compiled from: DiagnosticEventRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface DiagnosticEventRepository {
    void addDiagnosticEvent(@NotNull DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent);

    void clear();

    void configure(@NotNull NativeConfigurationOuterClass.DiagnosticEventsConfiguration diagnosticEventsConfiguration);

    void flush();

    @NotNull
    c0<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> getDiagnosticEvents();
}
