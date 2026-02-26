package com.iab.omid.library.unity3d.walking;

import android.view.View;
import com.iab.omid.library.unity3d.internal.e;
import com.iab.omid.library.unity3d.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f11003a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0243a> f11004b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f11005c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f11006d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f11007e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f11008f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f11009g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<View, Boolean> f11010h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11011i;

    /* JADX INFO: renamed from: com.iab.omid.library.unity3d.walking.a$a, reason: collision with other inner class name */
    public static class C0243a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f11012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f11013b = new ArrayList<>();

        public C0243a(e eVar, String str) {
            this.f11012a = eVar;
            a(str);
        }

        public e a() {
            return this.f11012a;
        }

        public ArrayList<String> b() {
            return this.f11013b;
        }

        public void a(String str) {
            this.f11013b.add(str);
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f11010h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f11010h.containsKey(view)) {
            return this.f11010h.get(view);
        }
        Map<View, Boolean> map = this.f11010h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public View a(String str) {
        return this.f11005c.get(str);
    }

    public C0243a c(View view) {
        C0243a c0243a = this.f11004b.get(view);
        if (c0243a != null) {
            this.f11004b.remove(view);
        }
        return c0243a;
    }

    public String d(View view) {
        if (this.f11003a.size() == 0) {
            return null;
        }
        String str = this.f11003a.get(view);
        if (str != null) {
            this.f11003a.remove(view);
        }
        return str;
    }

    public c e(View view) {
        return this.f11006d.contains(view) ? c.PARENT_VIEW : this.f11011i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public boolean f(View view) {
        if (!this.f11010h.containsKey(view)) {
            return true;
        }
        this.f11010h.put(view, Boolean.TRUE);
        return false;
    }

    private String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue()) {
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
        this.f11006d.addAll(hashSet);
        return null;
    }

    public String b(String str) {
        return this.f11009g.get(str);
    }

    public HashSet<String> c() {
        return this.f11007e;
    }

    public void d() {
        this.f11011i = true;
    }

    public void e() {
        com.iab.omid.library.unity3d.internal.c cVarC = com.iab.omid.library.unity3d.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.unity3d.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        String strA = a(viewC);
                        if (strA == null) {
                            this.f11007e.add(adSessionId);
                            this.f11003a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f11008f.add(adSessionId);
                            this.f11005c.put(adSessionId, viewC);
                            this.f11009g.put(adSessionId, strA);
                        }
                    } else {
                        this.f11008f.add(adSessionId);
                        this.f11009g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void a() {
        this.f11003a.clear();
        this.f11004b.clear();
        this.f11005c.clear();
        this.f11006d.clear();
        this.f11007e.clear();
        this.f11008f.clear();
        this.f11009g.clear();
        this.f11011i = false;
    }

    public HashSet<String> b() {
        return this.f11008f;
    }

    private void a(com.iab.omid.library.unity3d.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.unity3d.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0243a c0243a = this.f11004b.get(view);
        if (c0243a != null) {
            c0243a.a(aVar.getAdSessionId());
        } else {
            this.f11004b.put(view, new C0243a(eVar, aVar.getAdSessionId()));
        }
    }
}
