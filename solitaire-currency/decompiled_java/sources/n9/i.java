package n9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends g implements f<Integer> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f31729e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final i f31730f = new i(1, 0);

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final i a() {
            return i.f31730f;
        }
    }

    public i(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // n9.g
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (b() != iVar.b() || e() != iVar.e()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // n9.g
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + e();
    }

    public boolean i(int i10) {
        return b() <= i10 && i10 <= e();
    }

    @Override // n9.g, n9.f
    public boolean isEmpty() {
        return b() > e();
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(e());
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(b());
    }

    @Override // n9.g
    @NotNull
    public String toString() {
        return b() + ".." + e();
    }
}
