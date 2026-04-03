package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.utils.CoroutineTimer;
import com.unity3d.services.core.log.DeviceLog;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.a;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import o9.o;
import org.jetbrains.annotations.NotNull;
import s9.c0;
import s9.e0;
import s9.j;
import s9.o0;
import s9.x;
import s9.y;
import v8.k0;

/* JADX INFO: compiled from: AndroidDiagnosticEventRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidDiagnosticEventRepository implements DiagnosticEventRepository {

    @NotNull
    private final x<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> _diagnosticEvents;

    @NotNull
    private final Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> allowedEvents;

    @NotNull
    private final y<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> batch;

    @NotNull
    private final Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> blockedEvents;

    @NotNull
    private final y<Boolean> configured;

    @NotNull
    private final c0<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> diagnosticEvents;

    @NotNull
    private final y<Boolean> enabled;

    @NotNull
    private final CoroutineTimer flushTimer;
    private int maxBatchSize;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$configure$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDiagnosticEventRepository.kt */
    static final class AnonymousClass1 extends v implements a<k0> {
        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AndroidDiagnosticEventRepository.this.flush();
        }
    }

    public AndroidDiagnosticEventRepository(@NotNull CoroutineTimer flushTimer) {
        t.i(flushTimer, "flushTimer");
        this.flushTimer = flushTimer;
        this.batch = o0.a(new ArrayList());
        this.maxBatchSize = Integer.MAX_VALUE;
        this.allowedEvents = new LinkedHashSet();
        this.blockedEvents = new LinkedHashSet();
        Boolean bool = Boolean.FALSE;
        this.enabled = o0.a(bool);
        this.configured = o0.a(bool);
        x<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> xVarA = e0.a(10, 10, r9.a.DROP_OLDEST);
        this._diagnosticEvents = xVarA;
        this.diagnosticEvents = j.b(xVarA);
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void addDiagnosticEvent(@NotNull DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent) {
        List<DiagnosticEventRequestOuterClass.DiagnosticEvent> value;
        List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list;
        List<DiagnosticEventRequestOuterClass.DiagnosticEvent> value2;
        List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list2;
        t.i(diagnosticEvent, "diagnosticEvent");
        if (!this.configured.getValue().booleanValue()) {
            y<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> yVar = this.batch;
            do {
                value2 = yVar.getValue();
                list2 = value2;
                list2.add(diagnosticEvent);
            } while (!yVar.d(value2, list2));
            return;
        }
        if (this.enabled.getValue().booleanValue()) {
            y<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> yVar2 = this.batch;
            do {
                value = yVar2.getValue();
                list = value;
                list.add(diagnosticEvent);
            } while (!yVar2.d(value, list));
            if (this.batch.getValue().size() >= this.maxBatchSize) {
                flush();
            }
        }
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void clear() {
        y<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> yVar = this.batch;
        while (!yVar.d(yVar.getValue(), new ArrayList())) {
        }
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void configure(@NotNull NativeConfigurationOuterClass.DiagnosticEventsConfiguration diagnosticsEventsConfiguration) {
        t.i(diagnosticsEventsConfiguration, "diagnosticsEventsConfiguration");
        this.configured.setValue(Boolean.TRUE);
        this.enabled.setValue(Boolean.valueOf(diagnosticsEventsConfiguration.getEnabled()));
        if (!this.enabled.getValue().booleanValue()) {
            clear();
            return;
        }
        this.maxBatchSize = diagnosticsEventsConfiguration.getMaxBatchSize();
        Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> set = this.allowedEvents;
        List<DiagnosticEventRequestOuterClass.DiagnosticEventType> allowedEventsList = diagnosticsEventsConfiguration.getAllowedEventsList();
        t.h(allowedEventsList, "diagnosticsEventsConfiguration.allowedEventsList");
        set.addAll(allowedEventsList);
        Set<DiagnosticEventRequestOuterClass.DiagnosticEventType> set2 = this.blockedEvents;
        List<DiagnosticEventRequestOuterClass.DiagnosticEventType> blockedEventsList = diagnosticsEventsConfiguration.getBlockedEventsList();
        t.h(blockedEventsList, "diagnosticsEventsConfiguration.blockedEventsList");
        set2.addAll(blockedEventsList);
        this.flushTimer.start(0L, diagnosticsEventsConfiguration.getMaxBatchIntervalMs(), new AnonymousClass1());
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    public void flush() {
        List<DiagnosticEventRequestOuterClass.DiagnosticEvent> value;
        y<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> yVar = this.batch;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, new ArrayList()));
        List<DiagnosticEventRequestOuterClass.DiagnosticEvent> listW = o.w(o.k(o.k(d0.a0(value), new AndroidDiagnosticEventRepository$flush$events$2(this)), new AndroidDiagnosticEventRepository$flush$events$3(this)));
        if (!listW.isEmpty()) {
            DeviceLog.debug("Unity Ads Sending diagnostic batch enabled: " + this.enabled.getValue().booleanValue() + " size: " + listW.size() + " :: " + listW);
            this._diagnosticEvents.a(listW);
        }
    }

    @Override // com.unity3d.ads.core.data.repository.DiagnosticEventRepository
    @NotNull
    public c0<List<DiagnosticEventRequestOuterClass.DiagnosticEvent>> getDiagnosticEvents() {
        return this.diagnosticEvents;
    }
}
