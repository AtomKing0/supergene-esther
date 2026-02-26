package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.model.WebViewClientError;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SendWebViewClientErrorDiagnostics.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface SendWebViewClientErrorDiagnostics {
    void invoke(@NotNull List<WebViewClientError> list);
}
