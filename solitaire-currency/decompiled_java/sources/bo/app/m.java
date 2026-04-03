package bo.app;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends p40 {
    public m(ArrayList arrayList) {
        super(arrayList);
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        Iterator it = this.f3604a.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (!((n00) it.next()).a(g10Var)) {
                return false;
            }
            z10 = true;
        }
        return z10;
    }
}
