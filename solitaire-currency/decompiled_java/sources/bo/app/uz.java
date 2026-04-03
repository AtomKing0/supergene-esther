package bo.app;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class uz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4062a;

    public uz(List geofencesList) {
        kotlin.jvm.internal.t.i(geofencesList, "geofencesList");
        this.f4062a = geofencesList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof uz) && kotlin.jvm.internal.t.d(this.f4062a, ((uz) obj).f4062a);
    }

    public final int hashCode() {
        return this.f4062a.hashCode();
    }

    public final String toString() {
        return "GeofencesReceivedEvent(geofencesList=" + this.f4062a + ')';
    }
}
