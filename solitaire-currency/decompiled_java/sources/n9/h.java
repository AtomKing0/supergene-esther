package n9;

import java.util.NoSuchElementException;
import kotlin.collections.l0;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f31725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31728d;

    public h(int i10, int i11, int i12) {
        this.f31725a = i12;
        this.f31726b = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f31727c = z10;
        this.f31728d = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f31727c;
    }

    @Override // kotlin.collections.l0
    public int nextInt() {
        int i10 = this.f31728d;
        if (i10 != this.f31726b) {
            this.f31728d = this.f31725a + i10;
        } else {
            if (!this.f31727c) {
                throw new NoSuchElementException();
            }
            this.f31727c = false;
        }
        return i10;
    }
}
