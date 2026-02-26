package androidx.compose.ui.node;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DepthSortedSet.kt */
/* JADX INFO: loaded from: classes.dex */
final class DepthSortedSet$mapOfOriginalDepth$2 extends v implements h9.a<Map<LayoutNode, Integer>> {
    public static final DepthSortedSet$mapOfOriginalDepth$2 INSTANCE = new DepthSortedSet$mapOfOriginalDepth$2();

    DepthSortedSet$mapOfOriginalDepth$2() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final Map<LayoutNode, Integer> invoke() {
        return new LinkedHashMap();
    }
}
