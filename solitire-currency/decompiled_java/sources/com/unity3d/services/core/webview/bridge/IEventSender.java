package com.unity3d.services.core.webview.bridge;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IEventSender.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IEventSender {
    boolean canSend();

    boolean sendEvent(@NotNull Enum<?> r12, @NotNull Enum<?> r22, @NotNull Object... objArr);
}
