package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Lambda.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class v<R> implements o<R>, Serializable {
    private final int arity;

    public v(int i10) {
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.o
    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        String strI = o0.i(this);
        t.h(strI, "renderLambdaToString(this)");
        return strI;
    }
}
