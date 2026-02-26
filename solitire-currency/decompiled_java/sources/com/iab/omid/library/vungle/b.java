package com.iab.omid.library.vungle;

import android.content.Context;
import com.iab.omid.library.vungle.internal.i;
import com.iab.omid.library.vungle.internal.j;
import com.iab.omid.library.vungle.utils.e;
import com.iab.omid.library.vungle.utils.g;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11045a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.5.0-Vungle";
    }

    void c() {
        g.a();
        com.iab.omid.library.vungle.internal.a.a().d();
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.vungle.internal.b.g().a(context);
        com.iab.omid.library.vungle.utils.a.a(context);
        com.iab.omid.library.vungle.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.vungle.internal.g.b().a(context);
        com.iab.omid.library.vungle.internal.a.a().a(context);
        j.b().a(context);
    }

    boolean b() {
        return this.f11045a;
    }

    void a(boolean z10) {
        this.f11045a = z10;
    }
}
