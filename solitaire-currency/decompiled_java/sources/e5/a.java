package e5;

/* JADX INFO: compiled from: Absent.java */
/* JADX INFO: loaded from: classes3.dex */
final class a<T> extends l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a<Object> f25126a = new a<>();

    private a() {
    }

    static <T> l<T> e() {
        return f25126a;
    }

    @Override // e5.l
    public T b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // e5.l
    public boolean c() {
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
