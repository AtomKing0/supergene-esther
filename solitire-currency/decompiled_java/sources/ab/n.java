package ab;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Invocation.java */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<?> f435b;

    n(Method method, List<?> list) {
        this.f434a = method;
        this.f435b = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f434a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f434a.getDeclaringClass().getName(), this.f434a.getName(), this.f435b);
    }
}
