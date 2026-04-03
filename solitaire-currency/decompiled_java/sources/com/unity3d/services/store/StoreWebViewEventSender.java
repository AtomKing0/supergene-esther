package com.unity3d.services.store;

import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StoreWebViewEventSender.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StoreWebViewEventSender {

    @NotNull
    private final IEventSender eventSender;

    public StoreWebViewEventSender(@NotNull IEventSender eventSender) {
        t.i(eventSender, "eventSender");
        this.eventSender = eventSender;
    }

    public final void send(@NotNull StoreEvent event, @NotNull Object... params) {
        t.i(event, "event");
        t.i(params, "params");
        this.eventSender.sendEvent(WebViewEventCategory.STORE, event, Arrays.copyOf(params, params.length));
    }
}
