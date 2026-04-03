package androidx.compose.animation;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentScope$slideIntoContainer$1 extends v implements l<Integer, Integer> {
    public static final AnimatedContentScope$slideIntoContainer$1 INSTANCE = new AnimatedContentScope$slideIntoContainer$1();

    AnimatedContentScope$slideIntoContainer$1() {
        super(1);
    }

    @NotNull
    public final Integer invoke(int i10) {
        return Integer.valueOf(i10);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return invoke(num.intValue());
    }
}
