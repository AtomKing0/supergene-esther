package bo.app;

import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class kr implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pr f3279a;

    public kr(pr prVar) {
        this.f3279a = prVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f3279a) {
            pr prVar = this.f3279a;
            if (prVar.f3653i == null) {
                return null;
            }
            while (prVar.f3652h > prVar.f3650f) {
                prVar.d((String) ((Map.Entry) prVar.f3654j.entrySet().iterator().next()).getKey());
            }
            if (this.f3279a.a()) {
                this.f3279a.d();
                this.f3279a.f3655k = 0;
            }
            return null;
        }
    }
}
