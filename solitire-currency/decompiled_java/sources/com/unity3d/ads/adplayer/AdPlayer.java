package com.unity3d.ads.adplayer;

import androidx.annotation.CallSuper;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.model.ShowEvent;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.h;
import s9.x;
import v8.k0;
import v8.r;
import v8.s;

/* JADX INFO: compiled from: AdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface AdPlayer {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: AdPlayer.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final x<String> broadcastEventChannel = e0.b(0, 0, null, 7, null);

        private Companion() {
        }

        @NotNull
        public final x<String> getBroadcastEventChannel() {
            return broadcastEventChannel;
        }
    }

    /* JADX INFO: compiled from: AdPlayer.kt */
    public static final class DefaultImpls {
        @CallSuper
        @Nullable
        public static Object destroy(@NotNull AdPlayer adPlayer, @NotNull z8.d<? super k0> dVar) {
            p0.e(adPlayer.getScope(), null, 1, null);
            return k0.f35197a;
        }

        public static void show(@NotNull AdPlayer adPlayer, @NotNull ShowOptions showOptions) {
            t.i(showOptions, "showOptions");
            throw new r(null, 1, null);
        }
    }

    @CallSuper
    @Nullable
    Object destroy(@NotNull z8.d<? super k0> dVar);

    void dispatchShowCompleted();

    @NotNull
    h<LoadEvent> getOnLoadEvent();

    @NotNull
    h<ShowEvent> getOnShowEvent();

    @NotNull
    o0 getScope();

    @NotNull
    h<s<byte[], Integer>> getUpdateCampaignState();

    @NotNull
    WebViewContainer getWebViewContainer();

    @Nullable
    Object onAllowedPiiChange(@NotNull byte[] bArr, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object onBroadcastEvent(@NotNull String str, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object requestShow(@Nullable Map<String, ? extends Object> map, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object sendActivityDestroyed(@NotNull z8.d<? super k0> dVar);

    @Nullable
    Object sendFocusChange(boolean z10, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object sendMuteChange(boolean z10, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object sendPrivacyFsmChange(@NotNull byte[] bArr, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object sendUserConsentChange(@NotNull byte[] bArr, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object sendVisibilityChange(boolean z10, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object sendVolumeChange(double d10, @NotNull z8.d<? super k0> dVar);

    void show(@NotNull ShowOptions showOptions);
}
