package q8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.i;
import p8.j;
import p8.m;
import p8.p;
import p8.r;

/* JADX INFO: compiled from: Unsafe.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final byte[] f33176a = new byte[0];

    public static final void a(@NotNull m mVar, @NotNull a current) {
        t.i(mVar, "<this>");
        t.i(current, "current");
        if (current == mVar) {
            return;
        }
        if (!(current.j() > current.h())) {
            mVar.O(current);
        } else if (current.e() - current.f() < 8) {
            mVar.i0(current);
        } else {
            mVar.c1(current.h());
        }
    }

    @Nullable
    public static final a b(@NotNull m mVar, int i10) {
        t.i(mVar, "<this>");
        return mVar.V0(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final a c(@NotNull m mVar, @NotNull a current) {
        t.i(mVar, "<this>");
        t.i(current, "current");
        if (current != mVar) {
            return mVar.S(current);
        }
        if (mVar.q()) {
            return (a) mVar;
        }
        return null;
    }

    @NotNull
    public static final a d(@NotNull p pVar, int i10, @Nullable a aVar) {
        t.i(pVar, "<this>");
        if (aVar != null) {
            pVar.c();
        }
        return pVar.J0(i10);
    }

    public static final int e(@NotNull j jVar, @NotNull i builder) {
        t.i(jVar, "<this>");
        t.i(builder, "builder");
        int iU0 = builder.U0();
        a aVarK0 = builder.K0();
        if (aVarK0 == null) {
            return 0;
        }
        if (iU0 <= r.a() && aVarK0.x() == null && jVar.h1(aVarK0)) {
            builder.a();
            return iU0;
        }
        jVar.c(aVarK0);
        return iU0;
    }
}
