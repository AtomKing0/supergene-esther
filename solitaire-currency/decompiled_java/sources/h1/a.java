package h1;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ActivityFragmentLifecycle.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<i> f26387a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f26388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26389c;

    a() {
    }

    @Override // h1.h
    public void a(@NonNull i iVar) {
        this.f26387a.remove(iVar);
    }

    @Override // h1.h
    public void b(@NonNull i iVar) {
        this.f26387a.add(iVar);
        if (this.f26389c) {
            iVar.onDestroy();
        } else if (this.f26388b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    void c() {
        this.f26389c = true;
        Iterator it = o1.k.i(this.f26387a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onDestroy();
        }
    }

    void d() {
        this.f26388b = true;
        Iterator it = o1.k.i(this.f26387a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStart();
        }
    }

    void e() {
        this.f26388b = false;
        Iterator it = o1.k.i(this.f26387a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStop();
        }
    }
}
