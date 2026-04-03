package j1;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r0.j;

/* JADX INFO: compiled from: ResourceDecoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f28619a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f28620b = new HashMap();

    /* JADX INFO: compiled from: ResourceDecoderRegistry.java */
    private static class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f28621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<R> f28622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final j<T, R> f28623c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, j<T, R> jVar) {
            this.f28621a = cls;
            this.f28622b = cls2;
            this.f28623c = jVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f28621a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f28622b);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> c(@NonNull String str) {
        List<a<?, ?>> arrayList;
        if (!this.f28619a.contains(str)) {
            this.f28619a.add(str);
        }
        arrayList = this.f28620b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f28620b.put(str, arrayList);
        }
        return arrayList;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull j<T, R> jVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, jVar));
    }

    @NonNull
    public synchronized <T, R> List<j<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f28619a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f28620b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f28623c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f28619a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f28620b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f28622b)) {
                        arrayList.add(aVar.f28622b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f28619a);
        this.f28619a.clear();
        this.f28619a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f28619a.add(str);
            }
        }
    }
}
