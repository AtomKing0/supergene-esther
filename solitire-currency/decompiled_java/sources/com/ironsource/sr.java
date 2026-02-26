package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class sr implements dl<mr, t> {
    @Override // com.ironsource.dl
    @NotNull
    public t a(@NotNull mr input) {
        we weVarE;
        String strC;
        String strG;
        String strI;
        String strH;
        kotlin.jvm.internal.t.i(input, "input");
        tr trVarB = input.b();
        k0 k0VarA = input.a();
        String str = (k0VarA == null || (strH = k0VarA.h()) == null) ? "0" : strH;
        k0 k0VarA2 = input.a();
        String str2 = (k0VarA2 == null || (strI = k0VarA2.i()) == null) ? "0" : strI;
        k0 k0VarA3 = input.a();
        String str3 = (k0VarA3 == null || (strG = k0VarA3.g()) == null) ? "0" : strG;
        k0 k0VarA4 = input.a();
        if (k0VarA4 == null || (weVarE = k0VarA4.e()) == null) {
            weVarE = we.UnknownProvider;
        }
        we weVar = weVarE;
        k0 k0VarA5 = input.a();
        if (k0VarA5 == null || (strC = k0VarA5.c()) == null) {
            strC = "0";
        }
        return new t(trVarB, str, str2, str3, weVar, strC);
    }
}
