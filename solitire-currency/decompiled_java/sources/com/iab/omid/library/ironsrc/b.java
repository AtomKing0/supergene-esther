package com.iab.omid.library.ironsrc;

import android.content.Context;
import com.iab.omid.library.ironsrc.internal.f;
import com.iab.omid.library.ironsrc.internal.h;
import com.iab.omid.library.ironsrc.utils.e;
import com.iab.omid.library.ironsrc.utils.g;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10793a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.4.2-Ironsrc";
    }

    void c() {
        g.a();
        com.iab.omid.library.ironsrc.internal.a.a().d();
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        h.c().a(context);
        com.iab.omid.library.ironsrc.internal.b.g().a(context);
        com.iab.omid.library.ironsrc.utils.a.a(context);
        com.iab.omid.library.ironsrc.utils.c.a(context);
        e.a(context);
        f.b().a(context);
        com.iab.omid.library.ironsrc.internal.a.a().a(context);
    }

    boolean b() {
        return this.f10793a;
    }

    void a(boolean z10) {
        this.f10793a = z10;
    }
}
