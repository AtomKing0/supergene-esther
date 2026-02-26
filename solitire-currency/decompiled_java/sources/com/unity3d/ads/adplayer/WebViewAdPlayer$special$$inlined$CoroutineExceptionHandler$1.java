package com.unity3d.ads.adplayer;

import com.unity3d.services.core.device.Storage;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import z8.g;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1 extends z8.a implements l0 {
    final /* synthetic */ WebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(l0.b bVar, WebViewAdPlayer webViewAdPlayer) {
        super(bVar);
        this.this$0 = webViewAdPlayer;
    }

    @Override // kotlinx.coroutines.l0
    public void handleException(@NotNull g gVar, @NotNull Throwable th) {
        Storage.Companion.removeStorageEventCallback(this.this$0.storageEventCallback);
    }
}
