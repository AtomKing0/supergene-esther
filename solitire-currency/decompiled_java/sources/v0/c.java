package v0;

import java.util.Queue;
import v0.l;

/* JADX INFO: compiled from: BaseKeyPool.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class c<T extends l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f34987a = o1.k.e(20);

    c() {
    }

    abstract T a();

    T b() {
        T tPoll = this.f34987a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t10) {
        if (this.f34987a.size() < 20) {
            this.f34987a.offer(t10);
        }
    }
}
