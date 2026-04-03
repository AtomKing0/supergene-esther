package com.unity3d.services.ads.measurements;

import android.annotation.SuppressLint;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MeasurementsReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"NewApi", "MissingPermission"})
public final class MeasurementsReceiver implements OutcomeReceiver<Object, Exception> {

    @NotNull
    private final MeasurementsEvents errorEvent;

    @NotNull
    private final IEventSender eventSender;

    @NotNull
    private final MeasurementsEvents successEvent;

    public MeasurementsReceiver(@NotNull IEventSender eventSender, @NotNull MeasurementsEvents successEvent, @NotNull MeasurementsEvents errorEvent) {
        t.i(eventSender, "eventSender");
        t.i(successEvent, "successEvent");
        t.i(errorEvent, "errorEvent");
        this.eventSender = eventSender;
        this.successEvent = successEvent;
        this.errorEvent = errorEvent;
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(@NotNull Object p02) {
        t.i(p02, "p0");
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, this.successEvent, new Object[0]);
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@NotNull Exception error) {
        t.i(error, "error");
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, this.errorEvent, error.toString());
    }
}
