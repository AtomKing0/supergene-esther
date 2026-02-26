package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RippleContainer.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class RippleHostMap {

    @NotNull
    private final Map<AndroidRippleIndicationInstance, RippleHostView> indicationToHostMap = new LinkedHashMap();

    @NotNull
    private final Map<RippleHostView, AndroidRippleIndicationInstance> hostToIndicationMap = new LinkedHashMap();

    @Nullable
    public final RippleHostView get(@NotNull AndroidRippleIndicationInstance indicationInstance) {
        t.i(indicationInstance, "indicationInstance");
        return this.indicationToHostMap.get(indicationInstance);
    }

    public final void remove(@NotNull AndroidRippleIndicationInstance indicationInstance) {
        t.i(indicationInstance, "indicationInstance");
        RippleHostView rippleHostView = this.indicationToHostMap.get(indicationInstance);
        if (rippleHostView != null) {
            this.hostToIndicationMap.remove(rippleHostView);
        }
        this.indicationToHostMap.remove(indicationInstance);
    }

    public final void set(@NotNull AndroidRippleIndicationInstance indicationInstance, @NotNull RippleHostView rippleHostView) {
        t.i(indicationInstance, "indicationInstance");
        t.i(rippleHostView, "rippleHostView");
        this.indicationToHostMap.put(indicationInstance, rippleHostView);
        this.hostToIndicationMap.put(rippleHostView, indicationInstance);
    }

    @Nullable
    public final AndroidRippleIndicationInstance get(@NotNull RippleHostView rippleHostView) {
        t.i(rippleHostView, "rippleHostView");
        return this.hostToIndicationMap.get(rippleHostView);
    }
}
