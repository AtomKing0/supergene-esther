package f1;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import o1.k;
import r0.l;

/* JADX INFO: compiled from: GifFrameLoader.java */
/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q0.a f25557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f25558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f25559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.j f25560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v0.d f25561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f25562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f25563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f25564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.i<Bitmap> f25565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f25566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f25567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f25568l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f25569m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private l<Bitmap> f25570n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f25571o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f25572p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f25573q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f25574r;

    /* JADX INFO: compiled from: GifFrameLoader.java */
    @VisibleForTesting
    static class a extends l1.c<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f25575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f25576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f25577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bitmap f25578g;

        a(Handler handler, int i10, long j10) {
            this.f25575d = handler;
            this.f25576e = i10;
            this.f25577f = j10;
        }

        @Override // l1.h
        public void d(@Nullable Drawable drawable) {
            this.f25578g = null;
        }

        Bitmap h() {
            return this.f25578g;
        }

        @Override // l1.h
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(@NonNull Bitmap bitmap, @Nullable m1.b<? super Bitmap> bVar) {
            this.f25578g = bitmap;
            this.f25575d.sendMessageAtTime(this.f25575d.obtainMessage(1, this), this.f25577f);
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                g.this.m((a) message.obj);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            g.this.f25560d.l((a) message.obj);
            return false;
        }
    }

    g(com.bumptech.glide.b bVar, q0.a aVar, int i10, int i11, l<Bitmap> lVar, Bitmap bitmap) {
        this(bVar.f(), com.bumptech.glide.b.t(bVar.h()), aVar, null, i(com.bumptech.glide.b.t(bVar.h()), i10, i11), lVar, bitmap);
    }

    private static r0.f g() {
        return new n1.b(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.i<Bitmap> i(com.bumptech.glide.j jVar, int i10, int i11) {
        return jVar.i().b(k1.f.j0(u0.j.f34322b).g0(true).a0(true).R(i10, i11));
    }

    private void l() {
        if (!this.f25562f || this.f25563g) {
            return;
        }
        if (this.f25564h) {
            o1.j.a(this.f25571o == null, "Pending target must be null when starting from the first frame");
            this.f25557a.f();
            this.f25564h = false;
        }
        a aVar = this.f25571o;
        if (aVar != null) {
            this.f25571o = null;
            m(aVar);
            return;
        }
        this.f25563g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.f25557a.e());
        this.f25557a.b();
        this.f25568l = new a(this.f25558b, this.f25557a.g(), jUptimeMillis);
        this.f25565i.b(k1.f.k0(g())).w0(this.f25557a).q0(this.f25568l);
    }

    private void n() {
        Bitmap bitmap = this.f25569m;
        if (bitmap != null) {
            this.f25561e.c(bitmap);
            this.f25569m = null;
        }
    }

    private void p() {
        if (this.f25562f) {
            return;
        }
        this.f25562f = true;
        this.f25567k = false;
        l();
    }

    private void q() {
        this.f25562f = false;
    }

    void a() {
        this.f25559c.clear();
        n();
        q();
        a aVar = this.f25566j;
        if (aVar != null) {
            this.f25560d.l(aVar);
            this.f25566j = null;
        }
        a aVar2 = this.f25568l;
        if (aVar2 != null) {
            this.f25560d.l(aVar2);
            this.f25568l = null;
        }
        a aVar3 = this.f25571o;
        if (aVar3 != null) {
            this.f25560d.l(aVar3);
            this.f25571o = null;
        }
        this.f25557a.clear();
        this.f25567k = true;
    }

    ByteBuffer b() {
        return this.f25557a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.f25566j;
        return aVar != null ? aVar.h() : this.f25569m;
    }

    int d() {
        a aVar = this.f25566j;
        if (aVar != null) {
            return aVar.f25576e;
        }
        return -1;
    }

    Bitmap e() {
        return this.f25569m;
    }

    int f() {
        return this.f25557a.c();
    }

    int h() {
        return this.f25574r;
    }

    int j() {
        return this.f25557a.h() + this.f25572p;
    }

    int k() {
        return this.f25573q;
    }

    @VisibleForTesting
    void m(a aVar) {
        this.f25563g = false;
        if (this.f25567k) {
            this.f25558b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f25562f) {
            this.f25571o = aVar;
            return;
        }
        if (aVar.h() != null) {
            n();
            a aVar2 = this.f25566j;
            this.f25566j = aVar;
            for (int size = this.f25559c.size() - 1; size >= 0; size--) {
                this.f25559c.get(size).a();
            }
            if (aVar2 != null) {
                this.f25558b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    void o(l<Bitmap> lVar, Bitmap bitmap) {
        this.f25570n = (l) o1.j.d(lVar);
        this.f25569m = (Bitmap) o1.j.d(bitmap);
        this.f25565i = this.f25565i.b(new k1.f().e0(lVar));
        this.f25572p = k.g(bitmap);
        this.f25573q = bitmap.getWidth();
        this.f25574r = bitmap.getHeight();
    }

    void r(b bVar) {
        if (this.f25567k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f25559c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f25559c.isEmpty();
        this.f25559c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    void s(b bVar) {
        this.f25559c.remove(bVar);
        if (this.f25559c.isEmpty()) {
            q();
        }
    }

    g(v0.d dVar, com.bumptech.glide.j jVar, q0.a aVar, Handler handler, com.bumptech.glide.i<Bitmap> iVar, l<Bitmap> lVar, Bitmap bitmap) {
        this.f25559c = new ArrayList();
        this.f25560d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f25561e = dVar;
        this.f25558b = handler;
        this.f25565i = iVar;
        this.f25557a = aVar;
        o(lVar, bitmap);
    }
}
