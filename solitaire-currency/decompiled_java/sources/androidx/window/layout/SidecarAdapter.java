package androidx.window.layout;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import androidx.annotation.VisibleForTesting;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SidecarAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SidecarAdapter {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final String TAG = SidecarAdapter.class.getSimpleName();

    @NotNull
    private final SpecificationComputer.VerificationMode verificationMode;

    /* JADX INFO: compiled from: SidecarAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        public final int getRawSidecarDevicePosture(@NotNull SidecarDeviceState sidecarDeviceState) {
            t.i(sidecarDeviceState, "sidecarDeviceState");
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                try {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                    if (objInvoke != null) {
                        return ((Integer) objInvoke).intValue();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return 0;
                }
            }
        }

        public final int getSidecarDevicePosture$window_release(@NotNull SidecarDeviceState sidecarDeviceState) {
            t.i(sidecarDeviceState, "sidecarDeviceState");
            int rawSidecarDevicePosture = getRawSidecarDevicePosture(sidecarDeviceState);
            if (rawSidecarDevicePosture < 0 || rawSidecarDevicePosture > 4) {
                return 0;
            }
            return rawSidecarDevicePosture;
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        @NotNull
        public final List<SidecarDisplayFeature> getSidecarDisplayFeatures(@NotNull SidecarWindowLayoutInfo info) {
            t.i(info, "info");
            try {
                try {
                    List<SidecarDisplayFeature> list = info.displayFeatures;
                    return list == null ? v.l() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(info, new Object[0]);
                    if (objInvoke != null) {
                        return (List) objInvoke;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return v.l();
            }
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        public final void setSidecarDevicePosture(@NotNull SidecarDeviceState sidecarDeviceState, int i10) {
            t.i(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i10;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i10));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        public final void setSidecarDisplayFeatures(@NotNull SidecarWindowLayoutInfo info, @NotNull List<SidecarDisplayFeature> displayFeatures) {
            t.i(info, "info");
            t.i(displayFeatures, "displayFeatures");
            try {
                try {
                    info.displayFeatures = displayFeatures;
                } catch (NoSuchFieldError unused) {
                    SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(info, displayFeatures);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SidecarAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean isEqualSidecarDisplayFeature(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (t.d(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return t.d(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    private final boolean isEqualSidecarDisplayFeatures(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (!isEqualSidecarDisplayFeature(list.get(i10), list2.get(i10))) {
                return false;
            }
            i10 = i11;
        }
        return true;
    }

    public final boolean isEqualSidecarDeviceState(@Nullable SidecarDeviceState sidecarDeviceState, @Nullable SidecarDeviceState sidecarDeviceState2) {
        if (t.d(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        Companion companion = Companion;
        return companion.getSidecarDevicePosture$window_release(sidecarDeviceState) == companion.getSidecarDevicePosture$window_release(sidecarDeviceState2);
    }

    public final boolean isEqualSidecarWindowLayoutInfo(@Nullable SidecarWindowLayoutInfo sidecarWindowLayoutInfo, @Nullable SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (t.d(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        Companion companion = Companion;
        return isEqualSidecarDisplayFeatures(companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo), companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo2));
    }

    @NotNull
    public final List<DisplayFeature> translate(@NotNull List<SidecarDisplayFeature> sidecarDisplayFeatures, @NotNull SidecarDeviceState deviceState) {
        t.i(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        t.i(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            DisplayFeature displayFeatureTranslate$window_release = translate$window_release((SidecarDisplayFeature) it.next(), deviceState);
            if (displayFeatureTranslate$window_release != null) {
                arrayList.add(displayFeatureTranslate$window_release);
            }
        }
        return arrayList;
    }

    @Nullable
    public final DisplayFeature translate$window_release(@NotNull SidecarDisplayFeature feature, @NotNull SidecarDeviceState deviceState) {
        HardwareFoldingFeature.Type fold;
        FoldingFeature.State state;
        t.i(feature, "feature");
        t.i(deviceState, "deviceState");
        SpecificationComputer.Companion companion = SpecificationComputer.Companion;
        String TAG2 = TAG;
        t.h(TAG2, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) SpecificationComputer.Companion.startSpecification$default(companion, feature, TAG2, this.verificationMode, null, 4, null).require("Type must be either TYPE_FOLD or TYPE_HINGE", SidecarAdapter$translate$checkedFeature$1.INSTANCE).require("Feature bounds must not be 0", SidecarAdapter$translate$checkedFeature$2.INSTANCE).require("TYPE_FOLD must have 0 area", SidecarAdapter$translate$checkedFeature$3.INSTANCE).require("Feature be pinned to either left or top", SidecarAdapter$translate$checkedFeature$4.INSTANCE).compute();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            fold = HardwareFoldingFeature.Type.Companion.getFOLD();
        } else {
            if (type != 2) {
                return null;
            }
            fold = HardwareFoldingFeature.Type.Companion.getHINGE();
        }
        int sidecarDevicePosture$window_release = Companion.getSidecarDevicePosture$window_release(deviceState);
        if (sidecarDevicePosture$window_release == 0 || sidecarDevicePosture$window_release == 1) {
            return null;
        }
        if (sidecarDevicePosture$window_release == 2) {
            state = FoldingFeature.State.HALF_OPENED;
        } else {
            if (sidecarDevicePosture$window_release != 3 && sidecarDevicePosture$window_release == 4) {
                return null;
            }
            state = FoldingFeature.State.FLAT;
        }
        Rect rect = feature.getRect();
        t.h(rect, "feature.rect");
        return new HardwareFoldingFeature(new Bounds(rect), fold, state);
    }

    public SidecarAdapter(@NotNull SpecificationComputer.VerificationMode verificationMode) {
        t.i(verificationMode, "verificationMode");
        this.verificationMode = verificationMode;
    }

    public /* synthetic */ SidecarAdapter(SpecificationComputer.VerificationMode verificationMode, int i10, k kVar) {
        this((i10 & 1) != 0 ? SpecificationComputer.VerificationMode.QUIET : verificationMode);
    }

    @NotNull
    public final WindowLayoutInfo translate(@Nullable SidecarWindowLayoutInfo sidecarWindowLayoutInfo, @NotNull SidecarDeviceState state) {
        t.i(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new WindowLayoutInfo(v.l());
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        Companion companion = Companion;
        companion.setSidecarDevicePosture(sidecarDeviceState, companion.getSidecarDevicePosture$window_release(state));
        return new WindowLayoutInfo(translate(companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo), sidecarDeviceState));
    }
}
