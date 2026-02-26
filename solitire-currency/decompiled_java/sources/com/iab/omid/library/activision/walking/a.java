package com.iab.omid.library.activision.walking;

import android.view.View;
import com.iab.omid.library.activision.internal.e;
import com.iab.omid.library.activision.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f10614a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0232a> f10615b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f10616c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f10617d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f10618e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f10619f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f10620g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashSet<String> f10621h = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<View, Boolean> f10622i = new WeakHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10623j;

    /* JADX INFO: renamed from: com.iab.omid.library.activision.walking.a$a, reason: collision with other inner class name */
    public static class C0232a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f10624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f10625b = new ArrayList<>();

        public C0232a(e eVar, String str) {
            this.f10624a = eVar;
            a(str);
        }

        public e a() {
            return this.f10624a;
        }

        public ArrayList<String> b() {
            return this.f10625b;
        }

        public void a(String str) {
            this.f10625b.add(str);
        }
    }

    public View a(String str) {
        return this.f10616c.get(str);
    }

    public C0232a b(View view) {
        C0232a c0232a = this.f10615b.get(view);
        if (c0232a != null) {
            this.f10615b.remove(view);
        }
        return c0232a;
    }

    public String c(View view) {
        if (this.f10614a.size() == 0) {
            return null;
        }
        String str = this.f10614a.get(view);
        if (str != null) {
            this.f10614a.remove(view);
        }
        return str;
    }

    public c d(View view) {
        return this.f10617d.contains(view) ? c.PARENT_VIEW : this.f10623j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.activision.internal.c cVarC = com.iab.omid.library.activision.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.activision.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        boolean zE = h.e(viewC);
                        if (zE) {
                            this.f10621h.add(adSessionId);
                        }
                        String strA = a(viewC, zE);
                        if (strA == null) {
                            this.f10618e.add(adSessionId);
                            this.f10614a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f10619f.add(adSessionId);
                            this.f10616c.put(adSessionId, viewC);
                            this.f10620g.put(adSessionId, strA);
                        }
                    } else {
                        this.f10619f.add(adSessionId);
                        this.f10620g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    private Boolean a(View view) {
        if (view.hasWindowFocus()) {
            this.f10622i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f10622i.containsKey(view)) {
            return this.f10622i.get(view);
        }
        Map<View, Boolean> map = this.f10622i;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public String b(String str) {
        return this.f10620g.get(str);
    }

    public HashSet<String> c() {
        return this.f10618e;
    }

    public void d() {
        this.f10623j = true;
    }

    public boolean e(View view) {
        if (!this.f10622i.containsKey(view)) {
            return true;
        }
        this.f10622i.put(view, Boolean.TRUE);
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
        this.f10617d.addAll(hashSet);
        return null;
    }

    public HashSet<String> b() {
        return this.f10619f;
    }

    public boolean c(String str) {
        return this.f10621h.contains(str);
    }

    public void a() {
        this.f10614a.clear();
        this.f10615b.clear();
        this.f10616c.clear();
        this.f10617d.clear();
        this.f10618e.clear();
        this.f10619f.clear();
        this.f10620g.clear();
        this.f10623j = false;
        this.f10621h.clear();
    }

    private void a(com.iab.omid.library.activision.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.activision.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0232a c0232a = this.f10615b.get(view);
        if (c0232a != null) {
            c0232a.a(aVar.getAdSessionId());
        } else {
            this.f10615b.put(view, new C0232a(eVar, aVar.getAdSessionId()));
        }
    }
}
