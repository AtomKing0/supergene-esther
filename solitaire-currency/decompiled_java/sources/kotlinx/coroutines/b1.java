package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b1<T> extends w9.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29860c;

    public b1(int i10) {
        this.f29860c = i10;
    }

    @NotNull
    public abstract z8.d<T> d();

    @Nullable
    public Throwable e(@Nullable Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f29865a;
        }
        return null;
    }

    public final void g(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            v8.f.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.t.f(th);
        m0.a(d().getContext(), new r0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Nullable
    public abstract Object h();

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088 A[Catch: all -> 0x00b5, DONT_GENERATE, TRY_LEAVE, TryCatch #2 {all -> 0x00b5, blocks: (B:3:0x0002, B:5:0x001e, B:23:0x0082, B:25:0x0088, B:33:0x00ab, B:36:0x00b4, B:35:0x00b1, B:8:0x0024, B:10:0x0032, B:12:0x003a, B:15:0x0046, B:17:0x004c, B:21:0x007e, B:19:0x0063, B:20:0x0071), top: B:48:0x0002, inners: #3 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.b1.run():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(@Nullable Object obj) {
        return obj;
    }

    public void c(@Nullable Object obj, @NotNull Throwable th) {
    }
}
