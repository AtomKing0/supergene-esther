package com.iab.omid.library.activision.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.activision.internal.c;
import com.iab.omid.library.activision.internal.e;
import com.iab.omid.library.activision.internal.f;
import com.iab.omid.library.activision.internal.i;
import com.iab.omid.library.activision.publisher.AdSessionStatePublisher;
import com.iab.omid.library.activision.publisher.b;
import com.iab.omid.library.activision.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f10507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f10508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f10509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.activision.weakreference.a f10510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f10511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f10517k;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    private void a() {
        if (this.f10515i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void b() {
        if (this.f10516j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f10513g) {
            return;
        }
        this.f10509c.a(view, friendlyObstructionPurpose, str);
    }

    public View c() {
        return this.f10510d.get();
    }

    public List<e> d() {
        return this.f10509c.a();
    }

    public boolean e() {
        return this.f10517k != null;
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f10513g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.f10512f && !this.f10513g;
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void finish() {
        if (this.f10513g) {
            return;
        }
        this.f10510d.clear();
        removeAllFriendlyObstructions();
        this.f10513g = true;
        getAdSessionStatePublisher().f();
        c.c().b(this);
        getAdSessionStatePublisher().b();
        this.f10511e = null;
        this.f10517k = null;
    }

    public boolean g() {
        return this.f10513g;
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public String getAdSessionId() {
        return this.f10514h;
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f10511e;
    }

    public boolean h() {
        return this.f10508b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f10508b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f10512f;
    }

    void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f10515i = true;
    }

    void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f10516j = true;
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void registerAdView(@Nullable View view) {
        if (this.f10513g || c() == view) {
            return;
        }
        b(view);
        getAdSessionStatePublisher().a();
        a(view);
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f10513g) {
            return;
        }
        this.f10509c.b();
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f10513g) {
            return;
        }
        this.f10509c.c(view);
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f10517k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.activision.adsession.AdSession
    public void start() {
        if (this.f10512f || this.f10511e == null) {
            return;
        }
        this.f10512f = true;
        c.c().c(this);
        this.f10511e.a(i.c().b());
        this.f10511e.a(com.iab.omid.library.activision.internal.a.a().b());
        this.f10511e.a(this, this.f10507a);
    }

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f10509c = new f();
        this.f10512f = false;
        this.f10513g = false;
        this.f10508b = adSessionConfiguration;
        this.f10507a = adSessionContext;
        this.f10514h = str;
        b(null);
        this.f10511e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.activision.publisher.a(str, adSessionContext.getWebView()) : new b(str, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f10511e.i();
        c.c().a(this);
        this.f10511e.a(adSessionConfiguration);
    }

    private void a(@Nullable View view) {
        Collection<a> collectionB = c.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.c() == view) {
                aVar.f10510d.clear();
            }
        }
    }

    private void b(@Nullable View view) {
        this.f10510d = new com.iab.omid.library.activision.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.activision.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.activision.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f10517k.onPossibleObstructionsDetected(this.f10514h, arrayList);
        }
    }

    void a(@NonNull JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f10516j = true;
    }
}
