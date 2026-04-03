package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.j;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AndroidSessionRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository$nativeConfiguration$1", f = "AndroidSessionRepository.kt", l = {131}, m = "invokeSuspend")
final class AndroidSessionRepository$nativeConfiguration$1 extends l implements p<o0, d<? super NativeConfigurationOuterClass.NativeConfiguration>, Object> {
    int label;
    final /* synthetic */ AndroidSessionRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidSessionRepository$nativeConfiguration$1(AndroidSessionRepository androidSessionRepository, d<? super AndroidSessionRepository$nativeConfiguration$1> dVar) {
        super(2, dVar);
        this.this$0 = androidSessionRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new AndroidSessionRepository$nativeConfiguration$1(this.this$0, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            h hVar = this.this$0.persistedNativeConfiguration;
            this.label = 1;
            obj = j.w(hVar, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return obj;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super NativeConfigurationOuterClass.NativeConfiguration> dVar) {
        return ((AndroidSessionRepository$nativeConfiguration$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
