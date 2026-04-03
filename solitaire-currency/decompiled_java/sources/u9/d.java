package u9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final h0 f34649a = new h0("CLOSED");

    @NotNull
    public static final <N extends e<N>> N b(@NotNull N n10) {
        while (true) {
            Object objF = n10.f();
            if (objF == f34649a) {
                return n10;
            }
            e eVar = (e) objF;
            if (eVar != null) {
                n10 = (N) eVar;
            } else if (n10.j()) {
                return n10;
            }
        }
    }

    @NotNull
    public static final <S extends e0<S>> Object c(@NotNull S s10, long j10, @NotNull h9.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.f34654c >= j10 && !s10.h()) {
                return f0.a(s10);
            }
            Object objF = s10.f();
            if (objF == f34649a) {
                return f0.a(f34649a);
            }
            S sMo4invoke = (S) ((e) objF);
            if (sMo4invoke == null) {
                sMo4invoke = pVar.mo4invoke(Long.valueOf(s10.f34654c + 1), s10);
                if (s10.l(sMo4invoke)) {
                    if (s10.h()) {
                        s10.k();
                    }
                }
            }
            s10 = (Object) sMo4invoke;
        }
    }
}
