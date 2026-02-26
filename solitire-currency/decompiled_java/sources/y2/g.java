package y2;

import androidx.annotation.Nullable;
import java.io.IOException;
import p2.b0;
import p2.m;

/* JADX INFO: compiled from: OggSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
interface g {
    long a(m mVar) throws IOException;

    @Nullable
    b0 createSeekMap();

    void startSeek(long j10);
}
