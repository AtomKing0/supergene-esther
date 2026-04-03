package com.iab.omid.library.ironsrc.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.ironsrc.processor.a;
import com.iab.omid.library.ironsrc.utils.f;
import com.iab.omid.library.ironsrc.utils.h;
import com.iab.omid.library.ironsrc.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0238a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f10861i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Handler f10862j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f10863k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Runnable f10864l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f10865m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10867b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10873h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f10866a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10868c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.ironsrc.weakreference.a> f10869d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.walking.a f10871f = new com.iab.omid.library.ironsrc.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.processor.b f10870e = new com.iab.omid.library.ironsrc.processor.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.walking.b f10872g = new com.iab.omid.library.ironsrc.walking.b(new com.iab.omid.library.ironsrc.walking.async.c());

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
            TreeWalker.this.f10872g.b();
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
            if (TreeWalker.f10863k != null) {
                TreeWalker.f10863k.post(TreeWalker.f10864l);
                TreeWalker.f10863k.postDelayed(TreeWalker.f10865m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d() {
        a(f.b() - this.f10873h);
    }

    private void e() {
        this.f10867b = 0;
        this.f10869d.clear();
        this.f10868c = false;
        Iterator<com.iab.omid.library.ironsrc.adsession.a> it = com.iab.omid.library.ironsrc.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f10868c = true;
                break;
            }
        }
        this.f10873h = f.b();
    }

    public static TreeWalker getInstance() {
        return f10861i;
    }

    private void i() {
        if (f10863k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f10863k = handler;
            handler.post(f10864l);
            f10863k.postDelayed(f10865m, 200L);
        }
    }

    private void k() {
        Handler handler = f10863k;
        if (handler != null) {
            handler.removeCallbacks(f10865m);
            f10863k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f10866a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f10866a.add(treeWalkerTimeLogger);
    }

    @VisibleForTesting
    void f() {
        this.f10871f.e();
        long jB = f.b();
        com.iab.omid.library.ironsrc.processor.a aVarA = this.f10870e.a();
        if (this.f10871f.b().size() > 0) {
            for (String str : this.f10871f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f10871f.a(str), jSONObjectA);
                com.iab.omid.library.ironsrc.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f10872g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f10871f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, com.iab.omid.library.ironsrc.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.ironsrc.utils.c.b(jSONObjectA2);
            this.f10872g.b(jSONObjectA2, this.f10871f.c(), jB);
            if (this.f10868c) {
                Iterator<com.iab.omid.library.ironsrc.adsession.a> it = com.iab.omid.library.ironsrc.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(this.f10869d);
                }
            }
        } else {
            this.f10872g.b();
        }
        this.f10871f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f10866a.clear();
        f10862j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f10866a.contains(treeWalkerTimeLogger)) {
            this.f10866a.remove(treeWalkerTimeLogger);
        }
    }

    private void a(long j10) {
        if (this.f10866a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f10866a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f10867b, TimeUnit.NANOSECONDS.toMillis(j10));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f10867b, j10);
                }
            }
        }
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strD = this.f10871f.d(view);
        if (strD == null) {
            return false;
        }
        com.iab.omid.library.ironsrc.utils.c.a(jSONObject, strD);
        com.iab.omid.library.ironsrc.utils.c.a(jSONObject, Boolean.valueOf(this.f10871f.f(view)));
        this.f10871f.d();
        return true;
    }

    private void a(View view, com.iab.omid.library.ironsrc.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.ironsrc.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.ironsrc.walking.c.PARENT_VIEW, z10);
    }

    @Override // com.iab.omid.library.ironsrc.processor.a.InterfaceC0238a
    public void a(View view, com.iab.omid.library.ironsrc.processor.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.ironsrc.walking.c cVarE;
        if (h.d(view) && (cVarE = this.f10871f.e(view)) != com.iab.omid.library.ironsrc.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.ironsrc.utils.c.a(jSONObject, jSONObjectA);
            if (!b(view, jSONObjectA)) {
                boolean z11 = z10 || a(view, jSONObjectA);
                if (this.f10868c && cVarE == com.iab.omid.library.ironsrc.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f10869d.add(new com.iab.omid.library.ironsrc.weakreference.a(view));
                }
                a(view, aVar, jSONObjectA, cVarE, z11);
            }
            this.f10867b++;
        }
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.ironsrc.processor.a aVarB = this.f10870e.b();
        String strB = this.f10871f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.ironsrc.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.ironsrc.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.ironsrc.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0239a c0239aC = this.f10871f.c(view);
        if (c0239aC == null) {
            return false;
        }
        com.iab.omid.library.ironsrc.utils.c.a(jSONObject, c0239aC);
        return true;
    }
}
