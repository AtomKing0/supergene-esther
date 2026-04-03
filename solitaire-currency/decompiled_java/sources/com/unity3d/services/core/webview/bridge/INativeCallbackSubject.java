package com.unity3d.services.core.webview.bridge;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: INativeCallbackSubject.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface INativeCallbackSubject {
    @NotNull
    NativeCallback getCallback(@NotNull String str);

    void remove(@NotNull NativeCallback nativeCallback);
}
