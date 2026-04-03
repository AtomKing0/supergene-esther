package e5;

/* JADX INFO: compiled from: Present.java */
/* JADX INFO: loaded from: classes3.dex */
final class r<T> extends l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f25156a;

    r(T t10) {
        this.f25156a = t10;
    }

    @Override // e5.l
    public T b() {
        return this.f25156a;
    }

    @Override // e5.l
    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f25156a.equals(((r) obj).f25156a);
        }
        return false;
    }

    public int hashCode() {
        return this.f25156a.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f25156a + ")";
    }
}
