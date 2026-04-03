package bo.app;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h50 extends p40 {
    public h50(ArrayList arrayList) {
        super(arrayList);
    }

    @Override // bo.app.n00
    public final boolean a(g10 g10Var) {
        Iterator it = this.f3604a.iterator();
        while (it.hasNext()) {
            if (((n00) it.next()).a(g10Var)) {
                return true;
            }
        }
        return false;
    }
}
