package com.iab.omid.library.activision.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.activision.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f10535f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.activision.utils.f f10536a = new com.iab.omid.library.activision.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f10537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f10539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10540e;

    private a(d dVar) {
        this.f10539d = dVar;
    }

    public static a a() {
        return f10535f;
    }

    private void c() {
        if (!this.f10538c || this.f10537b == null) {
            return;
        }
        Iterator<com.iab.omid.library.activision.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f10537b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f10536a.a();
        Date date = this.f10537b;
        if (date == null || dateA.after(date)) {
            this.f10537b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f10538c) {
            return;
        }
        this.f10539d.a(context);
        this.f10539d.a(this);
        this.f10539d.e();
        this.f10540e = this.f10539d.c();
        this.f10538c = true;
    }

    @Override // com.iab.omid.library.activision.internal.d.a
    public void a(boolean z10) {
        if (!this.f10540e && z10) {
            d();
        }
        this.f10540e = z10;
    }
}
