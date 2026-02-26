package com.unity3d.services.ads.measurements;

import android.annotation.SuppressLint;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MeasurementsStatusReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"NewApi", "MissingPermission"})
public final class MeasurementsStatusReceiver implements OutcomeReceiver<Integer, Exception> {

    @NotNull
    private final IEventSender eventSender;

    public MeasurementsStatusReceiver(@NotNull IEventSender eventSender) {
        t.i(eventSender, "eventSender");
        this.eventSender = eventSender;
    }

    @Override // android.os.OutcomeReceiver
    public /* bridge */ /* synthetic */ void onResult(Integer num) {
        onResult(num.intValue());
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@NotNull Exception error) {
        t.i(error, "error");
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.NOT_AVAILABLE, MeasurementsErrors.ERROR_EXCEPTION, error.toString());
    }

    public void onResult(int i10) {
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.AVAILABLE, Integer.valueOf(i10));
    }
}
