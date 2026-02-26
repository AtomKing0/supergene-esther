package io.sentry.util;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Random.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class z implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f28380b = new AtomicLong(8682522807148012L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f28381a;

    public z() {
        this(f() ^ System.nanoTime());
    }

    private static long a(long j10) {
        return (j10 ^ 25214903917L) & 281474976710655L;
    }

    private int b(int i10) {
        long j10;
        long j11;
        AtomicLong atomicLong = this.f28381a;
        do {
            j10 = atomicLong.get();
            j11 = ((25214903917L * j10) + 11) & 281474976710655L;
        } while (!atomicLong.compareAndSet(j10, j11));
        return (int) (j11 >>> (48 - i10));
    }

    private static long f() {
        AtomicLong atomicLong;
        long j10;
        long j11;
        do {
            atomicLong = f28380b;
            j10 = atomicLong.get();
            j11 = 1181783497276652981L * j10;
        } while (!atomicLong.compareAndSet(j10, j11));
        return j11;
    }

    public void c(byte[] bArr) {
        int length = bArr.length;
        int i10 = 0;
        while (i10 < length) {
            int iE = e();
            int iMin = Math.min(length - i10, 4);
            while (true) {
                int i11 = iMin - 1;
                if (iMin > 0) {
                    bArr[i10] = (byte) iE;
                    iE >>= 8;
                    i10++;
                    iMin = i11;
                }
            }
        }
    }

    public double d() {
        return ((((long) b(26)) << 27) + ((long) b(27))) * 1.1102230246251565E-16d;
    }

    public int e() {
        return b(32);
    }

    public z(long j10) {
        this.f28381a = new AtomicLong(a(j10));
    }
}
