package s0;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import s0.e;

/* JADX INFO: compiled from: DataRewinderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e.a<?> f33447b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f33448a = new HashMap();

    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    class a implements e.a<Object> {
        a() {
        }

        @Override // s0.e.a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // s0.e.a
        @NonNull
        public e<Object> b(@NonNull Object obj) {
            return new b(obj);
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t10) {
        e.a<?> aVar;
        o1.j.d(t10);
        aVar = this.f33448a.get(t10.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f33448a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t10.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f33447b;
        }
        return (e<T>) aVar.b(t10);
    }

    public synchronized void b(@NonNull e.a<?> aVar) {
        this.f33448a.put(aVar.a(), aVar);
    }

    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    private static final class b implements e<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f33449a;

        b(@NonNull Object obj) {
            this.f33449a = obj;
        }

        @Override // s0.e
        @NonNull
        public Object a() {
            return this.f33449a;
        }

        @Override // s0.e
        public void b() {
        }
    }
}
