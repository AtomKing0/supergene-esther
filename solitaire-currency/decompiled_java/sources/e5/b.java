package e5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: AbstractIterator.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class b<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0544b f25127a = EnumC0544b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f25128b;

    /* JADX INFO: compiled from: AbstractIterator.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25129a;

        static {
            int[] iArr = new int[EnumC0544b.values().length];
            f25129a = iArr;
            try {
                iArr[EnumC0544b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25129a[EnumC0544b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: e5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractIterator.java */
    private enum EnumC0544b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected b() {
    }

    private boolean c() {
        this.f25127a = EnumC0544b.FAILED;
        this.f25128b = a();
        if (this.f25127a == EnumC0544b.DONE) {
            return false;
        }
        this.f25127a = EnumC0544b.READY;
        return true;
    }

    protected abstract T a();

    protected final T b() {
        this.f25127a = EnumC0544b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        o.o(this.f25127a != EnumC0544b.FAILED);
        int i10 = a.f25129a[this.f25127a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f25127a = EnumC0544b.NOT_READY;
        T t10 = (T) j.a(this.f25128b);
        this.f25128b = null;
        return t10;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
