package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.DisplayMessage;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.x;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: FullScreenWebViewDisplay.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$1$1", f = "FullScreenWebViewDisplay.kt", l = {31}, m = "invokeSuspend")
final class FullScreenWebViewDisplay$onCreate$1$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ FullScreenWebViewDisplay $this_run;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullScreenWebViewDisplay$onCreate$1$1(FullScreenWebViewDisplay fullScreenWebViewDisplay, z8.d<? super FullScreenWebViewDisplay$onCreate$1$1> dVar) {
        super(2, dVar);
        this.$this_run = fullScreenWebViewDisplay;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new FullScreenWebViewDisplay$onCreate$1$1(this.$this_run, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            x<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.Companion.getDisplayMessages();
            DisplayMessage.DisplayError displayError = new DisplayMessage.DisplayError(this.$this_run.opportunityId, "Opportunity ID not found");
            this.label = 1;
            if (displayMessages.emit(displayError, this) == objE) {
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
        return ((FullScreenWebViewDisplay$onCreate$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
