package com.braze.coroutine;

import bo.app.q8;
import bo.app.r8;
import h9.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y2;
import v8.k0;
import z8.d;
import z8.g;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeCoroutineScope implements o0 {
    public static final BrazeCoroutineScope INSTANCE = new BrazeCoroutineScope();
    private static final g coroutineContext;
    private static final l0 exceptionHandler;

    static {
        r8 r8Var = new r8(l0.N7);
        exceptionHandler = r8Var;
        coroutineContext = e1.b().plus(r8Var).plus(y2.b(null, 1, null));
    }

    private BrazeCoroutineScope() {
    }

    public static /* synthetic */ b2 launchDelayed$default(BrazeCoroutineScope brazeCoroutineScope, Number number, g gVar, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gVar = brazeCoroutineScope.getCoroutineContext();
        }
        return brazeCoroutineScope.launchDelayed(number, gVar, lVar);
    }

    @Override // kotlinx.coroutines.o0
    public g getCoroutineContext() {
        return coroutineContext;
    }

    public final b2 launchDelayed(Number startDelayInMs, g specificContext, l<? super d<? super k0>, ? extends Object> block) {
        t.i(startDelayInMs, "startDelayInMs");
        t.i(specificContext, "specificContext");
        t.i(block, "block");
        return k.d(this, specificContext, null, new q8(startDelayInMs, block, null), 2, null);
    }
}
