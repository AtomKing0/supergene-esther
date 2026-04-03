package com.iab.omid.library.vungle.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.vungle.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f11058f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.vungle.utils.f f11059a = new com.iab.omid.library.vungle.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f11060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f11062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11063e;

    private a(d dVar) {
        this.f11062d = dVar;
    }

    public static a a() {
        return f11058f;
    }

    private void c() {
        if (!this.f11061c || this.f11060b == null) {
            return;
        }
        Iterator<com.iab.omid.library.vungle.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f11060b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f11059a.a();
        Date date = this.f11060b;
        if (date == null || dateA.after(date)) {
            this.f11060b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f11061c) {
            return;
        }
        this.f11062d.a(context);
        this.f11062d.a(this);
        this.f11062d.e();
        this.f11063e = this.f11062d.c();
        this.f11061c = true;
    }

    @Override // com.iab.omid.library.vungle.internal.d.a
    public void a(boolean z10) {
        if (!this.f11063e && z10) {
            d();
        }
        this.f11063e = z10;
    }
}
