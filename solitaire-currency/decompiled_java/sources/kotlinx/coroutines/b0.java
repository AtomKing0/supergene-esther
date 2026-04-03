package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f29855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final m f29856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final h9.l<Throwable, v8.k0> f29857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Object f29858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Throwable f29859e;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(@Nullable Object obj, @Nullable m mVar, @Nullable h9.l<? super Throwable, v8.k0> lVar, @Nullable Object obj2, @Nullable Throwable th) {
        this.f29855a = obj;
        this.f29856b = mVar;
        this.f29857c = lVar;
        this.f29858d = obj2;
        this.f29859e = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b0 b(b0 b0Var, Object obj, m mVar, h9.l lVar, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = b0Var.f29855a;
        }
        if ((i10 & 2) != 0) {
            mVar = b0Var.f29856b;
        }
        m mVar2 = mVar;
        if ((i10 & 4) != 0) {
            lVar = b0Var.f29857c;
        }
        h9.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = b0Var.f29858d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = b0Var.f29859e;
        }
        return b0Var.a(obj, mVar2, lVar2, obj4, th);
    }

    @NotNull
    public final b0 a(@Nullable Object obj, @Nullable m mVar, @Nullable h9.l<? super Throwable, v8.k0> lVar, @Nullable Object obj2, @Nullable Throwable th) {
        return new b0(obj, mVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f29859e != null;
    }

    public final void d(@NotNull p<?> pVar, @NotNull Throwable th) {
        m mVar = this.f29856b;
        if (mVar != null) {
            pVar.p(mVar, th);
        }
        h9.l<Throwable, v8.k0> lVar = this.f29857c;
        if (lVar != null) {
            pVar.q(lVar, th);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return kotlin.jvm.internal.t.d(this.f29855a, b0Var.f29855a) && kotlin.jvm.internal.t.d(this.f29856b, b0Var.f29856b) && kotlin.jvm.internal.t.d(this.f29857c, b0Var.f29857c) && kotlin.jvm.internal.t.d(this.f29858d, b0Var.f29858d) && kotlin.jvm.internal.t.d(this.f29859e, b0Var.f29859e);
    }

    public int hashCode() {
        Object obj = this.f29855a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        m mVar = this.f29856b;
        int iHashCode2 = (iHashCode + (mVar == null ? 0 : mVar.hashCode())) * 31;
        h9.l<Throwable, v8.k0> lVar = this.f29857c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f29858d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f29859e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.f29855a + ", cancelHandler=" + this.f29856b + ", onCancellation=" + this.f29857c + ", idempotentResume=" + this.f29858d + ", cancelCause=" + this.f29859e + ')';
    }

    public /* synthetic */ b0(Object obj, m mVar, h9.l lVar, Object obj2, Throwable th, int i10, kotlin.jvm.internal.k kVar) {
        this(obj, (i10 & 2) != 0 ? null : mVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
