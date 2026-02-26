package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.model.WebViewClientError;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AdPlayerError.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LoadWebViewError extends AdPlayerError {

    @NotNull
    private final List<WebViewClientError> errors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadWebViewError(@NotNull List<WebViewClientError> errors) {
        super("AdPlayer was not able to load the webview.", null);
        t.i(errors, "errors");
        this.errors = errors;
    }

    @NotNull
    public final List<WebViewClientError> getErrors() {
        return this.errors;
    }
}
