package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1", f = "CommonAdViewerExposedFunctions.kt", l = {268}, m = "invoke")
final class CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C32181 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1(CommonAdViewerExposedFunctionsKt.C32181 c32181, z8.d<? super CommonAdViewerExposedFunctionsKt$sendPrivacyUpdateRequest$1$invoke$1> dVar) {
        super(dVar);
        this.this$0 = c32181;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke2((Object[]) null, (z8.d<Object>) this);
    }
}
