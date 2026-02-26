package x9;

import h9.l;
import h9.q;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.h0;
import v8.k0;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final q<Object, Object, Object, Object> f36235a = a.f36241g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final h0 f36236b = new h0("STATE_REG");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final h0 f36237c = new h0("STATE_COMPLETED");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final h0 f36238d = new h0("STATE_CANCELLED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final h0 f36239e = new h0("NO_RESULT");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final h0 f36240f = new h0("PARAM_CLAUSE_0");

    /* JADX INFO: compiled from: Select.kt */
    static final class a extends v implements q {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f36241g = new a();

        a() {
            super(3);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(@NotNull Object obj, @Nullable Object obj2, @Nullable Object obj3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d a(int i10) {
        if (i10 == 0) {
            return d.SUCCESSFUL;
        }
        if (i10 == 1) {
            return d.REREGISTER;
        }
        if (i10 == 2) {
            return d.CANCELLED;
        }
        if (i10 == 3) {
            return d.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(o<? super k0> oVar, l<? super Throwable, k0> lVar) {
        Object objK = oVar.k(k0.f35197a, null, lVar);
        if (objK == null) {
            return false;
        }
        oVar.u(objK);
        return true;
    }
}
