package io.sentry;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CircularFifoQueue.java */
/* JADX INFO: loaded from: classes5.dex */
final class g<E> extends AbstractCollection<E> implements Queue<E>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private transient E[] f27814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f27815b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient int f27816c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient boolean f27817d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f27818e;

    /* JADX INFO: compiled from: CircularFifoQueue.java */
    class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f27819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f27820b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f27821c;

        a() {
            this.f27819a = g.this.f27815b;
            this.f27821c = g.this.f27817d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f27821c || this.f27819a != g.this.f27816c;
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f27821c = false;
            int i10 = this.f27819a;
            this.f27820b = i10;
            this.f27819a = g.this.l(i10);
            return (E) g.this.f27814a[this.f27820b];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i10 = this.f27820b;
            if (i10 == -1) {
                throw new IllegalStateException();
            }
            if (i10 == g.this.f27815b) {
                g.this.remove();
                this.f27820b = -1;
                return;
            }
            int iL = this.f27820b + 1;
            if (g.this.f27815b >= this.f27820b || iL >= g.this.f27816c) {
                while (iL != g.this.f27816c) {
                    if (iL >= g.this.f27818e) {
                        g.this.f27814a[iL - 1] = g.this.f27814a[0];
                        iL = 0;
                    } else {
                        g.this.f27814a[g.this.k(iL)] = g.this.f27814a[iL];
                        iL = g.this.l(iL);
                    }
                }
            } else {
                System.arraycopy(g.this.f27814a, iL, g.this.f27814a, this.f27820b, g.this.f27816c - iL);
            }
            this.f27820b = -1;
            g gVar = g.this;
            gVar.f27816c = gVar.k(gVar.f27816c);
            g.this.f27814a[g.this.f27816c] = null;
            g.this.f27817d = false;
            this.f27819a = g.this.k(this.f27819a);
        }
    }

    g(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        E[] eArr = (E[]) new Object[i10];
        this.f27814a = eArr;
        this.f27818e = eArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k(int i10) {
        int i11 = i10 - 1;
        return i11 < 0 ? this.f27818e - 1 : i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.f27818e) {
            return 0;
        }
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(@NotNull E e10) {
        if (e10 == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        if (m()) {
            remove();
        }
        E[] eArr = this.f27814a;
        int i10 = this.f27816c;
        int i11 = i10 + 1;
        this.f27816c = i11;
        eArr[i10] = e10;
        if (i11 >= this.f27818e) {
            this.f27816c = 0;
        }
        if (this.f27816c == this.f27815b) {
            this.f27817d = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f27817d = false;
        this.f27815b = 0;
        this.f27816c = 0;
        Arrays.fill(this.f27814a, (Object) null);
    }

    @Override // java.util.Queue
    @Nullable
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new a();
    }

    public boolean m() {
        return size() == this.f27818e;
    }

    @Override // java.util.Queue
    public boolean offer(@NotNull E e10) {
        return add(e10);
    }

    @Override // java.util.Queue
    @Nullable
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f27814a[this.f27815b];
    }

    @Override // java.util.Queue
    @Nullable
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    @NotNull
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E[] eArr = this.f27814a;
        int i10 = this.f27815b;
        E e10 = eArr[i10];
        if (e10 != null) {
            int i11 = i10 + 1;
            this.f27815b = i11;
            eArr[i10] = null;
            if (i11 >= this.f27818e) {
                this.f27815b = 0;
            }
            this.f27817d = false;
        }
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i10 = this.f27816c;
        int i11 = this.f27815b;
        if (i10 < i11) {
            return (this.f27818e - i11) + i10;
        }
        if (i10 == i11) {
            return this.f27817d ? this.f27818e : 0;
        }
        return i10 - i11;
    }
}
