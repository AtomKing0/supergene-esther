package q8;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s8.g;

/* JADX INFO: compiled from: ChunkBuffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends p8.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final d f33167j = new d(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f33168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f33169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private static final s8.g<a> f33170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private static final a f33171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private static final s8.g<a> f33172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private static final s8.g<a> f33173p;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final s8.g<a> f33174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private a f33175i;

    @NotNull
    private volatile /* synthetic */ Object nextRef;

    @NotNull
    private volatile /* synthetic */ int refCount;

    /* JADX INFO: compiled from: ChunkBuffer.kt */
    public static final class b extends s8.f<a> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // s8.g
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a k0() {
            return new a(n8.b.f31706a.b(4096), null, this, 0 == true ? 1 : 0);
        }

        @Override // s8.f, s8.g
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void C0(@NotNull a instance) {
            t.i(instance, "instance");
            n8.b.f31706a.a(instance.g());
        }
    }

    /* JADX INFO: compiled from: ChunkBuffer.kt */
    public static final class c extends s8.f<a> {
        c() {
        }

        @Override // s8.g
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a k0() {
            throw new UnsupportedOperationException("This pool doesn't support borrow");
        }

        @Override // s8.f, s8.g
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void C0(@NotNull a instance) {
            t.i(instance, "instance");
        }
    }

    /* JADX INFO: compiled from: ChunkBuffer.kt */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(k kVar) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f33171n;
        }

        @NotNull
        public final s8.g<a> b() {
            return a.f33170m;
        }

        @NotNull
        public final s8.g<a> c() {
            return p8.c.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        C0660a c0660a = new C0660a();
        f33170m = c0660a;
        f33171n = new a(n8.c.f31707a.a(), 0 == true ? 1 : 0, c0660a, 0 == true ? 1 : 0);
        f33172o = new b();
        f33173p = new c();
        f33168k = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "nextRef");
        f33169l = AtomicIntegerFieldUpdater.newUpdater(a.class, "refCount");
    }

    public /* synthetic */ a(ByteBuffer byteBuffer, a aVar, s8.g gVar, k kVar) {
        this(byteBuffer, aVar, gVar);
    }

    private final void v(a aVar) {
        if (!androidx.concurrent.futures.a.a(f33168k, this, null, aVar)) {
            throw new IllegalStateException("This chunk has already a next chunk.");
        }
    }

    public void A(@NotNull s8.g<a> pool) {
        t.i(pool, "pool");
        if (B()) {
            a aVar = this.f33175i;
            if (aVar != null) {
                D();
                aVar.A(pool);
            } else {
                s8.g<a> gVar = this.f33174h;
                if (gVar != null) {
                    pool = gVar;
                }
                pool.C0(this);
            }
        }
    }

    public final boolean B() {
        int i10;
        int i11;
        do {
            i10 = this.refCount;
            if (i10 <= 0) {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
            i11 = i10 - 1;
        } while (!f33169l.compareAndSet(this, i10, i11));
        return i11 == 0;
    }

    public final void C(@Nullable a aVar) {
        if (aVar == null) {
            w();
        } else {
            v(aVar);
        }
    }

    public final void D() {
        if (!f33169l.compareAndSet(this, 0, -1)) {
            throw new IllegalStateException("Unable to unlink: buffer is in use.");
        }
        w();
        this.f33175i = null;
    }

    public final void E() {
        int i10;
        do {
            i10 = this.refCount;
            if (i10 < 0) {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            }
            if (i10 > 0) {
                throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
            }
        } while (!f33169l.compareAndSet(this, i10, 1));
    }

    @Override // p8.a
    public final void q() {
        if (!(this.f33175i == null)) {
            throw new IllegalArgumentException("Unable to reset buffer with origin".toString());
        }
        super.q();
        this.nextRef = null;
    }

    @Nullable
    public final a w() {
        return (a) f33168k.getAndSet(this, null);
    }

    @Nullable
    public final a x() {
        return (a) this.nextRef;
    }

    @Nullable
    public final a y() {
        return this.f33175i;
    }

    public final int z() {
        return this.refCount;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private a(ByteBuffer memory, a aVar, s8.g<a> gVar) {
        super(memory, null);
        t.i(memory, "memory");
        this.f33174h = gVar;
        if (!(aVar != this)) {
            throw new IllegalArgumentException("A chunk couldn't be a view of itself.".toString());
        }
        this.nextRef = null;
        this.refCount = 1;
        this.f33175i = aVar;
    }

    /* JADX INFO: renamed from: q8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChunkBuffer.kt */
    public static final class C0660a implements s8.g<a> {
        C0660a() {
        }

        @Override // s8.g
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a k0() {
            return a.f33167j.a();
        }

        @Override // s8.g
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void C0(@NotNull a instance) {
            t.i(instance, "instance");
            if (!(instance == a.f33167j.a())) {
                throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.".toString());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            g.a.a(this);
        }

        @Override // s8.g
        public void dispose() {
        }
    }
}
