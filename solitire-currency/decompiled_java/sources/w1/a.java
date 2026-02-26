package w1;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_Event.java */
/* JADX INFO: loaded from: classes2.dex */
final class a<T> extends d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f35318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f35319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f35320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f35321d;

    a(@Nullable Integer num, T t10, e eVar, @Nullable f fVar) {
        this.f35318a = num;
        if (t10 == null) {
            throw new NullPointerException("Null payload");
        }
        this.f35319b = t10;
        if (eVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f35320c = eVar;
        this.f35321d = fVar;
    }

    @Override // w1.d
    @Nullable
    public Integer a() {
        return this.f35318a;
    }

    @Override // w1.d
    public T b() {
        return this.f35319b;
    }

    @Override // w1.d
    public e c() {
        return this.f35320c;
    }

    @Override // w1.d
    @Nullable
    public f d() {
        return this.f35321d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        Integer num = this.f35318a;
        if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
            if (this.f35319b.equals(dVar.b()) && this.f35320c.equals(dVar.c())) {
                f fVar = this.f35321d;
                if (fVar == null) {
                    if (dVar.d() == null) {
                        return true;
                    }
                } else if (fVar.equals(dVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f35318a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f35319b.hashCode()) * 1000003) ^ this.f35320c.hashCode()) * 1000003;
        f fVar = this.f35321d;
        return iHashCode ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{code=" + this.f35318a + ", payload=" + this.f35319b + ", priority=" + this.f35320c + ", productData=" + this.f35321d + "}";
    }
}
