package com.unity3d.services.core.di;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: UnityAdsModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.di.UnityAdsModule$provideHttpClient$1$config$1", f = "UnityAdsModule.kt", l = {278}, m = "invokeSuspend")
final class UnityAdsModule$provideHttpClient$1$config$1 extends l implements p<o0, d<? super Configuration>, Object> {
    final /* synthetic */ ConfigFileFromLocalStorage $configFileFromLocalStorage;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnityAdsModule$provideHttpClient$1$config$1(ConfigFileFromLocalStorage configFileFromLocalStorage, d<? super UnityAdsModule$provideHttpClient$1$config$1> dVar) {
        super(2, dVar);
        this.$configFileFromLocalStorage = configFileFromLocalStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        UnityAdsModule$provideHttpClient$1$config$1 unityAdsModule$provideHttpClient$1$config$1 = new UnityAdsModule$provideHttpClient$1$config$1(this.$configFileFromLocalStorage, dVar);
        unityAdsModule$provideHttpClient$1$config$1.L$0 = obj;
        return unityAdsModule$provideHttpClient$1$config$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objB;
        Object objMo4000invokegIAlus;
        Object objE = a9.d.e();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                u.b(obj);
                ConfigFileFromLocalStorage configFileFromLocalStorage = this.$configFileFromLocalStorage;
                t.a aVar = t.f35208b;
                ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params(null, 1, null);
                this.label = 1;
                objMo4000invokegIAlus = configFileFromLocalStorage.mo4000invokegIAlus(params, this);
                if (objMo4000invokegIAlus == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                objMo4000invokegIAlus = ((t) obj).j();
            }
            objB = t.b(t.a(objMo4000invokegIAlus));
        } catch (Throwable th) {
            t.a aVar2 = t.f35208b;
            objB = t.b(u.a(th));
        }
        if (t.g(objB)) {
            objB = null;
        }
        t tVar = (t) objB;
        if (tVar == null) {
            return null;
        }
        Object objJ = tVar.j();
        return (Configuration) (t.g(objJ) ? null : objJ);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super Configuration> dVar) {
        return ((UnityAdsModule$provideHttpClient$1$config$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
