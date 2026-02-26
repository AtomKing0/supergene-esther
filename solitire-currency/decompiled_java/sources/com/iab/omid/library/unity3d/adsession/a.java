package com.iab.omid.library.unity3d.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.unity3d.internal.c;
import com.iab.omid.library.unity3d.internal.e;
import com.iab.omid.library.unity3d.internal.h;
import com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher;
import com.iab.omid.library.unity3d.publisher.b;
import com.iab.omid.library.unity3d.utils.g;
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
    private static final Pattern f10902l = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f10903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f10904b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.unity3d.weakreference.a f10906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AdSessionStatePublisher f10907e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PossibleObstructionListener f10913k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<e> f10905c = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10908f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10909g = false;

    a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f10904b = adSessionConfiguration;
        this.f10903a = adSessionContext;
        String string = UUID.randomUUID().toString();
        this.f10910h = string;
        d(null);
        this.f10907e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.unity3d.publisher.a(string, adSessionContext.getWebView()) : new b(string, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.f10907e.i();
        c.c().a(this);
        this.f10907e.a(adSessionConfiguration);
    }

    private void a() {
        if (this.f10911i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private e b(View view) {
        for (e eVar : this.f10905c) {
            if (eVar.c().get() == view) {
                return eVar;
            }
        }
        return null;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f10909g) {
            return;
        }
        a(view);
        a(str);
        if (b(view) == null) {
            this.f10905c.add(new e(view, friendlyObstructionPurpose, str));
        }
    }

    public View c() {
        return this.f10906d.get();
    }

    public List<e> d() {
        return this.f10905c;
    }

    public boolean e() {
        return this.f10913k != null;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.f10909g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        getAdSessionStatePublisher().a(errorType, str);
    }

    public boolean f() {
        return this.f10908f && !this.f10909g;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void finish() {
        if (this.f10909g) {
            return;
        }
        this.f10906d.clear();
        removeAllFriendlyObstructions();
        this.f10909g = true;
        getAdSessionStatePublisher().f();
        c.c().b(this);
        getAdSessionStatePublisher().b();
        this.f10907e = null;
        this.f10913k = null;
    }

    public boolean g() {
        return this.f10909g;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public String getAdSessionId() {
        return this.f10910h;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f10907e;
    }

    public boolean h() {
        return this.f10904b.isNativeImpressionOwner();
    }

    public boolean i() {
        return this.f10904b.isNativeMediaEventsOwner();
    }

    public boolean j() {
        return this.f10908f;
    }

    void k() {
        a();
        getAdSessionStatePublisher().g();
        this.f10911i = true;
    }

    void l() {
        b();
        getAdSessionStatePublisher().h();
        this.f10912j = true;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void registerAdView(View view) {
        if (this.f10909g) {
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

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.f10909g) {
            return;
        }
        this.f10905c.clear();
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.f10909g) {
            return;
        }
        a(view);
        e eVarB = b(view);
        if (eVarB != null) {
            this.f10905c.remove(eVarB);
        }
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.f10913k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.unity3d.adsession.AdSession
    public void start() {
        if (this.f10908f) {
            return;
        }
        this.f10908f = true;
        c.c().c(this);
        this.f10907e.a(h.c().b());
        this.f10907e.a(com.iab.omid.library.unity3d.internal.a.a().b());
        this.f10907e.a(this, this.f10903a);
    }

    private static void a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void b() {
        if (this.f10912j) {
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
                aVar.f10906d.clear();
            }
        }
    }

    private void d(View view) {
        this.f10906d = new com.iab.omid.library.unity3d.weakreference.a(view);
    }

    private void a(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f10902l.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    public void a(List<com.iab.omid.library.unity3d.weakreference.a> list) {
        if (e()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.unity3d.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f10913k.onPossibleObstructionsDetected(this.f10910h, arrayList);
        }
    }

    void a(@NonNull JSONObject jSONObject) {
        b();
        getAdSessionStatePublisher().a(jSONObject);
        this.f10912j = true;
    }
}
