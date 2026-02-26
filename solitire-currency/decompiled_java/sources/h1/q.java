package h1;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: TargetTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<l1.h<?>> f26422a = Collections.newSetFromMap(new WeakHashMap());

    public void h() {
        this.f26422a.clear();
    }

    @NonNull
    public List<l1.h<?>> i() {
        return o1.k.i(this.f26422a);
    }

    public void j(@NonNull l1.h<?> hVar) {
        this.f26422a.add(hVar);
    }

    public void k(@NonNull l1.h<?> hVar) {
        this.f26422a.remove(hVar);
    }

    @Override // h1.i
    public void onDestroy() {
        Iterator it = o1.k.i(this.f26422a).iterator();
        while (it.hasNext()) {
            ((l1.h) it.next()).onDestroy();
        }
    }

    @Override // h1.i
    public void onStart() {
        Iterator it = o1.k.i(this.f26422a).iterator();
        while (it.hasNext()) {
            ((l1.h) it.next()).onStart();
        }
    }

    @Override // h1.i
    public void onStop() {
        Iterator it = o1.k.i(this.f26422a).iterator();
        while (it.hasNext()) {
            ((l1.h) it.next()).onStop();
        }
    }
}
