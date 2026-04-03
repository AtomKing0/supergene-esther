package bo.app;

import com.braze.models.IPutIntoJson;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class cc0 implements IPutIntoJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f2501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2502b;

    public cc0(UUID sessionIdUuid) {
        kotlin.jvm.internal.t.i(sessionIdUuid, "sessionIdUuid");
        this.f2501a = sessionIdUuid;
        String string = sessionIdUuid.toString();
        kotlin.jvm.internal.t.h(string, "sessionIdUuid.toString()");
        this.f2502b = string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof cc0) && kotlin.jvm.internal.t.d(this.f2501a, ((cc0) obj).f2501a);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        return this.f2502b;
    }

    public final int hashCode() {
        return this.f2501a.hashCode();
    }

    public final String toString() {
        return this.f2502b;
    }
}
