package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateComplete;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: InitializeStateComplete.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateComplete", f = "InitializeStateComplete.kt", l = {18}, m = "doWork-gIAlu-s")
final class InitializeStateComplete$doWork$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateComplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateComplete$doWork$1(InitializeStateComplete initializeStateComplete, z8.d<? super InitializeStateComplete$doWork$1> dVar) {
        super(dVar);
        this.this$0 = initializeStateComplete;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4006doWorkgIAlus = this.this$0.m4006doWorkgIAlus((InitializeStateComplete.Params) null, (z8.d<? super t<k0>>) this);
        return objM4006doWorkgIAlus == a9.d.e() ? objM4006doWorkgIAlus : t.a(objM4006doWorkgIAlus);
    }
}
