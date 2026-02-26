package com.iab.omid.library.unity3d.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.unity3d.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f10931f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.unity3d.utils.f f10932a = new com.iab.omid.library.unity3d.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f10933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f10935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10936e;

    private a(d dVar) {
        this.f10935d = dVar;
    }

    public static a a() {
        return f10931f;
    }

    private void c() {
        if (!this.f10934c || this.f10933b == null) {
            return;
        }
        Iterator<com.iab.omid.library.unity3d.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f10933b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f10932a.a();
        Date date = this.f10933b;
        if (date == null || dateA.after(date)) {
            this.f10933b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f10934c) {
            return;
        }
        this.f10935d.a(context);
        this.f10935d.a(this);
        this.f10935d.e();
        this.f10936e = this.f10935d.c();
        this.f10934c = true;
    }

    @Override // com.iab.omid.library.unity3d.internal.d.a
    public void a(boolean z10) {
        if (!this.f10936e && z10) {
            d();
        }
        this.f10936e = z10;
    }
}
