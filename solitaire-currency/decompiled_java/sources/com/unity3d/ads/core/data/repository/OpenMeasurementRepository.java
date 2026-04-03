package com.unity3d.ads.core.data.repository;

import android.content.Context;
import android.webkit.WebView;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.OMData;
import com.unity3d.ads.core.data.model.OMResult;
import com.unity3d.ads.core.data.model.OmidOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: OpenMeasurementRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface OpenMeasurementRepository {
    @Nullable
    Object activateOM(@NotNull Context context, @NotNull d<? super OMResult> dVar);

    @Nullable
    Object finishSession(@NotNull ByteString byteString, @NotNull d<? super OMResult> dVar);

    @NotNull
    OMData getOmData();

    boolean hasSessionFinished(@NotNull ByteString byteString);

    @Nullable
    Object impressionOccurred(@NotNull ByteString byteString, boolean z10, @NotNull d<? super OMResult> dVar);

    boolean isOMActive();

    void setOMActive(boolean z10);

    @Nullable
    Object startSession(@NotNull ByteString byteString, @Nullable WebView webView, @NotNull OmidOptions omidOptions, @NotNull d<? super OMResult> dVar);
}
