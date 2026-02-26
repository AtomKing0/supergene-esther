package androidx.activity.contextaware;

import android.content.Context;
import h9.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ o<R> $co;
    final /* synthetic */ l<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(o<R> oVar, l<Context, R> lVar) {
        this.$co = oVar;
        this.$onContextAvailable = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(@NotNull Context context) {
        Object objB;
        t.i(context, "context");
        d dVar = this.$co;
        l<Context, R> lVar = this.$onContextAvailable;
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(lVar.invoke(context));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(u.a(th));
        }
        dVar.resumeWith(objB);
    }
}
