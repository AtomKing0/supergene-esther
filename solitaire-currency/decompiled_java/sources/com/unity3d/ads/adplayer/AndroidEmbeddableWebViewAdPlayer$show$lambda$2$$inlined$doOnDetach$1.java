package com.unity3d.ads.adplayer;

import android.view.View;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ View $this_doOnDetach;
    final /* synthetic */ AndroidEmbeddableWebViewAdPlayer this$0;

    public AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(View view, AndroidEmbeddableWebViewAdPlayer androidEmbeddableWebViewAdPlayer) {
        this.$this_doOnDetach = view;
        this.this$0 = androidEmbeddableWebViewAdPlayer;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        t.i(view, "view");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        t.i(view, "view");
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        k.d(this.this$0.webViewAdPlayer.getScope(), null, null, new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(this.this$0, null), 3, null);
    }
}
