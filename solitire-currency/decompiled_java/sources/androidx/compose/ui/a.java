package androidx.compose.ui;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Modifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    static {
        Modifier.Companion companion = Modifier.Companion;
    }

    @NotNull
    public static Modifier a(Modifier modifier, @NotNull Modifier other) {
        t.i(other, "other");
        return other == Modifier.Companion ? modifier : new CombinedModifier(modifier, other);
    }
}
