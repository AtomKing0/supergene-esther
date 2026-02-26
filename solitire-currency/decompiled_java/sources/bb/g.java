package bb;

import ga.e0;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class g implements ab.h<e0, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final g f2332a = new g();

    g() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer convert(e0 e0Var) throws IOException {
        return Integer.valueOf(e0Var.string());
    }
}
