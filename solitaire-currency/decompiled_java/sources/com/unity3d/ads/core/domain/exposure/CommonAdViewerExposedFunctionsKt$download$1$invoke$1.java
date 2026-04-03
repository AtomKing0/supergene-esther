package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$download$1", f = "CommonAdViewerExposedFunctions.kt", l = {298}, m = "invoke")
final class CommonAdViewerExposedFunctionsKt$download$1$invoke$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C31931 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonAdViewerExposedFunctionsKt$download$1$invoke$1(CommonAdViewerExposedFunctionsKt.C31931 c31931, z8.d<? super CommonAdViewerExposedFunctionsKt$download$1$invoke$1> dVar) {
        super(dVar);
        this.this$0 = c31931;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke2((Object[]) null, (z8.d<Object>) this);
    }
}
