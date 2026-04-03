package com.iab.omid.library.ironsrc.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f10813c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.ironsrc.adsession.a> f10814a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.ironsrc.adsession.a> f10815b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f10813c;
    }

    public Collection<com.iab.omid.library.ironsrc.adsession.a> a() {
        return Collections.unmodifiableCollection(this.f10815b);
    }

    public Collection<com.iab.omid.library.ironsrc.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f10814a);
    }

    public boolean d() {
        return this.f10815b.size() > 0;
    }

    public void a(com.iab.omid.library.ironsrc.adsession.a aVar) {
        this.f10814a.add(aVar);
    }

    public void b(com.iab.omid.library.ironsrc.adsession.a aVar) {
        boolean zD = d();
        this.f10814a.remove(aVar);
        this.f10815b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        h.c().e();
    }

    public void c(com.iab.omid.library.ironsrc.adsession.a aVar) {
        boolean zD = d();
        this.f10815b.add(aVar);
        if (zD) {
            return;
        }
        h.c().d();
    }
}
