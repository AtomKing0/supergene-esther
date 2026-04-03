package n9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends j implements f<Long> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f31739e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final l f31740f = new l(1, 0);

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public l(long j10, long j11) {
        super(j10, j11, 1L);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (b() != lVar.b() || e() != lVar.e()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(long j10) {
        return b() <= j10 && j10 <= e();
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Long getEndInclusive() {
        return Long.valueOf(e());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (b() ^ (b() >>> 32))) + (e() ^ (e() >>> 32)));
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Long getStart() {
        return Long.valueOf(b());
    }

    @Override // n9.f
    public boolean isEmpty() {
        return b() > e();
    }

    @NotNull
    public String toString() {
        return b() + ".." + e();
    }
}
