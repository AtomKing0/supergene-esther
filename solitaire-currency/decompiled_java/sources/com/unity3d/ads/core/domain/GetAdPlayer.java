package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.WebViewBridge;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface GetAdPlayer {
    @NotNull
    AdPlayer invoke(@NotNull WebViewBridge webViewBridge, @NotNull AndroidWebViewContainer androidWebViewContainer, @NotNull ByteString byteString);
}
