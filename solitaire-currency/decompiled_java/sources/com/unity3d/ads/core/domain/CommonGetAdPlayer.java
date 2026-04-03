package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer;
import com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.WebViewAdPlayer;
import com.unity3d.ads.adplayer.WebViewBridge;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.banners.BannerViewCache;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CommonGetAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonGetAdPlayer implements GetAdPlayer {

    @NotNull
    private final o0 adPlayerScope;

    @NotNull
    private final k0 defaultDispatcher;

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final ExecuteAdViewerRequest executeAdViewerRequest;

    @NotNull
    private final OpenMeasurementRepository openMeasurementRepository;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    public CommonGetAdPlayer(@NotNull DeviceInfoRepository deviceInfoRepository, @NotNull SessionRepository sessionRepository, @NotNull ExecuteAdViewerRequest executeAdViewerRequest, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull k0 defaultDispatcher, @NotNull o0 adPlayerScope, @NotNull OpenMeasurementRepository openMeasurementRepository) {
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(sessionRepository, "sessionRepository");
        t.i(executeAdViewerRequest, "executeAdViewerRequest");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(defaultDispatcher, "defaultDispatcher");
        t.i(adPlayerScope, "adPlayerScope");
        t.i(openMeasurementRepository, "openMeasurementRepository");
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.executeAdViewerRequest = executeAdViewerRequest;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.defaultDispatcher = defaultDispatcher;
        this.adPlayerScope = adPlayerScope;
        this.openMeasurementRepository = openMeasurementRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetAdPlayer
    @NotNull
    public AdPlayer invoke(@NotNull WebViewBridge webviewBridge, @NotNull AndroidWebViewContainer webviewContainer, @NotNull ByteString opportunityId) {
        t.i(webviewBridge, "webviewBridge");
        t.i(webviewContainer, "webviewContainer");
        t.i(opportunityId, "opportunityId");
        WebViewAdPlayer webViewAdPlayer = new WebViewAdPlayer(webviewBridge, this.deviceInfoRepository, this.sessionRepository, this.executeAdViewerRequest, this.defaultDispatcher, this.sendDiagnosticEvent, webviewContainer, this.adPlayerScope);
        return BannerViewCache.getInstance().getBannerView(ProtobufExtensionsKt.toUUID(opportunityId).toString()) == null ? new AndroidFullscreenWebViewAdPlayer(webViewAdPlayer, ProtobufExtensionsKt.toISO8859String(opportunityId), webviewContainer, this.deviceInfoRepository, this.sessionRepository, this.openMeasurementRepository) : new AndroidEmbeddableWebViewAdPlayer(webViewAdPlayer, ProtobufExtensionsKt.toISO8859String(opportunityId), webviewContainer, this.openMeasurementRepository);
    }
}
