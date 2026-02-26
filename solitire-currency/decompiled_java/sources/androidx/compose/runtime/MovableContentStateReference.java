package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeApi
public final class MovableContentStateReference {
    public static final int $stable = 8;

    @NotNull
    private final Anchor anchor;

    @NotNull
    private final ControlledComposition composition;

    @NotNull
    private final MovableContent<Object> content;

    @NotNull
    private final List<s<RecomposeScopeImpl, IdentityArraySet<Object>>> invalidations;

    @NotNull
    private final PersistentMap<CompositionLocal<Object>, State<Object>> locals;

    @Nullable
    private final Object parameter;

    @NotNull
    private final SlotTable slotTable;

    /* JADX WARN: Multi-variable type inference failed */
    public MovableContentStateReference(@NotNull MovableContent<Object> content, @Nullable Object obj, @NotNull ControlledComposition composition, @NotNull SlotTable slotTable, @NotNull Anchor anchor, @NotNull List<s<RecomposeScopeImpl, IdentityArraySet<Object>>> invalidations, @NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> locals) {
        t.i(content, "content");
        t.i(composition, "composition");
        t.i(slotTable, "slotTable");
        t.i(anchor, "anchor");
        t.i(invalidations, "invalidations");
        t.i(locals, "locals");
        this.content = content;
        this.parameter = obj;
        this.composition = composition;
        this.slotTable = slotTable;
        this.anchor = anchor;
        this.invalidations = invalidations;
        this.locals = locals;
    }

    @NotNull
    public final Anchor getAnchor$runtime_release() {
        return this.anchor;
    }

    @NotNull
    public final ControlledComposition getComposition$runtime_release() {
        return this.composition;
    }

    @NotNull
    public final MovableContent<Object> getContent$runtime_release() {
        return this.content;
    }

    @NotNull
    public final List<s<RecomposeScopeImpl, IdentityArraySet<Object>>> getInvalidations$runtime_release() {
        return this.invalidations;
    }

    @NotNull
    public final PersistentMap<CompositionLocal<Object>, State<Object>> getLocals$runtime_release() {
        return this.locals;
    }

    @Nullable
    public final Object getParameter$runtime_release() {
        return this.parameter;
    }

    @NotNull
    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }
}
