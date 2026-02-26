package n2;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import k2.o1;

/* JADX INFO: compiled from: DecoderReuseEvaluation.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f31596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1 f31597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o1 f31598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f31599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f31600e;

    public i(String str, o1 o1Var, o1 o1Var2, int i10, int i11) {
        a4.a.a(i10 == 0 || i11 == 0);
        this.f31596a = a4.a.d(str);
        this.f31597b = (o1) a4.a.e(o1Var);
        this.f31598c = (o1) a4.a.e(o1Var2);
        this.f31599d = i10;
        this.f31600e = i11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f31599d == iVar.f31599d && this.f31600e == iVar.f31600e && this.f31596a.equals(iVar.f31596a) && this.f31597b.equals(iVar.f31597b) && this.f31598c.equals(iVar.f31598c);
    }

    public int hashCode() {
        return ((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f31599d) * 31) + this.f31600e) * 31) + this.f31596a.hashCode()) * 31) + this.f31597b.hashCode()) * 31) + this.f31598c.hashCode();
    }
}
