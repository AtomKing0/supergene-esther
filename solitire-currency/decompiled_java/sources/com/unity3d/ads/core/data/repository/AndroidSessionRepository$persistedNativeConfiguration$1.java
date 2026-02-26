package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.q;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.u;
import v8.y;
import z8.d;

/* JADX INFO: compiled from: AndroidSessionRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository$persistedNativeConfiguration$1", f = "AndroidSessionRepository.kt", l = {}, m = "invokeSuspend")
final class AndroidSessionRepository$persistedNativeConfiguration$1 extends l implements q<NativeConfigurationOuterClass.NativeConfiguration, Boolean, d<? super s<? extends NativeConfigurationOuterClass.NativeConfiguration, ? extends Boolean>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    AndroidSessionRepository$persistedNativeConfiguration$1(d<? super AndroidSessionRepository$persistedNativeConfiguration$1> dVar) {
        super(3, dVar);
    }

    @Nullable
    public final Object invoke(@NotNull NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration, boolean z10, @Nullable d<? super s<NativeConfigurationOuterClass.NativeConfiguration, Boolean>> dVar) {
        AndroidSessionRepository$persistedNativeConfiguration$1 androidSessionRepository$persistedNativeConfiguration$1 = new AndroidSessionRepository$persistedNativeConfiguration$1(dVar);
        androidSessionRepository$persistedNativeConfiguration$1.L$0 = nativeConfiguration;
        androidSessionRepository$persistedNativeConfiguration$1.Z$0 = z10;
        return androidSessionRepository$persistedNativeConfiguration$1.invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u.b(obj);
        return y.a((NativeConfigurationOuterClass.NativeConfiguration) this.L$0, b.a(this.Z$0));
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Object invoke(NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration, Boolean bool, d<? super s<? extends NativeConfigurationOuterClass.NativeConfiguration, ? extends Boolean>> dVar) {
        return invoke(nativeConfiguration, bool.booleanValue(), (d<? super s<NativeConfigurationOuterClass.NativeConfiguration, Boolean>>) dVar);
    }
}
