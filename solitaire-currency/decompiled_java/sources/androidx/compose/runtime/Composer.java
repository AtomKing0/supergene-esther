package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import z8.g;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Composer {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Composer.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final Object Empty = new Object() { // from class: androidx.compose.runtime.Composer$Companion$Empty$1
            @NotNull
            public String toString() {
                return "Empty";
            }
        };

        private Companion() {
        }

        @NotNull
        public final Object getEmpty() {
            return Empty;
        }

        @InternalComposeTracingApi
        public final void setTracer(@NotNull CompositionTracer tracer) {
            t.i(tracer, "tracer");
            ComposerKt.compositionTracer = tracer;
        }
    }

    @ComposeCompilerApi
    <V, T> void apply(V v10, @NotNull p<? super T, ? super V, k0> pVar);

    @InternalComposeApi
    @NotNull
    CompositionContext buildContext();

    @ComposeCompilerApi
    boolean changed(byte b10);

    @ComposeCompilerApi
    boolean changed(char c10);

    @ComposeCompilerApi
    boolean changed(double d10);

    @ComposeCompilerApi
    boolean changed(float f10);

    @ComposeCompilerApi
    boolean changed(int i10);

    @ComposeCompilerApi
    boolean changed(long j10);

    @ComposeCompilerApi
    boolean changed(@Nullable Object obj);

    @ComposeCompilerApi
    boolean changed(short s10);

    @ComposeCompilerApi
    boolean changed(boolean z10);

    void collectParameterInformation();

    @InternalComposeApi
    <T> T consume(@NotNull CompositionLocal<T> compositionLocal);

    @ComposeCompilerApi
    <T> void createNode(@NotNull h9.a<? extends T> aVar);

    @ComposeCompilerApi
    void deactivateToEndGroup(boolean z10);

    @ComposeCompilerApi
    void disableReusing();

    @ComposeCompilerApi
    void enableReusing();

    @ComposeCompilerApi
    void endDefaults();

    @ComposeCompilerApi
    void endMovableGroup();

    @ComposeCompilerApi
    void endNode();

    @InternalComposeApi
    void endProviders();

    @ComposeCompilerApi
    void endReplaceableGroup();

    @ComposeCompilerApi
    @Nullable
    ScopeUpdateScope endRestartGroup();

    @ComposeCompilerApi
    void endReusableGroup();

    @NotNull
    Applier<?> getApplier();

    @NotNull
    g getApplyCoroutineContext();

    @NotNull
    ControlledComposition getComposition();

    @NotNull
    CompositionData getCompositionData();

    int getCompoundKeyHash();

    boolean getDefaultsInvalid();

    boolean getInserting();

    @Nullable
    RecomposeScope getRecomposeScope();

    @Nullable
    Object getRecomposeScopeIdentity();

    boolean getSkipping();

    @InternalComposeApi
    void insertMovableContent(@NotNull MovableContent<?> movableContent, @Nullable Object obj);

    @InternalComposeApi
    void insertMovableContentReferences(@NotNull List<s<MovableContentStateReference, MovableContentStateReference>> list);

    @ComposeCompilerApi
    @NotNull
    Object joinKey(@Nullable Object obj, @Nullable Object obj2);

    @InternalComposeApi
    void recordSideEffect(@NotNull h9.a<k0> aVar);

    @InternalComposeApi
    void recordUsed(@NotNull RecomposeScope recomposeScope);

    @ComposeCompilerApi
    @Nullable
    Object rememberedValue();

    @ComposeCompilerApi
    void skipCurrentGroup();

    @ComposeCompilerApi
    void skipToGroupEnd();

    void sourceInformation(@NotNull String str);

    void sourceInformationMarkerEnd();

    void sourceInformationMarkerStart(int i10, @NotNull String str);

    @ComposeCompilerApi
    void startDefaults();

    @ComposeCompilerApi
    void startMovableGroup(int i10, @Nullable Object obj);

    @ComposeCompilerApi
    void startNode();

    @InternalComposeApi
    void startProviders(@NotNull ProvidedValue<?>[] providedValueArr);

    @ComposeCompilerApi
    void startReplaceableGroup(int i10);

    @ComposeCompilerApi
    @NotNull
    Composer startRestartGroup(int i10);

    @ComposeCompilerApi
    void startReusableGroup(int i10, @Nullable Object obj);

    @ComposeCompilerApi
    void startReusableNode();

    @ComposeCompilerApi
    void updateRememberedValue(@Nullable Object obj);

    @ComposeCompilerApi
    void useNode();
}
