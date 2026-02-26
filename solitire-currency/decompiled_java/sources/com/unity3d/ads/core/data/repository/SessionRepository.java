package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.SessionChange;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.c0;
import s9.h;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: SessionRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface SessionRepository {
    @NotNull
    NativeConfigurationOuterClass.FeatureFlags getFeatureFlags();

    @NotNull
    String getGameId();

    @Nullable
    Object getGatewayCache(@NotNull d<? super ByteString> dVar);

    @NotNull
    ByteString getGatewayState();

    @NotNull
    String getGatewayUrl();

    int getHeaderBiddingTokenCounter();

    @NotNull
    InitializationState getInitializationState();

    @NotNull
    NativeConfigurationOuterClass.NativeConfiguration getNativeConfiguration();

    @NotNull
    h<InitializationState> getObserveInitializationState();

    @NotNull
    c0<SessionChange> getOnChange();

    @Nullable
    Object getPrivacy(@NotNull d<? super ByteString> dVar);

    @Nullable
    Object getPrivacyFsm(@NotNull d<? super ByteString> dVar);

    @NotNull
    SessionCountersOuterClass.SessionCounters getSessionCounters();

    @NotNull
    ByteString getSessionId();

    @NotNull
    ByteString getSessionToken();

    boolean getShouldInitialize();

    void incrementBannerImpressionCount();

    void incrementBannerLoadRequestAdmCount();

    void incrementBannerLoadRequestCount();

    void incrementLoadRequestAdmCount();

    void incrementLoadRequestCount();

    boolean isDiagnosticsEnabled();

    boolean isOmEnabled();

    boolean isSdkInitialized();

    boolean isTestModeEnabled();

    @Nullable
    Object persistNativeConfiguration(@NotNull d<? super k0> dVar);

    void setGameId(@NotNull String str);

    @Nullable
    Object setGatewayCache(@NotNull ByteString byteString, @NotNull d<? super k0> dVar);

    void setGatewayState(@NotNull ByteString byteString);

    void setGatewayUrl(@NotNull String str);

    void setInitializationState(@NotNull InitializationState initializationState);

    void setNativeConfiguration(@NotNull NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration);

    @Nullable
    Object setPrivacy(@NotNull ByteString byteString, @NotNull d<? super k0> dVar);

    @Nullable
    Object setPrivacyFsm(@NotNull ByteString byteString, @NotNull d<? super k0> dVar);

    void setSessionCounters(@NotNull SessionCountersOuterClass.SessionCounters sessionCounters);

    void setSessionToken(@NotNull ByteString byteString);

    void setShouldInitialize(boolean z10);
}
