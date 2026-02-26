package h1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RequestTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<k1.c> f26412a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<k1.c> f26413b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26414c;

    public boolean a(@Nullable k1.c cVar) {
        boolean z10 = true;
        if (cVar == null) {
            return true;
        }
        boolean zRemove = this.f26412a.remove(cVar);
        if (!this.f26413b.remove(cVar) && !zRemove) {
            z10 = false;
        }
        if (z10) {
            cVar.clear();
        }
        return z10;
    }

    public void b() {
        Iterator it = o1.k.i(this.f26412a).iterator();
        while (it.hasNext()) {
            a((k1.c) it.next());
        }
        this.f26413b.clear();
    }

    public void c() {
        this.f26414c = true;
        for (k1.c cVar : o1.k.i(this.f26412a)) {
            if (cVar.isRunning() || cVar.h()) {
                cVar.clear();
                this.f26413b.add(cVar);
            }
        }
    }

    public void d() {
        this.f26414c = true;
        for (k1.c cVar : o1.k.i(this.f26412a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                this.f26413b.add(cVar);
            }
        }
    }

    public void e() {
        for (k1.c cVar : o1.k.i(this.f26412a)) {
            if (!cVar.h() && !cVar.d()) {
                cVar.clear();
                if (this.f26414c) {
                    this.f26413b.add(cVar);
                } else {
                    cVar.j();
                }
            }
        }
    }

    public void f() {
        this.f26414c = false;
        for (k1.c cVar : o1.k.i(this.f26412a)) {
            if (!cVar.h() && !cVar.isRunning()) {
                cVar.j();
            }
        }
        this.f26413b.clear();
    }

    public void g(@NonNull k1.c cVar) {
        this.f26412a.add(cVar);
        if (!this.f26414c) {
            cVar.j();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f26413b.add(cVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f26412a.size() + ", isPaused=" + this.f26414c + "}";
    }
}
