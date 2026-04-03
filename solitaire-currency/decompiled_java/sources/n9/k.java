package n9;

import java.util.NoSuchElementException;
import kotlin.collections.m0;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f31735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f31736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f31738d;

    public k(long j10, long j11, long j12) {
        this.f31735a = j12;
        this.f31736b = j11;
        boolean z10 = true;
        if (j12 <= 0 ? j10 < j11 : j10 > j11) {
            z10 = false;
        }
        this.f31737c = z10;
        this.f31738d = z10 ? j10 : j11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f31737c;
    }

    @Override // kotlin.collections.m0
    public long nextLong() {
        long j10 = this.f31738d;
        if (j10 != this.f31736b) {
            this.f31738d = this.f31735a + j10;
        } else {
            if (!this.f31737c) {
                throw new NoSuchElementException();
            }
            this.f31737c = false;
        }
        return j10;
    }
}
