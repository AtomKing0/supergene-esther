package u0;

import androidx.annotation.NonNull;
import java.io.File;
import w0.a;

/* JADX INFO: compiled from: DataCacheWriter.java */
/* JADX INFO: loaded from: classes2.dex */
class e<DataType> implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r0.d<DataType> f34247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataType f34248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r0.h f34249c;

    e(r0.d<DataType> dVar, DataType datatype, r0.h hVar) {
        this.f34247a = dVar;
        this.f34248b = datatype;
        this.f34249c = hVar;
    }

    @Override // w0.a.b
    public boolean a(@NonNull File file) {
        return this.f34247a.a(this.f34248b, file, this.f34249c);
    }
}
