package bb;

import ga.e0;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class b implements ab.h<e0, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f2327a = new b();

    b() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean convert(e0 e0Var) throws IOException {
        return Boolean.valueOf(e0Var.string());
    }
}
