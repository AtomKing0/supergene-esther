package com.iab.omid.library.applovin.walking;

import android.view.View;
import com.iab.omid.library.applovin.internal.e;
import com.iab.omid.library.applovin.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f10749a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0236a> f10750b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f10751c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f10752d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f10753e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f10754f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f10755g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashSet<String> f10756h = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<View, Boolean> f10757i = new WeakHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10758j;

    /* JADX INFO: renamed from: com.iab.omid.library.applovin.walking.a$a, reason: collision with other inner class name */
    public static class C0236a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f10759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f10760b = new ArrayList<>();

        public C0236a(e eVar, String str) {
            this.f10759a = eVar;
            a(str);
        }

        public e a() {
            return this.f10759a;
        }

        public ArrayList<String> b() {
            return this.f10760b;
        }

        public void a(String str) {
            this.f10760b.add(str);
        }
    }

    public View a(String str) {
        return this.f10751c.get(str);
    }

    public C0236a b(View view) {
        C0236a c0236a = this.f10750b.get(view);
        if (c0236a != null) {
            this.f10750b.remove(view);
        }
        return c0236a;
    }

    public String c(View view) {
        if (this.f10749a.size() == 0) {
            return null;
        }
        String str = this.f10749a.get(view);
        if (str != null) {
            this.f10749a.remove(view);
        }
        return str;
    }

    public c d(View view) {
        return this.f10752d.contains(view) ? c.PARENT_VIEW : this.f10758j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.applovin.internal.c cVarC = com.iab.omid.library.applovin.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.applovin.adsession.a aVar : cVarC.a()) {
                View viewE = aVar.e();
                if (aVar.h()) {
                    String strC = aVar.c();
                    if (viewE != null) {
                        boolean zE = h.e(viewE);
                        if (zE) {
                            this.f10756h.add(strC);
                        }
                        String strA = a(viewE, zE);
                        if (strA == null) {
                            this.f10753e.add(strC);
                            this.f10749a.put(viewE, strC);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f10754f.add(strC);
                            this.f10751c.put(strC, viewE);
                            this.f10755g.put(strC, strA);
                        }
                    } else {
                        this.f10754f.add(strC);
                        this.f10755g.put(strC, "noAdView");
                    }
                }
            }
        }
    }

    private Boolean a(View view) {
        if (view.hasWindowFocus()) {
            this.f10757i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f10757i.containsKey(view)) {
            return this.f10757i.get(view);
        }
        Map<View, Boolean> map = this.f10757i;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public String b(String str) {
        return this.f10755g.get(str);
    }

    public HashSet<String> c() {
        return this.f10753e;
    }

    public void d() {
        this.f10758j = true;
    }

    public boolean e(View view) {
        if (!this.f10757i.containsKey(view)) {
            return true;
        }
        this.f10757i.put(view, Boolean.TRUE);
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
        this.f10752d.addAll(hashSet);
        return null;
    }

    public HashSet<String> b() {
        return this.f10754f;
    }

    public boolean c(String str) {
        return this.f10756h.contains(str);
    }

    public void a() {
        this.f10749a.clear();
        this.f10750b.clear();
        this.f10751c.clear();
        this.f10752d.clear();
        this.f10753e.clear();
        this.f10754f.clear();
        this.f10755g.clear();
        this.f10758j = false;
        this.f10756h.clear();
    }

    private void a(com.iab.omid.library.applovin.adsession.a aVar) {
        Iterator<e> it = aVar.f().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.applovin.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0236a c0236a = this.f10750b.get(view);
        if (c0236a != null) {
            c0236a.a(aVar.c());
        } else {
            this.f10750b.put(view, new C0236a(eVar, aVar.c()));
        }
    }
}
