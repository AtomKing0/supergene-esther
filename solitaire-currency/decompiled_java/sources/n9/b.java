package n9;

import java.util.NoSuchElementException;
import kotlin.collections.s;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f31713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31716d;

    public b(char c10, char c11, int i10) {
        this.f31713a = i10;
        this.f31714b = c11;
        boolean z10 = true;
        if (i10 <= 0 ? t.k(c10, c11) < 0 : t.k(c10, c11) > 0) {
            z10 = false;
        }
        this.f31715c = z10;
        this.f31716d = z10 ? c10 : c11;
    }

    @Override // kotlin.collections.s
    public char a() {
        int i10 = this.f31716d;
        if (i10 != this.f31714b) {
            this.f31716d = this.f31713a + i10;
        } else {
            if (!this.f31715c) {
                throw new NoSuchElementException();
            }
            this.f31715c = false;
        }
        return (char) i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f31715c;
    }
}
