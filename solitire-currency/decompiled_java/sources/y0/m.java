package y0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* JADX INFO: compiled from: ModelCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class m<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o1.g<b<A>, B> f36297a;

    /* JADX INFO: compiled from: ModelCache.java */
    class a extends o1.g<b<A>, B> {
        a(long j10) {
            super(j10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // o1.g
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(@NonNull b<A> bVar, @Nullable B b10) {
            bVar.c();
        }
    }

    /* JADX INFO: compiled from: ModelCache.java */
    @VisibleForTesting
    static final class b<A> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f36299d = o1.k.e(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private A f36302c;

        private b() {
        }

        static <A> b<A> a(A a10, int i10, int i11) {
            b<A> bVar;
            Queue<b<?>> queue = f36299d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a10, i10, i11);
            return bVar;
        }

        private void b(A a10, int i10, int i11) {
            this.f36302c = a10;
            this.f36301b = i10;
            this.f36300a = i11;
        }

        public void c() {
            Queue<b<?>> queue = f36299d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f36301b == bVar.f36301b && this.f36300a == bVar.f36300a && this.f36302c.equals(bVar.f36302c);
        }

        public int hashCode() {
            return (((this.f36300a * 31) + this.f36301b) * 31) + this.f36302c.hashCode();
        }
    }

    public m(long j10) {
        this.f36297a = new a(j10);
    }

    @Nullable
    public B a(A a10, int i10, int i11) {
        b<A> bVarA = b.a(a10, i10, i11);
        B bG = this.f36297a.g(bVarA);
        bVarA.c();
        return bG;
    }

    public void b(A a10, int i10, int i11, B b10) {
        this.f36297a.k(b.a(a10, i10, i11), b10);
    }
}
