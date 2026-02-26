package androidx.compose.material;

import androidx.compose.material.SwipeableState;
import java.util.Map;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.material.SwipeableState$snapTo$2", f = "Swipeable.kt", l = {316}, m = "emit")
final class SwipeableState$snapTo$2$emit$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableState.C09532 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableState$snapTo$2$emit$1(SwipeableState.C09532 c09532, z8.d<? super SwipeableState$snapTo$2$emit$1> dVar) {
        super(dVar);
        this.this$0 = c09532;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Map) null, (z8.d<? super k0>) this);
    }
}
