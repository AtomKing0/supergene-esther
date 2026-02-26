package z3;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: HttpDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f37374a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Map<String, String> f37375b;

    public synchronized Map<String, String> a() {
        if (this.f37375b == null) {
            this.f37375b = Collections.unmodifiableMap(new HashMap(this.f37374a));
        }
        return this.f37375b;
    }
}
