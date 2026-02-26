package com.iab.omid.library.activision;

import android.content.Context;
import com.iab.omid.library.activision.internal.i;
import com.iab.omid.library.activision.internal.j;
import com.iab.omid.library.activision.utils.e;
import com.iab.omid.library.activision.utils.g;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10522a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.5.2-Activision";
    }

    void c() {
        g.a();
        com.iab.omid.library.activision.internal.a.a().d();
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.activision.internal.b.g().a(context);
        com.iab.omid.library.activision.utils.a.a(context);
        com.iab.omid.library.activision.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.activision.internal.g.b().a(context);
        com.iab.omid.library.activision.internal.a.a().a(context);
        j.b().a(context);
    }

    boolean b() {
        return this.f10522a;
    }

    void a(boolean z10) {
        this.f10522a = z10;
    }
}
