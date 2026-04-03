package androidx.compose.ui.platform;

import android.view.Choreographer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidUiDispatcher.android.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2$dispatcher$1", f = "AndroidUiDispatcher.android.kt", l = {}, m = "invokeSuspend")
final class AndroidUiDispatcher$Companion$Main$2$dispatcher$1 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super Choreographer>, Object> {
    int label;

    AndroidUiDispatcher$Companion$Main$2$dispatcher$1(z8.d<? super AndroidUiDispatcher$Companion$Main$2$dispatcher$1> dVar) {
        super(2, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v8.u.b(obj);
        return Choreographer.getInstance();
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super Choreographer> dVar) {
        return ((AndroidUiDispatcher$Companion$Main$2$dispatcher$1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
    }
}
