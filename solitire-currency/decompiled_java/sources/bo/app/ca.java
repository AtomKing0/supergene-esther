package bo.app;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class ca implements u00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2496b;

    public ca(LinkedHashSet eventsList) {
        kotlin.jvm.internal.t.i(eventsList, "eventsList");
        this.f2495a = eventsList;
        this.f2496b = eventsList.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ca) && kotlin.jvm.internal.t.d(this.f2495a, ((ca) obj).f2495a);
    }

    public final int hashCode() {
        return this.f2495a.hashCode();
    }

    @Override // bo.app.u00
    public final boolean isEmpty() {
        return this.f2496b;
    }

    public final String toString() {
        return "BrazeEventContainer(eventsList=" + this.f2495a + ')';
    }
}
