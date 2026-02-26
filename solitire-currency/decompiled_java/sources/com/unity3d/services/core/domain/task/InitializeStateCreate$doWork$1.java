package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: InitializeStateCreate.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeStateCreate", f = "InitializeStateCreate.kt", l = {28}, m = "doWork-gIAlu-s")
final class InitializeStateCreate$doWork$1 extends d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateCreate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateCreate$doWork$1(InitializeStateCreate initializeStateCreate, z8.d<? super InitializeStateCreate$doWork$1> dVar) {
        super(dVar);
        this.this$0 = initializeStateCreate;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM4010doWorkgIAlus = this.this$0.m4010doWorkgIAlus((InitializeStateCreate.Params) null, (z8.d<? super t<? extends Configuration>>) this);
        return objM4010doWorkgIAlus == a9.d.e() ? objM4010doWorkgIAlus : t.a(objM4010doWorkgIAlus);
    }
}
