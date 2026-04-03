package c7;

import android.content.Context;
import android.widget.RelativeLayout;
import b7.g;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.d;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.k;
import com.unity3d.scar.adapter.common.l;
import com.unity3d.scar.adapter.common.m;
import d7.e;

/* JADX INFO: compiled from: ScarAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g<QueryInfo> f4601e;

    /* JADX INFO: renamed from: c7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScarAdapter.java */
    class RunnableC0152a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f4602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a7.c f4603b;

        /* JADX INFO: renamed from: c7.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ScarAdapter.java */
        class C0153a implements a7.b {
            C0153a() {
            }

            @Override // a7.b
            public void onAdLoaded() {
                ((k) a.this).f24260b.put(RunnableC0152a.this.f4603b.c(), RunnableC0152a.this.f4602a);
            }
        }

        RunnableC0152a(e eVar, a7.c cVar) {
            this.f4602a = eVar;
            this.f4603b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4602a.b(new C0153a());
        }
    }

    /* JADX INFO: compiled from: ScarAdapter.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d7.g f4606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a7.c f4607b;

        /* JADX INFO: renamed from: c7.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ScarAdapter.java */
        class C0154a implements a7.b {
            C0154a() {
            }

            @Override // a7.b
            public void onAdLoaded() {
                ((k) a.this).f24260b.put(b.this.f4607b.c(), b.this.f4606a);
            }
        }

        b(d7.g gVar, a7.c cVar) {
            this.f4606a = gVar;
            this.f4607b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4606a.b(new C0154a());
        }
    }

    /* JADX INFO: compiled from: ScarAdapter.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d7.c f4610a;

        c(d7.c cVar) {
            this.f4610a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4610a.b(null);
        }
    }

    public a(d<m> dVar) {
        super(dVar);
        g<QueryInfo> gVar = new g<>();
        this.f4601e = gVar;
        this.f24259a = new e7.b(gVar);
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void c(Context context, a7.c cVar, i iVar) {
        l.a(new b(new d7.g(context, this.f4601e.a(cVar.c()), cVar, this.f24262d, iVar), cVar));
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void e(Context context, RelativeLayout relativeLayout, a7.c cVar, int i10, int i11, com.unity3d.scar.adapter.common.g gVar) {
        l.a(new c(new d7.c(context, this.f4601e.a(cVar.c()), relativeLayout, cVar, i10, i11, this.f24262d, gVar)));
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void f(Context context, a7.c cVar, h hVar) {
        l.a(new RunnableC0152a(new e(context, this.f4601e.a(cVar.c()), cVar, this.f24262d, hVar), cVar));
    }
}
