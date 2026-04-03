package androidx.compose.material;

import androidx.compose.animation.core.KeyframesSpec;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
final class ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2 extends v implements l<KeyframesSpec.KeyframesSpecConfig<Float>, k0> {
    public static final ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2 INSTANCE = new ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2();

    ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        invoke2(keyframesSpecConfig);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
        t.i(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(1800);
        keyframes.with(keyframes.at(Float.valueOf(0.0f), 333), ProgressIndicatorKt.FirstLineTailEasing);
        keyframes.at(Float.valueOf(1.0f), 1183);
    }
}
