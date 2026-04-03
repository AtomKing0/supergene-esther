package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
/* JADX INFO: loaded from: classes4.dex */
final class HandleInvocationsFromAdViewer$invoke$definition$11 extends v implements h9.a<ExposedFunction> {
    public static final HandleInvocationsFromAdViewer$invoke$definition$11 INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$11();

    HandleInvocationsFromAdViewer$invoke$definition$11() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final ExposedFunction invoke() {
        return CommonAdViewerExposedFunctionsKt.deleteStorage();
    }
}
