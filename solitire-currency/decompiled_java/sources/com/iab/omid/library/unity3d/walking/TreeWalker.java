package com.iab.omid.library.unity3d.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.unity3d.processor.a;
import com.iab.omid.library.unity3d.utils.f;
import com.iab.omid.library.unity3d.utils.h;
import com.iab.omid.library.unity3d.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TreeWalker implements a.InterfaceC0241a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f10989i = new TreeWalker();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Handler f10990j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f10991k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Runnable f10992l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Runnable f10993m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10995b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f11001h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f10994a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10996c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.unity3d.weakreference.a> f10997d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.unity3d.walking.a f10999f = new com.iab.omid.library.unity3d.walking.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.iab.omid.library.unity3d.processor.b f10998e = new com.iab.omid.library.unity3d.processor.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.iab.omid.library.unity3d.walking.b f11000g = new com.iab.omid.library.unity3d.walking.b(new com.iab.omid.library.unity3d.walking.async.c());

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
            TreeWalker.this.f11000g.b();
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
            if (TreeWalker.f10991k != null) {
                TreeWalker.f10991k.post(TreeWalker.f10992l);
                TreeWalker.f10991k.postDelayed(TreeWalker.f10993m, 200L);
            }
        }
    }

    TreeWalker() {
    }

    private void d() {
        a(f.b() - this.f11001h);
    }

    private void e() {
        this.f10995b = 0;
        this.f10997d.clear();
        this.f10996c = false;
        Iterator<com.iab.omid.library.unity3d.adsession.a> it = com.iab.omid.library.unity3d.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f10996c = true;
                break;
            }
        }
        this.f11001h = f.b();
    }

    public static TreeWalker getInstance() {
        return f10989i;
    }

    private void i() {
        if (f10991k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f10991k = handler;
            handler.post(f10992l);
            f10991k.postDelayed(f10993m, 200L);
        }
    }

    private void k() {
        Handler handler = f10991k;
        if (handler != null) {
            handler.removeCallbacks(f10993m);
            f10991k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f10994a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f10994a.add(treeWalkerTimeLogger);
    }

    @VisibleForTesting
    void f() {
        this.f10999f.e();
        long jB = f.b();
        com.iab.omid.library.unity3d.processor.a aVarA = this.f10998e.a();
        if (this.f10999f.b().size() > 0) {
            for (String str : this.f10999f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f10999f.a(str), jSONObjectA);
                com.iab.omid.library.unity3d.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.f11000g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f10999f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, com.iab.omid.library.unity3d.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.unity3d.utils.c.b(jSONObjectA2);
            this.f11000g.b(jSONObjectA2, this.f10999f.c(), jB);
            if (this.f10996c) {
                Iterator<com.iab.omid.library.unity3d.adsession.a> it = com.iab.omid.library.unity3d.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(this.f10997d);
                }
            }
        } else {
            this.f11000g.b();
        }
        this.f10999f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f10994a.clear();
        f10990j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f10994a.contains(treeWalkerTimeLogger)) {
            this.f10994a.remove(treeWalkerTimeLogger);
        }
    }

    private void a(long j10) {
        if (this.f10994a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f10994a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f10995b, TimeUnit.NANOSECONDS.toMillis(j10));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f10995b, j10);
                }
            }
        }
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strD = this.f10999f.d(view);
        if (strD == null) {
            return false;
        }
        com.iab.omid.library.unity3d.utils.c.a(jSONObject, strD);
        com.iab.omid.library.unity3d.utils.c.a(jSONObject, Boolean.valueOf(this.f10999f.f(view)));
        this.f10999f.d();
        return true;
    }

    private void a(View view, com.iab.omid.library.unity3d.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.unity3d.walking.c cVar, boolean z10) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.unity3d.walking.c.PARENT_VIEW, z10);
    }

    @Override // com.iab.omid.library.unity3d.processor.a.InterfaceC0241a
    public void a(View view, com.iab.omid.library.unity3d.processor.a aVar, JSONObject jSONObject, boolean z10) {
        com.iab.omid.library.unity3d.walking.c cVarE;
        if (h.d(view) && (cVarE = this.f10999f.e(view)) != com.iab.omid.library.unity3d.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.unity3d.utils.c.a(jSONObject, jSONObjectA);
            if (!b(view, jSONObjectA)) {
                boolean z11 = z10 || a(view, jSONObjectA);
                if (this.f10996c && cVarE == com.iab.omid.library.unity3d.walking.c.OBSTRUCTION_VIEW && !z11) {
                    this.f10997d.add(new com.iab.omid.library.unity3d.weakreference.a(view));
                }
                a(view, aVar, jSONObjectA, cVarE, z11);
            }
            this.f10995b++;
        }
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.unity3d.processor.a aVarB = this.f10998e.b();
        String strB = this.f10999f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.unity3d.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.unity3d.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.unity3d.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0243a c0243aC = this.f10999f.c(view);
        if (c0243aC == null) {
            return false;
        }
        com.iab.omid.library.unity3d.utils.c.a(jSONObject, c0243aC);
        return true;
    }
}
