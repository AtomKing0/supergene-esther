package com.unity3d.ads.adplayer;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: AndroidEmbeddableWebViewAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$2$2$1", f = "AndroidEmbeddableWebViewAdPlayer.kt", l = {41}, m = "invokeSuspend")
final class AndroidEmbeddableWebViewAdPlayer$show$2$2$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    int label;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidEmbeddableWebViewAdPlayer$show$2$2$1(AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer, z8.d<? super AndroidEmbeddableWebViewAdPlayer$show$2$2$1> dVar) {
        super(2, dVar);
        this.this$0 = androidEmbeddableWebViewAdPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(this.this$0, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer = this.this$0;
            this.label = 1;
            if (androidEmbeddableWebViewAdPlayer.destroy(this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((AndroidEmbeddableWebViewAdPlayer$show$2$2$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
