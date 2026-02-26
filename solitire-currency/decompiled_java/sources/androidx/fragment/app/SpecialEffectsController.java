package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.CallSuper;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.a0;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SpecialEffectsController.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpecialEffectsController {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final ViewGroup container;
    private boolean isContainerPostponed;
    private boolean operationDirectionIsPop;

    @NotNull
    private final List<Operation> pendingOperations;

    @NotNull
    private final List<Operation> runningOperations;

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    public static class Effect {
        private boolean isCancelled;
        private final boolean isSeekingSupported;
        private boolean isStarted;

        public final void cancel(@NotNull ViewGroup container) {
            kotlin.jvm.internal.t.i(container, "container");
            if (!this.isCancelled) {
                onCancel(container);
            }
            this.isCancelled = true;
        }

        public boolean isSeekingSupported() {
            return this.isSeekingSupported;
        }

        public void onCancel(@NotNull ViewGroup container) {
            kotlin.jvm.internal.t.i(container, "container");
        }

        public void onCommit(@NotNull ViewGroup container) {
            kotlin.jvm.internal.t.i(container, "container");
        }

        public void onProgress(@NotNull BackEventCompat backEvent, @NotNull ViewGroup container) {
            kotlin.jvm.internal.t.i(backEvent, "backEvent");
            kotlin.jvm.internal.t.i(container, "container");
        }

        public void onStart(@NotNull ViewGroup container) {
            kotlin.jvm.internal.t.i(container, "container");
        }

        public final void performStart(@NotNull ViewGroup container) {
            kotlin.jvm.internal.t.i(container, "container");
            if (!this.isStarted) {
                onStart(container);
            }
            this.isStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    static final class FragmentStateManagerOperation extends Operation {

        @NotNull
        private final FragmentStateManager fragmentStateManager;

        /* JADX WARN: Illegal instructions before constructor call */
        public FragmentStateManagerOperation(@NotNull Operation.State finalState, @NotNull Operation.LifecycleImpact lifecycleImpact, @NotNull FragmentStateManager fragmentStateManager) {
            kotlin.jvm.internal.t.i(finalState, "finalState");
            kotlin.jvm.internal.t.i(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.t.i(fragmentStateManager, "fragmentStateManager");
            Fragment fragment = fragmentStateManager.getFragment();
            kotlin.jvm.internal.t.h(fragment, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, fragment);
            this.fragmentStateManager = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete$fragment_release() {
            super.complete$fragment_release();
            getFragment().mTransitioning = false;
            this.fragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void onStart() {
            if (isStarted()) {
                return;
            }
            super.onStart();
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) {
                if (getLifecycleImpact() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragment = this.fragmentStateManager.getFragment();
                    kotlin.jvm.internal.t.h(fragment, "fragmentStateManager.fragment");
                    View viewRequireView = fragment.requireView();
                    kotlin.jvm.internal.t.h(viewRequireView, "fragment.requireView()");
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragment);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragment2 = this.fragmentStateManager.getFragment();
            kotlin.jvm.internal.t.h(fragment2, "fragmentStateManager.fragment");
            View viewFindFocus = fragment2.mView.findFocus();
            if (viewFindFocus != null) {
                fragment2.setFocusedView(viewFindFocus);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment2);
                }
            }
            View viewRequireView2 = getFragment().requireView();
            kotlin.jvm.internal.t.h(viewRequireView2, "this.fragment.requireView()");
            if (viewRequireView2.getParent() == null) {
                this.fragmentStateManager.addViewToContainer();
                viewRequireView2.setAlpha(0.0f);
            }
            if ((viewRequireView2.getAlpha() == 0.0f) && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpecialEffectsController(@NotNull ViewGroup container) {
        kotlin.jvm.internal.t.i(container, "container");
        this.container = container;
        this.pendingOperations = new ArrayList();
        this.runningOperations = new ArrayList();
    }

    private final void enqueue(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        synchronized (this.pendingOperations) {
            Fragment fragment = fragmentStateManager.getFragment();
            kotlin.jvm.internal.t.h(fragment, "fragmentStateManager.fragment");
            Operation operationFindPendingOperation = findPendingOperation(fragment);
            if (operationFindPendingOperation == null) {
                if (fragmentStateManager.getFragment().mTransitioning) {
                    Fragment fragment2 = fragmentStateManager.getFragment();
                    kotlin.jvm.internal.t.h(fragment2, "fragmentStateManager.fragment");
                    operationFindPendingOperation = findRunningOperation(fragment2);
                } else {
                    operationFindPendingOperation = null;
                }
            }
            if (operationFindPendingOperation != null) {
                operationFindPendingOperation.mergeWith(state, lifecycleImpact);
                return;
            }
            final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager);
            this.pendingOperations.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.y
                @Override // java.lang.Runnable
                public final void run() {
                    SpecialEffectsController.enqueue$lambda$4$lambda$2(this.f969a, fragmentStateManagerOperation);
                }
            });
            fragmentStateManagerOperation.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.z
                @Override // java.lang.Runnable
                public final void run() {
                    SpecialEffectsController.enqueue$lambda$4$lambda$3(this.f971a, fragmentStateManagerOperation);
                }
            });
            k0 k0Var = k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$4$lambda$2(SpecialEffectsController this$0, FragmentStateManagerOperation operation) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(operation, "$operation");
        if (this$0.pendingOperations.contains(operation)) {
            Operation.State finalState = operation.getFinalState();
            View view = operation.getFragment().mView;
            kotlin.jvm.internal.t.h(view, "operation.fragment.mView");
            finalState.applyState(view, this$0.container);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$4$lambda$3(SpecialEffectsController this$0, FragmentStateManagerOperation operation) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(operation, "$operation");
        this$0.pendingOperations.remove(operation);
        this$0.runningOperations.remove(operation);
    }

    private final Operation findPendingOperation(Fragment fragment) {
        Object next;
        Iterator<T> it = this.pendingOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.t.d(operation.getFragment(), fragment) && !operation.isCanceled()) {
                break;
            }
        }
        return (Operation) next;
    }

    private final Operation findRunningOperation(Fragment fragment) {
        Object next;
        Iterator<T> it = this.runningOperations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.t.d(operation.getFragment(), fragment) && !operation.isCanceled()) {
                break;
            }
        }
        return (Operation) next;
    }

    @NotNull
    public static final SpecialEffectsController getOrCreateController(@NotNull ViewGroup viewGroup, @NotNull FragmentManager fragmentManager) {
        return Companion.getOrCreateController(viewGroup, fragmentManager);
    }

    private final void processStart(List<Operation> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).onStart();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            a0.B(arrayList, ((Operation) it.next()).getEffects$fragment_release());
        }
        List listP0 = d0.P0(d0.T0(arrayList));
        int size2 = listP0.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((Effect) listP0.get(i11)).performStart(this.container);
        }
    }

    private final void updateFinalState() {
        for (Operation operation : this.pendingOperations) {
            if (operation.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                View viewRequireView = operation.getFragment().requireView();
                kotlin.jvm.internal.t.h(viewRequireView, "fragment.requireView()");
                operation.mergeWith(Operation.State.Companion.from(viewRequireView.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void applyContainerChangesToOperation$fragment_release(@NotNull Operation operation) {
        kotlin.jvm.internal.t.i(operation, "operation");
        if (operation.isAwaitingContainerChanges()) {
            Operation.State finalState = operation.getFinalState();
            View viewRequireView = operation.getFragment().requireView();
            kotlin.jvm.internal.t.h(viewRequireView, "operation.fragment.requireView()");
            finalState.applyState(viewRequireView, this.container);
            operation.setAwaitingContainerChanges(false);
        }
    }

    public abstract void collectEffects(@NotNull List<Operation> list, boolean z10);

    public void commitEffects$fragment_release(@NotNull List<Operation> operations) {
        kotlin.jvm.internal.t.i(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            a0.B(arrayList, ((Operation) it.next()).getEffects$fragment_release());
        }
        List listP0 = d0.P0(d0.T0(arrayList));
        int size = listP0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((Effect) listP0.get(i10)).onCommit(this.container);
        }
        int size2 = operations.size();
        for (int i11 = 0; i11 < size2; i11++) {
            applyContainerChangesToOperation$fragment_release(operations.get(i11));
        }
        List listP02 = d0.P0(operations);
        int size3 = listP02.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Operation operation = (Operation) listP02.get(i12);
            if (operation.getEffects$fragment_release().isEmpty()) {
                operation.complete$fragment_release();
            }
        }
    }

    public final void completeBack() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "SpecialEffectsController: Completing Back ");
        }
        processStart(this.runningOperations);
        commitEffects$fragment_release(this.runningOperations);
    }

    public final void enqueueAdd(@NotNull Operation.State finalState, @NotNull FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.t.i(finalState, "finalState");
        kotlin.jvm.internal.t.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(finalState, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void enqueueHide(@NotNull FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.t.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void enqueueRemove(@NotNull FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.t.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public final void enqueueShow(@NotNull FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.t.i(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void executePendingOperations() {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.executePendingOperations():void");
    }

    public final void forceCompleteAllOperations() {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.container.isAttachedToWindow();
        synchronized (this.pendingOperations) {
            updateFinalState();
            processStart(this.pendingOperations);
            for (Operation operation : d0.R0(this.runningOperations)) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.container + " is not attached to window. ") + "Cancelling running operation " + operation);
                }
                operation.cancel(this.container);
            }
            for (Operation operation2 : d0.R0(this.pendingOperations)) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.container + " is not attached to window. ") + "Cancelling pending operation " + operation2);
                }
                operation2.cancel(this.container);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void forcePostponedExecutePendingOperations() {
        if (this.isContainerPostponed) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
            }
            this.isContainerPostponed = false;
            executePendingOperations();
        }
    }

    @Nullable
    public final Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@NotNull FragmentStateManager fragmentStateManager) {
        kotlin.jvm.internal.t.i(fragmentStateManager, "fragmentStateManager");
        Fragment fragment = fragmentStateManager.getFragment();
        kotlin.jvm.internal.t.h(fragment, "fragmentStateManager.fragment");
        Operation operationFindPendingOperation = findPendingOperation(fragment);
        Operation.LifecycleImpact lifecycleImpact = operationFindPendingOperation != null ? operationFindPendingOperation.getLifecycleImpact() : null;
        Operation operationFindRunningOperation = findRunningOperation(fragment);
        Operation.LifecycleImpact lifecycleImpact2 = operationFindRunningOperation != null ? operationFindRunningOperation.getLifecycleImpact() : null;
        int i10 = lifecycleImpact == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lifecycleImpact.ordinal()];
        return (i10 == -1 || i10 == 1) ? lifecycleImpact2 : lifecycleImpact;
    }

    @NotNull
    public final ViewGroup getContainer() {
        return this.container;
    }

    public final boolean isPendingExecute() {
        return !this.pendingOperations.isEmpty();
    }

    public final void markPostponedState() {
        Operation operationPrevious;
        synchronized (this.pendingOperations) {
            updateFinalState();
            List<Operation> list = this.pendingOperations;
            ListIterator<Operation> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    operationPrevious = null;
                    break;
                }
                operationPrevious = listIterator.previous();
                Operation operation = operationPrevious;
                Operation.State.Companion companion = Operation.State.Companion;
                View view = operation.getFragment().mView;
                kotlin.jvm.internal.t.h(view, "operation.fragment.mView");
                Operation.State stateAsOperationState = companion.asOperationState(view);
                Operation.State finalState = operation.getFinalState();
                Operation.State state = Operation.State.VISIBLE;
                if (finalState == state && stateAsOperationState != state) {
                    break;
                }
            }
            Operation operation2 = operationPrevious;
            Fragment fragment = operation2 != null ? operation2.getFragment() : null;
            this.isContainerPostponed = fragment != null ? fragment.isPostponed() : false;
            k0 k0Var = k0.f35197a;
        }
    }

    public final void processProgress(@NotNull BackEventCompat backEvent) {
        kotlin.jvm.internal.t.i(backEvent, "backEvent");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: Processing Progress " + backEvent.getProgress());
        }
        List<Operation> list = this.runningOperations;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            a0.B(arrayList, ((Operation) it.next()).getEffects$fragment_release());
        }
        List listP0 = d0.P0(d0.T0(arrayList));
        int size = listP0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((Effect) listP0.get(i10)).onProgress(backEvent, this.container);
        }
    }

    public final void updateOperationDirection(boolean z10) {
        this.operationDirectionIsPop = z10;
    }

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final SpecialEffectsController getOrCreateController(@NotNull ViewGroup container, @NotNull FragmentManager fragmentManager) {
            kotlin.jvm.internal.t.i(container, "container");
            kotlin.jvm.internal.t.i(fragmentManager, "fragmentManager");
            SpecialEffectsControllerFactory specialEffectsControllerFactory = fragmentManager.getSpecialEffectsControllerFactory();
            kotlin.jvm.internal.t.h(specialEffectsControllerFactory, "fragmentManager.specialEffectsControllerFactory");
            return getOrCreateController(container, specialEffectsControllerFactory);
        }

        @NotNull
        public final SpecialEffectsController getOrCreateController(@NotNull ViewGroup container, @NotNull SpecialEffectsControllerFactory factory) {
            kotlin.jvm.internal.t.i(container, "container");
            kotlin.jvm.internal.t.i(factory, "factory");
            int i10 = R.id.special_effects_controller_view_tag;
            Object tag = container.getTag(i10);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController specialEffectsControllerCreateController = factory.createController(container);
            kotlin.jvm.internal.t.h(specialEffectsControllerCreateController, "factory.createController(container)");
            container.setTag(i10, specialEffectsControllerCreateController);
            return specialEffectsControllerCreateController;
        }
    }

    @NotNull
    public static final SpecialEffectsController getOrCreateController(@NotNull ViewGroup viewGroup, @NotNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        return Companion.getOrCreateController(viewGroup, specialEffectsControllerFactory);
    }

    /* JADX INFO: compiled from: SpecialEffectsController.kt */
    public static class Operation {

        @NotNull
        private final List<Effect> _effects;

        @NotNull
        private final List<Runnable> completionListeners;

        @NotNull
        private final List<Effect> effects;

        @NotNull
        private State finalState;

        @NotNull
        private final Fragment fragment;
        private boolean isAwaitingContainerChanges;
        private boolean isCanceled;
        private boolean isComplete;
        private boolean isSeeking;
        private boolean isStarted;

        @NotNull
        private LifecycleImpact lifecycleImpact;

        /* JADX INFO: compiled from: SpecialEffectsController.kt */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: compiled from: SpecialEffectsController.kt */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;


            @NotNull
            public static final Companion Companion = new Companion(null);

            /* JADX INFO: compiled from: SpecialEffectsController.kt */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                    this();
                }

                @NotNull
                public final State asOperationState(@NotNull View view) {
                    kotlin.jvm.internal.t.i(view, "<this>");
                    return (((view.getAlpha() > 0.0f ? 1 : (view.getAlpha() == 0.0f ? 0 : -1)) == 0) && view.getVisibility() == 0) ? State.INVISIBLE : from(view.getVisibility());
                }

                @NotNull
                public final State from(int i10) {
                    if (i10 == 0) {
                        return State.VISIBLE;
                    }
                    if (i10 == 4) {
                        return State.INVISIBLE;
                    }
                    if (i10 == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i10);
                }
            }

            /* JADX INFO: compiled from: SpecialEffectsController.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @NotNull
            public static final State from(int i10) {
                return Companion.from(i10);
            }

            public final void applyState(@NotNull View view, @NotNull ViewGroup container) {
                kotlin.jvm.internal.t.i(view, "view");
                kotlin.jvm.internal.t.i(container, "container");
                int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
                if (i10 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i10 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i10 == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        /* JADX INFO: compiled from: SpecialEffectsController.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LifecycleImpact.values().length];
                try {
                    iArr[LifecycleImpact.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LifecycleImpact.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LifecycleImpact.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Operation(@NotNull State finalState, @NotNull LifecycleImpact lifecycleImpact, @NotNull Fragment fragment) {
            kotlin.jvm.internal.t.i(finalState, "finalState");
            kotlin.jvm.internal.t.i(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.t.i(fragment, "fragment");
            this.finalState = finalState;
            this.lifecycleImpact = lifecycleImpact;
            this.fragment = fragment;
            this.completionListeners = new ArrayList();
            this.isAwaitingContainerChanges = true;
            ArrayList arrayList = new ArrayList();
            this._effects = arrayList;
            this.effects = arrayList;
        }

        public final void addCompletionListener(@NotNull Runnable listener) {
            kotlin.jvm.internal.t.i(listener, "listener");
            this.completionListeners.add(listener);
        }

        public final void addEffect(@NotNull Effect effect) {
            kotlin.jvm.internal.t.i(effect, "effect");
            this._effects.add(effect);
        }

        public final void cancel(@NotNull ViewGroup container) {
            kotlin.jvm.internal.t.i(container, "container");
            this.isStarted = false;
            if (this.isCanceled) {
                return;
            }
            this.isCanceled = true;
            if (this._effects.isEmpty()) {
                complete$fragment_release();
                return;
            }
            Iterator it = d0.P0(this.effects).iterator();
            while (it.hasNext()) {
                ((Effect) it.next()).cancel(container);
            }
        }

        @CallSuper
        public void complete$fragment_release() {
            this.isStarted = false;
            if (this.isComplete) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
            }
            this.isComplete = true;
            Iterator<T> it = this.completionListeners.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void completeEffect(@NotNull Effect effect) {
            kotlin.jvm.internal.t.i(effect, "effect");
            if (this._effects.remove(effect) && this._effects.isEmpty()) {
                complete$fragment_release();
            }
        }

        @NotNull
        public final List<Effect> getEffects$fragment_release() {
            return this.effects;
        }

        @NotNull
        public final State getFinalState() {
            return this.finalState;
        }

        @NotNull
        public final Fragment getFragment() {
            return this.fragment;
        }

        @NotNull
        public final LifecycleImpact getLifecycleImpact() {
            return this.lifecycleImpact;
        }

        public final boolean isAwaitingContainerChanges() {
            return this.isAwaitingContainerChanges;
        }

        public final boolean isCanceled() {
            return this.isCanceled;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final boolean isSeeking() {
            return this.isSeeking;
        }

        public final boolean isStarted() {
            return this.isStarted;
        }

        public final void mergeWith(@NotNull State finalState, @NotNull LifecycleImpact lifecycleImpact) {
            kotlin.jvm.internal.t.i(finalState, "finalState");
            kotlin.jvm.internal.t.i(lifecycleImpact, "lifecycleImpact");
            int i10 = WhenMappings.$EnumSwitchMapping$0[lifecycleImpact.ordinal()];
            if (i10 == 1) {
                if (this.finalState == State.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.lifecycleImpact + " to ADDING.");
                    }
                    this.finalState = State.VISIBLE;
                    this.lifecycleImpact = LifecycleImpact.ADDING;
                    this.isAwaitingContainerChanges = true;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> REMOVED. mLifecycleImpact  = " + this.lifecycleImpact + " to REMOVING.");
                }
                this.finalState = State.REMOVED;
                this.lifecycleImpact = LifecycleImpact.REMOVING;
                this.isAwaitingContainerChanges = true;
                return;
            }
            if (i10 == 3 && this.finalState != State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> " + finalState + '.');
                }
                this.finalState = finalState;
            }
        }

        @CallSuper
        public void onStart() {
            this.isStarted = true;
        }

        public final void setAwaitingContainerChanges(boolean z10) {
            this.isAwaitingContainerChanges = z10;
        }

        public final void setFinalState(@NotNull State state) {
            kotlin.jvm.internal.t.i(state, "<set-?>");
            this.finalState = state;
        }

        public final void setLifecycleImpact(@NotNull LifecycleImpact lifecycleImpact) {
            kotlin.jvm.internal.t.i(lifecycleImpact, "<set-?>");
            this.lifecycleImpact = lifecycleImpact;
        }

        @NotNull
        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.finalState + " lifecycleImpact = " + this.lifecycleImpact + " fragment = " + this.fragment + '}';
        }

        public final void cancel(@NotNull ViewGroup container, boolean z10) {
            kotlin.jvm.internal.t.i(container, "container");
            if (this.isCanceled) {
                return;
            }
            if (z10) {
                this.isSeeking = true;
            }
            cancel(container);
        }
    }
}
