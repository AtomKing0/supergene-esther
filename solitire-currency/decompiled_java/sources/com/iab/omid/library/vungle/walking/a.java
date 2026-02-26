package com.iab.omid.library.vungle.walking;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.vungle.internal.e;
import com.iab.omid.library.vungle.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f11137a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0247a> f11138b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f11139c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f11140d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f11141e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f11142f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f11143g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashSet<String> f11144h = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<View, Boolean> f11145i = new WeakHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11146j;

    /* JADX INFO: renamed from: com.iab.omid.library.vungle.walking.a$a, reason: collision with other inner class name */
    public static class C0247a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f11147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f11148b = new ArrayList<>();

        public C0247a(e eVar, String str) {
            this.f11147a = eVar;
            a(str);
        }

        public e a() {
            return this.f11147a;
        }

        public ArrayList<String> b() {
            return this.f11148b;
        }

        public void a(String str) {
            this.f11148b.add(str);
        }
    }

    public View a(String str) {
        return this.f11139c.get(str);
    }

    public C0247a b(View view) {
        C0247a c0247a = this.f11138b.get(view);
        if (c0247a != null) {
            this.f11138b.remove(view);
        }
        return c0247a;
    }

    public String c(View view) {
        if (this.f11137a.size() == 0) {
            return null;
        }
        String str = this.f11137a.get(view);
        if (str != null) {
            this.f11137a.remove(view);
        }
        return str;
    }

    public c d(View view) {
        return this.f11140d.contains(view) ? c.PARENT_VIEW : this.f11146j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.vungle.internal.c cVarC = com.iab.omid.library.vungle.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.vungle.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        boolean zE = h.e(viewC);
                        if (zE) {
                            this.f11144h.add(adSessionId);
                        }
                        String strA = a(viewC, zE);
                        if (strA == null) {
                            this.f11141e.add(adSessionId);
                            this.f11137a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f11142f.add(adSessionId);
                            this.f11139c.put(adSessionId, viewC);
                            this.f11143g.put(adSessionId, strA);
                        }
                    } else {
                        this.f11142f.add(adSessionId);
                        this.f11143g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    private Boolean a(View view) {
        if (view.hasWindowFocus()) {
            this.f11145i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f11145i.containsKey(view)) {
            return this.f11145i.get(view);
        }
        Map<View, Boolean> map = this.f11145i;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public String b(String str) {
        return this.f11143g.get(str);
    }

    public HashSet<String> c() {
        return this.f11141e;
    }

    public void d() {
        this.f11146j = true;
    }

    public boolean e(View view) {
        if (!this.f11145i.containsKey(view)) {
            return true;
        }
        this.f11145i.put(view, Boolean.TRUE);
        return false;
    }

    private String a(View view, boolean z10) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (a(view).booleanValue() && !z10) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strA = h.a(view);
            if (strA != null) {
                return strA;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f11140d.addAll(hashSet);
        return null;
    }

    public HashSet<String> b() {
        return this.f11142f;
    }

    @VisibleForTesting
    public boolean c(String str) {
        return this.f11144h.contains(str);
    }

    public void a() {
        this.f11137a.clear();
        this.f11138b.clear();
        this.f11139c.clear();
        this.f11140d.clear();
        this.f11141e.clear();
        this.f11142f.clear();
        this.f11143g.clear();
        this.f11146j = false;
        this.f11144h.clear();
    }

    private void a(com.iab.omid.library.vungle.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.vungle.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0247a c0247a = this.f11138b.get(view);
        if (c0247a != null) {
            c0247a.a(aVar.getAdSessionId());
        } else {
            this.f11138b.put(view, new C0247a(eVar, aVar.getAdSessionId()));
        }
    }
}
