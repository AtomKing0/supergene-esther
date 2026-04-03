package s8;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s8.g;

/* JADX INFO: compiled from: DefaultPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<T> implements g<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final b f33632f = new b(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater<d<?>> f33633g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f33634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f33636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray<T> f33637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final int[] f33638e;
    private volatile long top;

    /* JADX INFO: compiled from: DefaultPool.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }
    }

    static {
        AtomicLongFieldUpdater<d<?>> atomicLongFieldUpdaterNewUpdater = AtomicLongFieldUpdater.newUpdater(d.class, new a0() { // from class: s8.d.a
            @Override // kotlin.jvm.internal.a0, kotlin.reflect.KProperty1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Long.valueOf(((d) obj).top);
            }

            @Override // kotlin.jvm.internal.a0, kotlin.reflect.KMutableProperty1
            public void set(@Nullable Object obj, @Nullable Object obj2) {
                ((d) obj).top = ((Number) obj2).longValue();
            }
        }.getName());
        t.h(atomicLongFieldUpdaterNewUpdater, "newUpdater(Owner::class.java, p.name)");
        f33633g = atomicLongFieldUpdaterNewUpdater;
    }

    public d(int i10) {
        this.f33634a = i10;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException(("capacity should be positive but it is " + i10).toString());
        }
        if (!(i10 <= 536870911)) {
            throw new IllegalArgumentException(("capacity should be less or equal to 536870911 but it is " + i10).toString());
        }
        int iHighestOneBit = Integer.highestOneBit((i10 * 4) - 1) * 2;
        this.f33635b = iHighestOneBit;
        this.f33636c = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
        this.f33637d = new AtomicReferenceArray<>(iHighestOneBit + 1);
        this.f33638e = new int[iHighestOneBit + 1];
    }

    private final T B() {
        int iQ = q();
        if (iQ == 0) {
            return null;
        }
        return this.f33637d.getAndSet(iQ, null);
    }

    private final boolean J(T t10) {
        int iIdentityHashCode = ((System.identityHashCode(t10) * (-1640531527)) >>> this.f33636c) + 1;
        for (int i10 = 0; i10 < 8; i10++) {
            if (c.a(this.f33637d, iIdentityHashCode, null, t10)) {
                z(iIdentityHashCode);
                return true;
            }
            iIdentityHashCode--;
            if (iIdentityHashCode == 0) {
                iIdentityHashCode = this.f33635b;
            }
        }
        return false;
    }

    private final int q() {
        long j10;
        long j11;
        int i10;
        do {
            j10 = this.top;
            if (j10 == 0) {
                return 0;
            }
            j11 = ((j10 >> 32) & 4294967295L) + 1;
            i10 = (int) (4294967295L & j10);
            if (i10 == 0) {
                return 0;
            }
        } while (!f33633g.compareAndSet(this, j10, (j11 << 32) | ((long) this.f33638e[i10])));
        return i10;
    }

    private final void z(int i10) {
        long j10;
        long j11;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("index should be positive".toString());
        }
        do {
            j10 = this.top;
            j11 = ((long) i10) | ((((j10 >> 32) & 4294967295L) + 1) << 32);
            this.f33638e[i10] = (int) (4294967295L & j10);
        } while (!f33633g.compareAndSet(this, j10, j11));
    }

    @Override // s8.g
    public final void C0(@NotNull T instance) {
        t.i(instance, "instance");
        L(instance);
        if (J(instance)) {
            return;
        }
        n(instance);
    }

    protected void L(@NotNull T instance) {
        t.i(instance, "instance");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g.a.a(this);
    }

    @Override // s8.g
    public final void dispose() {
        while (true) {
            T tB = B();
            if (tB == null) {
                return;
            } else {
                n(tB);
            }
        }
    }

    @NotNull
    protected T i(@NotNull T instance) {
        t.i(instance, "instance");
        return instance;
    }

    @Override // s8.g
    @NotNull
    public final T k0() {
        T tI;
        T tB = B();
        return (tB == null || (tI = i(tB)) == null) ? x() : tI;
    }

    protected void n(@NotNull T instance) {
        t.i(instance, "instance");
    }

    @NotNull
    protected abstract T x();
}
