package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.Placeholder;
import h9.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InlineTextContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class InlineTextContent {

    @NotNull
    private final q<String, Composer, Integer, k0> children;

    @NotNull
    private final Placeholder placeholder;

    /* JADX WARN: Multi-variable type inference failed */
    public InlineTextContent(@NotNull Placeholder placeholder, @NotNull q<? super String, ? super Composer, ? super Integer, k0> children) {
        t.i(placeholder, "placeholder");
        t.i(children, "children");
        this.placeholder = placeholder;
        this.children = children;
    }

    @NotNull
    public final q<String, Composer, Integer, k0> getChildren() {
        return this.children;
    }

    @NotNull
    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }
}
