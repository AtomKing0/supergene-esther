package com.unity3d.mediation;

import android.content.Context;
import com.ironsource.kq;
import com.ironsource.nk;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlay {

    @NotNull
    public static final LevelPlay INSTANCE = new LevelPlay();

    public enum AdFormat {
        BANNER("banner"),
        INTERSTITIAL("interstitial"),
        REWARDED("rewarded"),
        NATIVE_AD(kq.f12892i);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f23881a;

        AdFormat(String str) {
            this.f23881a = str;
        }

        @NotNull
        public final String getValue() {
            return this.f23881a;
        }
    }

    private LevelPlay() {
    }

    public static final void init(@NotNull Context context, @NotNull LevelPlayInitRequest initRequest, @NotNull LevelPlayInitListener listener) {
        t.i(context, "context");
        t.i(initRequest, "initRequest");
        t.i(listener, "listener");
        nk.f14147a.a(context, initRequest, listener);
    }
}
