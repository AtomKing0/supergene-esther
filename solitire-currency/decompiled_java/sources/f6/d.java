package f6;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: GlobalLibraryVersionRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f25715b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<f> f25716a = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = f25715b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f25715b;
                if (dVar == null) {
                    dVar = new d();
                    f25715b = dVar;
                }
            }
        }
        return dVar;
    }

    Set<f> b() {
        Set<f> setUnmodifiableSet;
        synchronized (this.f25716a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f25716a);
        }
        return setUnmodifiableSet;
    }
}
