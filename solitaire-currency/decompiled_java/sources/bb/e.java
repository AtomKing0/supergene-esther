package bb;

import ga.e0;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes5.dex */
final class e implements ab.h<e0, Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final e f2330a = new e();

    e() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Double convert(e0 e0Var) throws IOException {
        return Double.valueOf(e0Var.string());
    }
}
