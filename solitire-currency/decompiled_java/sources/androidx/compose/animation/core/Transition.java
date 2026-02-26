package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import h9.l;
import h9.p;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class Transition<S> {

    @NotNull
    private final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;

    @NotNull
    private final SnapshotStateList<Transition<?>> _transitions;

    @NotNull
    private final MutableState isSeeking$delegate;

    @Nullable
    private final String label;
    private long lastSeekedTimeNanos;

    @NotNull
    private final MutableState playTimeNanos$delegate;

    @NotNull
    private final MutableState segment$delegate;

    @NotNull
    private final MutableState startTimeNanos$delegate;

    @NotNull
    private final MutableState targetState$delegate;

    @NotNull
    private final State totalDurationNanos$delegate;

    @NotNull
    private final MutableTransitionState<S> transitionState;

    @NotNull
    private final MutableState updateChildrenNeeded$delegate;

    /* JADX INFO: compiled from: Transition.kt */
    @InternalAnimationApi
    public final class DeferredAnimation<T, V extends AnimationVector> {

        @Nullable
        private Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data;

        @NotNull
        private final String label;
        final /* synthetic */ Transition<S> this$0;

        @NotNull
        private final TwoWayConverter<T, V> typeConverter;

        /* JADX INFO: compiled from: Transition.kt */
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {

            @NotNull
            private final Transition<S>.TransitionAnimationState<T, V> animation;

            @NotNull
            private l<? super S, ? extends T> targetValueByState;
            final /* synthetic */ Transition<S>.DeferredAnimation<T, V> this$0;

            @NotNull
            private l<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(@NotNull DeferredAnimation deferredAnimation, @NotNull Transition<S>.TransitionAnimationState<T, V> animation, @NotNull l<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec, l<? super S, ? extends T> targetValueByState) {
                t.i(animation, "animation");
                t.i(transitionSpec, "transitionSpec");
                t.i(targetValueByState, "targetValueByState");
                this.this$0 = deferredAnimation;
                this.animation = animation;
                this.transitionSpec = transitionSpec;
                this.targetValueByState = targetValueByState;
            }

            @NotNull
            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            @NotNull
            public final l<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            @NotNull
            public final l<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            @Override // androidx.compose.runtime.State
            public T getValue() {
                updateAnimationStates(this.this$0.this$0.getSegment());
                return this.animation.getValue();
            }

            public final void setTargetValueByState(@NotNull l<? super S, ? extends T> lVar) {
                t.i(lVar, "<set-?>");
                this.targetValueByState = lVar;
            }

            public final void setTransitionSpec(@NotNull l<? super Segment<S>, ? extends FiniteAnimationSpec<T>> lVar) {
                t.i(lVar, "<set-?>");
                this.transitionSpec = lVar;
            }

            public final void updateAnimationStates(@NotNull Segment<S> segment) {
                t.i(segment, "segment");
                T tInvoke = this.targetValueByState.invoke(segment.getTargetState());
                if (!this.this$0.this$0.isSeeking()) {
                    this.animation.updateTargetValue$animation_core_release(tInvoke, this.transitionSpec.invoke(segment));
                } else {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), tInvoke, this.transitionSpec.invoke(segment));
                }
            }
        }

        public DeferredAnimation(@NotNull Transition transition, @NotNull TwoWayConverter<T, V> typeConverter, String label) {
            t.i(typeConverter, "typeConverter");
            t.i(label, "label");
            this.this$0 = transition;
            this.typeConverter = typeConverter;
            this.label = label;
        }

        @NotNull
        public final State<T> animate(@NotNull l<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec, @NotNull l<? super S, ? extends T> targetValueByState) {
            t.i(transitionSpec, "transitionSpec");
            t.i(targetValueByState, "targetValueByState");
            DeferredAnimationData deferredAnimationData = this.data;
            if (deferredAnimationData == null) {
                Transition<S> transition = this.this$0;
                deferredAnimationData = new DeferredAnimationData(this, new TransitionAnimationState(transition, targetValueByState.invoke(transition.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, targetValueByState.invoke(this.this$0.getCurrentState())), this.typeConverter, this.label), transitionSpec, targetValueByState);
                Transition<S> transition2 = this.this$0;
                this.data = deferredAnimationData;
                transition2.addAnimation$animation_core_release(deferredAnimationData.getAnimation());
            }
            Transition<S> transition3 = this.this$0;
            deferredAnimationData.setTargetValueByState(targetValueByState);
            deferredAnimationData.setTransitionSpec(transitionSpec);
            deferredAnimationData.updateAnimationStates(transition3.getSegment());
            return deferredAnimationData;
        }

        @Nullable
        public final Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> getData$animation_core_release() {
            return this.data;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final void setData$animation_core_release(@Nullable Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> deferredAnimationData) {
            this.data = deferredAnimationData;
        }

        public final void setupSeeking$animation_core_release() {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> deferredAnimationData = this.data;
            if (deferredAnimationData != null) {
                Transition<S> transition = this.this$0;
                deferredAnimationData.getAnimation().updateInitialAndTargetValue$animation_core_release(deferredAnimationData.getTargetValueByState().invoke(transition.getSegment().getInitialState()), deferredAnimationData.getTargetValueByState().invoke(transition.getSegment().getTargetState()), deferredAnimationData.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    /* JADX INFO: compiled from: Transition.kt */
    public interface Segment<S> {

        /* JADX INFO: compiled from: Transition.kt */
        public static final class DefaultImpls {
            @Deprecated
            public static <S> boolean isTransitioningTo(@NotNull Segment<S> segment, S s10, S s11) {
                return e.a(segment, s10, s11);
            }
        }

        S getInitialState();

        S getTargetState();

        boolean isTransitioningTo(S s10, S s11);
    }

    /* JADX INFO: compiled from: Transition.kt */
    private static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        public SegmentImpl(S s10, S s11) {
            this.initialState = s10;
            this.targetState = s11;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                if (t.d(getInitialState(), segment.getInitialState()) && t.d(getTargetState(), segment.getTargetState())) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getTargetState() {
            return this.targetState;
        }

        public int hashCode() {
            S initialState = getInitialState();
            int iHashCode = (initialState != null ? initialState.hashCode() : 0) * 31;
            S targetState = getTargetState();
            return iHashCode + (targetState != null ? targetState.hashCode() : 0);
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public /* synthetic */ boolean isTransitioningTo(Object obj, Object obj2) {
            return e.a(this, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Stable
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {

        @NotNull
        private final MutableState animation$delegate;

        @NotNull
        private final MutableState animationSpec$delegate;

        @NotNull
        private final FiniteAnimationSpec<T> interruptionSpec;

        @NotNull
        private final MutableState isFinished$delegate;

        @NotNull
        private final String label;

        @NotNull
        private final MutableState needsReset$delegate;

        @NotNull
        private final MutableState offsetTimeNanos$delegate;

        @NotNull
        private final MutableState targetValue$delegate;
        final /* synthetic */ Transition<S> this$0;

        @NotNull
        private final TwoWayConverter<T, V> typeConverter;

        @NotNull
        private final MutableState value$delegate;

        @NotNull
        private V velocityVector;

        public TransitionAnimationState(Transition transition, @NotNull T t10, @NotNull V initialVelocityVector, @NotNull TwoWayConverter<T, V> typeConverter, String label) {
            T tInvoke;
            t.i(initialVelocityVector, "initialVelocityVector");
            t.i(typeConverter, "typeConverter");
            t.i(label, "label");
            this.this$0 = transition;
            this.typeConverter = typeConverter;
            this.label = label;
            this.targetValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            this.animationSpec$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), null, 2, null);
            this.animation$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), typeConverter, t10, getTargetValue(), initialVelocityVector), null, 2, null);
            this.isFinished$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.offsetTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
            this.needsReset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            this.velocityVector = initialVelocityVector;
            Float f10 = VisibilityThresholdsKt.getVisibilityThresholdMap().get(typeConverter);
            if (f10 != null) {
                float fFloatValue = f10.floatValue();
                V vInvoke = typeConverter.getConvertToVector().invoke(t10);
                int size$animation_core_release = vInvoke.getSize$animation_core_release();
                for (int i10 = 0; i10 < size$animation_core_release; i10++) {
                    vInvoke.set$animation_core_release(i10, fFloatValue);
                }
                tInvoke = this.typeConverter.getConvertFromVector().invoke(vInvoke);
            } else {
                tInvoke = null;
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, tInvoke, 3, null);
        }

        private final boolean getNeedsReset() {
            return ((Boolean) this.needsReset$delegate.getValue()).booleanValue();
        }

        private final long getOffsetTimeNanos() {
            return ((Number) this.offsetTimeNanos$delegate.getValue()).longValue();
        }

        private final T getTargetValue() {
            return this.targetValue$delegate.getValue();
        }

        private final void setAnimation(TargetBasedAnimation<T, V> targetBasedAnimation) {
            this.animation$delegate.setValue(targetBasedAnimation);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> finiteAnimationSpec) {
            this.animationSpec$delegate.setValue(finiteAnimationSpec);
        }

        private final void setNeedsReset(boolean z10) {
            this.needsReset$delegate.setValue(Boolean.valueOf(z10));
        }

        private final void setOffsetTimeNanos(long j10) {
            this.offsetTimeNanos$delegate.setValue(Long.valueOf(j10));
        }

        private final void setTargetValue(T t10) {
            this.targetValue$delegate.setValue(t10);
        }

        private final void updateAnimation(T t10, boolean z10) {
            FiniteAnimationSpec<T> animationSpec = (!z10 || (getAnimationSpec() instanceof SpringSpec)) ? getAnimationSpec() : this.interruptionSpec;
            setAnimation(new TargetBasedAnimation<>(animationSpec, this.typeConverter, t10, getTargetValue(), this.velocityVector));
            this.this$0.onChildAnimationUpdated();
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z10, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            transitionAnimationState.updateAnimation(obj, z10);
        }

        @NotNull
        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        @NotNull
        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        public final long getDurationNanos$animation_core_release() {
            return getAnimation().getDurationNanos();
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        @Override // androidx.compose.runtime.State
        public T getValue() {
            return this.value$delegate.getValue();
        }

        public final boolean isFinished$animation_core_release() {
            return ((Boolean) this.isFinished$delegate.getValue()).booleanValue();
        }

        public final void onPlayTimeChanged$animation_core_release(long j10, float f10) {
            long durationNanos = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1)) == 0 ? getAnimation().getDurationNanos() : (long) ((j10 - getOffsetTimeNanos()) / f10);
            setValue$animation_core_release(getAnimation().getValueFromNanos(durationNanos));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(durationNanos);
            if (getAnimation().isFinishedFromNanos(durationNanos)) {
                setFinished$animation_core_release(true);
                setOffsetTimeNanos(0L);
            }
        }

        public final void resetAnimation$animation_core_release() {
            setNeedsReset(true);
        }

        public final void seekTo$animation_core_release(long j10) {
            setValue$animation_core_release(getAnimation().getValueFromNanos(j10));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(j10);
        }

        public final void setFinished$animation_core_release(boolean z10) {
            this.isFinished$delegate.setValue(Boolean.valueOf(z10));
        }

        public void setValue$animation_core_release(T t10) {
            this.value$delegate.setValue(t10);
        }

        public final void updateInitialAndTargetValue$animation_core_release(T t10, T t11, @NotNull FiniteAnimationSpec<T> animationSpec) {
            t.i(animationSpec, "animationSpec");
            setTargetValue(t11);
            setAnimationSpec(animationSpec);
            if (t.d(getAnimation().getInitialValue(), t10) && t.d(getAnimation().getTargetValue(), t11)) {
                return;
            }
            updateAnimation$default(this, t10, false, 2, null);
        }

        public final void updateTargetValue$animation_core_release(T t10, @NotNull FiniteAnimationSpec<T> animationSpec) {
            t.i(animationSpec, "animationSpec");
            if (!t.d(getTargetValue(), t10) || getNeedsReset()) {
                setTargetValue(t10);
                setAnimationSpec(animationSpec);
                updateAnimation$default(this, null, !isFinished$animation_core_release(), 1, null);
                setFinished$animation_core_release(false);
                setOffsetTimeNanos(this.this$0.getPlayTimeNanos());
                setNeedsReset(false);
            }
        }
    }

    public Transition(@NotNull MutableTransitionState<S> transitionState, @Nullable String str) {
        t.i(transitionState, "transitionState");
        this.transitionState = transitionState;
        this.label = str;
        this.targetState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.segment$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this.playTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.startTimeNanos$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.MIN_VALUE, null, 2, null);
        this.updateChildrenNeeded$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new Transition$totalDurationNanos$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long getStartTimeNanos() {
        return ((Number) this.startTimeNanos$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded$animation_core_release(true);
        if (isSeeking()) {
            long jMax = 0;
            for (Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState : this._animations) {
                jMax = Math.max(jMax, transitionAnimationState.getDurationNanos$animation_core_release());
                transitionAnimationState.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded$animation_core_release(false);
        }
    }

    private final void setSegment(Segment<S> segment) {
        this.segment$delegate.setValue(segment);
    }

    private final void setStartTimeNanos(long j10) {
        this.startTimeNanos$delegate.setValue(Long.valueOf(j10));
    }

    public final boolean addAnimation$animation_core_release(@NotNull Transition<S>.TransitionAnimationState<?, ?> animation) {
        t.i(animation, "animation");
        return this._animations.add(animation);
    }

    public final boolean addTransition$animation_core_release(@NotNull Transition<?> transition) {
        t.i(transition, "transition");
        return this._transitions.add(transition);
    }

    @Composable
    public final void animateTo$animation_core_release(S s10, @Nullable Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1493585151);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(s10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else if (!isSeeking()) {
            updateTarget$animation_core_release(s10, composerStartRestartGroup, (i11 & 14) | (i11 & 112));
            if (!t.d(s10, getCurrentState()) || isRunning() || getUpdateChildrenNeeded$animation_core_release()) {
                int i12 = (i11 >> 3) & 14;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                boolean zChanged = composerStartRestartGroup.changed(this);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Transition$animateTo$1$1(this, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(this, (p<? super o0, ? super z8.d<? super k0>, ? extends Object>) objRememberedValue, composerStartRestartGroup, i12);
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Transition$animateTo$2(this, s10, i10));
    }

    @NotNull
    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public final long getLastSeekedTimeNanos$animation_core_release() {
        return this.lastSeekedTimeNanos;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long getPlayTimeNanos() {
        return ((Number) this.playTimeNanos$delegate.getValue()).longValue();
    }

    @NotNull
    public final Segment<S> getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos$delegate.getValue()).longValue();
    }

    @NotNull
    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getUpdateChildrenNeeded$animation_core_release() {
        return ((Boolean) this.updateChildrenNeeded$delegate.getValue()).booleanValue();
    }

    public final boolean isRunning() {
        return getStartTimeNanos() != Long.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    public final void onFrame$animation_core_release(long j10, float f10) {
        if (getStartTimeNanos() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(j10);
        }
        setUpdateChildrenNeeded$animation_core_release(false);
        setPlayTimeNanos(j10 - getStartTimeNanos());
        boolean z10 = true;
        for (Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState : this._animations) {
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                transitionAnimationState.onPlayTimeChanged$animation_core_release(getPlayTimeNanos(), f10);
            }
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                z10 = false;
            }
        }
        for (Transition<?> transition : this._transitions) {
            if (!t.d(transition.getTargetState(), transition.getCurrentState())) {
                transition.onFrame$animation_core_release(getPlayTimeNanos(), f10);
            }
            if (!t.d(transition.getTargetState(), transition.getCurrentState())) {
                z10 = false;
            }
        }
        if (z10) {
            onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos(Long.MIN_VALUE);
        setCurrentState$animation_core_release(getTargetState());
        setPlayTimeNanos(0L);
        this.transitionState.setRunning$animation_core_release(false);
    }

    public final void onTransitionStart$animation_core_release(long j10) {
        setStartTimeNanos(j10);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void removeAnimation$animation_core_release(@NotNull Transition<S>.TransitionAnimationState<?, ?> animation) {
        t.i(animation, "animation");
        this._animations.remove(animation);
    }

    public final boolean removeTransition$animation_core_release(@NotNull Transition<?> transition) {
        t.i(transition, "transition");
        return this._transitions.remove(transition);
    }

    public final void seek(S s10, S s11, long j10) {
        setStartTimeNanos(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !t.d(getCurrentState(), s10) || !t.d(getTargetState(), s11)) {
            setCurrentState$animation_core_release(s10);
            setTargetState$animation_core_release(s11);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(s10, s11));
        }
        for (Transition<?> transition : this._transitions) {
            if (transition.isSeeking()) {
                transition.seek(transition.getCurrentState(), transition.getTargetState(), j10);
            }
        }
        Iterator<Transition<S>.TransitionAnimationState<?, ?>> it = this._animations.iterator();
        while (it.hasNext()) {
            it.next().seekTo$animation_core_release(j10);
        }
        this.lastSeekedTimeNanos = j10;
    }

    public final void setCurrentState$animation_core_release(S s10) {
        this.transitionState.setCurrentState$animation_core_release(s10);
    }

    public final void setLastSeekedTimeNanos$animation_core_release(long j10) {
        this.lastSeekedTimeNanos = j10;
    }

    public final void setPlayTimeNanos(long j10) {
        this.playTimeNanos$delegate.setValue(Long.valueOf(j10));
    }

    public final void setSeeking$animation_core_release(boolean z10) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setTargetState$animation_core_release(S s10) {
        this.targetState$delegate.setValue(s10);
    }

    public final void setUpdateChildrenNeeded$animation_core_release(boolean z10) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(z10));
    }

    @Composable
    public final void updateTarget$animation_core_release(S s10, @Nullable Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-583974681);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(s10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else if (!isSeeking() && !t.d(getTargetState(), s10)) {
            setSegment(new SegmentImpl(getTargetState(), s10));
            setCurrentState$animation_core_release(getTargetState());
            setTargetState$animation_core_release(s10);
            if (!isRunning()) {
                setUpdateChildrenNeeded$animation_core_release(true);
            }
            Iterator<Transition<S>.TransitionAnimationState<?, ?>> it = this._animations.iterator();
            while (it.hasNext()) {
                it.next().resetAnimation$animation_core_release();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Transition$updateTarget$2(this, s10, i10));
    }

    public final void removeAnimation$animation_core_release(@NotNull Transition<S>.DeferredAnimation<?, ?> deferredAnimation) {
        Transition<S>.TransitionAnimationState<?, ?> animation;
        t.i(deferredAnimation, "deferredAnimation");
        Transition<S>.DeferredAnimationData<?, ?>.DeferredAnimationData<?, V> data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release == 0 || (animation = data$animation_core_release.getAnimation()) == null) {
            return;
        }
        removeAnimation$animation_core_release(animation);
    }

    public /* synthetic */ Transition(MutableTransitionState mutableTransitionState, String str, int i10, k kVar) {
        this(mutableTransitionState, (i10 & 2) != 0 ? null : str);
    }

    public Transition(S s10, @Nullable String str) {
        this(new MutableTransitionState(s10), str);
    }

    @InternalAnimationApi
    public static /* synthetic */ void getPlayTimeNanos$annotations() {
    }

    @InternalAnimationApi
    public static /* synthetic */ void isSeeking$annotations() {
    }
}
