package b7;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SignalsStorage.java */
/* JADX INFO: loaded from: classes4.dex */
public class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, T> f2232a = new ConcurrentHashMap();

    public T a(String str) {
        return this.f2232a.get(str);
    }

    public void b(String str, T t10) {
        this.f2232a.put(str, t10);
    }
}
