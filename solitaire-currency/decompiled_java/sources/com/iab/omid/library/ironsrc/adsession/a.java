package com.iab.omid.library.ironsrc.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.ironsrc.internal.c;
import com.iab.omid.library.ironsrc.internal.e;
import com.iab.omid.library.ironsrc.internal.h;
import com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher;
import com.iab.omid.library.ironsrc.publisher.b;
import com.iab.omid.library.ironsrc.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f10777l = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f10778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f10779b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.weakreference.a f10781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f10782e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f10788k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<e> f10780c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10783f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10784g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10785h = UUID.randomUUID().toString();

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f10779b = adSessionConfiguration;
        this.f10778a = adSessionContext;
        d(null);
        this.f10782e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.ironsrc.publisher.a(adSessionContext.getWebView()) : new b(adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f10782e.i();
        c.c().a(this);
        this.f10782e.a(adSessionConfiguration);
    }

    private void a() {
        if (this.f10786i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private e b(View view) {
        for (e eVar : this.f10780c) {
            if (eVar.c().get() == view) {
                return eVar;
            }
        }
        return null;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f10784g) {
            return;
        }
        a(view);
        a(str);
        if (b(view) == null) {
            this.f10780c.add(new e(view, friendlyObstructionPurpose, str));
        }
    }

    public View c() {
        return this.f10781d.get();
    }

    public List<e> d() {
        return this.f10780c;
    }

    public boolean e() {
        return this.f10788k != null;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f10784g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.f10783f && !this.f10784g;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void finish() {
        if (this.f10784g) {
            return;
        }
        this.f10781d.clear();
        removeAllFriendlyObstructions();
        this.f10784g = true;
        getAdSessionStatePublisher().f();
        c.c().b(this);
        getAdSessionStatePublisher().b();
        this.f10782e = null;
        this.f10788k = null;
    }

    public boolean g() {
        return this.f10784g;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public String getAdSessionId() {
        return this.f10785h;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f10782e;
    }

    public boolean h() {
        return this.f10779b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f10779b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f10783f;
    }

    void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f10786i = true;
    }

    void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f10787j = true;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void registerAdView(View view) {
        if (this.f10784g) {
            return;
        }
        g.a(view, "AdView is null");
        if (c() == view) {
            return;
        }
        d(view);
        getAdSessionStatePublisher().a();
        c(view);
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f10784g) {
            return;
        }
        this.f10780c.clear();
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f10784g) {
            return;
        }
        a(view);
        e eVarB = b(view);
        if (eVarB != null) {
            this.f10780c.remove(eVarB);
        }
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f10788k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.AdSession
    public void start() {
        if (this.f10783f) {
            return;
        }
        this.f10783f = true;
        c.c().c(this);
        this.f10782e.a(h.c().b());
        this.f10782e.a(com.iab.omid.library.ironsrc.internal.a.a().b());
        this.f10782e.a(this, this.f10778a);
    }

    private static void a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void b() {
        if (this.f10787j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private void c(View view) {
        Collection<a> collectionB = c.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.c() == view) {
                aVar.f10781d.clear();
            }
        }
    }

    private void d(View view) {
        this.f10781d = new com.iab.omid.library.ironsrc.weakreference.a(view);
    }

    private void a(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f10777l.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    public void a(List<com.iab.omid.library.ironsrc.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.ironsrc.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f10788k.onPossibleObstructionsDetected(this.f10785h, arrayList);
        }
    }

    void a(@NonNull JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f10787j = true;
    }
}
