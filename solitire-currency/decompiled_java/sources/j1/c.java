package j1;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import g1.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import u0.i;
import u0.t;

/* JADX INFO: compiled from: LoadPathCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final t<?, ?, ?> f28614c = new t<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayMap<o1.i, t<?, ?, ?>> f28615a = new ArrayMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<o1.i> f28616b = new AtomicReference<>();

    private o1.i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        o1.i andSet = this.f28616b.getAndSet(null);
        if (andSet == null) {
            andSet = new o1.i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVar;
        o1.i iVarB = b(cls, cls2, cls3);
        synchronized (this.f28615a) {
            tVar = (t) this.f28615a.get(iVarB);
        }
        this.f28616b.set(iVarB);
        return tVar;
    }

    public boolean c(@Nullable t<?, ?, ?> tVar) {
        return f28614c.equals(tVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable t<?, ?, ?> tVar) {
        synchronized (this.f28615a) {
            ArrayMap<o1.i, t<?, ?, ?>> arrayMap = this.f28615a;
            o1.i iVar = new o1.i(cls, cls2, cls3);
            if (tVar == null) {
                tVar = f28614c;
            }
            arrayMap.put(iVar, tVar);
        }
    }
}
