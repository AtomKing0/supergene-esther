package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
/* JADX INFO: loaded from: classes4.dex */
final class HandleInvocationsFromAdViewer$invoke$definition$22 extends v implements h9.a<ExposedFunction> {
    final /* synthetic */ HandleInvocationsFromAdViewer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandleInvocationsFromAdViewer$invoke$definition$22(HandleInvocationsFromAdViewer handleInvocationsFromAdViewer) {
        super(0);
        this.this$0 = handleInvocationsFromAdViewer;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final ExposedFunction invoke() {
        return CommonAdViewerExposedFunctionsKt.getSessionToken((SessionRepository) this.this$0.getServiceProvider().getRegistry().getService("", o0.b(SessionRepository.class)));
    }
}
