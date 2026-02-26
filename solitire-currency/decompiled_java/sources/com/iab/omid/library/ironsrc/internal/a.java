package com.iab.omid.library.ironsrc.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.ironsrc.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f10806f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.ironsrc.utils.f f10807a = new com.iab.omid.library.ironsrc.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f10808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f10810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10811e;

    private a(d dVar) {
        this.f10810d = dVar;
    }

    public static a a() {
        return f10806f;
    }

    private void c() {
        if (!this.f10809c || this.f10808b == null) {
            return;
        }
        Iterator<com.iab.omid.library.ironsrc.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f10808b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f10807a.a();
        Date date = this.f10808b;
        if (date == null || dateA.after(date)) {
            this.f10808b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f10809c) {
            return;
        }
        this.f10810d.a(context);
        this.f10810d.a(this);
        this.f10810d.e();
        this.f10811e = this.f10810d.c();
        this.f10809c = true;
    }

    @Override // com.iab.omid.library.ironsrc.internal.d.a
    public void a(boolean z10) {
        if (!this.f10811e && z10) {
            d();
        }
        this.f10811e = z10;
    }
}
