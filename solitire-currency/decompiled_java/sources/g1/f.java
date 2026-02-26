package g1;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TranscoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f25784a = new ArrayList();

    /* JADX INFO: compiled from: TranscoderRegistry.java */
    private static final class a<Z, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<Z> f25785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<R> f25786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e<Z, R> f25787c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f25785a = cls;
            this.f25786b = cls2;
            this.f25787c = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f25785a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f25786b);
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f25784a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f25787c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f25784a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f25784a.add(new a<>(cls, cls2, eVar));
    }
}
