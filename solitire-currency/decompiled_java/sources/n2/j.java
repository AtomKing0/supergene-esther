package n2;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.ArrayDeque;
import n2.f;
import n2.g;
import n2.h;

/* JADX INFO: compiled from: SimpleDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j<I extends g, O extends h, E extends f> implements d<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f31601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f31602b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<I> f31603c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayDeque<O> f31604d = new ArrayDeque<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final I[] f31605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final O[] f31606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f31608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private I f31609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private E f31610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f31611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f31612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f31613m;

    /* JADX INFO: compiled from: SimpleDecoder.java */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            j.this.p();
        }
    }

    protected j(I[] iArr, O[] oArr) {
        this.f31605e = iArr;
        this.f31607g = iArr.length;
        for (int i10 = 0; i10 < this.f31607g; i10++) {
            ((I[]) this.f31605e)[i10] = c();
        }
        this.f31606f = oArr;
        this.f31608h = oArr.length;
        for (int i11 = 0; i11 < this.f31608h; i11++) {
            ((O[]) this.f31606f)[i11] = d();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f31601a = aVar;
        aVar.start();
    }

    private boolean b() {
        return !this.f31603c.isEmpty() && this.f31608h > 0;
    }

    private boolean g() throws InterruptedException {
        E e10;
        synchronized (this.f31602b) {
            while (!this.f31612l && !b()) {
                this.f31602b.wait();
            }
            if (this.f31612l) {
                return false;
            }
            I iRemoveFirst = this.f31603c.removeFirst();
            O[] oArr = this.f31606f;
            int i10 = this.f31608h - 1;
            this.f31608h = i10;
            O o10 = oArr[i10];
            boolean z10 = this.f31611k;
            this.f31611k = false;
            if (iRemoveFirst.h()) {
                o10.a(4);
            } else {
                if (iRemoveFirst.g()) {
                    o10.a(Integer.MIN_VALUE);
                }
                if (iRemoveFirst.i()) {
                    o10.a(C.BUFFER_FLAG_FIRST_SAMPLE);
                }
                try {
                    e10 = (E) f(iRemoveFirst, o10, z10);
                } catch (OutOfMemoryError e11) {
                    e10 = (E) e(e11);
                } catch (RuntimeException e12) {
                    e10 = (E) e(e12);
                }
                if (e10 != null) {
                    synchronized (this.f31602b) {
                        this.f31610j = e10;
                    }
                    return false;
                }
            }
            synchronized (this.f31602b) {
                if (this.f31611k) {
                    o10.l();
                } else if (o10.g()) {
                    this.f31613m++;
                    o10.l();
                } else {
                    o10.f31595c = this.f31613m;
                    this.f31613m = 0;
                    this.f31604d.addLast(o10);
                }
                m(iRemoveFirst);
            }
            return true;
        }
    }

    private void j() {
        if (b()) {
            this.f31602b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends n2.f */
    private void k() throws E, f {
        E e10 = this.f31610j;
        if (e10 != null) {
            throw e10;
        }
    }

    private void m(I i10) {
        i10.c();
        I[] iArr = this.f31605e;
        int i11 = this.f31607g;
        this.f31607g = i11 + 1;
        iArr[i11] = i10;
    }

    private void o(O o10) {
        o10.c();
        O[] oArr = this.f31606f;
        int i10 = this.f31608h;
        this.f31608h = i10 + 1;
        oArr[i10] = o10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        do {
            try {
            } catch (InterruptedException e10) {
                throw new IllegalStateException(e10);
            }
        } while (g());
    }

    protected abstract I c();

    protected abstract O d();

    protected abstract E e(Throwable th);

    @Nullable
    protected abstract E f(I i10, O o10, boolean z10);

    @Override // n2.d
    public final void flush() {
        synchronized (this.f31602b) {
            this.f31611k = true;
            this.f31613m = 0;
            I i10 = this.f31609i;
            if (i10 != null) {
                m(i10);
                this.f31609i = null;
            }
            while (!this.f31603c.isEmpty()) {
                m(this.f31603c.removeFirst());
            }
            while (!this.f31604d.isEmpty()) {
                this.f31604d.removeFirst().l();
            }
        }
    }

    @Override // n2.d
    @Nullable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final I dequeueInputBuffer() throws f {
        I i10;
        synchronized (this.f31602b) {
            k();
            a4.a.g(this.f31609i == null);
            int i11 = this.f31607g;
            if (i11 == 0) {
                i10 = null;
            } else {
                I[] iArr = this.f31605e;
                int i12 = i11 - 1;
                this.f31607g = i12;
                i10 = iArr[i12];
            }
            this.f31609i = i10;
        }
        return i10;
    }

    @Override // n2.d
    @Nullable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final O dequeueOutputBuffer() throws f {
        synchronized (this.f31602b) {
            k();
            if (this.f31604d.isEmpty()) {
                return null;
            }
            return this.f31604d.removeFirst();
        }
    }

    @Override // n2.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(I i10) throws f {
        synchronized (this.f31602b) {
            k();
            a4.a.a(i10 == this.f31609i);
            this.f31603c.addLast(i10);
            j();
            this.f31609i = null;
        }
    }

    @CallSuper
    protected void n(O o10) {
        synchronized (this.f31602b) {
            o(o10);
            j();
        }
    }

    protected final void q(int i10) {
        a4.a.g(this.f31607g == this.f31605e.length);
        for (I i11 : this.f31605e) {
            i11.m(i10);
        }
    }

    @Override // n2.d
    @CallSuper
    public void release() {
        synchronized (this.f31602b) {
            this.f31612l = true;
            this.f31602b.notify();
        }
        try {
            this.f31601a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
