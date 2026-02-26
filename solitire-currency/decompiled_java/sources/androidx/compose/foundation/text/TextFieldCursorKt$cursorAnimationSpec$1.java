package androidx.compose.foundation.text;

import androidx.compose.animation.core.KeyframesSpec;
import androidx.room.RoomDatabase;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TextFieldCursor.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldCursorKt$cursorAnimationSpec$1 extends v implements l<KeyframesSpec.KeyframesSpecConfig<Float>, k0> {
    public static final TextFieldCursorKt$cursorAnimationSpec$1 INSTANCE = new TextFieldCursorKt$cursorAnimationSpec$1();

    TextFieldCursorKt$cursorAnimationSpec$1() {
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
        keyframes.setDurationMillis(1000);
        Float fValueOf = Float.valueOf(1.0f);
        keyframes.at(fValueOf, 0);
        keyframes.at(fValueOf, 499);
        Float fValueOf2 = Float.valueOf(0.0f);
        keyframes.at(fValueOf2, 500);
        keyframes.at(fValueOf2, RoomDatabase.MAX_BIND_PARAMETER_CNT);
    }
}
