package u9;

import kotlinx.coroutines.g1;
import kotlinx.coroutines.n2;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes5.dex */
final class y extends n2 implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Throwable f34717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f34718b;

    public y(@Nullable Throwable th, @Nullable String str) {
        this.f34717a = th;
        this.f34718b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void J0() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f34717a
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f34718b
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f34717a
            r1.<init>(r0, r2)
            throw r1
        L36:
            u9.x.d()
            v8.h r0 = new v8.h
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.y.J0():java.lang.Void");
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public Void dispatch(@NotNull z8.g gVar, @NotNull Runnable runnable) {
        J0();
        throw new v8.h();
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public Void scheduleResumeAfterDelay(long j10, @NotNull kotlinx.coroutines.o<? super v8.k0> oVar) {
        J0();
        throw new v8.h();
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public g1 invokeOnTimeout(long j10, @NotNull Runnable runnable, @NotNull z8.g gVar) {
        J0();
        throw new v8.h();
    }

    @Override // kotlinx.coroutines.k0
    public boolean isDispatchNeeded(@NotNull z8.g gVar) {
        J0();
        throw new v8.h();
    }

    @Override // kotlinx.coroutines.n2, kotlinx.coroutines.k0
    @NotNull
    public kotlinx.coroutines.k0 limitedParallelism(int i10) {
        J0();
        throw new v8.h();
    }

    @Override // kotlinx.coroutines.n2, kotlinx.coroutines.k0
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f34717a != null) {
            str = ", cause=" + this.f34717a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.n2
    @NotNull
    public n2 getImmediate() {
        return this;
    }
}
