package com.vungle.ads.internal.omsdk;

import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OMTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements f {

    @NotNull
    public static final a Companion = new a(null);
    private static final long DESTROY_DELAY_MS = TimeUnit.SECONDS.toMillis(1);

    @Nullable
    private AdSession adSession;
    private final boolean enabled;
    private boolean started;

    /* JADX INFO: compiled from: OMTracker.kt */
    public static final class b {
        @NotNull
        public final d make(boolean z10) {
            return new d(z10, null);
        }
    }

    public /* synthetic */ d(boolean z10, k kVar) {
        this(z10);
    }

    @Override // com.vungle.ads.internal.omsdk.f
    public void onPageFinished(@NotNull WebView webView) {
        t.i(webView, "webView");
        if (this.started && this.adSession == null) {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
            Owner owner = Owner.JAVASCRIPT;
            AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false), AdSessionContext.createHtmlAdSessionContext(Partner.createPartner("Vungle", "7.4.2"), webView, null, null));
            this.adSession = adSessionCreateAdSession;
            if (adSessionCreateAdSession != null) {
                adSessionCreateAdSession.registerAdView(webView);
            }
            AdSession adSession = this.adSession;
            if (adSession != null) {
                adSession.start();
            }
        }
    }

    public final void start() {
        if (this.enabled && Omid.isActive()) {
            this.started = true;
        }
    }

    public final long stop() {
        long j10;
        AdSession adSession;
        if (!this.started || (adSession = this.adSession) == null) {
            j10 = 0;
        } else {
            if (adSession != null) {
                adSession.finish();
            }
            j10 = DESTROY_DELAY_MS;
        }
        this.started = false;
        this.adSession = null;
        return j10;
    }

    private d(boolean z10) {
        this.enabled = z10;
    }

    /* JADX INFO: compiled from: OMTracker.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        public final long getDESTROY_DELAY_MS() {
            return d.DESTROY_DELAY_MS;
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESTROY_DELAY_MS$annotations() {
        }
    }
}
