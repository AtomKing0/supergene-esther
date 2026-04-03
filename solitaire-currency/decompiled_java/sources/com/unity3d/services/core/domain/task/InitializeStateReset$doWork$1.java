package com.unity3d.services.core.domain.task;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: InitializeStateReset.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateReset", f = "InitializeStateReset.kt", l = {33}, m = "doWork-gIAlu-s$suspendImpl")
final class InitializeStateReset$doWork$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$1(InitializeStateReset initializeStateReset, z8.d<? super InitializeStateReset$doWork$1> dVar) {
        super(dVar);
        this.this$0 = initializeStateReset;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4015doWorkgIAlus$suspendImpl = InitializeStateReset.m4015doWorkgIAlus$suspendImpl(this.this$0, null, this);
        return objM4015doWorkgIAlus$suspendImpl == a9.d.e() ? objM4015doWorkgIAlus$suspendImpl : t.a(objM4015doWorkgIAlus$suspendImpl);
    }
}
