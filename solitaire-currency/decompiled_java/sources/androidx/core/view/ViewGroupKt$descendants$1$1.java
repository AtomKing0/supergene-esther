package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
final class ViewGroupKt$descendants$1$1 extends kotlin.jvm.internal.v implements h9.l<View, Iterator<? extends View>> {
    public static final ViewGroupKt$descendants$1$1 INSTANCE = new ViewGroupKt$descendants$1$1();

    ViewGroupKt$descendants$1$1() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    public final Iterator<View> invoke(@NotNull View view) {
        o9.g<View> children;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
            return null;
        }
        return children.iterator();
    }
}
