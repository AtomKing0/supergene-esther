package o1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class g<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<T, Y> f31800a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f31801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f31802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f31803d;

    public g(long j10) {
        this.f31801b = j10;
        this.f31802c = j10;
    }

    private void f() {
        m(this.f31802c);
    }

    public void b() {
        m(0L);
    }

    @Nullable
    public synchronized Y g(@NonNull T t10) {
        return this.f31800a.get(t10);
    }

    public synchronized long h() {
        return this.f31802c;
    }

    protected int i(@Nullable Y y10) {
        return 1;
    }

    @Nullable
    public synchronized Y k(@NonNull T t10, @Nullable Y y10) {
        long jI = i(y10);
        if (jI >= this.f31802c) {
            j(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.f31803d += jI;
        }
        Y yPut = this.f31800a.put(t10, y10);
        if (yPut != null) {
            this.f31803d -= (long) i(yPut);
            if (!yPut.equals(y10)) {
                j(t10, yPut);
            }
        }
        f();
        return yPut;
    }

    @Nullable
    public synchronized Y l(@NonNull T t10) {
        Y yRemove;
        yRemove = this.f31800a.remove(t10);
        if (yRemove != null) {
            this.f31803d -= (long) i(yRemove);
        }
        return yRemove;
    }

    protected synchronized void m(long j10) {
        while (this.f31803d > j10) {
            Iterator<Map.Entry<T, Y>> it = this.f31800a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f31803d -= (long) i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }

    protected void j(@NonNull T t10, @Nullable Y y10) {
    }
}
