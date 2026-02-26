package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import r9.a;
import s9.c0;
import s9.e0;
import s9.j;
import s9.x;

/* JADX INFO: compiled from: OperativeEventRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OperativeEventRepository {

    @NotNull
    private final x<OperativeEventRequestOuterClass.OperativeEventRequest> _operativeEvents;

    @NotNull
    private final c0<OperativeEventRequestOuterClass.OperativeEventRequest> operativeEvents;

    public OperativeEventRepository() {
        x<OperativeEventRequestOuterClass.OperativeEventRequest> xVarA = e0.a(10, 10, a.DROP_OLDEST);
        this._operativeEvents = xVarA;
        this.operativeEvents = j.b(xVarA);
    }

    public final void addOperativeEvent(@NotNull OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest) {
        t.i(operativeEventRequest, "operativeEventRequest");
        this._operativeEvents.a(operativeEventRequest);
    }

    @NotNull
    public final c0<OperativeEventRequestOuterClass.OperativeEventRequest> getOperativeEvents() {
        return this.operativeEvents;
    }
}
