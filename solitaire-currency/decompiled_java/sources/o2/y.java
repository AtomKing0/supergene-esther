package o2;

import android.os.Looper;
import androidx.annotation.Nullable;
import k2.o1;
import l2.t1;
import o2.o;
import o2.w;

/* JADX INFO: compiled from: DrmSessionManager.java */
/* JADX INFO: loaded from: classes2.dex */
public interface y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f31949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final y f31950b;

    /* JADX INFO: compiled from: DrmSessionManager.java */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f31951a = new b() { // from class: o2.z
            @Override // o2.y.b
            public final void release() {
                a0.a();
            }
        };

        void release();
    }

    static {
        a aVar = new a();
        f31949a = aVar;
        f31950b = aVar;
    }

    @Nullable
    o a(@Nullable w.a aVar, o1 o1Var);

    int b(o1 o1Var);

    void c(Looper looper, t1 t1Var);

    b d(@Nullable w.a aVar, o1 o1Var);

    void prepare();

    void release();

    /* JADX INFO: compiled from: DrmSessionManager.java */
    class a implements y {
        a() {
        }

        @Override // o2.y
        @Nullable
        public o a(@Nullable w.a aVar, o1 o1Var) {
            if (o1Var.f29350o == null) {
                return null;
            }
            return new e0(new o.a(new p0(1), 6001));
        }

        @Override // o2.y
        public int b(o1 o1Var) {
            return o1Var.f29350o != null ? 1 : 0;
        }

        @Override // o2.y
        public /* synthetic */ b d(w.a aVar, o1 o1Var) {
            return x.a(this, aVar, o1Var);
        }

        @Override // o2.y
        public /* synthetic */ void prepare() {
            x.b(this);
        }

        @Override // o2.y
        public /* synthetic */ void release() {
            x.c(this);
        }

        @Override // o2.y
        public void c(Looper looper, t1 t1Var) {
        }
    }
}
