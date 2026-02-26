package com.unity3d.ironsourceads;

import androidx.compose.animation.core.AnimationConstants;
import com.ironsource.mediationsdk.l;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class AdSize {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f23827c;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final AdSize banner() {
            return new AdSize(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50, l.f13634a, null);
        }

        @NotNull
        public final AdSize large() {
            return new AdSize(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 90, l.f13635b, null);
        }

        @NotNull
        public final AdSize leaderboard() {
            return new AdSize(728, 90, l.f13637d, null);
        }

        @NotNull
        public final AdSize mediumRectangle() {
            return new AdSize(AnimationConstants.DefaultDurationMillis, 250, l.f13640g, null);
        }
    }

    private AdSize(int i10, int i11, String str) {
        this.f23825a = i10;
        this.f23826b = i11;
        this.f23827c = str;
    }

    @NotNull
    public static final AdSize banner() {
        return Companion.banner();
    }

    @NotNull
    public static final AdSize large() {
        return Companion.large();
    }

    @NotNull
    public static final AdSize leaderboard() {
        return Companion.leaderboard();
    }

    @NotNull
    public static final AdSize mediumRectangle() {
        return Companion.mediumRectangle();
    }

    public final int getHeight() {
        return this.f23826b;
    }

    @NotNull
    public final String getSizeDescription() {
        return this.f23827c;
    }

    public final int getWidth() {
        return this.f23825a;
    }

    public /* synthetic */ AdSize(int i10, int i11, String str, k kVar) {
        this(i10, i11, str);
    }
}
