package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.v;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentScope$SizeModifier$measure$size$2<S> extends v implements l<S, IntSize> {
    final /* synthetic */ AnimatedContentScope<S> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedContentScope$SizeModifier$measure$size$2(AnimatedContentScope<S> animatedContentScope) {
        super(1);
        this.this$0 = animatedContentScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.l
    public /* bridge */ /* synthetic */ IntSize invoke(Object obj) {
        return IntSize.m3825boximpl(m24invokeYEO4UFw(obj));
    }

    /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
    public final long m24invokeYEO4UFw(S s10) {
        State<IntSize> state = this.this$0.getTargetSizeMap$animation_release().get(s10);
        return state != null ? state.getValue().m3837unboximpl() : IntSize.Companion.m3838getZeroYbymL2g();
    }
}
