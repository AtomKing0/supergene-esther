package bo.app;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class tr {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final rr f3964e = new rr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cc0 f3967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l00 f3968d;

    public /* synthetic */ tr(int i10, List list, cc0 cc0Var, tg tgVar, int i11) {
        this(i10, (i11 & 2) != 0 ? kotlin.collections.v.l() : list, (i11 & 4) != 0 ? null : cc0Var, (i11 & 8) != 0 ? null : tgVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tr)) {
            return false;
        }
        tr trVar = (tr) obj;
        return this.f3965a == trVar.f3965a && kotlin.jvm.internal.t.d(this.f3966b, trVar.f3966b) && kotlin.jvm.internal.t.d(this.f3967c, trVar.f3967c) && kotlin.jvm.internal.t.d(this.f3968d, trVar.f3968d);
    }

    public final int hashCode() {
        int iHashCode = (this.f3966b.hashCode() + (gc0.a(this.f3965a) * 31)) * 31;
        cc0 cc0Var = this.f3967c;
        int iHashCode2 = (iHashCode + (cc0Var == null ? 0 : cc0Var.f2501a.hashCode())) * 31;
        l00 l00Var = this.f3968d;
        return iHashCode2 + (l00Var != null ? l00Var.hashCode() : 0);
    }

    public final String toString() {
        return p9.j.f("\n            commandType = " + sr.a(this.f3965a) + "\n            brazeEvents = " + this.f3966b + "\n            sessionId = " + this.f3967c + "\n            brazeRequest = " + this.f3968d + "\n        ");
    }

    public tr(int i10, List list, cc0 cc0Var, l00 l00Var) {
        this.f3965a = i10;
        this.f3966b = list;
        this.f3967c = cc0Var;
        this.f3968d = l00Var;
    }
}
