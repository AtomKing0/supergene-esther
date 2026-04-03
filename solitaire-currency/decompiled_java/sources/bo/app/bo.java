package bo.app;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class bo implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return x8.b.a(Long.valueOf(((z80) obj).f4411b), Long.valueOf(((z80) obj2).f4411b));
    }
}
