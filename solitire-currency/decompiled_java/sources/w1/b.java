package w1;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_ProductData.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f35322a;

    b(@Nullable Integer num) {
        this.f35322a = num;
    }

    @Override // w1.f
    @Nullable
    public Integer a() {
        return this.f35322a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        Integer num = this.f35322a;
        Integer numA = ((f) obj).a();
        return num == null ? numA == null : num.equals(numA);
    }

    public int hashCode() {
        Integer num = this.f35322a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f35322a + "}";
    }
}
