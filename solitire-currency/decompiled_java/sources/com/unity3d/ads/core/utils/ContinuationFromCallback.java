package com.unity3d.ads.core.utils;

import com.unity3d.ads.core.data.model.exception.ExposureException;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ContinuationFromCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContinuationFromCallback extends WebViewCallback {

    @NotNull
    private final d<Object> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContinuationFromCallback(@NotNull d<Object> continuation) {
        super("", 0);
        t.i(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // com.unity3d.services.core.webview.bridge.WebViewCallback
    public void error(@Nullable Enum<?> r52, @NotNull Object... params) {
        t.i(params, "params");
        d<Object> dVar = this.continuation;
        t.a aVar = v8.t.f35208b;
        dVar.resumeWith(v8.t.b(u.a(new ExposureException("Invocation failed with: " + r52, params))));
    }

    @Override // com.unity3d.services.core.webview.bridge.WebViewCallback
    public void invoke(@NotNull Object... params) {
        kotlin.jvm.internal.t.i(params, "params");
        this.continuation.resumeWith(v8.t.b(params));
    }
}
