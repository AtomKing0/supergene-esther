package l2;

import androidx.annotation.Nullable;
import k2.n3;
import l2.c;
import l3.a0;

/* JADX INFO: compiled from: PlaybackSessionManager.java */
/* JADX INFO: loaded from: classes2.dex */
public interface s1 {

    /* JADX INFO: compiled from: PlaybackSessionManager.java */
    public interface a {
        void U(c.a aVar, String str, boolean z10);

        void o0(c.a aVar, String str, String str2);

        void v0(c.a aVar, String str);

        void w0(c.a aVar, String str);
    }

    void a(a aVar);

    void b(c.a aVar);

    String c(n3 n3Var, a0.b bVar);

    void d(c.a aVar);

    void e(c.a aVar, int i10);

    void f(c.a aVar);

    @Nullable
    String getActiveSessionId();
}
