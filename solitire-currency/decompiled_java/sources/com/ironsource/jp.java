package com.ironsource;

import com.ironsource.g2;

/* JADX INFO: loaded from: classes4.dex */
public final class jp {
    /* JADX INFO: Access modifiers changed from: private */
    public static final g2 b(pp ppVar, boolean z10) {
        return new g2(z10 ? g2.a.MANUAL : ppVar.k().e() ? g2.a.AUTOMATIC_LOAD_WHILE_SHOW : g2.a.AUTOMATIC_LOAD_AFTER_CLOSE, ppVar.k().j(), ppVar.k().b(), -1L);
    }
}
