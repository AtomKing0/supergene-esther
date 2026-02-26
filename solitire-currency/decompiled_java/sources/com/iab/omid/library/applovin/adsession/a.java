package com.iab.omid.library.applovin.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.internal.c;
import com.iab.omid.library.applovin.internal.e;
import com.iab.omid.library.applovin.internal.f;
import com.iab.omid.library.applovin.internal.i;
import com.iab.omid.library.applovin.publisher.AdSessionStatePublisher;
import com.iab.omid.library.applovin.publisher.b;
import com.iab.omid.library.applovin.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f10642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f10643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f10644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.applovin.weakreference.a f10645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f10646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f10652k;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    private void a() {
        if (this.f10650i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void b() {
        if (this.f10651j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f10648g) {
            return;
        }
        this.f10644c.a(view, friendlyObstructionPurpose, str);
    }

    public String c() {
        return this.f10649h;
    }

    public AdSessionStatePublisher d() {
        return this.f10646e;
    }

    public View e() {
        return this.f10645d.get();
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f10648g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        d().a(errorType, str);
    }

    public List<e> f() {
        return this.f10644c.a();
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void finish() {
        if (this.f10648g) {
            return;
        }
        this.f10645d.clear();
        removeAllFriendlyObstructions();
        this.f10648g = true;
        d().f();
        c.c().b(this);
        d().b();
        this.f10646e = null;
        this.f10652k = null;
    }

    public boolean g() {
        return this.f10652k != null;
    }

    public boolean h() {
        return this.f10647f && !this.f10648g;
    }

    public boolean i() {
        return this.f10648g;
    }

    public boolean j() {
        return this.f10643b.isNativeImpressionOwner();
    }

    public boolean k() {
        return this.f10643b.isNativeMediaEventsOwner();
    }

    public boolean l() {
        return this.f10647f;
    }

    void m() {
        a();
        d().g();
        this.f10650i = true;
    }

    void n() {
        b();
        d().h();
        this.f10651j = true;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void registerAdView(@Nullable View view) {
        if (this.f10648g || e() == view) {
            return;
        }
        b(view);
        d().a();
        a(view);
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f10648g) {
            return;
        }
        this.f10644c.b();
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f10648g) {
            return;
        }
        this.f10644c.c(view);
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f10652k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.applovin.adsession.AdSession
    public void start() {
        if (this.f10647f || this.f10646e == null) {
            return;
        }
        this.f10647f = true;
        c.c().c(this);
        this.f10646e.a(i.c().b());
        this.f10646e.a(com.iab.omid.library.applovin.internal.a.a().b());
        this.f10646e.a(this, this.f10642a);
    }

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f10644c = new f();
        this.f10647f = false;
        this.f10648g = false;
        this.f10643b = adSessionConfiguration;
        this.f10642a = adSessionContext;
        this.f10649h = str;
        b(null);
        this.f10646e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.applovin.publisher.a(str, adSessionContext.getWebView()) : new b(str, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f10646e.i();
        c.c().a(this);
        this.f10646e.a(adSessionConfiguration);
    }

    private void a(@Nullable View view) {
        Collection<a> collectionB = c.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.e() == view) {
                aVar.f10645d.clear();
            }
        }
    }

    private void b(@Nullable View view) {
        this.f10645d = new com.iab.omid.library.applovin.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.applovin.weakreference.a> list) {
        if (g()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.applovin.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f10652k.onPossibleObstructionsDetected(this.f10649h, arrayList);
        }
    }

    void a(@NonNull JSONObject jSONObject) {
        b();
        d().a(jSONObject);
        this.f10651j = true;
    }
}
