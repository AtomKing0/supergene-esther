package j7;

import android.content.Context;
import android.widget.RelativeLayout;
import com.unity3d.scar.adapter.common.d;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.k;
import com.unity3d.scar.adapter.common.l;
import com.unity3d.scar.adapter.common.m;
import l7.e;
import l7.g;

/* JADX INFO: compiled from: ScarAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k7.a f28761e;

    /* JADX INFO: renamed from: j7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScarAdapter.java */
    class RunnableC0595a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f28762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a7.c f28763b;

        /* JADX INFO: renamed from: j7.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ScarAdapter.java */
        class C0596a implements a7.b {
            C0596a() {
            }

            @Override // a7.b
            public void onAdLoaded() {
                ((k) a.this).f24260b.put(RunnableC0595a.this.f28763b.c(), RunnableC0595a.this.f28762a);
            }
        }

        RunnableC0595a(e eVar, a7.c cVar) {
            this.f28762a = eVar;
            this.f28763b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28762a.b(new C0596a());
        }
    }

    /* JADX INFO: compiled from: ScarAdapter.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f28766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a7.c f28767b;

        /* JADX INFO: renamed from: j7.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ScarAdapter.java */
        class C0597a implements a7.b {
            C0597a() {
            }

            @Override // a7.b
            public void onAdLoaded() {
                ((k) a.this).f24260b.put(b.this.f28767b.c(), b.this.f28766a);
            }
        }

        b(g gVar, a7.c cVar) {
            this.f28766a = gVar;
            this.f28767b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28766a.b(new C0597a());
        }
    }

    /* JADX INFO: compiled from: ScarAdapter.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l7.c f28770a;

        c(l7.c cVar) {
            this.f28770a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28770a.b(null);
        }
    }

    public a(d<m> dVar, String str) {
        super(dVar);
        k7.a aVar = new k7.a(new z6.a(str));
        this.f28761e = aVar;
        this.f24259a = new m7.b(aVar);
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void c(Context context, a7.c cVar, i iVar) {
        l.a(new b(new g(context, this.f28761e, cVar, this.f24262d, iVar), cVar));
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void e(Context context, RelativeLayout relativeLayout, a7.c cVar, int i10, int i11, com.unity3d.scar.adapter.common.g gVar) {
        l.a(new c(new l7.c(context, relativeLayout, this.f28761e, cVar, i10, i11, this.f24262d, gVar)));
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void f(Context context, a7.c cVar, h hVar) {
        l.a(new RunnableC0595a(new e(context, this.f28761e, cVar, this.f24262d, hVar), cVar));
    }
}
