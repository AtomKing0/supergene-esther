package bb;

import ga.e0;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class h implements ab.h<e0, Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final h f2333a = new h();

    h() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long convert(e0 e0Var) throws IOException {
        return Long.valueOf(e0Var.string());
    }
}
