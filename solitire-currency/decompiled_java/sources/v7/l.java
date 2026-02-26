package v7;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends v implements h9.l<Throwable, k0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ b2 f35157g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(b2 b2Var) {
        super(1);
        this.f35157g = b2Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        if (th == null) {
            return;
        }
        this.f35157g.cancel(new CancellationException(th.getMessage()));
    }
}
