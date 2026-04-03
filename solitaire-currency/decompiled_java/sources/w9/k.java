package w9;

import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final Runnable f35542c;

    public k(@NotNull Runnable runnable, long j10, @NotNull i iVar) {
        super(j10, iVar);
        this.f35542c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f35542c.run();
        } finally {
            this.f35540b.a();
        }
    }

    @NotNull
    public String toString() {
        return "Task[" + s0.a(this.f35542c) + '@' + s0.b(this.f35542c) + ", " + this.f35539a + ", " + this.f35540b + ']';
    }
}
