package da;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ElementMarker.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class y {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f24662e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final long[] f24663f = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.p<SerialDescriptor, Integer, Boolean> f24665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f24666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final long[] f24667d;

    /* JADX INFO: compiled from: ElementMarker.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(@NotNull SerialDescriptor descriptor, @NotNull h9.p<? super SerialDescriptor, ? super Integer, Boolean> readIfAbsent) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        kotlin.jvm.internal.t.i(readIfAbsent, "readIfAbsent");
        this.f24664a = descriptor;
        this.f24665b = readIfAbsent;
        int iD = descriptor.d();
        if (iD <= 64) {
            this.f24666c = iD != 64 ? (-1) << iD : 0L;
            this.f24667d = f24663f;
        } else {
            this.f24666c = 0L;
            this.f24667d = e(iD);
        }
    }

    private final void b(int i10) {
        int i11 = (i10 >>> 6) - 1;
        long[] jArr = this.f24667d;
        jArr[i11] = jArr[i11] | (1 << (i10 & 63));
    }

    private final int c() {
        int length = this.f24667d.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            int i12 = i11 * 64;
            long j10 = this.f24667d[i10];
            while (j10 != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j10);
                j10 |= 1 << iNumberOfTrailingZeros;
                int i13 = iNumberOfTrailingZeros + i12;
                if (this.f24665b.mo4invoke(this.f24664a, Integer.valueOf(i13)).booleanValue()) {
                    this.f24667d[i10] = j10;
                    return i13;
                }
            }
            this.f24667d[i10] = j10;
            i10 = i11;
        }
        return -1;
    }

    private final long[] e(int i10) {
        long[] jArr = new long[(i10 - 1) >>> 6];
        if ((i10 & 63) != 0) {
            jArr[kotlin.collections.p.R(jArr)] = (-1) << i10;
        }
        return jArr;
    }

    public final void a(int i10) {
        if (i10 < 64) {
            this.f24666c |= 1 << i10;
        } else {
            b(i10);
        }
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iD = this.f24664a.d();
        do {
            long j10 = this.f24666c;
            if (j10 == -1) {
                if (iD > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j10);
            this.f24666c |= 1 << iNumberOfTrailingZeros;
        } while (!this.f24665b.mo4invoke(this.f24664a, Integer.valueOf(iNumberOfTrailingZeros)).booleanValue());
        return iNumberOfTrailingZeros;
    }
}
