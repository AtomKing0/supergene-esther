package bo.app;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ia0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3040a;

    public ia0(ArrayList logs) {
        kotlin.jvm.internal.t.i(logs, "logs");
        this.f3040a = logs;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ia0) && kotlin.jvm.internal.t.d(this.f3040a, ((ia0) obj).f3040a);
    }

    public final int hashCode() {
        return this.f3040a.hashCode();
    }

    public final String toString() {
        return "SdkDebuggerSendLogEvent(logs=" + this.f3040a + ')';
    }
}
