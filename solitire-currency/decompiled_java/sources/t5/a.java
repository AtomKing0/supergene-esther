package t5;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes3.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f34074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f34075b;

    public T a() {
        return this.f34075b;
    }

    public Class<T> b() {
        return this.f34074a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f34074a, this.f34075b);
    }
}
