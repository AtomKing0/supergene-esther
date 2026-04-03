package bb;

import ga.e0;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class c implements ab.h<e0, Byte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c f2328a = new c();

    c() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Byte convert(e0 e0Var) throws IOException {
        return Byte.valueOf(e0Var.string());
    }
}
