package androidx.core.view;

import android.view.ViewParent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class ViewKt$ancestors$1 extends kotlin.jvm.internal.q implements h9.l<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // h9.l
    public final ViewParent invoke(@NotNull ViewParent viewParent) {
        return viewParent.getParent();
    }
}
