package bb;

import ga.e0;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class i implements ab.h<e0, Short> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final i f2334a = new i();

    i() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Short convert(e0 e0Var) throws IOException {
        return Short.valueOf(e0Var.string());
    }
}
