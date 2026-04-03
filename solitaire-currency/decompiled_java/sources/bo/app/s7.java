package bo.app;

import com.braze.models.IPutIntoJson;

/* JADX INFO: loaded from: classes2.dex */
public final class s7 implements IPutIntoJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3835a;

    public s7(String apiKey) {
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        this.f3835a = apiKey;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s7) && kotlin.jvm.internal.t.d(this.f3835a, ((s7) obj).f3835a);
    }

    @Override // com.braze.models.IPutIntoJson
    public final Object forJsonPut() {
        return this.f3835a;
    }

    public final int hashCode() {
        return this.f3835a.hashCode();
    }

    public final String toString() {
        return this.f3835a;
    }
}
