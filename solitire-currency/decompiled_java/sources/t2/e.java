package t2;

import a4.c0;
import k2.j2;
import p2.e0;

/* JADX INFO: compiled from: TagPayloadReader.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final e0 f34057a;

    /* JADX INFO: compiled from: TagPayloadReader.java */
    public static final class a extends j2 {
        public a(String str) {
            super(str, null, false, 1);
        }
    }

    protected e(e0 e0Var) {
        this.f34057a = e0Var;
    }

    public final boolean a(c0 c0Var, long j10) throws j2 {
        return b(c0Var) && c(c0Var, j10);
    }

    protected abstract boolean b(c0 c0Var) throws j2;

    protected abstract boolean c(c0 c0Var, long j10) throws j2;
}
