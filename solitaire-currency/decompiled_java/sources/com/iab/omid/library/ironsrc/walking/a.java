package com.iab.omid.library.ironsrc.walking;

import android.view.View;
import com.iab.omid.library.ironsrc.internal.e;
import com.iab.omid.library.ironsrc.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f10875a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0239a> f10876b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f10877c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f10878d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<String> f10879e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f10880f = new HashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f10881g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<View, Boolean> f10882h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10883i;

    /* JADX INFO: renamed from: com.iab.omid.library.ironsrc.walking.a$a, reason: collision with other inner class name */
    public static class C0239a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f10884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f10885b = new ArrayList<>();

        public C0239a(e eVar, String str) {
            this.f10884a = eVar;
            a(str);
        }

        public e a() {
            return this.f10884a;
        }

        public ArrayList<String> b() {
            return this.f10885b;
        }

        public void a(String str) {
            this.f10885b.add(str);
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.f10882h.remove(view);
            return Boolean.FALSE;
        }
        if (this.f10882h.containsKey(view)) {
            return this.f10882h.get(view);
        }
        Map<View, Boolean> map = this.f10882h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public View a(String str) {
        return this.f10877c.get(str);
    }

    public C0239a c(View view) {
        C0239a c0239a = this.f10876b.get(view);
        if (c0239a != null) {
            this.f10876b.remove(view);
        }
        return c0239a;
    }

    public String d(View view) {
        if (this.f10875a.size() == 0) {
            return null;
        }
        String str = this.f10875a.get(view);
        if (str != null) {
            this.f10875a.remove(view);
        }
        return str;
    }

    public c e(View view) {
        return this.f10878d.contains(view) ? c.PARENT_VIEW : this.f10883i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public boolean f(View view) {
        if (!this.f10882h.containsKey(view)) {
            return true;
        }
        this.f10882h.put(view, Boolean.TRUE);
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
        this.f10878d.addAll(hashSet);
        return null;
    }

    public String b(String str) {
        return this.f10881g.get(str);
    }

    public HashSet<String> c() {
        return this.f10879e;
    }

    public void d() {
        this.f10883i = true;
    }

    public void e() {
        com.iab.omid.library.ironsrc.internal.c cVarC = com.iab.omid.library.ironsrc.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.ironsrc.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        String strA = a(viewC);
                        if (strA == null) {
                            this.f10879e.add(adSessionId);
                            this.f10875a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f10880f.add(adSessionId);
                            this.f10877c.put(adSessionId, viewC);
                            this.f10881g.put(adSessionId, strA);
                        }
                    } else {
                        this.f10880f.add(adSessionId);
                        this.f10881g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void a() {
        this.f10875a.clear();
        this.f10876b.clear();
        this.f10877c.clear();
        this.f10878d.clear();
        this.f10879e.clear();
        this.f10880f.clear();
        this.f10881g.clear();
        this.f10883i = false;
    }

    public HashSet<String> b() {
        return this.f10880f;
    }

    private void a(com.iab.omid.library.ironsrc.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.ironsrc.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0239a c0239a = this.f10876b.get(view);
        if (c0239a != null) {
            c0239a.a(aVar.getAdSessionId());
        } else {
            this.f10876b.put(view, new C0239a(eVar, aVar.getAdSessionId()));
        }
    }
}
