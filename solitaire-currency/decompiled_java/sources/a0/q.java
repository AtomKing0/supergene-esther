package a0;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w.c;

/* JADX INFO: compiled from: HardwareBitmaps.kt */
/* JADX INFO: loaded from: classes2.dex */
final class q extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f60a = new a(null);

    /* JADX INFO: compiled from: HardwareBitmaps.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public q(@Nullable r rVar) {
        super(null);
    }

    @Override // a0.n
    public boolean a(@NotNull w.i iVar) {
        w.c cVarB = iVar.b();
        if ((cVarB instanceof c.a ? ((c.a) cVarB).f35260a : Integer.MAX_VALUE) > 100) {
            w.c cVarA = iVar.a();
            if ((cVarA instanceof c.a ? ((c.a) cVarA).f35260a : Integer.MAX_VALUE) > 100) {
                return true;
            }
        }
        return false;
    }

    @Override // a0.n
    public boolean b() {
        return m.f49a.b(null);
    }
}
