package com.iab.omid.library.vungle.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.vungle.internal.c;
import com.iab.omid.library.vungle.internal.e;
import com.iab.omid.library.vungle.internal.f;
import com.iab.omid.library.vungle.internal.i;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.publisher.b;
import com.iab.omid.library.vungle.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f11030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f11031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f11032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.vungle.weakreference.a f11033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f11034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f11037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f11040k;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    private void a() {
        if (this.f11038i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void b() {
        if (this.f11039j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f11036g) {
            return;
        }
        this.f11032c.a(view, friendlyObstructionPurpose, str);
    }

    public View c() {
        return this.f11033d.get();
    }

    public List<e> d() {
        return this.f11032c.a();
    }

    public boolean e() {
        return this.f11040k != null;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f11036g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.f11035f && !this.f11036g;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void finish() {
        if (this.f11036g) {
            return;
        }
        this.f11033d.clear();
        removeAllFriendlyObstructions();
        this.f11036g = true;
        getAdSessionStatePublisher().f();
        c.c().b(this);
        getAdSessionStatePublisher().b();
        this.f11034e = null;
        this.f11040k = null;
    }

    public boolean g() {
        return this.f11036g;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public String getAdSessionId() {
        return this.f11037h;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f11034e;
    }

    public boolean h() {
        return this.f11031b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f11031b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f11035f;
    }

    void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f11038i = true;
    }

    void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f11039j = true;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void registerAdView(@Nullable View view) {
        if (this.f11036g || c() == view) {
            return;
        }
        b(view);
        getAdSessionStatePublisher().a();
        a(view);
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f11036g) {
            return;
        }
        this.f11032c.b();
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f11036g) {
            return;
        }
        this.f11032c.c(view);
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f11040k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void start() {
        if (this.f11035f) {
            return;
        }
        this.f11035f = true;
        c.c().c(this);
        this.f11034e.a(i.c().b());
        this.f11034e.a(com.iab.omid.library.vungle.internal.a.a().b());
        this.f11034e.a(this, this.f11030a);
    }

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f11032c = new f();
        this.f11035f = false;
        this.f11036g = false;
        this.f11031b = adSessionConfiguration;
        this.f11030a = adSessionContext;
        this.f11037h = str;
        b(null);
        this.f11034e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.vungle.publisher.a(str, adSessionContext.getWebView()) : new b(str, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f11034e.i();
        c.c().a(this);
        this.f11034e.a(adSessionConfiguration);
    }

    private void a(@Nullable View view) {
        Collection<a> collectionB = c.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.c() == view) {
                aVar.f11033d.clear();
            }
        }
    }

    private void b(@Nullable View view) {
        this.f11033d = new com.iab.omid.library.vungle.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.vungle.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.vungle.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f11040k.onPossibleObstructionsDetected(this.f11037h, arrayList);
        }
    }

    void a(@NonNull JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f11039j = true;
    }
}
