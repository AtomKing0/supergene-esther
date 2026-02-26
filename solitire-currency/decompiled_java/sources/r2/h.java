package r2;

import a4.c0;
import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: StreamNameChunk.java */
/* JADX INFO: loaded from: classes2.dex */
final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33301a;

    private h(String str) {
        this.f33301a = str;
    }

    public static h a(c0 c0Var) {
        return new h(c0Var.A(c0Var.a()));
    }

    @Override // r2.a
    public int getType() {
        return AviExtractor.FOURCC_strn;
    }
}
