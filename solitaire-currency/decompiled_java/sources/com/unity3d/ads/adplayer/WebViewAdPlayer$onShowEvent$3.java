package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.model.ShowStatus;
import com.unity3d.ads.core.data.model.ShowEvent;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: WebViewAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.ads.adplayer.WebViewAdPlayer$onShowEvent$3", f = "WebViewAdPlayer.kt", l = {}, m = "invokeSuspend")
final class WebViewAdPlayer$onShowEvent$3 extends l implements q<ShowEvent, Boolean, z8.d<? super ShowEvent>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    WebViewAdPlayer$onShowEvent$3(z8.d<? super WebViewAdPlayer$onShowEvent$3> dVar) {
        super(3, dVar);
    }

    @Nullable
    public final Object invoke(@NotNull ShowEvent showEvent, boolean z10, @Nullable z8.d<? super ShowEvent> dVar) {
        WebViewAdPlayer$onShowEvent$3 webViewAdPlayer$onShowEvent$3 = new WebViewAdPlayer$onShowEvent$3(dVar);
        webViewAdPlayer$onShowEvent$3.L$0 = showEvent;
        webViewAdPlayer$onShowEvent$3.Z$0 = z10;
        return webViewAdPlayer$onShowEvent$3.invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u.b(obj);
        return this.Z$0 ? new ShowEvent.Completed(ShowStatus.COMPLETED) : (ShowEvent) this.L$0;
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ Object invoke(ShowEvent showEvent, Boolean bool, z8.d<? super ShowEvent> dVar) {
        return invoke(showEvent, bool.booleanValue(), dVar);
    }
}
