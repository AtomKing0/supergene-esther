package z3;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Allocator.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: compiled from: Allocator.java */
    public interface a {
        z3.a getAllocation();

        @Nullable
        a next();
    }

    void a(z3.a aVar);

    z3.a allocate();

    void b(a aVar);

    int getIndividualAllocationLength();

    void trim();
}
