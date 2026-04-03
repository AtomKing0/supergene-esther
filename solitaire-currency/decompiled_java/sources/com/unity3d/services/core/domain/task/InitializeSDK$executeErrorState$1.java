package com.unity3d.services.core.domain.task;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: InitializeSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", l = {111}, m = "executeErrorState-BWLJW6A")
final class InitializeSDK$executeErrorState$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$executeErrorState$1(InitializeSDK initializeSDK, z8.d<? super InitializeSDK$executeErrorState$1> dVar) {
        super(dVar);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4004executeErrorStateBWLJW6A = this.this$0.m4004executeErrorStateBWLJW6A(null, null, null, this);
        return objM4004executeErrorStateBWLJW6A == a9.d.e() ? objM4004executeErrorStateBWLJW6A : t.a(objM4004executeErrorStateBWLJW6A);
    }
}
