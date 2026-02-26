package w2;

import androidx.media3.common.C;
import p2.b0;

/* JADX INFO: compiled from: Seeker.java */
/* JADX INFO: loaded from: classes2.dex */
interface g extends b0 {

    /* JADX INFO: compiled from: Seeker.java */
    public static class a extends b0.b implements g {
        public a() {
            super(C.TIME_UNSET);
        }

        @Override // w2.g
        public long getDataEndPosition() {
            return -1L;
        }

        @Override // w2.g
        public long getTimeUs(long j10) {
            return 0L;
        }
    }

    long getDataEndPosition();

    long getTimeUs(long j10);
}
