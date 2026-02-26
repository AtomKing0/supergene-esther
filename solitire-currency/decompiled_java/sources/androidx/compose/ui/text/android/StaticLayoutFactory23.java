package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StaticLayoutFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    @DoNotInline
    @NotNull
    public StaticLayout create(@NotNull StaticLayoutParams params) {
        t.i(params, "params");
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(params.getText(), params.getStart(), params.getEnd(), params.getPaint(), params.getWidth());
        builderObtain.setTextDirection(params.getTextDir());
        builderObtain.setAlignment(params.getAlignment());
        builderObtain.setMaxLines(params.getMaxLines());
        builderObtain.setEllipsize(params.getEllipsize());
        builderObtain.setEllipsizedWidth(params.getEllipsizedWidth());
        builderObtain.setLineSpacing(params.getLineSpacingExtra(), params.getLineSpacingMultiplier());
        builderObtain.setIncludePad(params.getIncludePadding());
        builderObtain.setBreakStrategy(params.getBreakStrategy());
        builderObtain.setHyphenationFrequency(params.getHyphenationFrequency());
        builderObtain.setIndents(params.getLeftIndents(), params.getRightIndents());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            StaticLayoutFactory26 staticLayoutFactory26 = StaticLayoutFactory26.INSTANCE;
            t.h(builderObtain, "this");
            staticLayoutFactory26.setJustificationMode(builderObtain, params.getJustificationMode());
        }
        if (i10 >= 28) {
            StaticLayoutFactory28 staticLayoutFactory28 = StaticLayoutFactory28.INSTANCE;
            t.h(builderObtain, "this");
            staticLayoutFactory28.setUseLineSpacingFromFallbacks(builderObtain, params.getUseFallbackLineSpacing());
        }
        StaticLayout staticLayoutBuild = builderObtain.build();
        t.h(staticLayoutBuild, "obtain(params.text, para…  }\n            }.build()");
        return staticLayoutBuild;
    }
}
