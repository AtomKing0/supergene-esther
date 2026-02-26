package androidx.compose.foundation;

import androidx.compose.foundation.HoverableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Hoverable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.HoverableKt$hoverable$2", f = "Hoverable.kt", l = {62}, m = "invoke$emitEnter")
final class HoverableKt$hoverable$2$invoke$emitEnter$1 extends kotlin.coroutines.jvm.internal.d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    HoverableKt$hoverable$2$invoke$emitEnter$1(z8.d<? super HoverableKt$hoverable$2$invoke$emitEnter$1> dVar) {
        super(dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HoverableKt.AnonymousClass2.invoke$emitEnter(null, null, this);
    }
}
