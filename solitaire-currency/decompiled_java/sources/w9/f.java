package w9;

import java.util.concurrent.Executor;
import kotlinx.coroutines.q1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public class f extends q1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f35536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f35537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private a f35538f = J0();

    public f(int i10, int i11, long j10, @NotNull String str) {
        this.f35534b = i10;
        this.f35535c = i11;
        this.f35536d = j10;
        this.f35537e = str;
    }

    private final a J0() {
        return new a(this.f35534b, this.f35535c, this.f35536d, this.f35537e);
    }

    @Override // kotlinx.coroutines.q1
    @NotNull
    public Executor I0() {
        return this.f35538f;
    }

    public final void K0(@NotNull Runnable runnable, @NotNull i iVar, boolean z10) {
        this.f35538f.x(runnable, iVar, z10);
    }

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        a.z(this.f35538f, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.k0
    public void dispatchYield(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        a.z(this.f35538f, runnable, null, true, 2, null);
    }
}
