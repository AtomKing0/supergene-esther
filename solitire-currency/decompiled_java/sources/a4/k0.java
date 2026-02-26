package a4;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: TimedValueQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private V[] f188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f190d;

    public k0() {
        this(10);
    }

    private void b(long j10, V v10) {
        int i10 = this.f189c;
        int i11 = this.f190d;
        V[] vArr = this.f188b;
        int length = (i10 + i11) % vArr.length;
        this.f187a[length] = j10;
        vArr[length] = v10;
        this.f190d = i11 + 1;
    }

    private void d(long j10) {
        if (this.f190d > 0) {
            if (j10 <= this.f187a[((this.f189c + r0) - 1) % this.f188b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f188b.length;
        if (this.f190d < length) {
            return;
        }
        int i10 = length * 2;
        long[] jArr = new long[i10];
        V[] vArr = (V[]) f(i10);
        int i11 = this.f189c;
        int i12 = length - i11;
        System.arraycopy(this.f187a, i11, jArr, 0, i12);
        System.arraycopy(this.f188b, this.f189c, vArr, 0, i12);
        int i13 = this.f189c;
        if (i13 > 0) {
            System.arraycopy(this.f187a, 0, jArr, i12, i13);
            System.arraycopy(this.f188b, 0, vArr, i12, this.f189c);
        }
        this.f187a = jArr;
        this.f188b = vArr;
        this.f189c = 0;
    }

    private static <V> V[] f(int i10) {
        return (V[]) new Object[i10];
    }

    @Nullable
    private V h(long j10, boolean z10) {
        V vK = null;
        long j11 = Long.MAX_VALUE;
        while (this.f190d > 0) {
            long j12 = j10 - this.f187a[this.f189c];
            if (j12 < 0 && (z10 || (-j12) >= j11)) {
                break;
            }
            vK = k();
            j11 = j12;
        }
        return vK;
    }

    @Nullable
    private V k() {
        a.g(this.f190d > 0);
        V[] vArr = this.f188b;
        int i10 = this.f189c;
        V v10 = vArr[i10];
        vArr[i10] = null;
        this.f189c = (i10 + 1) % vArr.length;
        this.f190d--;
        return v10;
    }

    public synchronized void a(long j10, V v10) {
        d(j10);
        e();
        b(j10, v10);
    }

    public synchronized void c() {
        this.f189c = 0;
        this.f190d = 0;
        Arrays.fill(this.f188b, (Object) null);
    }

    @Nullable
    public synchronized V g(long j10) {
        return h(j10, false);
    }

    @Nullable
    public synchronized V i() {
        return this.f190d == 0 ? null : k();
    }

    @Nullable
    public synchronized V j(long j10) {
        return h(j10, true);
    }

    public synchronized int l() {
        return this.f190d;
    }

    public k0(int i10) {
        this.f187a = new long[i10];
        this.f188b = (V[]) f(i10);
    }
}
