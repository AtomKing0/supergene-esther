package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HandleInvocationsFromAdViewer.kt */
/* JADX INFO: loaded from: classes4.dex */
final class HandleInvocationsFromAdViewer$invoke$definition$1 extends v implements h9.a<ExposedFunction> {
    final /* synthetic */ String $adDataObject;
    final /* synthetic */ String $adDataRefreshTokenObject;
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ String $impressionConfigObject;
    final /* synthetic */ HandleInvocationsFromAdViewer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandleInvocationsFromAdViewer$invoke$definition$1(HandleInvocationsFromAdViewer handleInvocationsFromAdViewer, String str, String str2, String str3, AdObject adObject) {
        super(0);
        this.this$0 = handleInvocationsFromAdViewer;
        this.$adDataObject = str;
        this.$impressionConfigObject = str2;
        this.$adDataRefreshTokenObject = str3;
        this.$adObject = adObject;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final ExposedFunction invoke() {
        return CommonAdViewerExposedFunctionsKt.m3996getAdContextyLuu4LI((GetAndroidAdPlayerContext) this.this$0.getServiceProvider().getRegistry().getService("", o0.b(GetAndroidAdPlayerContext.class)), this.$adDataObject, this.$impressionConfigObject, this.$adDataRefreshTokenObject, (IsOMActivated) this.this$0.getServiceProvider().getRegistry().getService("", o0.b(IsOMActivated.class)), this.$adObject);
    }
}
