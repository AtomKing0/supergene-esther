package a1;

import androidx.annotation.NonNull;
import u0.v;

/* JADX INFO: compiled from: SimpleResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class j<T> implements v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f81a;

    public j(@NonNull T t10) {
        this.f81a = (T) o1.j.d(t10);
    }

    @Override // u0.v
    @NonNull
    public Class<T> a() {
        return (Class<T>) this.f81a.getClass();
    }

    @Override // u0.v
    @NonNull
    public final T get() {
        return this.f81a;
    }

    @Override // u0.v
    public final int getSize() {
        return 1;
    }

    @Override // u0.v
    public void recycle() {
    }
}
