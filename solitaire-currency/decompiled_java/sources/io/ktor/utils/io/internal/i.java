package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RingBufferCapacity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26860b = AtomicIntegerFieldUpdater.newUpdater(i.class, "_availableForRead$internal");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26861c = AtomicIntegerFieldUpdater.newUpdater(i.class, "_availableForWrite$internal");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f26862d = AtomicIntegerFieldUpdater.newUpdater(i.class, "_pendingToFlush");

    @NotNull
    public volatile /* synthetic */ int _availableForWrite$internal;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f26863a;

    @NotNull
    public volatile /* synthetic */ int _availableForRead$internal = 0;

    @NotNull
    volatile /* synthetic */ int _pendingToFlush = 0;

    public i(int i10) {
        this.f26863a = i10;
        this._availableForWrite$internal = i10;
    }

    private final Void b(int i10, int i11, int i12) {
        throw new IllegalArgumentException("Completed read overflow: " + i10 + " + " + i12 + " = " + i11 + " > " + this.f26863a);
    }

    private final Void d(int i10, int i11) {
        throw new IllegalArgumentException("Complete write overflow: " + i10 + " + " + i11 + " > " + this.f26863a);
    }

    public final void a(int i10) {
        int i11;
        int i12;
        do {
            i11 = this._availableForWrite$internal;
            i12 = i11 + i10;
            if (i12 > this.f26863a) {
                b(i11, i12, i10);
                throw new v8.h();
            }
        } while (!f26861c.compareAndSet(this, i11, i12));
    }

    public final void c(int i10) {
        int i11;
        int i12;
        do {
            i11 = this._pendingToFlush;
            i12 = i11 + i10;
            if (i12 > this.f26863a) {
                d(i11, i10);
                throw new v8.h();
            }
        } while (!f26862d.compareAndSet(this, i11, i12));
    }

    public final boolean e() {
        int andSet = f26862d.getAndSet(this, 0);
        return andSet == 0 ? this._availableForRead$internal > 0 : f26860b.addAndGet(this, andSet) > 0;
    }

    public final void f() {
        f26861c.getAndSet(this, 0);
    }

    public final boolean g() {
        return this._availableForWrite$internal == this.f26863a;
    }

    public final boolean h() {
        return this._availableForWrite$internal == 0;
    }

    public final void i() {
        this._availableForRead$internal = this.f26863a;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final void j() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.f26863a;
    }

    public final boolean k() {
        int i10;
        do {
            i10 = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || i10 != this.f26863a) {
                return false;
            }
        } while (!f26861c.compareAndSet(this, i10, 0));
        return true;
    }

    public final int l(int i10) {
        int i11;
        int iMin;
        do {
            i11 = this._availableForRead$internal;
            iMin = Math.min(i10, i11);
            if (iMin == 0) {
                return 0;
            }
        } while (!f26860b.compareAndSet(this, i11, i11 - iMin));
        return Math.min(i10, i11);
    }

    public final boolean m(int i10) {
        int i11;
        do {
            i11 = this._availableForRead$internal;
            if (i11 < i10) {
                return false;
            }
        } while (!f26860b.compareAndSet(this, i11, i11 - i10));
        return true;
    }

    public final int n(int i10) {
        int i11;
        int iMin;
        do {
            i11 = this._availableForWrite$internal;
            iMin = Math.min(i10, i11);
            if (iMin == 0) {
                return 0;
            }
        } while (!f26861c.compareAndSet(this, i11, i11 - iMin));
        return Math.min(i10, i11);
    }

    @NotNull
    public String toString() {
        return "RingBufferCapacity[read: " + this._availableForRead$internal + ", write: " + this._availableForWrite$internal + ", flush: " + this._pendingToFlush + ", capacity: " + this.f26863a + ']';
    }
}
