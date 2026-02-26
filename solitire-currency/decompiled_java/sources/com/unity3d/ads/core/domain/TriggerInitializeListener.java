package com.unity3d.ads.core.domain;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.properties.SdkProperties;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.u;

/* JADX INFO: compiled from: TriggerInitializeListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TriggerInitializeListener {

    @NotNull
    private final k0 coroutineDispatcher;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.TriggerInitializeListener$error$1, reason: invalid class name */
    /* JADX INFO: compiled from: TriggerInitializeListener.kt */
    @f(c = "com.unity3d.ads.core.domain.TriggerInitializeListener$error$1", f = "TriggerInitializeListener.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ String $errorMsg;
        final /* synthetic */ UnityAds.UnityAdsInitializationError $unityAdsInitializationError;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$unityAdsInitializationError = unityAdsInitializationError;
            this.$errorMsg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass1(this.$unityAdsInitializationError, this.$errorMsg, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            SdkProperties.notifyInitializationFailed(this.$unityAdsInitializationError, this.$errorMsg);
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.TriggerInitializeListener$success$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TriggerInitializeListener.kt */
    @f(c = "com.unity3d.ads.core.domain.TriggerInitializeListener$success$1", f = "TriggerInitializeListener.kt", l = {}, m = "invokeSuspend")
    static final class C31891 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        int label;

        C31891(z8.d<? super C31891> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C31891(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            SdkProperties.notifyInitializationComplete();
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C31891) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public TriggerInitializeListener(@NotNull k0 coroutineDispatcher) {
        t.i(coroutineDispatcher, "coroutineDispatcher");
        this.coroutineDispatcher = coroutineDispatcher;
    }

    public final void error(@NotNull UnityAds.UnityAdsInitializationError unityAdsInitializationError, @NotNull String errorMsg) {
        t.i(unityAdsInitializationError, "unityAdsInitializationError");
        t.i(errorMsg, "errorMsg");
        k.d(p0.a(this.coroutineDispatcher), null, null, new AnonymousClass1(unityAdsInitializationError, errorMsg, null), 3, null);
    }

    public final void success() {
        k.d(p0.a(this.coroutineDispatcher), null, null, new C31891(null), 3, null);
    }
}
