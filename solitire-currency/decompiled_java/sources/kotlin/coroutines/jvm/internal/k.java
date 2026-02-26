package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class k extends j implements o<Object> {
    private final int arity;

    public k(int i10, @Nullable z8.d<Object> dVar) {
        super(dVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.o
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strH = o0.h(this);
        t.h(strH, "renderLambdaToString(this)");
        return strH;
    }

    public k(int i10) {
        this(i10, null);
    }
}
