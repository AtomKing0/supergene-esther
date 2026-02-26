package l3;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import l2.t1;

/* JADX INFO: compiled from: ProgressiveMediaExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public interface j0 {

    /* JADX INFO: compiled from: ProgressiveMediaExtractor.java */
    public interface a {
        j0 a(t1 t1Var);
    }

    void a(z3.h hVar, Uri uri, Map<String, List<String>> map, long j10, long j11, p2.n nVar) throws IOException;

    int b(p2.a0 a0Var) throws IOException;

    void disableSeekingOnMp3Streams();

    long getCurrentInputPosition();

    void release();

    void seek(long j10, long j11);
}
