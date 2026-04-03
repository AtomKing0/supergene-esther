package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class y3 extends s3 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final /* synthetic */ boolean f7827p = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a7 f7828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f7829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaEvents f7830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final VastProperties f7831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f7832l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f7833m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f7834n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f7835o;

    public y3(a7 a7Var) {
        super(a7Var);
        this.f7829i = new AtomicBoolean();
        this.f7832l = new AtomicBoolean();
        this.f7833m = new AtomicBoolean();
        this.f7834n = new AtomicBoolean();
        this.f7835o = new AtomicBoolean();
        this.f7828h = a7Var;
        float fL1 = a7Var.l1();
        if (a7Var.l1() == -1) {
            this.f7831k = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        } else {
            this.f7831k = VastProperties.createVastPropertiesForSkippableMedia(fL1, true, Position.STANDALONE);
        }
    }

    public void A() {
        b("track resumed", new Runnable() { // from class: com.applovin.impl.cf
            @Override // java.lang.Runnable
            public final void run() {
                this.f4980a.s();
            }
        });
    }

    public void B() {
        b("track skipped", new Runnable() { // from class: com.applovin.impl.bf
            @Override // java.lang.Runnable
            public final void run() {
                this.f4927a.t();
            }
        });
    }

    public void C() {
        if (this.f7835o.compareAndSet(false, true)) {
            b("track third quartile", new Runnable() { // from class: com.applovin.impl.ue
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7545a.u();
                }
            });
        }
    }

    @Override // com.applovin.impl.s3
    protected AdSessionContext a(WebView webView) {
        if (!f7827p && this.f7828h.e1() == null) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        for (b7 b7Var : this.f7828h.e1().b()) {
            List<h7> listC = b7Var.c();
            if (listC.isEmpty()) {
                m7.a(b7Var.b(), f7.FAILED_TO_LOAD_RESOURCE, this.f6799b);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (h7 h7Var : listC) {
                    if ("omid".equalsIgnoreCase(h7Var.b())) {
                        arrayList2.add(h7Var);
                    }
                }
                if (arrayList2.isEmpty()) {
                    m7.a(b7Var.b(), f7.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED, this.f6799b);
                } else {
                    ArrayList<URL> arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        try {
                            arrayList3.add(new URL(((h7) it.next()).c()));
                        } catch (Throwable th) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f6800c.a(this.f6801d, "Failed to parse JavaScript resource url", th);
                            }
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        m7.a(b7Var.b(), f7.FAILED_TO_LOAD_RESOURCE, this.f6799b);
                    } else {
                        String strE = b7Var.e();
                        String strD = b7Var.d();
                        if (!StringUtils.isValidString(strE) || StringUtils.isValidString(strD)) {
                            for (URL url : arrayList3) {
                                arrayList.add(StringUtils.isValidString(strE) ? VerificationScriptResource.createVerificationScriptResourceWithParameters(strD, url, strE) : VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                            }
                        } else {
                            m7.a(b7Var.b(), f7.FAILED_TO_LOAD_RESOURCE, this.f6799b);
                        }
                    }
                }
            }
        }
        String strA = this.f6799b.W().a();
        if (TextUtils.isEmpty(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.b(this.f6801d, "JavaScript SDK content not loaded successfully");
            }
            return null;
        }
        try {
            return AdSessionContext.createNativeAdSessionContext(this.f6799b.W().b(), strA, arrayList, this.f7828h.getOpenMeasurementContentUrl(), this.f7828h.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th2) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f6800c.a(this.f6801d, "Failed to create ad session context", th2);
            return null;
        }
    }

    public void b(final float f10, final boolean z10) {
        if (this.f7832l.compareAndSet(false, true)) {
            b("track started", new Runnable() { // from class: com.applovin.impl.ff
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5221a.a(f10, z10);
                }
            });
        }
    }

    @Override // com.applovin.impl.s3
    public void h() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.xe
            @Override // java.lang.Runnable
            public final void run() {
                this.f7761a.p();
            }
        });
    }

    public void v() {
        b("track clicked", new Runnable() { // from class: com.applovin.impl.ef
            @Override // java.lang.Runnable
            public final void run() {
                this.f5162a.m();
            }
        });
    }

    public void w() {
        b("track completed", new Runnable() { // from class: com.applovin.impl.af
            @Override // java.lang.Runnable
            public final void run() {
                this.f4876a.n();
            }
        });
    }

    public void x() {
        if (this.f7833m.compareAndSet(false, true)) {
            b("track first quartile", new Runnable() { // from class: com.applovin.impl.ye
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7856a.o();
                }
            });
        }
    }

    public void y() {
        if (this.f7834n.compareAndSet(false, true)) {
            b("track midpoint", new Runnable() { // from class: com.applovin.impl.df
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5055a.q();
                }
            });
        }
    }

    public void z() {
        b("track paused", new Runnable() { // from class: com.applovin.impl.ve
            @Override // java.lang.Runnable
            public final void run() {
                this.f7653a.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f7830j.bufferFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f7830j.bufferStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f7830j.adUserInteraction(InteractionType.CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.f7830j.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.f7830j.firstQuartile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f6804g.loaded(this.f7831k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.f7830j.midpoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.f7830j.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.f7830j.resume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f7830j.skipped();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f7830j.thirdQuartile();
    }

    public void i() {
        if (this.f7829i.compareAndSet(true, false)) {
            b("buffer finished", new Runnable() { // from class: com.applovin.impl.we
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7705a.k();
                }
            });
        }
    }

    public void j() {
        if (this.f7829i.compareAndSet(false, true)) {
            b("buffer started", new Runnable() { // from class: com.applovin.impl.ze
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7934a.l();
                }
            });
        }
    }

    public void b(final boolean z10) {
        b("track volume changed", new Runnable() { // from class: com.applovin.impl.te
            @Override // java.lang.Runnable
            public final void run() {
                this.f7483a.a(z10);
            }
        });
    }

    @Override // com.applovin.impl.s3
    protected AdSessionConfiguration a() {
        try {
            CreativeType creativeType = CreativeType.VIDEO;
            ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
            Owner owner = Owner.NATIVE;
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.a(this.f6801d, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }

    @Override // com.applovin.impl.s3
    protected void a(AdSession adSession) {
        try {
            this.f7830j = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.a(this.f6801d, "Failed to create media events", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(float f10, boolean z10) {
        this.f7830j.start(f10, z10 ? 0.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z10) {
        this.f7830j.volumeChange(z10 ? 0.0f : 1.0f);
    }
}
