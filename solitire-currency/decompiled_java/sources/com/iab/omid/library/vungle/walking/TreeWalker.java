package com.iab.omid.library.vungle.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.vungle.internal.j;
import com.iab.omid.library.vungle.processor.a;
import com.iab.omid.library.vungle.utils.f;
import com.iab.omid.library.vungle.utils.h;
import com.iab.omid.library.vungle.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0245a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f11123i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Handler f11124j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f11125k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Runnable f11126l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f11127m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11129b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f11135h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f11128a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11130c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.vungle.weakreference.a> f11131d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.vungle.walking.a f11133f = new com.iab.omid.library.vungle.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.vungle.processor.b f11132e = new com.iab.omid.library.vungle.processor.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.vungle.walking.b f11134g = new com.iab.omid.library.vungle.walking.b(new com.iab.omid.library.vungle.walking.async.c());

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i10, long j10);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i10, long j10);
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f11134g.b();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f11125k != null) {
                TreeWalker.f11125k.post(TreeWalker.f11126l);
                TreeWalker.f11125k.postDelayed(TreeWalker.f11127m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d() {
        a(f.b() - this.f11135h);
    }

    private void e() {
        this.f11129b = 0;
        this.f11131d.clear();
        this.f11130c = false;
        Iterator<com.iab.omid.library.vungle.adsession.a> it = com.iab.omid.library.vungle.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f11130c = true;
                break;
            }
        }
        this.f11135h = f.b();
    }

    public static TreeWalker getInstance() {
        return f11123i;
    }

    private void i() {
        if (f11125k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f11125k = handler;
            handler.post(f11126l);
            f11125k.postDelayed(f11127m, 200L);
        }
    }

    private void k() {
        Handler handler = f11125k;
        if (handler != null) {
            handler.removeCallbacks(f11127m);
            f11125k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
        j.b().a();
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f11128a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f11128a.add(treeWalkerTimeLogger);
    }

    @VisibleForTesting
    void f() {
        this.f11133f.e();
        long jB = f.b();
        com.iab.omid.library.vungle.processor.a aVarA = this.f11132e.a();
        if (this.f11133f.b().size() > 0) {
            for (String str : this.f11133f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f11133f.a(str), jSONObjectA);
                com.iab.omid.library.vungle.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f11134g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f11133f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, com.iab.omid.library.vungle.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.vungle.utils.c.b(jSONObjectA2);
            this.f11134g.b(jSONObjectA2, this.f11133f.c(), jB);
            if (this.f11130c) {
                Iterator<com.iab.omid.library.vungle.adsession.a> it = com.iab.omid.library.vungle.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(this.f11131d);
                }
            }
        } else {
            this.f11134g.b();
        }
        this.f11133f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f11128a.clear();
        f11124j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f11128a.contains(treeWalkerTimeLogger)) {
            this.f11128a.remove(treeWalkerTimeLogger);
        }
    }

    private void a(long j10) {
        if (this.f11128a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f11128a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f11129b, TimeUnit.NANOSECONDS.toMillis(j10));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f11129b, j10);
                }
            }
        }
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strC = this.f11133f.c(view);
        if (strC == null) {
            return false;
        }
        com.iab.omid.library.vungle.utils.c.a(jSONObject, strC);
        com.iab.omid.library.vungle.utils.c.a(jSONObject, Boolean.valueOf(this.f11133f.e(view)));
        com.iab.omid.library.vungle.utils.c.b(jSONObject, Boolean.valueOf(this.f11133f.c(strC)));
        this.f11133f.d();
        return true;
    }

    private void a(View view, com.iab.omid.library.vungle.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.vungle.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.vungle.walking.c.PARENT_VIEW, z10);
    }

    @Override // com.iab.omid.library.vungle.processor.a.InterfaceC0245a
    public void a(View view, com.iab.omid.library.vungle.processor.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.vungle.walking.c cVarD;
        if (h.f(view) && (cVarD = this.f11133f.d(view)) != com.iab.omid.library.vungle.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.vungle.utils.c.a(jSONObject, jSONObjectA);
            if (!b(view, jSONObjectA)) {
                boolean z11 = z10 || a(view, jSONObjectA);
                if (this.f11130c && cVarD == com.iab.omid.library.vungle.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f11131d.add(new com.iab.omid.library.vungle.weakreference.a(view));
                }
                a(view, aVar, jSONObjectA, cVarD, z11);
            }
            this.f11129b++;
        }
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.vungle.processor.a aVarB = this.f11132e.b();
        String strB = this.f11133f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.vungle.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.vungle.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.vungle.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0247a c0247aB = this.f11133f.b(view);
        if (c0247aB == null) {
            return false;
        }
        com.iab.omid.library.vungle.utils.c.a(jSONObject, c0247aB);
        return true;
    }
}
