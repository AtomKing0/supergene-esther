package bo.app;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class hy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f3008a;

    public hy(JSONArray featureFlagsData) {
        kotlin.jvm.internal.t.i(featureFlagsData, "featureFlagsData");
        this.f3008a = featureFlagsData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof hy) && kotlin.jvm.internal.t.d(this.f3008a, ((hy) obj).f3008a);
    }

    public final int hashCode() {
        return this.f3008a.hashCode();
    }

    public final String toString() {
        return "FeatureFlagsReceivedEvent(featureFlagsData=" + this.f3008a + ')';
    }
}
