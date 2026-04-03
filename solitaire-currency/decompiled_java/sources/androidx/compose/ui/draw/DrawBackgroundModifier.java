package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawBackgroundModifier extends InspectorValueInfo implements DrawModifier {

    @NotNull
    private final l<DrawScope, k0> onDraw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DrawBackgroundModifier(@NotNull l<? super DrawScope, k0> onDraw, @NotNull l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(onDraw, "onDraw");
        t.i(inspectorInfo, "inspectorInfo");
        this.onDraw = onDraw;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        t.i(contentDrawScope, "<this>");
        this.onDraw.invoke(contentDrawScope);
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawBackgroundModifier) {
            return t.d(this.onDraw, ((DrawBackgroundModifier) obj).onDraw);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final l<DrawScope, k0> getOnDraw() {
        return this.onDraw;
    }

    public int hashCode() {
        return this.onDraw.hashCode();
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
