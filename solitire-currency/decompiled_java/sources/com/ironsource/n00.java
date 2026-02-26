package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class n00<T> {
    public static boolean a(sa saVar) {
        return saVar.j().exists();
    }

    public static void b(sa saVar) {
        saVar.k().a(saVar);
        if (saVar.j().exists()) {
            IronSourceStorageUtils.deleteFile(saVar.j());
        }
        try {
            saVar.k().a(saVar.j(), saVar.c().value(), 5, 5);
        } catch (Exception e10) {
            i9.d().a(e10);
            h9.l<v8.t<? extends T>, v8.k0> lVarI = saVar.i();
            t.a aVar = v8.t.f35208b;
            lVarI.invoke(v8.t.a(v8.t.b(v8.u.a(e10))));
        }
    }
}
