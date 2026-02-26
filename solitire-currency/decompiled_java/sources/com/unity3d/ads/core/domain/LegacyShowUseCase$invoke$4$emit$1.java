package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LegacyShowUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4", f = "LegacyShowUseCase.kt", l = {154, 155, 156, 158, 163}, m = "emit")
final class LegacyShowUseCase$invoke$4$emit$1 extends kotlin.coroutines.jvm.internal.d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyShowUseCase.AnonymousClass4<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LegacyShowUseCase$invoke$4$emit$1(LegacyShowUseCase.AnonymousClass4<? super T> anonymousClass4, z8.d<? super LegacyShowUseCase$invoke$4$emit$1> dVar) {
        super(dVar);
        this.this$0 = anonymousClass4;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ShowEvent) null, (z8.d<? super k0>) this);
    }
}
