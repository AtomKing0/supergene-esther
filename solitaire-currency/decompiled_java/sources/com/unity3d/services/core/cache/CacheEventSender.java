package com.unity3d.services.core.cache;

import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CacheEventSender.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CacheEventSender implements Serializable {

    @NotNull
    private final IEventSender eventSender;

    public CacheEventSender(@NotNull IEventSender eventSender) {
        t.i(eventSender, "eventSender");
        this.eventSender = eventSender;
    }

    public final boolean sendEvent(@NotNull CacheEvent eventId, @NotNull Object... params) {
        t.i(eventId, "eventId");
        t.i(params, "params");
        return this.eventSender.sendEvent(WebViewEventCategory.CACHE, eventId, Arrays.copyOf(params, params.length));
    }
}
