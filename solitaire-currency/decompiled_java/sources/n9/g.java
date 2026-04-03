package n9;

import kotlin.collections.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class g implements Iterable<Integer>, i9.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f31721d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f31722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f31724c;

    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final g a(int i10, int i11, int i12) {
            return new g(i10, i11, i12);
        }
    }

    public g(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f31722a = i10;
        this.f31723b = c9.c.c(i10, i11, i12);
        this.f31724c = i12;
    }

    public final int b() {
        return this.f31722a;
    }

    public final int e() {
        return this.f31723b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof g) {
            if (!isEmpty() || !((g) obj).isEmpty()) {
                g gVar = (g) obj;
                if (this.f31722a != gVar.f31722a || this.f31723b != gVar.f31723b || this.f31724c != gVar.f31724c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f31724c;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public l0 iterator() {
        return new h(this.f31722a, this.f31723b, this.f31724c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f31722a * 31) + this.f31723b) * 31) + this.f31724c;
    }

    public boolean isEmpty() {
        if (this.f31724c > 0) {
            if (this.f31722a > this.f31723b) {
                return true;
            }
        } else if (this.f31722a < this.f31723b) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i10;
        if (this.f31724c > 0) {
            sb = new StringBuilder();
            sb.append(this.f31722a);
            sb.append("..");
            sb.append(this.f31723b);
            sb.append(" step ");
            i10 = this.f31724c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f31722a);
            sb.append(" downTo ");
            sb.append(this.f31723b);
            sb.append(" step ");
            i10 = -this.f31724c;
        }
        sb.append(i10);
        return sb.toString();
    }
}
