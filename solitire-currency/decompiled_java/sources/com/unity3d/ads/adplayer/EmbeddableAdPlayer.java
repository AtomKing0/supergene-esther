package com.unity3d.ads.adplayer;

import androidx.annotation.CallSuper;
import com.unity3d.ads.adplayer.AdPlayer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: EmbeddableAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface EmbeddableAdPlayer extends AdPlayer {

    /* JADX INFO: compiled from: EmbeddableAdPlayer.kt */
    public static final class DefaultImpls {
        @CallSuper
        @Nullable
        public static Object destroy(@NotNull EmbeddableAdPlayer embeddableAdPlayer, @NotNull z8.d<? super k0> dVar) {
            Object objDestroy = AdPlayer.DefaultImpls.destroy(embeddableAdPlayer, dVar);
            return objDestroy == a9.d.e() ? objDestroy : k0.f35197a;
        }

        public static void show(@NotNull EmbeddableAdPlayer embeddableAdPlayer, @NotNull ShowOptions showOptions) {
            t.i(showOptions, "showOptions");
            AdPlayer.DefaultImpls.show(embeddableAdPlayer, showOptions);
        }
    }
}
