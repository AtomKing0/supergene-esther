package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
final class BorderKt$drawRoundRectBorder$2 extends v implements h9.l<ContentDrawScope, k0> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ Path $roundedRectPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BorderKt$drawRoundRectBorder$2(Path path, Brush brush) {
        super(1);
        this.$roundedRectPath = path;
        this.$brush = brush;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(ContentDrawScope contentDrawScope) {
        invoke2(contentDrawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ContentDrawScope onDrawWithContent) {
        t.i(onDrawWithContent, "$this$onDrawWithContent");
        onDrawWithContent.drawContent();
        androidx.compose.ui.graphics.drawscope.b.F(onDrawWithContent, this.$roundedRectPath, this.$brush, 0.0f, null, null, 0, 60, null);
    }
}
