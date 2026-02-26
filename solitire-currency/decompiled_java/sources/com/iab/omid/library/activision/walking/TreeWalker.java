package com.iab.omid.library.activision.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.activision.internal.j;
import com.iab.omid.library.activision.processor.a;
import com.iab.omid.library.activision.utils.f;
import com.iab.omid.library.activision.utils.h;
import com.iab.omid.library.activision.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0230a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f10600i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Handler f10601j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f10602k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Runnable f10603l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f10604m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10606b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10612h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f10605a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10607c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.activision.weakreference.a> f10608d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.activision.walking.a f10610f = new com.iab.omid.library.activision.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.activision.processor.b f10609e = new com.iab.omid.library.activision.processor.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.activision.walking.b f10611g = new com.iab.omid.library.activision.walking.b(new com.iab.omid.library.activision.walking.async.c());

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
            TreeWalker.this.f10611g.b();
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
            if (TreeWalker.f10602k != null) {
                TreeWalker.f10602k.post(TreeWalker.f10603l);
                TreeWalker.f10602k.postDelayed(TreeWalker.f10604m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d() {
        a(f.b() - this.f10612h);
    }

    private void e() {
        this.f10606b = 0;
        this.f10608d.clear();
        this.f10607c = false;
        Iterator<com.iab.omid.library.activision.adsession.a> it = com.iab.omid.library.activision.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f10607c = true;
                break;
            }
        }
        this.f10612h = f.b();
    }

    public static TreeWalker getInstance() {
        return f10600i;
    }

    private void i() {
        if (f10602k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f10602k = handler;
            handler.post(f10603l);
            f10602k.postDelayed(f10604m, 200L);
        }
    }

    private void k() {
        Handler handler = f10602k;
        if (handler != null) {
            handler.removeCallbacks(f10604m);
            f10602k = null;
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
        if (this.f10605a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f10605a.add(treeWalkerTimeLogger);
    }

    @VisibleForTesting
    void f() {
        this.f10610f.e();
        long jB = f.b();
        com.iab.omid.library.activision.processor.a aVarA = this.f10609e.a();
        if (this.f10610f.b().size() > 0) {
            for (String str : this.f10610f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f10610f.a(str), jSONObjectA);
                com.iab.omid.library.activision.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f10611g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f10610f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, com.iab.omid.library.activision.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.activision.utils.c.b(jSONObjectA2);
            this.f10611g.b(jSONObjectA2, this.f10610f.c(), jB);
            if (this.f10607c) {
                Iterator<com.iab.omid.library.activision.adsession.a> it = com.iab.omid.library.activision.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(this.f10608d);
                }
            }
        } else {
            this.f10611g.b();
        }
        this.f10610f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f10605a.clear();
        f10601j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f10605a.contains(treeWalkerTimeLogger)) {
            this.f10605a.remove(treeWalkerTimeLogger);
        }
    }

    private void a(long j10) {
        if (this.f10605a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f10605a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f10606b, TimeUnit.NANOSECONDS.toMillis(j10));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f10606b, j10);
                }
            }
        }
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strC = this.f10610f.c(view);
        if (strC == null) {
            return false;
        }
        com.iab.omid.library.activision.utils.c.a(jSONObject, strC);
        com.iab.omid.library.activision.utils.c.a(jSONObject, Boolean.valueOf(this.f10610f.e(view)));
        com.iab.omid.library.activision.utils.c.b(jSONObject, Boolean.valueOf(this.f10610f.c(strC)));
        this.f10610f.d();
        return true;
    }

    private void a(View view, com.iab.omid.library.activision.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.activision.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.activision.walking.c.PARENT_VIEW, z10);
    }

    @Override // com.iab.omid.library.activision.processor.a.InterfaceC0230a
    public void a(View view, com.iab.omid.library.activision.processor.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.activision.walking.c cVarD;
        if (h.f(view) && (cVarD = this.f10610f.d(view)) != com.iab.omid.library.activision.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.activision.utils.c.a(jSONObject, jSONObjectA);
            if (!b(view, jSONObjectA)) {
                boolean z11 = z10 || a(view, jSONObjectA);
                if (this.f10607c && cVarD == com.iab.omid.library.activision.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f10608d.add(new com.iab.omid.library.activision.weakreference.a(view));
                }
                a(view, aVar, jSONObjectA, cVarD, z11);
            }
            this.f10606b++;
        }
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.activision.processor.a aVarB = this.f10609e.b();
        String strB = this.f10610f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.activision.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.activision.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.activision.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0232a c0232aB = this.f10610f.b(view);
        if (c0232aB == null) {
            return false;
        }
        com.iab.omid.library.activision.utils.c.a(jSONObject, c0232aB);
        return true;
    }
}
