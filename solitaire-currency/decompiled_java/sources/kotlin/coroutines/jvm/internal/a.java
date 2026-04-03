package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements z8.d<Object>, e, Serializable {

    @Nullable
    private final z8.d<Object> completion;

    public a(@Nullable z8.d<Object> dVar) {
        this.completion = dVar;
    }

    @NotNull
    public z8.d<k0> create(@NotNull z8.d<?> completion) {
        t.i(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @Nullable
    public e getCallerFrame() {
        z8.d<Object> dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    @Nullable
    public final z8.d<Object> getCompletion() {
        return this.completion;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    @Nullable
    protected abstract Object invokeSuspend(@NotNull Object obj);

    @Override // z8.d
    public final void resumeWith(@NotNull Object obj) {
        Object objInvokeSuspend;
        z8.d<Object> dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            z8.d<Object> dVar2 = aVar.completion;
            t.f(dVar2);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                obj = v8.t.b(u.a(th));
            }
            if (objInvokeSuspend == a9.d.e()) {
                return;
            }
            obj = v8.t.b(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @NotNull
    public z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> completion) {
        kotlin.jvm.internal.t.i(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    protected void releaseIntercepted() {
    }
}
