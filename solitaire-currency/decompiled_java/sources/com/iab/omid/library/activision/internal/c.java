package com.iab.omid.library.activision.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f10542c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.activision.adsession.a> f10543a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.activision.adsession.a> f10544b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f10542c;
    }

    public Collection<com.iab.omid.library.activision.adsession.a> a() {
        return Collections.unmodifiableCollection(this.f10544b);
    }

    public Collection<com.iab.omid.library.activision.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f10543a);
    }

    public boolean d() {
        return this.f10544b.size() > 0;
    }

    public void a(com.iab.omid.library.activision.adsession.a aVar) {
        this.f10543a.add(aVar);
    }

    public void b(com.iab.omid.library.activision.adsession.a aVar) {
        boolean zD = d();
        this.f10543a.remove(aVar);
        this.f10544b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        i.c().e();
    }

    public void c(com.iab.omid.library.activision.adsession.a aVar) {
        boolean zD = d();
        this.f10544b.add(aVar);
        if (zD) {
            return;
        }
        i.c().d();
    }
}
