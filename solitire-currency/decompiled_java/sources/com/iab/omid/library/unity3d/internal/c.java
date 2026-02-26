package com.iab.omid.library.unity3d.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f10938c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.unity3d.adsession.a> f10939a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.unity3d.adsession.a> f10940b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return f10938c;
    }

    public Collection<com.iab.omid.library.unity3d.adsession.a> a() {
        return Collections.unmodifiableCollection(this.f10940b);
    }

    public Collection<com.iab.omid.library.unity3d.adsession.a> b() {
        return Collections.unmodifiableCollection(this.f10939a);
    }

    public boolean d() {
        return this.f10940b.size() > 0;
    }

    public void a(com.iab.omid.library.unity3d.adsession.a aVar) {
        this.f10939a.add(aVar);
    }

    public void b(com.iab.omid.library.unity3d.adsession.a aVar) {
        boolean zD = d();
        this.f10939a.remove(aVar);
        this.f10940b.remove(aVar);
        if (!zD || d()) {
            return;
        }
        h.c().e();
    }

    public void c(com.iab.omid.library.unity3d.adsession.a aVar) {
        boolean zD = d();
        this.f10940b.add(aVar);
        if (zD) {
            return;
        }
        h.c().d();
    }
}
