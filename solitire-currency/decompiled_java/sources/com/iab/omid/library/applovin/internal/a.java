package com.iab.omid.library.applovin.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.applovin.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f10670f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.applovin.utils.f f10671a = new com.iab.omid.library.applovin.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f10672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f10674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10675e;

    private a(d dVar) {
        this.f10674d = dVar;
    }

    public static a a() {
        return f10670f;
    }

    private void c() {
        if (!this.f10673c || this.f10672b == null) {
            return;
        }
        Iterator<com.iab.omid.library.applovin.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().d().a(b());
        }
    }

    public Date b() {
        Date date = this.f10672b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f10671a.a();
        Date date = this.f10672b;
        if (date == null || dateA.after(date)) {
            this.f10672b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f10673c) {
            return;
        }
        this.f10674d.a(context);
        this.f10674d.a(this);
        this.f10674d.e();
        this.f10675e = this.f10674d.c();
        this.f10673c = true;
    }

    @Override // com.iab.omid.library.applovin.internal.d.a
    public void a(boolean z10) {
        if (!this.f10675e && z10) {
            d();
        }
        this.f10675e = z10;
    }
}
