package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SimpleEntity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleEntity<M extends Modifier> extends LayoutNodeEntity<SimpleEntity<M>, M> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleEntity(@NotNull LayoutNodeWrapper layoutNodeWrapper, @NotNull M modifier) {
        super(layoutNodeWrapper, modifier);
        t.i(layoutNodeWrapper, "layoutNodeWrapper");
        t.i(modifier, "modifier");
    }
}
