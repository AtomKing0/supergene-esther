package t9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface p<T> extends s9.h<T> {

    /* JADX INFO: compiled from: ChannelFlow.kt */
    public static final class a {
        public static /* synthetic */ s9.h a(p pVar, z8.g gVar, int i10, r9.a aVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i11 & 1) != 0) {
                gVar = z8.h.f37608a;
            }
            if ((i11 & 2) != 0) {
                i10 = -3;
            }
            if ((i11 & 4) != 0) {
                aVar = r9.a.SUSPEND;
            }
            return pVar.b(gVar, i10, aVar);
        }
    }

    @NotNull
    s9.h<T> b(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar);
}
