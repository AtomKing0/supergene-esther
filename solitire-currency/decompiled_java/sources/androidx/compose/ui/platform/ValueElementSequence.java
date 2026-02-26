package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ValueElementSequence implements o9.g<ValueElement> {
    public static final int $stable = 8;

    @NotNull
    private final List<ValueElement> elements = new ArrayList();

    @Override // o9.g
    @NotNull
    public Iterator<ValueElement> iterator() {
        return this.elements.iterator();
    }

    public final void set(@NotNull String name, @Nullable Object obj) {
        kotlin.jvm.internal.t.i(name, "name");
        this.elements.add(new ValueElement(name, obj));
    }
}
