package androidx.compose.ui.layout;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GraphicLayerInfo.android.kt */
/* JADX INFO: loaded from: classes.dex */
public interface GraphicLayerInfo {

    /* JADX INFO: compiled from: GraphicLayerInfo.android.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static long getOwnerViewId(@NotNull GraphicLayerInfo graphicLayerInfo) {
            return a.a(graphicLayerInfo);
        }
    }

    long getLayerId();

    long getOwnerViewId();
}
