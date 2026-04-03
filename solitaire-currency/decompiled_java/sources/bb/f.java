package bb;

import ga.e0;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class f implements ab.h<e0, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final f f2331a = new f();

    f() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float convert(e0 e0Var) throws IOException {
        return Float.valueOf(e0Var.string());
    }
}
