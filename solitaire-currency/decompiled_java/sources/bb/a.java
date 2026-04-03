package bb;

import ga.c0;
import ga.x;
import java.io.IOException;

/* JADX INFO: compiled from: ScalarRequestBodyConverter.java */
/* JADX INFO: loaded from: classes5.dex */
final class a<T> implements ab.h<T, c0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a<Object> f2325a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final x f2326b = x.e("text/plain; charset=UTF-8");

    private a() {
    }

    @Override // ab.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c0 convert(T t10) throws IOException {
        return c0.create(f2326b, String.valueOf(t10));
    }
}
