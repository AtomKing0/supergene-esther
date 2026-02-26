package va;

import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.m;
import ua.z0;

/* JADX INFO: compiled from: FixedLengthSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f35226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f35227c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull z0 delegate, long j10, boolean z10) {
        super(delegate);
        t.i(delegate, "delegate");
        this.f35225a = j10;
        this.f35226b = z10;
    }

    private final void a(ua.c cVar, long j10) throws IOException {
        ua.c cVar2 = new ua.c();
        cVar2.s(cVar);
        cVar.G(cVar2, j10);
        cVar2.c();
    }

    @Override // ua.m, ua.z0
    public long read(@NotNull ua.c sink, long j10) throws IOException {
        t.i(sink, "sink");
        long j11 = this.f35227c;
        long j12 = this.f35225a;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f35226b) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1L;
            }
            j10 = Math.min(j10, j13);
        }
        long j14 = super.read(sink, j10);
        if (j14 != -1) {
            this.f35227c += j14;
        }
        long j15 = this.f35227c;
        long j16 = this.f35225a;
        if ((j15 >= j16 || j14 != -1) && j15 <= j16) {
            return j14;
        }
        if (j14 > 0 && j15 > j16) {
            a(sink, sink.size() - (this.f35227c - this.f35225a));
        }
        throw new IOException("expected " + this.f35225a + " bytes but got " + this.f35227c);
    }
}
