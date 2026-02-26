package u9;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.n2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f34713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f34714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final n2 f34715c;

    static {
        w wVar = new w();
        f34713a = wVar;
        f34714b = i0.f("kotlinx.coroutines.fast.service.loader", true);
        f34715c = wVar.a();
    }

    private w() {
    }

    private final n2 a() {
        Object next;
        n2 n2VarE;
        try {
            List<v> listC = f34714b ? l.f34670a.c() : o9.o.w(o9.m.c(ServiceLoader.load(v.class, v.class.getClassLoader()).iterator()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((v) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((v) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            v vVar = (v) next;
            return (vVar == null || (n2VarE = x.e(vVar, listC)) == null) ? x.b(null, null, 3, null) : n2VarE;
        } catch (Throwable th) {
            return x.b(th, null, 2, null);
        }
    }
}
