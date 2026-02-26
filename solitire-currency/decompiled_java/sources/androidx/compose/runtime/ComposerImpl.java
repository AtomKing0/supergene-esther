package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.o;
import kotlin.collections.z;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;
import v8.s;
import v8.y;
import z8.g;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl implements Composer {

    @NotNull
    private final Set<RememberObserver> abandonSet;

    @NotNull
    private final Applier<?> applier;

    @NotNull
    private List<q<Applier<?>, SlotWriter, RememberManager, k0>> changes;
    private int childrenComposing;

    @NotNull
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;

    @NotNull
    private Stack<Object> downNodes;

    @NotNull
    private final IntStack entersStack;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;

    @NotNull
    private IntStack groupNodeCountStack;
    private boolean implicitRootStart;

    @NotNull
    private Anchor insertAnchor;

    @NotNull
    private final List<q<Applier<?>, SlotWriter, RememberManager, k0>> insertFixups;

    @NotNull
    private SlotTable insertTable;

    @NotNull
    private final Stack<q<Applier<?>, SlotWriter, RememberManager, k0>> insertUpFixups;
    private boolean inserting;

    @NotNull
    private final Stack<RecomposeScopeImpl> invalidateStack;

    @NotNull
    private final List<Invalidation> invalidations;
    private boolean isComposing;
    private boolean isDisposed;

    @NotNull
    private List<q<Applier<?>, SlotWriter, RememberManager, k0>> lateChanges;

    @Nullable
    private int[] nodeCountOverrides;

    @Nullable
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;

    @NotNull
    private IntStack nodeIndexStack;

    @NotNull
    private final CompositionContext parentContext;

    @NotNull
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> parentProvider;

    @Nullable
    private Pending pending;

    @NotNull
    private final Stack<Pending> pendingStack;
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;

    @Nullable
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> providerCache;

    @NotNull
    private final HashMap<Integer, PersistentMap<CompositionLocal<Object>, State<Object>>> providerUpdates;
    private boolean providersInvalid;

    @NotNull
    private final IntStack providersInvalidStack;

    @NotNull
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup;

    @NotNull
    private final SlotTable slotTable;

    @NotNull
    private Snapshot snapshot;
    private boolean startedGroup;

    @NotNull
    private final IntStack startedGroups;

    @NotNull
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private int writersReaderDelta;

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$createNode$2, reason: invalid class name */
    /* JADX INFO: compiled from: Composer.kt */
    static final class AnonymousClass2 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ h9.a<T> $factory;
        final /* synthetic */ Anchor $groupAnchor;
        final /* synthetic */ int $insertIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(h9.a<? extends T> aVar, Anchor anchor, int i10) {
            super(3);
            this.$factory = aVar;
            this.$groupAnchor = anchor;
            this.$insertIndex = i10;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "applier");
            t.i(slots, "slots");
            t.i(rememberManager, "<anonymous parameter 2>");
            Object objInvoke = this.$factory.invoke();
            slots.updateNode(this.$groupAnchor, objInvoke);
            applier.insertTopDown(this.$insertIndex, objInvoke);
            applier.down(objInvoke);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$createNode$3, reason: invalid class name */
    /* JADX INFO: compiled from: Composer.kt */
    static final class AnonymousClass3 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ Anchor $groupAnchor;
        final /* synthetic */ int $insertIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Anchor anchor, int i10) {
            super(3);
            this.$groupAnchor = anchor;
            this.$insertIndex = i10;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "applier");
            t.i(slots, "slots");
            t.i(rememberManager, "<anonymous parameter 2>");
            Object objNode = slots.node(this.$groupAnchor);
            applier.up();
            applier.insertBottomUp(this.$insertIndex, objNode);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09632 extends v implements p<Integer, Object, k0> {
        final /* synthetic */ int $group;

        /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Composer.kt */
        static final class AnonymousClass1 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
            final /* synthetic */ Object $data;
            final /* synthetic */ int $group;
            final /* synthetic */ int $index;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Object obj, int i10, int i11) {
                super(3);
                this.$data = obj;
                this.$group = i10;
                this.$index = i11;
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                invoke2(applier, slotWriter, rememberManager);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
                t.i(applier, "<anonymous parameter 0>");
                t.i(slots, "slots");
                t.i(rememberManager, "rememberManager");
                if (!t.d(this.$data, slots.slot(this.$group, this.$index))) {
                    ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                    throw new h();
                }
                rememberManager.forgetting((RememberObserver) this.$data);
                slots.set(this.$index, Composer.Companion.getEmpty());
            }
        }

        /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Composer.kt */
        static final class C01162 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
            final /* synthetic */ Object $data;
            final /* synthetic */ int $group;
            final /* synthetic */ int $index;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01162(Object obj, int i10, int i11) {
                super(3);
                this.$data = obj;
                this.$group = i10;
                this.$index = i11;
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                invoke2(applier, slotWriter, rememberManager);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
                t.i(applier, "<anonymous parameter 0>");
                t.i(slots, "slots");
                t.i(rememberManager, "<anonymous parameter 2>");
                if (t.d(this.$data, slots.slot(this.$group, this.$index))) {
                    slots.set(this.$index, Composer.Companion.getEmpty());
                } else {
                    ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                    throw new h();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09632(int i10) {
            super(2);
            this.$group = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Integer num, Object obj) {
            invoke(num.intValue(), obj);
            return k0.f35197a;
        }

        public final void invoke(int i10, @Nullable Object obj) {
            if (obj instanceof RememberObserver) {
                ComposerImpl.this.reader.reposition(this.$group);
                ComposerImpl.recordSlotTableOperation$default(ComposerImpl.this, false, new AnonymousClass1(obj, this.$group, i10), 1, null);
            } else if (obj instanceof RecomposeScopeImpl) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                CompositionImpl composition = recomposeScopeImpl.getComposition();
                if (composition != null) {
                    composition.setPendingInvalidScopes$runtime_release(true);
                    recomposeScopeImpl.release();
                }
                ComposerImpl.this.reader.reposition(this.$group);
                ComposerImpl.recordSlotTableOperation$default(ComposerImpl.this, false, new C01162(obj, this.$group, i10), 1, null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1, reason: invalid class name */
    /* JADX INFO: compiled from: Composer.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ MovableContent<Object> $content;
        final /* synthetic */ Object $parameter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MovableContent<Object> movableContent, Object obj) {
            super(2);
            this.$content = movableContent;
            this.$parameter = obj;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$content.getContent().invoke(this.$parameter, composer, 8);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeDowns$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09641 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ Object[] $nodes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09641(Object[] objArr) {
            super(3);
            this.$nodes = objArr;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            t.i(applier, "applier");
            t.i(slotWriter, "<anonymous parameter 1>");
            t.i(rememberManager, "<anonymous parameter 2>");
            int length = this.$nodes.length;
            for (int i10 = 0; i10 < length; i10++) {
                applier.down(this.$nodes[i10]);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeMovement$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09651 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ int $count;
        final /* synthetic */ int $removeIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09651(int i10, int i11) {
            super(3);
            this.$removeIndex = i10;
            this.$count = i11;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            t.i(applier, "applier");
            t.i(slotWriter, "<anonymous parameter 1>");
            t.i(rememberManager, "<anonymous parameter 2>");
            applier.remove(this.$removeIndex, this.$count);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeMovement$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09662 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ int $count;
        final /* synthetic */ int $from;
        final /* synthetic */ int $to;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09662(int i10, int i11, int i12) {
            super(3);
            this.$from = i10;
            this.$to = i11;
            this.$count = i12;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            t.i(applier, "applier");
            t.i(slotWriter, "<anonymous parameter 1>");
            t.i(rememberManager, "<anonymous parameter 2>");
            applier.move(this.$from, this.$to, this.$count);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeOperationLocation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09672 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ int $distance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09672(int i10) {
            super(3);
            this.$distance = i10;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "<anonymous parameter 0>");
            t.i(slots, "slots");
            t.i(rememberManager, "<anonymous parameter 2>");
            slots.advanceBy(this.$distance);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeUps$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09681 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ int $count;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09681(int i10) {
            super(3);
            this.$count = i10;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            t.i(applier, "applier");
            t.i(slotWriter, "<anonymous parameter 1>");
            t.i(rememberManager, "<anonymous parameter 2>");
            int i10 = this.$count;
            for (int i11 = 0; i11 < i10; i11++) {
                applier.up();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordInsert$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09691 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ Anchor $anchor;
        final /* synthetic */ SlotTable $insertTable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09691(SlotTable slotTable, Anchor anchor) {
            super(3);
            this.$insertTable = slotTable;
            this.$anchor = anchor;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "<anonymous parameter 0>");
            t.i(slots, "slots");
            t.i(rememberManager, "<anonymous parameter 2>");
            slots.beginInsert();
            SlotTable slotTable = this.$insertTable;
            slots.moveFrom(slotTable, this.$anchor.toIndexFor(slotTable));
            slots.endInsert();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordInsert$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09702 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ Anchor $anchor;
        final /* synthetic */ List<q<Applier<?>, SlotWriter, RememberManager, k0>> $fixups;
        final /* synthetic */ SlotTable $insertTable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09702(SlotTable slotTable, Anchor anchor, List<q<Applier<?>, SlotWriter, RememberManager, k0>> list) {
            super(3);
            this.$insertTable = slotTable;
            this.$anchor = anchor;
            this.$fixups = list;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "applier");
            t.i(slots, "slots");
            t.i(rememberManager, "rememberManager");
            SlotTable slotTable = this.$insertTable;
            List<q<Applier<?>, SlotWriter, RememberManager, k0>> list = this.$fixups;
            SlotWriter slotWriterOpenWriter = slotTable.openWriter();
            try {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    list.get(i10).invoke(applier, slotWriterOpenWriter, rememberManager);
                }
                k0 k0Var = k0.f35197a;
                slotWriterOpenWriter.close();
                slots.beginInsert();
                SlotTable slotTable2 = this.$insertTable;
                slots.moveFrom(slotTable2, this.$anchor.toIndexFor(slotTable2));
                slots.endInsert();
            } catch (Throwable th) {
                slotWriterOpenWriter.close();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordSideEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09711 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ h9.a<k0> $effect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09711(h9.a<k0> aVar) {
            super(3);
            this.$effect = aVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            t.i(applier, "<anonymous parameter 0>");
            t.i(slotWriter, "<anonymous parameter 1>");
            t.i(rememberManager, "rememberManager");
            rememberManager.sideEffect(this.$effect);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordSlotEditing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09721 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ Anchor $anchor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09721(Anchor anchor) {
            super(3);
            this.$anchor = anchor;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "<anonymous parameter 0>");
            t.i(slots, "slots");
            t.i(rememberManager, "<anonymous parameter 2>");
            slots.ensureStarted(this.$anchor);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$start$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09732 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ int $currentRelativePosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09732(int i10) {
            super(3);
            this.$currentRelativePosition = i10;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "<anonymous parameter 0>");
            t.i(slots, "slots");
            t.i(rememberManager, "<anonymous parameter 2>");
            slots.moveGroup(this.$currentRelativePosition);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$startReaderGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09741 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ Object $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09741(Object obj) {
            super(3);
            this.$data = obj;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            t.i(applier, "<anonymous parameter 0>");
            t.i(slots, "slots");
            t.i(rememberManager, "<anonymous parameter 2>");
            slots.updateAux(this.$data);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$updateValue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09751 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ Object $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09751(Object obj) {
            super(3);
            this.$value = obj;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
            t.i(applier, "<anonymous parameter 0>");
            t.i(slotWriter, "<anonymous parameter 1>");
            t.i(rememberManager, "rememberManager");
            rememberManager.remembering((RememberObserver) this.$value);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$updateValue$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Composer.kt */
    static final class C09762 extends v implements q<Applier<?>, SlotWriter, RememberManager, k0> {
        final /* synthetic */ int $groupSlotIndex;
        final /* synthetic */ Object $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09762(Object obj, int i10) {
            super(3);
            this.$value = obj;
            this.$groupSlotIndex = i10;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
            RecomposeScopeImpl recomposeScopeImpl;
            CompositionImpl composition;
            t.i(applier, "<anonymous parameter 0>");
            t.i(slots, "slots");
            t.i(rememberManager, "rememberManager");
            Object obj = this.$value;
            if (obj instanceof RememberObserver) {
                rememberManager.remembering((RememberObserver) obj);
            }
            Object obj2 = slots.set(this.$groupSlotIndex, this.$value);
            if (obj2 instanceof RememberObserver) {
                rememberManager.forgetting((RememberObserver) obj2);
            } else {
                if (!(obj2 instanceof RecomposeScopeImpl) || (composition = (recomposeScopeImpl = (RecomposeScopeImpl) obj2).getComposition()) == null) {
                    return;
                }
                recomposeScopeImpl.release();
                composition.setPendingInvalidScopes$runtime_release(true);
            }
        }
    }

    public ComposerImpl(@NotNull Applier<?> applier, @NotNull CompositionContext parentContext, @NotNull SlotTable slotTable, @NotNull Set<RememberObserver> abandonSet, @NotNull List<q<Applier<?>, SlotWriter, RememberManager, k0>> changes, @NotNull List<q<Applier<?>, SlotWriter, RememberManager, k0>> lateChanges, @NotNull ControlledComposition composition) {
        t.i(applier, "applier");
        t.i(parentContext, "parentContext");
        t.i(slotTable, "slotTable");
        t.i(abandonSet, "abandonSet");
        t.i(changes, "changes");
        t.i(lateChanges, "lateChanges");
        t.i(composition, "composition");
        this.applier = applier;
        this.parentContext = parentContext;
        this.slotTable = slotTable;
        this.abandonSet = abandonSet;
        this.changes = changes;
        this.lateChanges = lateChanges;
        this.composition = composition;
        this.pendingStack = new Stack<>();
        this.nodeIndexStack = new IntStack();
        this.groupNodeCountStack = new IntStack();
        this.invalidations = new ArrayList();
        this.entersStack = new IntStack();
        this.parentProvider = ExtensionsKt.persistentHashMapOf();
        this.providerUpdates = new HashMap<>();
        this.providersInvalidStack = new IntStack();
        this.reusingGroup = -1;
        this.snapshot = SnapshotKt.currentSnapshot();
        this.invalidateStack = new Stack<>();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        slotReaderOpenReader.close();
        this.reader = slotReaderOpenReader;
        SlotTable slotTable2 = new SlotTable();
        this.insertTable = slotTable2;
        SlotWriter slotWriterOpenWriter = slotTable2.openWriter();
        slotWriterOpenWriter.close();
        this.writer = slotWriterOpenWriter;
        SlotReader slotReaderOpenReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = slotReaderOpenReader2.anchor(0);
            slotReaderOpenReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th) {
            slotReaderOpenReader2.close();
            throw th;
        }
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates.clear();
        this.reader.close();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
    }

    private final void addRecomposeScope() {
        RecomposeScopeImpl recomposeScopeImpl;
        if (getInserting()) {
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((CompositionImpl) getComposition());
            this.invalidateStack.push(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.start(this.compositionToken);
            return;
        }
        Invalidation invalidationRemoveLocation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object next = this.reader.next();
        if (t.d(next, Composer.Companion.getEmpty())) {
            recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) getComposition());
            updateValue(recomposeScopeImpl);
        } else {
            if (next == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            }
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        recomposeScopeImpl.setRequiresRecompose(invalidationRemoveLocation != null);
        this.invalidateStack.push(recomposeScopeImpl);
        recomposeScopeImpl.start(this.compositionToken);
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final int compoundKeyOf(int i10, int i11, int i12) {
        if (i10 == i11) {
            return i12;
        }
        int iGroupCompoundKeyPart = groupCompoundKeyPart(this.reader, i10);
        return iGroupCompoundKeyPart == 126665345 ? iGroupCompoundKeyPart : Integer.rotateLeft(compoundKeyOf(this.reader.parent(i10), i11, i12), 3) ^ iGroupCompoundKeyPart;
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        SlotTable slotTable = new SlotTable();
        this.insertTable = slotTable;
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        slotWriterOpenWriter.close();
        this.writer = slotWriterOpenWriter;
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> currentCompositionLocalScope(Integer num) {
        PersistentMap persistentMap;
        if (num == null && (persistentMap = this.providerCache) != null) {
            return persistentMap;
        }
        if (getInserting() && this.writerHasAProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) == 202 && t.d(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object objGroupAux = this.writer.groupAux(parent);
                    if (objGroupAux == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
                    }
                    PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap2 = (PersistentMap) objGroupAux;
                    this.providerCache = persistentMap2;
                    return persistentMap2;
                }
                parent = this.writer.parent(parent);
            }
        }
        if (this.reader.getSize() > 0) {
            int iIntValue = num != null ? num.intValue() : this.reader.getParent();
            while (iIntValue > 0) {
                if (this.reader.groupKey(iIntValue) == 202 && t.d(this.reader.groupObjectKey(iIntValue), ComposerKt.getCompositionLocalMap())) {
                    PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap3 = this.providerUpdates.get(Integer.valueOf(iIntValue));
                    if (persistentMap3 == null) {
                        Object objGroupAux2 = this.reader.groupAux(iIntValue);
                        if (objGroupAux2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
                        }
                        persistentMap3 = (PersistentMap) objGroupAux2;
                    }
                    this.providerCache = persistentMap3;
                    return persistentMap3;
                }
                iIntValue = this.reader.parent(iIntValue);
            }
        }
        PersistentMap persistentMap4 = this.parentProvider;
        this.providerCache = persistentMap4;
        return persistentMap4;
    }

    static /* synthetic */ PersistentMap currentCompositionLocalScope$default(ComposerImpl composerImpl, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        return composerImpl.currentCompositionLocalScope(num);
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, p<? super Composer, ? super Integer, k0> pVar) {
        if (!(!this.isComposing)) {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported".toString());
            throw new h();
        }
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            this.snapshot = snapshotCurrentSnapshot;
            this.compositionToken = snapshotCurrentSnapshot.getId();
            this.providerUpdates.clear();
            int size$runtime_release = identityArrayMap.getSize$runtime_release();
            for (int i10 = 0; i10 < size$runtime_release; i10++) {
                Object obj = identityArrayMap.getKeys$runtime_release()[i10];
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                }
                IdentityArraySet identityArraySet = (IdentityArraySet) identityArrayMap.getValues$runtime_release()[i10];
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                Anchor anchor = recomposeScopeImpl.getAnchor();
                if (anchor == null) {
                    return;
                }
                this.invalidations.add(new Invalidation(recomposeScopeImpl, anchor.getLocation$runtime_release(), identityArraySet));
            }
            List<Invalidation> list = this.invalidations;
            if (list.size() > 1) {
                z.A(list, new Comparator() { // from class: androidx.compose.runtime.ComposerImpl$doCompose$lambda-37$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t10, T t11) {
                        return x8.b.a(Integer.valueOf(((Invalidation) t10).getLocation()), Integer.valueOf(((Invalidation) t11).getLocation()));
                    }
                });
            }
            this.nodeIndex = 0;
            this.isComposing = true;
            try {
                startRoot();
                Object objNextSlot = nextSlot();
                if (objNextSlot != pVar && pVar != null) {
                    updateValue(pVar);
                }
                SnapshotStateKt.observeDerivedStateRecalculations(new ComposerImpl$doCompose$2$3(this), new ComposerImpl$doCompose$2$4(this), new ComposerImpl$doCompose$2$5(pVar, this, objNextSlot));
                endRoot();
                this.isComposing = false;
                this.invalidations.clear();
                k0 k0Var = k0.f35197a;
            } catch (Throwable th) {
                this.isComposing = false;
                this.invalidations.clear();
                abortRoot();
                throw th;
            }
        } finally {
            Trace.INSTANCE.endSection(objBeginSection);
        }
    }

    private final void doRecordDownsFor(int i10, int i11) {
        if (i10 <= 0 || i10 == i11) {
            return;
        }
        doRecordDownsFor(this.reader.parent(i10), i11);
        if (this.reader.isNode(i10)) {
            recordDown(nodeAt(this.reader, i10));
        }
    }

    private final void end(boolean z10) {
        List<KeyInfo> list;
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int i10 = this.groupNodeCount;
        Pending pending = this.pending;
        int i11 = 0;
        if (pending != null && pending.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending.getKeyInfos();
            List<KeyInfo> used = pending.getUsed();
            Set setFastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i12 = 0;
            int i13 = 0;
            int iUpdatedNodeCountOf = 0;
            while (i12 < size2) {
                KeyInfo keyInfo = keyInfos.get(i12);
                if (setFastToSet.contains(keyInfo)) {
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i13 < size) {
                            KeyInfo keyInfo2 = used.get(i13);
                            if (keyInfo2 != keyInfo) {
                                int iNodePositionOf = pending.nodePositionOf(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (iNodePositionOf != iUpdatedNodeCountOf) {
                                    int iUpdatedNodeCountOf2 = pending.updatedNodeCountOf(keyInfo2);
                                    list = used;
                                    recordMoveNode(pending.getStartIndex() + iNodePositionOf, iUpdatedNodeCountOf + pending.getStartIndex(), iUpdatedNodeCountOf2);
                                    pending.registerMoveNode(iNodePositionOf, iUpdatedNodeCountOf, iUpdatedNodeCountOf2);
                                } else {
                                    list = used;
                                }
                            } else {
                                list = used;
                                i12++;
                            }
                            i13++;
                            iUpdatedNodeCountOf += pending.updatedNodeCountOf(keyInfo2);
                            used = list;
                        }
                    }
                    i11 = 0;
                } else {
                    recordRemoveNode(pending.nodePositionOf(keyInfo) + pending.getStartIndex(), keyInfo.getNodes());
                    pending.updateNodeCount(keyInfo.getLocation(), i11);
                    recordReaderMoving(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                }
                i12++;
                i11 = 0;
            }
            realizeMovement();
            if (keyInfos.size() > 0) {
                recordReaderMoving(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i14 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            recordRemoveNode(i14, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting = getInserting();
        if (inserting) {
            if (z10) {
                registerInsertUpFixup();
                i10 = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int iInsertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(iInsertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(iInsertedGroupVirtualIndex, i10);
                }
            }
        } else {
            if (z10) {
                recordUp();
            }
            recordEndGroup();
            int parent4 = this.reader.getParent();
            if (i10 != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i10);
            }
            if (z10) {
                i10 = 1;
            }
            this.reader.endGroup();
            realizeMovement();
        }
        exitGroup(i10, inserting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter slotWriterOpenWriter = this.insertTable.openWriter();
            this.writer = slotWriterOpenWriter;
            slotWriterOpenWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean z10, Pending pending) {
        this.pendingStack.push(this.pending);
        this.pending = pending;
        this.nodeIndexStack.push(this.nodeIndex);
        if (z10) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int i10, boolean z10) {
        Pending pendingPop = this.pendingStack.pop();
        if (pendingPop != null && !z10) {
            pendingPop.setGroupIndex(pendingPop.getGroupIndex() + 1);
        }
        this.pending = pendingPop;
        this.nodeIndex = this.nodeIndexStack.pop() + i10;
        this.groupNodeCount = this.groupNodeCountStack.pop() + i10;
    }

    private final void finalizeCompose() {
        realizeUps();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeRuntimeError("Start/end imbalance".toString());
            throw new h();
        }
        if (this.startedGroups.isEmpty()) {
            cleanUpCompose();
        } else {
            ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
            throw new h();
        }
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i10) {
        Object objGroupAux;
        if (slotReader.hasObjectKey(i10)) {
            Object objGroupObjectKey = slotReader.groupObjectKey(i10);
            if (objGroupObjectKey != null) {
                return objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey instanceof MovableContent ? MovableContentKt.movableContentKey : objGroupObjectKey.hashCode();
            }
            return 0;
        }
        int iGroupKey = slotReader.groupKey(i10);
        if (iGroupKey == 207 && (objGroupAux = slotReader.groupAux(i10)) != null && !t.d(objGroupAux, Composer.Companion.getEmpty())) {
            iGroupKey = objGroupAux.hashCode();
        }
        return iGroupKey;
    }

    private static final int insertMovableContentReferences$currentNodeIndex(SlotWriter slotWriter) {
        int currentGroup = slotWriter.getCurrentGroup();
        int parent = slotWriter.getParent();
        while (parent >= 0 && !slotWriter.isNode(parent)) {
            parent = slotWriter.parent(parent);
        }
        int iGroupSize = parent + 1;
        int iNodeCount = 0;
        while (iGroupSize < currentGroup) {
            if (slotWriter.indexInGroup(currentGroup, iGroupSize)) {
                if (slotWriter.isNode(iGroupSize)) {
                    iNodeCount = 0;
                }
                iGroupSize++;
            } else {
                iNodeCount += slotWriter.isNode(iGroupSize) ? 1 : slotWriter.nodeCount(iGroupSize);
                iGroupSize += slotWriter.groupSize(iGroupSize);
            }
        }
        return iNodeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int insertMovableContentReferences$positionToInsert(SlotWriter slotWriter, Anchor anchor, Applier<Object> applier) {
        int iAnchorIndex = slotWriter.anchorIndex(anchor);
        ComposerKt.runtimeCheck(slotWriter.getCurrentGroup() < iAnchorIndex);
        insertMovableContentReferences$positionToParentOf(slotWriter, applier, iAnchorIndex);
        int iInsertMovableContentReferences$currentNodeIndex = insertMovableContentReferences$currentNodeIndex(slotWriter);
        while (slotWriter.getCurrentGroup() < iAnchorIndex) {
            if (slotWriter.indexInCurrentGroup(iAnchorIndex)) {
                if (slotWriter.isNode()) {
                    applier.down(slotWriter.node(slotWriter.getCurrentGroup()));
                    iInsertMovableContentReferences$currentNodeIndex = 0;
                }
                slotWriter.startGroup();
            } else {
                iInsertMovableContentReferences$currentNodeIndex += slotWriter.skipGroup();
            }
        }
        ComposerKt.runtimeCheck(slotWriter.getCurrentGroup() == iAnchorIndex);
        return iInsertMovableContentReferences$currentNodeIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertMovableContentReferences$positionToParentOf(SlotWriter slotWriter, Applier<Object> applier, int i10) {
        while (!slotWriter.indexInParent(i10)) {
            slotWriter.skipToGroupEnd();
            if (slotWriter.isNode(slotWriter.getParent())) {
                applier.up();
            }
            slotWriter.endGroup();
        }
    }

    private final int insertedGroupVirtualIndex(int i10) {
        return (-2) - i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeMovableContentLambda(MovableContent<Object> movableContent, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Object obj, boolean z10) {
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        changed(obj);
        int compoundKeyHash = getCompoundKeyHash();
        this.compoundKeyHash = MovableContentKt.movableContentKey;
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        boolean z11 = (getInserting() || t.d(this.reader.getGroupAux(), persistentMap)) ? false : true;
        if (z11) {
            this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap);
        }
        start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap);
        if (!getInserting() || z10) {
            boolean z12 = this.providersInvalid;
            this.providersInvalid = z11;
            ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(1378964644, true, new AnonymousClass1(movableContent, obj)));
            this.providersInvalid = z12;
        } else {
            this.writerHasAProvider = true;
            this.providerCache = null;
            SlotWriter slotWriter = this.writer;
            this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(movableContent, obj, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), kotlin.collections.v.l(), currentCompositionLocalScope$default(this, null, 1, null)));
        }
        endGroup();
        this.compoundKeyHash = compoundKeyHash;
        endMovableGroup();
    }

    private final Object nodeAt(SlotReader slotReader, int i10) {
        return slotReader.node(i10);
    }

    private final int nodeIndexOf(int i10, int i11, int i12, int i13) {
        int iParent = this.reader.parent(i11);
        while (iParent != i12 && !this.reader.isNode(iParent)) {
            iParent = this.reader.parent(iParent);
        }
        if (this.reader.isNode(iParent)) {
            i13 = 0;
        }
        if (iParent == i11) {
            return i13;
        }
        int iUpdatedNodeCount = (updatedNodeCount(iParent) - this.reader.nodeCount(i11)) + i13;
        loop1: while (i13 < iUpdatedNodeCount && iParent != i10) {
            iParent++;
            while (iParent < i10) {
                int iGroupSize = this.reader.groupSize(iParent) + iParent;
                if (i10 >= iGroupSize) {
                    i13 += updatedNodeCount(iParent);
                    iParent = iGroupSize;
                }
            }
            break loop1;
        }
        return i13;
    }

    private final void realizeDowns(Object[] objArr) {
        record(new C09641(objArr));
    }

    private final void realizeMovement() {
        int i10 = this.previousCount;
        this.previousCount = 0;
        if (i10 > 0) {
            int i11 = this.previousRemove;
            if (i11 >= 0) {
                this.previousRemove = -1;
                recordApplierOperation(new C09651(i11, i10));
                return;
            }
            int i12 = this.previousMoveFrom;
            this.previousMoveFrom = -1;
            int i13 = this.previousMoveTo;
            this.previousMoveTo = -1;
            recordApplierOperation(new C09662(i12, i13, i10));
        }
    }

    private final void realizeOperationLocation(boolean z10) {
        int parent = z10 ? this.reader.getParent() : this.reader.getCurrentGroup();
        int i10 = parent - this.writersReaderDelta;
        if (!(i10 >= 0)) {
            ComposerKt.composeRuntimeError("Tried to seek backward".toString());
            throw new h();
        }
        if (i10 > 0) {
            record(new C09672(i10));
            this.writersReaderDelta = parent;
        }
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerImpl composerImpl, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        composerImpl.realizeOperationLocation(z10);
    }

    private final void realizeUps() {
        int i10 = this.pendingUps;
        if (i10 > 0) {
            this.pendingUps = 0;
            record(new C09681(i10));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #0 {all -> 0x005c, blocks: (B:3:0x0007, B:5:0x0014, B:7:0x0028, B:8:0x002c, B:10:0x0032, B:12:0x003e, B:11:0x003a, B:15:0x0045, B:17:0x004b, B:19:0x0051), top: B:25:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <R> R recomposeMovableContent(androidx.compose.runtime.ControlledComposition r9, androidx.compose.runtime.ControlledComposition r10, java.lang.Integer r11, java.util.List<v8.s<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>>> r12, h9.a<? extends R> r13) {
        /*
            r8 = this;
            boolean r0 = r8.implicitRootStart
            boolean r1 = r8.isComposing
            int r2 = r8.nodeIndex
            r3 = 0
            r8.implicitRootStart = r3     // Catch: java.lang.Throwable -> L5c
            r4 = 1
            r8.isComposing = r4     // Catch: java.lang.Throwable -> L5c
            r8.nodeIndex = r3     // Catch: java.lang.Throwable -> L5c
            int r4 = r12.size()     // Catch: java.lang.Throwable -> L5c
        L12:
            if (r3 >= r4) goto L41
            java.lang.Object r5 = r12.get(r3)     // Catch: java.lang.Throwable -> L5c
            v8.s r5 = (v8.s) r5     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r6 = r5.a()     // Catch: java.lang.Throwable -> L5c
            androidx.compose.runtime.RecomposeScopeImpl r6 = (androidx.compose.runtime.RecomposeScopeImpl) r6     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r5 = r5.b()     // Catch: java.lang.Throwable -> L5c
            androidx.compose.runtime.collection.IdentityArraySet r5 = (androidx.compose.runtime.collection.IdentityArraySet) r5     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L3a
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L5c
        L2c:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Throwable -> L5c
            if (r7 == 0) goto L3e
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L5c
            r8.tryImminentInvalidation$runtime_release(r6, r7)     // Catch: java.lang.Throwable -> L5c
            goto L2c
        L3a:
            r5 = 0
            r8.tryImminentInvalidation$runtime_release(r6, r5)     // Catch: java.lang.Throwable -> L5c
        L3e:
            int r3 = r3 + 1
            goto L12
        L41:
            if (r9 == 0) goto L51
            if (r11 == 0) goto L4a
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L5c
            goto L4b
        L4a:
            r11 = -1
        L4b:
            java.lang.Object r9 = r9.delegateInvalidations(r10, r11, r13)     // Catch: java.lang.Throwable -> L5c
            if (r9 != 0) goto L55
        L51:
            java.lang.Object r9 = r13.invoke()     // Catch: java.lang.Throwable -> L5c
        L55:
            r8.implicitRootStart = r0
            r8.isComposing = r1
            r8.nodeIndex = r2
            return r9
        L5c:
            r9 = move-exception
            r8.implicitRootStart = r0
            r8.isComposing = r1
            r8.nodeIndex = r2
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recomposeMovableContent(androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.ControlledComposition, java.lang.Integer, java.util.List, h9.a):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, h9.a aVar, int i10, Object obj) {
        ControlledComposition controlledComposition3 = (i10 & 1) != 0 ? null : controlledComposition;
        ControlledComposition controlledComposition4 = (i10 & 2) != 0 ? null : controlledComposition2;
        Integer num2 = (i10 & 4) != 0 ? null : num;
        if ((i10 & 8) != 0) {
            list = kotlin.collections.v.l();
        }
        return composerImpl.recomposeMovableContent(controlledComposition3, controlledComposition4, num2, list, aVar);
    }

    private final void recomposeToGroupEnd() {
        boolean z10 = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int iGroupSize = this.reader.groupSize(parent) + parent;
        int i10 = this.nodeIndex;
        int compoundKeyHash = getCompoundKeyHash();
        int i11 = this.groupNodeCount;
        Invalidation invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        boolean z11 = false;
        int i12 = parent;
        while (invalidationFirstInRange != null) {
            int location = invalidationFirstInRange.getLocation();
            ComposerKt.removeLocation(this.invalidations, location);
            if (invalidationFirstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i12, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i10);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(currentGroup), parent, compoundKeyHash);
                this.providerCache = null;
                invalidationFirstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i12 = currentGroup;
                z11 = true;
            } else {
                this.invalidateStack.push(invalidationFirstInRange.getScope());
                invalidationFirstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        }
        if (z11) {
            recordUpsAndDowns(i12, parent, parent);
            this.reader.skipToGroupEnd();
            int iUpdatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i10 + iUpdatedNodeCount;
            this.groupNodeCount = i11 + iUpdatedNodeCount;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash;
        this.isComposing = z10;
    }

    private final void record(q<? super Applier<?>, ? super SlotWriter, ? super RememberManager, k0> qVar) {
        this.changes.add(qVar);
    }

    private final void recordApplierOperation(q<? super Applier<?>, ? super SlotWriter, ? super RememberManager, k0> qVar) {
        realizeUps();
        realizeDowns();
        record(qVar);
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        recordSlotEditingOperation(ComposerKt.removeCurrentGroupInstance);
        this.writersReaderDelta += this.reader.getGroupSize();
    }

    private final void recordDown(Object obj) {
        this.downNodes.push(obj);
    }

    private final void recordEndGroup() {
        int parent = this.reader.getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
            throw new h();
        }
        if (this.startedGroups.peekOr(-1) == parent) {
            this.startedGroups.pop();
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, null);
        }
    }

    private final void recordEndRoot() {
        if (this.startedGroup) {
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, null);
            this.startedGroup = false;
        }
    }

    private final void recordFixup(q<? super Applier<?>, ? super SlotWriter, ? super RememberManager, k0> qVar) {
        this.insertFixups.add(qVar);
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            recordSlotEditingOperation(new C09691(this.insertTable, anchor));
            return;
        }
        List listR0 = d0.R0(this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        recordSlotEditingOperation(new C09702(this.insertTable, anchor, listR0));
    }

    private final void recordInsertUpFixup(q<? super Applier<?>, ? super SlotWriter, ? super RememberManager, k0> qVar) {
        this.insertUpFixups.push(qVar);
    }

    private final void recordMoveNode(int i10, int i11, int i12) {
        if (i12 > 0) {
            int i13 = this.previousCount;
            if (i13 > 0 && this.previousMoveFrom == i10 - i13 && this.previousMoveTo == i11 - i13) {
                this.previousCount = i13 + i12;
                return;
            }
            realizeMovement();
            this.previousMoveFrom = i10;
            this.previousMoveTo = i11;
            this.previousCount = i12;
        }
    }

    private final void recordReaderMoving(int i10) {
        this.writersReaderDelta = i10 - (this.reader.getCurrentGroup() - this.writersReaderDelta);
    }

    private final void recordRemoveNode(int i10, int i11) {
        if (i11 > 0) {
            if (!(i10 >= 0)) {
                ComposerKt.composeRuntimeError(("Invalid remove index " + i10).toString());
                throw new h();
            }
            if (this.previousRemove == i10) {
                this.previousCount += i11;
                return;
            }
            realizeMovement();
            this.previousRemove = i10;
            this.previousCount = i11;
        }
    }

    private final void recordSlotEditing() {
        SlotReader slotReader;
        int parent;
        if (this.reader.getSize() <= 0 || this.startedGroups.peekOr(-1) == (parent = (slotReader = this.reader).getParent())) {
            return;
        }
        if (!this.startedGroup && this.implicitRootStart) {
            recordSlotTableOperation$default(this, false, ComposerKt.startRootGroup, 1, null);
            this.startedGroup = true;
        }
        Anchor anchor = slotReader.anchor(parent);
        this.startedGroups.push(parent);
        recordSlotTableOperation$default(this, false, new C09721(anchor), 1, null);
    }

    private final void recordSlotEditingOperation(q<? super Applier<?>, ? super SlotWriter, ? super RememberManager, k0> qVar) {
        realizeOperationLocation$default(this, false, 1, null);
        recordSlotEditing();
        record(qVar);
    }

    private final void recordSlotTableOperation(boolean z10, q<? super Applier<?>, ? super SlotWriter, ? super RememberManager, k0> qVar) {
        realizeOperationLocation(z10);
        record(qVar);
    }

    static /* synthetic */ void recordSlotTableOperation$default(ComposerImpl composerImpl, boolean z10, q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        composerImpl.recordSlotTableOperation(z10, qVar);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty()) {
            this.downNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    private final void recordUpsAndDowns(int i10, int i11, int i12) {
        SlotReader slotReader = this.reader;
        int iNearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, i10, i11, i12);
        while (i10 > 0 && i10 != iNearestCommonRootOf) {
            if (slotReader.isNode(i10)) {
                recordUp();
            }
            i10 = slotReader.parent(i10);
        }
        doRecordDownsFor(i11, iNearestCommonRootOf);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    private final void reportFreeMovableContent(int i10) {
        reportFreeMovableContent$reportGroup(this, i10, false, 0);
        realizeMovement();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i10, boolean z10, int i11) {
        if (!composerImpl.reader.hasMark(i10)) {
            if (!composerImpl.reader.containsMark(i10)) {
                return composerImpl.reader.nodeCount(i10);
            }
            int iGroupSize = composerImpl.reader.groupSize(i10) + i10;
            int iGroupSize2 = i10 + 1;
            int iReportFreeMovableContent$reportGroup = 0;
            while (iGroupSize2 < iGroupSize) {
                boolean zIsNode = composerImpl.reader.isNode(iGroupSize2);
                if (zIsNode) {
                    composerImpl.realizeMovement();
                    composerImpl.recordDown(composerImpl.reader.node(iGroupSize2));
                }
                iReportFreeMovableContent$reportGroup += reportFreeMovableContent$reportGroup(composerImpl, iGroupSize2, zIsNode || z10, zIsNode ? 0 : i11 + iReportFreeMovableContent$reportGroup);
                if (zIsNode) {
                    composerImpl.realizeMovement();
                    composerImpl.recordUp();
                }
                iGroupSize2 += composerImpl.reader.groupSize(iGroupSize2);
            }
            return iReportFreeMovableContent$reportGroup;
        }
        Object objGroupObjectKey = composerImpl.reader.groupObjectKey(i10);
        if (objGroupObjectKey == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        }
        MovableContent movableContent = (MovableContent) objGroupObjectKey;
        Object objGroupGet = composerImpl.reader.groupGet(i10, 0);
        Anchor anchor = composerImpl.reader.anchor(i10);
        List listFilterToRange = ComposerKt.filterToRange(composerImpl.invalidations, i10, composerImpl.reader.groupSize(i10) + i10);
        ArrayList arrayList = new ArrayList(listFilterToRange.size());
        int size = listFilterToRange.size();
        for (int i12 = 0; i12 < size; i12++) {
            Invalidation invalidation = (Invalidation) listFilterToRange.get(i12);
            arrayList.add(y.a(invalidation.getScope(), invalidation.getInstances()));
        }
        MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, objGroupGet, composerImpl.getComposition(), composerImpl.slotTable, anchor, arrayList, composerImpl.currentCompositionLocalScope(Integer.valueOf(i10)));
        composerImpl.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        composerImpl.recordSlotEditing();
        composerImpl.record(new ComposerImpl$reportFreeMovableContent$reportGroup$1(composerImpl, movableContentStateReference, anchor));
        if (!z10) {
            return composerImpl.reader.nodeCount(i10);
        }
        composerImpl.realizeMovement();
        composerImpl.realizeUps();
        composerImpl.realizeDowns();
        int iNodeCount = composerImpl.reader.isNode(i10) ? 1 : composerImpl.reader.nodeCount(i10);
        if (iNodeCount <= 0) {
            return 0;
        }
        composerImpl.recordRemoveNode(i11, iNodeCount);
        return 0;
    }

    private final <T> T resolveCompositionLocal(CompositionLocal<T> compositionLocal, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        return ComposerKt.contains(persistentMap, compositionLocal) ? (T) ComposerKt.getValueOf(persistentMap, compositionLocal) : compositionLocal.getDefaultValueHolder$runtime_release().getValue();
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    private final void start(int i10, Object obj, boolean z10, Object obj2) {
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(i10, obj, obj2);
        Pending pending = null;
        if (getInserting()) {
            this.reader.beginEmpty();
            int currentGroup = this.writer.getCurrentGroup();
            if (z10) {
                this.writer.startNode(Composer.Companion.getEmpty());
            } else if (obj2 != null) {
                SlotWriter slotWriter = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter.startData(i10, obj, obj2);
            } else {
                SlotWriter slotWriter2 = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter2.startGroup(i10, obj);
            }
            Pending pending2 = this.pending;
            if (pending2 != null) {
                KeyInfo keyInfo = new KeyInfo(i10, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                pending2.registerInsert(keyInfo, this.nodeIndex - pending2.getStartIndex());
                pending2.recordUsed(keyInfo);
            }
            enterGroup(z10, null);
            return;
        }
        if (this.pending == null) {
            if (this.reader.getGroupKey() == i10 && t.d(obj, this.reader.getGroupObjectKey())) {
                startReaderGroup(z10, obj2);
            } else {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            }
        }
        Pending pending3 = this.pending;
        if (pending3 != null) {
            KeyInfo next = pending3.getNext(i10, obj);
            if (next != null) {
                pending3.recordUsed(next);
                int location = next.getLocation();
                this.nodeIndex = pending3.nodePositionOf(next) + pending3.getStartIndex();
                int iSlotPositionOf = pending3.slotPositionOf(next);
                int groupIndex = iSlotPositionOf - pending3.getGroupIndex();
                pending3.registerMoveSlot(iSlotPositionOf, pending3.getGroupIndex());
                recordReaderMoving(location);
                this.reader.reposition(location);
                if (groupIndex > 0) {
                    recordSlotEditingOperation(new C09732(groupIndex));
                }
                startReaderGroup(z10, obj2);
            } else {
                this.reader.beginEmpty();
                this.inserting = true;
                this.providerCache = null;
                ensureWriter();
                this.writer.beginInsert();
                int currentGroup2 = this.writer.getCurrentGroup();
                if (z10) {
                    this.writer.startNode(Composer.Companion.getEmpty());
                } else if (obj2 != null) {
                    SlotWriter slotWriter3 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter3.startData(i10, obj, obj2);
                } else {
                    SlotWriter slotWriter4 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter4.startGroup(i10, obj);
                }
                this.insertAnchor = this.writer.anchor(currentGroup2);
                KeyInfo keyInfo2 = new KeyInfo(i10, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                pending3.registerInsert(keyInfo2, this.nodeIndex - pending3.getStartIndex());
                pending3.recordUsed(keyInfo2);
                pending = new Pending(new ArrayList(), z10 ? 0 : this.nodeIndex);
            }
        }
        enterGroup(z10, pending);
    }

    private final void startGroup(int i10) {
        start(i10, null, false, null);
    }

    private final void startReaderGroup(boolean z10, Object obj) {
        if (z10) {
            this.reader.startNode();
            return;
        }
        if (obj != null && this.reader.getGroupAux() != obj) {
            recordSlotTableOperation$default(this, false, new C09741(obj), 1, null);
        }
        this.reader.startGroup();
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        Set<CompositionData> set = (Set) resolveCompositionLocal(InspectionTablesKt.getLocalInspectionTables(), this.parentProvider);
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int i10, Object obj, Object obj2) {
        if (obj != null) {
            if (obj instanceof Enum) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) obj).ordinal());
                return;
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(obj.hashCode());
                return;
            }
        }
        if (obj2 == null || i10 != 207 || t.d(obj2, Composer.Companion.getEmpty())) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(i10);
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(obj2.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int i10) {
        this.compoundKeyHash = i10 ^ Integer.rotateLeft(getCompoundKeyHash(), 3);
    }

    private final void updateCompoundKeyWhenWeExitGroup(int i10, Object obj, Object obj2) {
        if (obj != null) {
            if (obj instanceof Enum) {
                updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) obj).ordinal());
                return;
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(obj.hashCode());
                return;
            }
        }
        if (obj2 == null || i10 != 207 || t.d(obj2, Composer.Companion.getEmpty())) {
            updateCompoundKeyWhenWeExitGroupKeyHash(i10);
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(obj2.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int i10) {
        this.compoundKeyHash = Integer.rotateRight(i10 ^ getCompoundKeyHash(), 3);
    }

    private final void updateNodeCount(int i10, int i11) {
        if (updatedNodeCount(i10) != i11) {
            if (i10 < 0) {
                HashMap<Integer, Integer> map = this.nodeCountVirtualOverrides;
                if (map == null) {
                    map = new HashMap<>();
                    this.nodeCountVirtualOverrides = map;
                }
                map.put(Integer.valueOf(i10), Integer.valueOf(i11));
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                iArr = new int[this.reader.getSize()];
                o.u(iArr, -1, 0, 0, 6, null);
                this.nodeCountOverrides = iArr;
            }
            iArr[i10] = i11;
        }
    }

    private final void updateNodeCountOverrides(int i10, int i11) {
        int iUpdatedNodeCount = updatedNodeCount(i10);
        if (iUpdatedNodeCount != i11) {
            int i12 = i11 - iUpdatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (i10 != -1) {
                int iUpdatedNodeCount2 = updatedNodeCount(i10) + i12;
                updateNodeCount(i10, iUpdatedNodeCount2);
                int i13 = size;
                while (true) {
                    if (-1 < i13) {
                        Pending pendingPeek = this.pendingStack.peek(i13);
                        if (pendingPeek != null && pendingPeek.updateNodeCount(i10, iUpdatedNodeCount2)) {
                            size = i13 - 1;
                            break;
                        }
                        i13--;
                    } else {
                        break;
                    }
                }
                if (i10 < 0) {
                    i10 = this.reader.getParent();
                } else if (this.reader.isNode(i10)) {
                    return;
                } else {
                    i10 = this.reader.parent(i10);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final PersistentMap<CompositionLocal<Object>, State<Object>> updateProviderMapGroup(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        builder.putAll(persistentMap2);
        PersistentMap persistentMapBuild = builder.build();
        startGroup(204, ComposerKt.getProviderMaps());
        changed(persistentMapBuild);
        changed(persistentMap2);
        endGroup();
        return persistentMapBuild;
    }

    private final int updatedNodeCount(int i10) {
        int i11;
        Integer num;
        if (i10 >= 0) {
            int[] iArr = this.nodeCountOverrides;
            return (iArr == null || (i11 = iArr[i10]) < 0) ? this.reader.nodeCount(i10) : i11;
        }
        HashMap<Integer, Integer> map = this.nodeCountVirtualOverrides;
        if (map == null || (num = map.get(Integer.valueOf(i10))) == null) {
            return 0;
        }
        return num.intValue();
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
            throw new h();
        }
    }

    private final void validateNodeNotExpected() {
        if (!this.nodeExpected) {
            return;
        }
        ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
        throw new h();
    }

    private final <R> R withChanges(List<q<Applier<?>, SlotWriter, RememberManager, k0>> list, h9.a<? extends R> aVar) {
        List list2 = this.changes;
        try {
            this.changes = list;
            return aVar.invoke();
        } finally {
            r.b(1);
            this.changes = list2;
            r.a(1);
        }
    }

    private final <R> R withReader(SlotReader slotReader, h9.a<? extends R> aVar) {
        SlotReader slotReader2 = this.reader;
        int[] iArr = this.nodeCountOverrides;
        this.nodeCountOverrides = null;
        try {
            this.reader = slotReader;
            return aVar.invoke();
        } finally {
            r.b(1);
            this.reader = slotReader2;
            this.nodeCountOverrides = iArr;
            r.a(1);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(V v10, @NotNull p<? super T, ? super V, k0> block) {
        t.i(block, "block");
        ComposerImpl$apply$operation$1 composerImpl$apply$operation$1 = new ComposerImpl$apply$operation$1(block, v10);
        if (getInserting()) {
            recordFixup(composerImpl$apply$operation$1);
        } else {
            recordApplierOperation(composerImpl$apply$operation$1);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public CompositionContext buildContext() {
        startGroup(206, ComposerKt.getReference());
        Object objNextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = objNextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) objNextSlot : null;
        if (compositionContextHolder == null) {
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(getCompoundKeyHash(), this.forceRecomposeScopes));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope$default(this, null, 1, null));
        endGroup();
        return compositionContextHolder.getRef();
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z10, @NotNull h9.a<? extends T> block) {
        t.i(block, "block");
        T t10 = (T) nextSlot();
        if (t10 != Composer.Companion.getEmpty() && !z10) {
            return t10;
        }
        T tInvoke = block.invoke();
        updateValue(tInvoke);
        return tInvoke;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(@Nullable Object obj) {
        if (t.d(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates.clear();
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final void composeContent$runtime_release(@NotNull IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested, @NotNull p<? super Composer, ? super Integer, k0> content) {
        t.i(invalidationsRequested, "invalidationsRequested");
        t.i(content, "content");
        if (this.changes.isEmpty()) {
            doCompose(invalidationsRequested, content);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new h();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public <T> T consume(@NotNull CompositionLocal<T> key) {
        t.i(key, "key");
        return (T) resolveCompositionLocal(key, currentCompositionLocalScope$default(this, null, 1, null));
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(@NotNull h9.a<? extends T> factory) {
        t.i(factory, "factory");
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
            throw new h();
        }
        int iPeek = this.nodeIndexStack.peek();
        SlotWriter slotWriter = this.writer;
        Anchor anchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        recordFixup(new AnonymousClass2(factory, anchor, iPeek));
        recordInsertUpFixup(new AnonymousClass3(anchor, iPeek));
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean z10) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup".toString());
            throw new h();
        }
        if (getInserting()) {
            return;
        }
        if (!z10) {
            skipReaderToGroupEnd();
            return;
        }
        int currentGroup = this.reader.getCurrentGroup();
        int currentEnd = this.reader.getCurrentEnd();
        for (int i10 = currentGroup; i10 < currentEnd; i10++) {
            this.reader.forEachData$runtime_release(i10, new C09632(i10));
        }
        ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
        this.reader.reposition(currentGroup);
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    public final void dispose$runtime_release() {
        Trace trace = Trace.INSTANCE;
        Object objBeginSection = trace.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.providerUpdates.clear();
            getApplier().clear();
            this.isDisposed = true;
            k0 k0Var = k0.f35197a;
            trace.endSection(objBeginSection);
        } catch (Throwable th) {
            Trace.INSTANCE.endSection(objBeginSection);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release == null || !currentRecomposeScope$runtime_release.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime_release.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    @Nullable
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        l<Composition, k0> lVarEnd;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImplPop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (recomposeScopeImplPop != null) {
            recomposeScopeImplPop.setRequiresRecompose(false);
        }
        if (recomposeScopeImplPop != null && (lVarEnd = recomposeScopeImplPop.end(this.compositionToken)) != null) {
            record(new ComposerImpl$endRestartGroup$1$1(lVarEnd, this));
        }
        if (recomposeScopeImplPop != null && !recomposeScopeImplPop.getSkipped$runtime_release() && (recomposeScopeImplPop.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImplPop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                recomposeScopeImplPop.setAnchor(anchor);
            }
            recomposeScopeImplPop.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImplPop;
        }
        end(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public g getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext$runtime_release();
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public ControlledComposition getComposition() {
        return this.composition;
    }

    @Override // androidx.compose.runtime.Composer
    @NotNull
    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Nullable
    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing == 0 && stack.isNotEmpty()) {
            return stack.peek();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        if (this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    @NotNull
    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    @Nullable
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    @Override // androidx.compose.runtime.Composer
    @Nullable
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        if (getInserting() || this.reusing || this.providersInvalid) {
            return false;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return (currentRecomposeScope$runtime_release != null && !currentRecomposeScope$runtime_release.getRequiresRecompose()) && !this.forciblyRecompose;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContent(@NotNull MovableContent<?> value, @Nullable Object obj) {
        t.i(value, "value");
        invokeMovableContentLambda(value, currentCompositionLocalScope$default(this, null, 1, null), obj, false);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContentReferences(@NotNull List<s<MovableContentStateReference, MovableContentStateReference>> references) {
        SlotReader slotReaderOpenReader;
        List list;
        t.i(references, "references");
        List<q<Applier<?>, SlotWriter, RememberManager, k0>> list2 = this.lateChanges;
        List list3 = this.changes;
        try {
            this.changes = list2;
            record(ComposerKt.resetSlotsInstance);
            int size = references.size();
            for (int i10 = 0; i10 < size; i10++) {
                s<MovableContentStateReference, MovableContentStateReference> sVar = references.get(i10);
                MovableContentStateReference movableContentStateReferenceA = sVar.a();
                MovableContentStateReference movableContentStateReferenceB = sVar.b();
                Anchor anchor$runtime_release = movableContentStateReferenceA.getAnchor$runtime_release();
                int iAnchorIndex = movableContentStateReferenceA.getSlotTable$runtime_release().anchorIndex(anchor$runtime_release);
                l0 l0Var = new l0();
                realizeUps();
                record(new ComposerImpl$insertMovableContentReferences$1$1$1(l0Var, anchor$runtime_release));
                if (movableContentStateReferenceB == null) {
                    if (t.d(movableContentStateReferenceA.getSlotTable$runtime_release(), this.insertTable)) {
                        createFreshInsertTable();
                    }
                    slotReaderOpenReader = movableContentStateReferenceA.getSlotTable$runtime_release().openReader();
                    try {
                        slotReaderOpenReader.reposition(iAnchorIndex);
                        this.writersReaderDelta = iAnchorIndex;
                        ArrayList arrayList = new ArrayList();
                        recomposeMovableContent$default(this, null, null, null, null, new ComposerImpl$insertMovableContentReferences$1$1$2$1(this, arrayList, slotReaderOpenReader, movableContentStateReferenceA), 15, null);
                        if (!arrayList.isEmpty()) {
                            record(new ComposerImpl$insertMovableContentReferences$1$1$2$2(l0Var, arrayList));
                        }
                        k0 k0Var = k0.f35197a;
                        slotReaderOpenReader.close();
                    } finally {
                    }
                } else {
                    List listCollectNodesFrom = ComposerKt.collectNodesFrom(movableContentStateReferenceB.getSlotTable$runtime_release(), movableContentStateReferenceB.getAnchor$runtime_release());
                    if (!listCollectNodesFrom.isEmpty()) {
                        record(new ComposerImpl$insertMovableContentReferences$1$1$3(l0Var, listCollectNodesFrom));
                        int iAnchorIndex2 = this.slotTable.anchorIndex(anchor$runtime_release);
                        updateNodeCount(iAnchorIndex2, updatedNodeCount(iAnchorIndex2) + listCollectNodesFrom.size());
                    }
                    record(new ComposerImpl$insertMovableContentReferences$1$1$4(this, movableContentStateReferenceB, movableContentStateReferenceA));
                    SlotTable slotTable$runtime_release = movableContentStateReferenceB.getSlotTable$runtime_release();
                    slotReaderOpenReader = slotTable$runtime_release.openReader();
                    try {
                        SlotReader slotReader = this.reader;
                        int[] iArr = this.nodeCountOverrides;
                        this.nodeCountOverrides = null;
                        try {
                            this.reader = slotReaderOpenReader;
                            int iAnchorIndex3 = slotTable$runtime_release.anchorIndex(movableContentStateReferenceB.getAnchor$runtime_release());
                            slotReaderOpenReader.reposition(iAnchorIndex3);
                            this.writersReaderDelta = iAnchorIndex3;
                            ArrayList arrayList2 = new ArrayList();
                            List list4 = this.changes;
                            try {
                                this.changes = arrayList2;
                                list = list4;
                                try {
                                    recomposeMovableContent(movableContentStateReferenceB.getComposition$runtime_release(), movableContentStateReferenceA.getComposition$runtime_release(), Integer.valueOf(slotReaderOpenReader.getCurrentGroup()), movableContentStateReferenceB.getInvalidations$runtime_release(), new ComposerImpl$insertMovableContentReferences$1$1$5$1$1$1(this, movableContentStateReferenceA));
                                    k0 k0Var2 = k0.f35197a;
                                    this.changes = list;
                                    if (!arrayList2.isEmpty()) {
                                        record(new ComposerImpl$insertMovableContentReferences$1$1$5$1$2(l0Var, arrayList2));
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    this.changes = list;
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                list = list4;
                            }
                        } finally {
                        }
                    } finally {
                    }
                }
                record(ComposerKt.skipToGroupEndInstance);
            }
            record(ComposerImpl$insertMovableContentReferences$1$2.INSTANCE);
            this.writersReaderDelta = 0;
            k0 k0Var3 = k0.f35197a;
            this.changes = list3;
            cleanUpCompose();
        } catch (Throwable th3) {
            this.changes = list3;
            throw th3;
        }
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    @NotNull
    public Object joinKey(@Nullable Object obj, @Nullable Object obj2) {
        Object key = ComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return key == null ? new JoinedKey(obj, obj2) : key;
    }

    @Nullable
    public final Object nextSlot() {
        if (!getInserting()) {
            return this.reusing ? Composer.Companion.getEmpty() : this.reader.next();
        }
        validateNodeNotExpected();
        return Composer.Companion.getEmpty();
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    public final void prepareCompose$runtime_release(@NotNull h9.a<k0> block) {
        t.i(block, "block");
        if (!(!this.isComposing)) {
            ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
            throw new h();
        }
        this.isComposing = true;
        try {
            block.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    public final boolean recompose$runtime_release(@NotNull IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested) {
        t.i(invalidationsRequested, "invalidationsRequested");
        if (!this.changes.isEmpty()) {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new h();
        }
        if (!invalidationsRequested.isNotEmpty() && !(!this.invalidations.isEmpty()) && !this.forciblyRecompose) {
            return false;
        }
        doCompose(invalidationsRequested, null);
        return !this.changes.isEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(@NotNull h9.a<k0> effect) {
        t.i(effect, "effect");
        record(new C09711(effect));
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(@NotNull RecomposeScope scope) {
        t.i(scope, "scope");
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.setUsed(true);
    }

    @Override // androidx.compose.runtime.Composer
    @Nullable
    public Object rememberedValue() {
        return nextSlot();
    }

    public final void setInsertTable$runtime_release(@NotNull SlotTable slotTable) {
        t.i(slotTable, "<set-?>");
        this.insertTable = slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(groupKey, groupObjectKey, groupAux);
        startReaderGroup(slotReader.isNode(), null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        updateCompoundKeyWhenWeExitGroup(groupKey, groupObjectKey, groupAux);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
            throw new h();
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            currentRecomposeScope$runtime_release.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(@NotNull String sourceInformation) {
        t.i(sourceInformation, "sourceInformation");
        if (getInserting()) {
            this.writer.insertAux(sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        end(false);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i10, @NotNull String sourceInformation) {
        t.i(sourceInformation, "sourceInformation");
        start(i10, null, false, sourceInformation);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        start(-127, null, false, null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int i10, @Nullable Object obj) {
        start(i10, obj, false, null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        int i10 = 125;
        if (!getInserting() && (!this.reusing ? this.reader.getGroupKey() == 126 : this.reader.getGroupKey() == 125)) {
            i10 = 126;
        }
        start(i10, null, true, null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void startProviders(@NotNull ProvidedValue<?>[] values) {
        PersistentMap<CompositionLocal<Object>, State<Object>> persistentMapUpdateProviderMapGroup;
        boolean z10;
        t.i(values, "values");
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMapCurrentCompositionLocalScope$default = currentCompositionLocalScope$default(this, null, 1, null);
        startGroup(201, ComposerKt.getProvider());
        startGroup(203, ComposerKt.getProviderValues());
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap = (PersistentMap) ActualJvm_jvmKt.invokeComposableForResult(this, new ComposerImpl$startProviders$currentProviders$1(values, persistentMapCurrentCompositionLocalScope$default));
        endGroup();
        if (getInserting()) {
            persistentMapUpdateProviderMapGroup = updateProviderMapGroup(persistentMapCurrentCompositionLocalScope$default, persistentMap);
            this.writerHasAProvider = true;
        } else {
            Object objGroupGet = this.reader.groupGet(0);
            if (objGroupGet == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            }
            PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap2 = (PersistentMap) objGroupGet;
            Object objGroupGet2 = this.reader.groupGet(1);
            if (objGroupGet2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            }
            PersistentMap persistentMap3 = (PersistentMap) objGroupGet2;
            if (!getSkipping() || !t.d(persistentMap3, persistentMap)) {
                persistentMapUpdateProviderMapGroup = updateProviderMapGroup(persistentMapCurrentCompositionLocalScope$default, persistentMap);
                z10 = !t.d(persistentMapUpdateProviderMapGroup, persistentMap2);
                if (z10 && !getInserting()) {
                    this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMapUpdateProviderMapGroup);
                }
                this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
                this.providersInvalid = z10;
                this.providerCache = persistentMapUpdateProviderMapGroup;
                start(202, ComposerKt.getCompositionLocalMap(), false, persistentMapUpdateProviderMapGroup);
            }
            skipGroup();
            persistentMapUpdateProviderMapGroup = persistentMap2;
        }
        z10 = false;
        if (z10) {
            this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMapUpdateProviderMapGroup);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z10;
        this.providerCache = persistentMapUpdateProviderMapGroup;
        start(202, ComposerKt.getCompositionLocalMap(), false, persistentMapUpdateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int i10) {
        start(i10, null, false, null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    @NotNull
    public Composer startRestartGroup(int i10) {
        start(i10, null, false, null);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int i10, @Nullable Object obj) {
        if (this.reader.getGroupKey() == i10 && !t.d(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        start(i10, null, false, obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        start(125, null, true, null);
        this.nodeExpected = true;
    }

    public final boolean tryImminentInvalidation$runtime_release(@NotNull RecomposeScopeImpl scope, @Nullable Object obj) {
        t.i(scope, "scope");
        Anchor anchor = scope.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.slotTable);
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, scope, obj);
        return true;
    }

    public final void updateCachedValue(@Nullable Object obj) {
        updateValue(obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(@Nullable Object obj) {
        updateValue(obj);
    }

    public final void updateValue(@Nullable Object obj) {
        if (!getInserting()) {
            int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
            if (obj instanceof RememberObserver) {
                this.abandonSet.add(obj);
            }
            recordSlotTableOperation(true, new C09762(obj, groupSlotIndex));
            return;
        }
        this.writer.update(obj);
        if (obj instanceof RememberObserver) {
            record(new C09751(obj));
            this.abandonSet.add(obj);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (!getInserting()) {
            recordDown(getNode(this.reader));
        } else {
            ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
            throw new h();
        }
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty()) {
            realizeDowns(this.downNodes.toArray());
            this.downNodes.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startGroup(int i10, Object obj) {
        start(i10, obj, false, null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char c10) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Character) && c10 == ((Character) objNextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c10));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte b10) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Byte) && b10 == ((Number) objNextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b10));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short s10) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Short) && s10 == ((Number) objNextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s10));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean z10) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Boolean) && z10 == ((Boolean) objNextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z10));
        return true;
    }

    /* JADX INFO: compiled from: Composer.kt */
    private static final class CompositionContextHolder implements RememberObserver {

        @NotNull
        private final CompositionContextImpl ref;

        public CompositionContextHolder(@NotNull CompositionContextImpl ref) {
            t.i(ref, "ref");
            this.ref = ref;
        }

        @NotNull
        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }
    }

    /* JADX INFO: compiled from: Composer.kt */
    private final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;

        @NotNull
        private final Set<ComposerImpl> composers = new LinkedHashSet();

        @NotNull
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExtensionsKt.persistentHashMapOf(), null, 2, null);
        private final int compoundHashKey;

        @Nullable
        private Set<Set<CompositionData>> inspectionTables;

        public CompositionContextImpl(int i10, boolean z10) {
            this.compoundHashKey = i10;
            this.collectingParameterInformation = z10;
        }

        private final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope() {
            return (PersistentMap) this.compositionLocalScope$delegate.getValue();
        }

        private final void setCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            this.compositionLocalScope$delegate.setValue(persistentMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @ComposableInferredTarget(scheme = "[0[0]]")
        public void composeInitial$runtime_release(@NotNull ControlledComposition composition, @NotNull p<? super Composer, ? super Integer, k0> content) {
            t.i(composition, "composition");
            t.i(content, "content");
            ComposerImpl.this.parentContext.composeInitial$runtime_release(composition, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
            t.i(reference, "reference");
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(reference);
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set<Set<CompositionData>> set = this.inspectionTables;
                if (set != null) {
                    for (ComposerImpl composerImpl : this.composers) {
                        Iterator<Set<CompositionData>> it = set.iterator();
                        while (it.hasNext()) {
                            it.next().remove(composerImpl.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        @NotNull
        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        @NotNull
        public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        @NotNull
        public g getEffectCoroutineContext$runtime_release() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext$runtime_release();
        }

        @Nullable
        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        @Override // androidx.compose.runtime.CompositionContext
        @NotNull
        public g getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
            t.i(reference, "reference");
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime_release(@NotNull ControlledComposition composition) {
            t.i(composition, "composition");
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl scope) {
            t.i(scope, "scope");
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference reference, @NotNull MovableContentState data) {
            t.i(reference, "reference");
            t.i(data, "data");
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(reference, data);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @Nullable
        public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference reference) {
            t.i(reference, "reference");
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> table) {
            t.i(table, "table");
            Set hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(table);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime_release(@NotNull Composer composer) {
            t.i(composer, "composer");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime_release(@NotNull ControlledComposition composition) {
            t.i(composition, "composition");
            ComposerImpl.this.parentContext.registerComposition$runtime_release(composition);
        }

        public final void setInspectionTables(@Nullable Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime_release() {
            ComposerImpl.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime_release(@NotNull Composer composer) {
            t.i(composer, "composer");
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(((ComposerImpl) composer).slotTable);
                }
            }
            t0.a(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime_release(@NotNull ControlledComposition composition) {
            t.i(composition, "composition");
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(composition);
        }

        public final void updateCompositionLocalScope(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> scope) {
            t.i(scope, "scope");
            setCompositionLocalScope(scope);
        }

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }
    }

    @InternalComposeApi
    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float f10) {
        Object objNextSlot = nextSlot();
        if (objNextSlot instanceof Float) {
            if (f10 == ((Number) objNextSlot).floatValue()) {
                return false;
            }
        }
        updateValue(Float.valueOf(f10));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long j10) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Long) && j10 == ((Number) objNextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j10));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double d10) {
        Object objNextSlot = nextSlot();
        if (objNextSlot instanceof Double) {
            if (d10 == ((Number) objNextSlot).doubleValue()) {
                return false;
            }
        }
        updateValue(Double.valueOf(d10));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int i10) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Integer) && i10 == ((Number) objNextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i10));
        return true;
    }
}
