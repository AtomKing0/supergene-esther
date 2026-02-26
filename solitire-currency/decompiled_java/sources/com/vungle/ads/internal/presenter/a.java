package com.vungle.ads.internal.presenter;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.vungle.ads.b2;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdEventListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    @NotNull
    public static final C0526a Companion = new C0526a(null);

    @NotNull
    private static final String TAG = "AdEventListener";
    private boolean adRewarded;

    @Nullable
    private com.vungle.ads.internal.model.j placement;

    @Nullable
    private final b playAdCallback;

    /* JADX INFO: renamed from: com.vungle.ads.internal.presenter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdEventListener.kt */
    public static final class C0526a {
        private C0526a() {
        }

        public /* synthetic */ C0526a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public a(@Nullable b bVar, @Nullable com.vungle.ads.internal.model.j jVar) {
        this.playAdCallback = bVar;
        this.placement = jVar;
    }

    public final void onError(@NotNull b2 error, @Nullable String str) {
        t.i(error, "error");
        b bVar = this.playAdCallback;
        if (bVar != null) {
            bVar.onFailure(error);
            com.vungle.ads.internal.util.p.Companion.e(TAG, "AdEventListener#PlayAdCallback " + str, error);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void onNext(@NotNull String s10, @Nullable String str, @Nullable String str2) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        t.i(s10, "s");
        com.vungle.ads.internal.util.p.Companion.d(TAG, "s=" + s10 + ", value=" + str + ", id=" + str2);
        switch (s10.hashCode()) {
            case -1912374177:
                if (s10.equals(l.SUCCESSFUL_VIEW)) {
                    com.vungle.ads.internal.model.j jVar = this.placement;
                    boolean z10 = false;
                    if (jVar != null && jVar.isRewardedVideo()) {
                        z10 = true;
                    }
                    if (z10 && !this.adRewarded) {
                        this.adRewarded = true;
                        b bVar5 = this.playAdCallback;
                        if (bVar5 != null) {
                            bVar5.onAdRewarded(str2);
                        }
                        break;
                    }
                }
                break;
            case -1627831289:
                if (s10.equals("adViewed") && (bVar = this.playAdCallback) != null) {
                    bVar.onAdImpression(str2);
                }
                break;
            case 100571:
                if (s10.equals(TtmlNode.END) && (bVar2 = this.playAdCallback) != null) {
                    bVar2.onAdEnd(str2);
                }
                break;
            case 3417674:
                if (s10.equals("open")) {
                    if (t.d(str, "adClick")) {
                        b bVar6 = this.playAdCallback;
                        if (bVar6 != null) {
                            bVar6.onAdClick(str2);
                        }
                        break;
                    } else if (t.d(str, "adLeftApplication") && (bVar3 = this.playAdCallback) != null) {
                        bVar3.onAdLeftApplication(str2);
                        break;
                    }
                }
                break;
            case 109757538:
                if (s10.equals(TtmlNode.START) && (bVar4 = this.playAdCallback) != null) {
                    bVar4.onAdStart(str2);
                }
                break;
        }
    }
}
