package f7;

import android.content.Context;
import android.widget.RelativeLayout;
import com.unity3d.scar.adapter.common.d;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.k;
import com.unity3d.scar.adapter.common.l;
import com.unity3d.scar.adapter.common.m;
import h7.e;
import h7.g;

/* JADX INFO: compiled from: ScarAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g7.a f25719e;

    /* JADX INFO: renamed from: f7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScarAdapter.java */
    class RunnableC0553a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f25720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a7.c f25721b;

        /* JADX INFO: renamed from: f7.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ScarAdapter.java */
        class C0554a implements a7.b {
            C0554a() {
            }

            @Override // a7.b
            public void onAdLoaded() {
                ((k) a.this).f24260b.put(RunnableC0553a.this.f25721b.c(), RunnableC0553a.this.f25720a);
            }
        }

        RunnableC0553a(e eVar, a7.c cVar) {
            this.f25720a = eVar;
            this.f25721b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25720a.b(new C0554a());
        }
    }

    /* JADX INFO: compiled from: ScarAdapter.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f25724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a7.c f25725b;

        /* JADX INFO: renamed from: f7.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ScarAdapter.java */
        class C0555a implements a7.b {
            C0555a() {
            }

            @Override // a7.b
            public void onAdLoaded() {
                ((k) a.this).f24260b.put(b.this.f25725b.c(), b.this.f25724a);
            }
        }

        b(g gVar, a7.c cVar) {
            this.f25724a = gVar;
            this.f25725b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25724a.b(new C0555a());
        }
    }

    /* JADX INFO: compiled from: ScarAdapter.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h7.c f25728a;

        c(h7.c cVar) {
            this.f25728a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25728a.b(null);
        }
    }

    public a(d<m> dVar, String str) {
        super(dVar);
        g7.a aVar = new g7.a(new z6.a(str));
        this.f25719e = aVar;
        this.f24259a = new i7.b(aVar);
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void c(Context context, a7.c cVar, i iVar) {
        l.a(new b(new g(context, this.f25719e, cVar, this.f24262d, iVar), cVar));
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void e(Context context, RelativeLayout relativeLayout, a7.c cVar, int i10, int i11, com.unity3d.scar.adapter.common.g gVar) {
        l.a(new c(new h7.c(context, relativeLayout, this.f25719e, cVar, i10, i11, this.f24262d, gVar)));
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void f(Context context, a7.c cVar, h hVar) {
        l.a(new RunnableC0553a(new e(context, this.f25719e, cVar, this.f24262d, hVar), cVar));
    }
}
