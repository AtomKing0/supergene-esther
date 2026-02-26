package n9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes5.dex */
final class d implements e<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f31719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f31720b;

    public d(float f10, float f11) {
        this.f31719a = f10;
        this.f31720b = f11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n9.e
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return e(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public boolean b(float f10) {
        return f10 >= this.f31719a && f10 <= this.f31720b;
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float getEndInclusive() {
        return Float.valueOf(this.f31720b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n9.e
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    @Override // n9.f
    @NotNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.f31719a);
    }

    public boolean e(float f10, float f11) {
        return f10 <= f11;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (!isEmpty() || !((d) obj).isEmpty()) {
            d dVar = (d) obj;
            if (!(this.f31719a == dVar.f31719a)) {
                return false;
            }
            if (!(this.f31720b == dVar.f31720b)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f31719a) * 31) + Float.floatToIntBits(this.f31720b);
    }

    @Override // n9.e, n9.f
    public boolean isEmpty() {
        return this.f31719a > this.f31720b;
    }

    @NotNull
    public String toString() {
        return this.f31719a + ".." + this.f31720b;
    }
}
