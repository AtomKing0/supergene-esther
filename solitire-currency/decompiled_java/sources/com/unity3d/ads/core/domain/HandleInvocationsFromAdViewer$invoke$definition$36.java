package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.attribution.AndroidAttribution;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
/* JADX INFO: loaded from: classes4.dex */
final class HandleInvocationsFromAdViewer$invoke$definition$36 extends v implements h9.a<ExposedFunction> {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ HandleInvocationsFromAdViewer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandleInvocationsFromAdViewer$invoke$definition$36(HandleInvocationsFromAdViewer handleInvocationsFromAdViewer, AdObject adObject) {
        super(0);
        this.this$0 = handleInvocationsFromAdViewer;
        this.$adObject = adObject;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final ExposedFunction invoke() {
        return CommonAdViewerExposedFunctionsKt.attributionRegisterView((AndroidAttribution) this.this$0.getServiceProvider().getRegistry().getService("", o0.b(AndroidAttribution.class)), this.$adObject);
    }
}
